package io.openjob.common.task;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseConsumer<T> {

    protected final Long id;
    protected final Integer consumerCoreThreadNum;
    protected final Integer consumerMaxThreadNum;
    protected final String consumerThreadName;
    protected Long pollIdleTime = 1000L;
    protected Long pollSleepTime = 500L;
    protected ThreadPoolExecutor consumerExecutor;
    protected Integer pollSize;
    //这两个pollThread可能是废逻辑
    //todo
    protected String pollThreadName;
    protected Thread pollThread;
    protected TaskQueue<T> queues;
    protected ThreadPoolExecutor pullExecutor;
    protected AtomicInteger activePollNum = new AtomicInteger(0);

    /**
     * @param id                    id
     * @param consumerCoreThreadNum consumerCoreThreadNum
     * @param consumerMaxThreadNum  consumerMaxThreadNum
     * @param consumerThreadName    consumerThreadName
     * @param pollSize              pollSize
     * @param pollThreadName        pollThreadName
     * @param queues                queues
     */
    public BaseConsumer(Long id,
            Integer consumerCoreThreadNum,
            Integer consumerMaxThreadNum,
            String consumerThreadName,
            Integer pollSize,
            String pollThreadName,
            TaskQueue<T> queues) {
        this.id = id;
        this.consumerCoreThreadNum = consumerCoreThreadNum;
        this.consumerMaxThreadNum = consumerMaxThreadNum;
        this.consumerThreadName = consumerThreadName;
        this.pollSize = pollSize;
        this.pollThreadName = pollThreadName;
        this.queues = queues;
    }

    /**
     * @param id                    id
     * @param consumerCoreThreadNum consumerCoreThreadNum
     * @param consumerMaxThreadNum  consumerMaxThreadNum
     * @param consumerThreadName    consumerThreadName
     * @param pollSize              pollSize
     * @param pollThreadName        pollThreadName
     * @param queues                queues
     * @param pollIdleTime          pollIdleTime(ms)
     * @param pollSleepTime         pollSleepTime(ms)
     */
    public BaseConsumer(Long id,
            Integer consumerCoreThreadNum,
            Integer consumerMaxThreadNum,
            String consumerThreadName,
            Integer pollSize,
            String pollThreadName,
            TaskQueue<T> queues,
            Long pollIdleTime,
            Long pollSleepTime) {
        this.id = id;
        this.consumerCoreThreadNum = consumerCoreThreadNum;
        this.consumerMaxThreadNum = consumerMaxThreadNum;
        this.consumerThreadName = consumerThreadName;
        this.pollSize = pollSize;
        this.pollThreadName = pollThreadName;
        this.queues = queues;
        this.pollIdleTime = pollIdleTime;
        this.pollSleepTime = pollSleepTime;
    }

    /**
     * Start
     */
    @SuppressWarnings("all")
    public void start() {
        consumerExecutor = new ThreadPoolExecutor(
                this.consumerCoreThreadNum,
                this.consumerMaxThreadNum,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10240),
                new ThreadFactory() {
                    private final AtomicInteger index = new AtomicInteger(1);

                    @Override
                    public Thread newThread(@NonNull Runnable r) {
                        return new Thread(r, String.format("%s-%d-%d", consumerThreadName, id, index.getAndIncrement()));
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        consumerExecutor.allowCoreThreadTimeOut(true);

        this.pullExecutor = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                r -> new Thread(r, pollThreadName)
        );

        //todo
        //拉取线程自动恢复逻辑未实现；
        this.pullExecutor.submit(() -> {
            try {
                while (!Thread
                        .currentThread()
                        .isInterrupted()) {
                    List<T> tasks = this.pollTasks();
                    if (tasks.size() < this.pollSize) {
                        if (tasks.isEmpty()) {
                            Thread.sleep(this.pollIdleTime);
                            continue;
                        }
                        Thread.sleep(this.pollSleepTime);
                    }

                }
            } catch (Throwable ex) {
                log.warn("Task consumer failed! message={}", ex.getMessage());
            }
        });


    }

    /**
     * @param id    id
     * @param tasks tasks
     */
    public abstract void consume(Long id, List<T> tasks);

    /**
     * stop
     */
    public void stop() {
        //Poll thread
        //这个逻辑可能是废逻辑.
        //todo
        if (Objects.nonNull(pollThread)) {
            pollThread.interrupt();
        }

        if (Objects.nonNull(consumerExecutor)) {
            consumerExecutor.shutdownNow();
        }

        if (Objects.nonNull(this.queues)) {
            this.queues.clear();
        }

        if (Objects.nonNull(this.pullExecutor)) {
            this.pullExecutor.shutdownNow();
        }
    }

    /**
     * Whether is active.
     *
     * @return boolean
     */
    public synchronized boolean isActive() {
        return queues.size() > 0 || activePollNum.get() > 0;
    }

    /**
     * @return activePollNum
     */
    public AtomicInteger getActivePollNum() {
        return activePollNum;
    }

    //pollTask方法可以考虑将activePollNum的decrementAndGet()方法打包在finally逻辑块中，这样consume方法就不必操作activePollNum。

    /**
     * @return List<T>
     */
    private synchronized List<T> pollTasks() {
        List<T> tasks = queues.poll(this.pollSize);
        if (!tasks.isEmpty()) {
            this.activePollNum.incrementAndGet();
            this.consume(id, tasks);
        }
        return tasks;
    }
}
