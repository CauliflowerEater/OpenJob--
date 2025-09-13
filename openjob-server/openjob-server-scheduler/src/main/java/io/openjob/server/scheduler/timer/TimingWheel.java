package io.openjob.server.scheduler.timer;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Maps;


public class TimingWheel {

    /**
     * second.
     */
    private Long tickTime;

    private Integer wheelSize;

    private Long interval;

    /**
     * second.
     */
    private Long startTime;

    private AtomicInteger taskCounter;

    private volatile DelayQueue<TimerTaskList> delayQueue;

    /**
     * second.
     */
    private Long currentTime;

    /**
     * overflowWheel can potentially be updated and read by two concurrent threads through add().
     * Therefore, it needs to be volatile due to Double-Checked Locking pattern with JVM
     */
    private TimingWheel overflowWheel;

    private TimerTaskList[] buckets;

    private Map<Long, io.openjob.server.scheduler.timer.TimerTaskEntry> taskEntryMap = Maps.newConcurrentMap();

    private Map<Long, Set<Long>> slotsToTaskMap = Maps.newConcurrentMap();


    /**
     * Timing wheel.
     *
     * @param tickTime    tickTime
     * @param wheelSize   wheelSize
     * @param startTime   startTime
     * @param taskCounter taskCounter
     * @param delayQueue  delayQueue
     */
    public TimingWheel(Long tickTime, Integer wheelSize, Long startTime, AtomicInteger taskCounter,
            DelayQueue<TimerTaskList> delayQueue) {
        this.tickTime = tickTime;
        this.wheelSize = wheelSize;
        this.startTime = startTime;
        this.taskCounter = taskCounter;
        this.delayQueue = delayQueue;
        this.interval = tickTime * wheelSize;
        this.currentTime = startTime - (startTime % tickTime);

        this.buckets = new TimerTaskList[wheelSize];
        for (int i = 0; i < buckets.length; i++) {
            this.buckets[i] = new TimerTaskList(this, taskCounter);
        }
    }

    /**
     * Add timer task entry.
     *
     * @param timerTaskEntry timerTaskEntry
     * @return Boolean
     */
    public Boolean add(io.openjob.server.scheduler.timer.TimerTaskEntry timerTaskEntry) {
        long expiration = timerTaskEntry.getExpiration();
        if (timerTaskEntry.canceled()) {
            return false;
        }

        if (expiration < currentTime + tickTime) {
            return false;
        }

        //todo
        //事件判断的时间窗口有问题，
        //原本是expiration<currentTime+interval，现在改成expiration<startTime+interval
        //startTime是当前时间轮的开始时间，interval是时间轮的间隔，expiration是任务的到期时间
        //如果是currentTime+interval这个判断逻辑上就说不通，当前的时间轮永远都不会过期。
        if (expiration < startTime + interval) {
            long virtualId = expiration / tickTime;
            int index = (int) (virtualId % wheelSize);
            TimerTaskList bucket = buckets[index];
            timerTaskEntry.setCurrentBucket(index);
            bucket.add(timerTaskEntry);

            Long taskId = timerTaskEntry
                    .getTimerTask()
                    .getTaskId();
            Long slotsId = timerTaskEntry
                    .getTimerTask()
                    .getSlotsId();
            this.taskEntryMap.put(taskId, timerTaskEntry);
            Set<Long> defaultSet = new HashSet<>();
            this.slotsToTaskMap
                    .getOrDefault(slotsId, defaultSet)
                    .add(taskId);
            this.slotsToTaskMap.putIfAbsent(slotsId, defaultSet);

            if (bucket.setExpiration(virtualId * tickTime)) {
                delayQueue.offer(bucket);
            }

            return true;
        }

        if (Objects.isNull(overflowWheel)) {
            addOverflowWheel();
        }

        return overflowWheel.add(timerTaskEntry);
    }

    //todo
    //map映射都是在本地维护的，如果删除的任务不是在本地插入的，本地不存在相应的映射关系，就会删除失败
    //这是单机设计在分布式环境下的适配问题
    //可通过Redis将映射关系外部化

    /**
     * Remove by task id.
     *
     * @param taskId task id.
     */
    public void removeByTaskId(Long taskId) {
        io.openjob.server.scheduler.timer.TimerTaskEntry timerTaskEntry = taskEntryMap.remove(taskId);
        if (Objects.nonNull(timerTaskEntry)) {
            // Remove slots.
            //todo
            //这个“slotsIds”，叫“taskIdSet”才对，其中存的是与slotId对应的taskId的集合；
            Set<Long> slotsIds = this.slotsToTaskMap.remove(timerTaskEntry
                    .getTimerTask()
                    .getSlotsId());
            Optional
                    .ofNullable(slotsIds)
                    .ifPresent(s -> s.remove(taskId));

            TimerTaskList bucket = buckets[timerTaskEntry.getCurrentBucket()];
            bucket.remove(timerTaskEntry);
            return;
        }

        if (Objects.nonNull(overflowWheel)) {
            overflowWheel.removeByTaskId(taskId);
        }
    }

    /**
     * Remove by slots' id.
     *
     * @param slotsId slotsId
     */
    public void removeBySlotsId(Long slotsId) {
        Optional
                .ofNullable(this.slotsToTaskMap.remove(slotsId))
                .ifPresent(s -> s.forEach(this::removeByTaskId));


        if (Objects.nonNull(overflowWheel)) {
            this.overflowWheel.removeBySlotsId(slotsId);
        }
    }

    /**
     * Advance clock by time.
     *
     * @param time time
     */
    public void advanceClock(Long time) {
        if (time >= currentTime + tickTime) {
            currentTime = time - (time % tickTime);

            if (Objects.nonNull(overflowWheel)) {
                overflowWheel.advanceClock(currentTime);
            }
        }
    }

    /**
     * Remove entry map by taskId.
     *
     * @param taskId taskId
     */
    public void removeFromEntryMap(Long taskId) {
        this.taskEntryMap.remove(taskId);
    }

    //todo
    //溢出轮的时间粒度与当前时间轮相同
    //如果插入一个远期任务，会导致连锁创建大量溢出轮进而导致性能抖动（触发full gc,占用主线程，或是占用锁资源）；
    //重新设计溢出轮和时间推进的逻辑，当然，这个任务优先级不高；

    /**
     * Add overflow wheel.
     */
    private void addOverflowWheel() {
        synchronized (this) {
            if (Objects.isNull(overflowWheel)) {
                overflowWheel = new TimingWheel(this.interval, this.wheelSize, this.currentTime, this.taskCounter, this.delayQueue);
            }
        }
    }

}
