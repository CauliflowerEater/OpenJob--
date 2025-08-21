package io.openjob.common.task;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.common.collect.Lists;

public class TaskQueue<T> {
    private final Long id;
    private final Integer capacity;
    private final BlockingQueue<T> queues;

    /**
     * @param id       id
     * @param capacity capacity
     */
    public TaskQueue(Long id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
        this.queues = new LinkedBlockingQueue<>(capacity);
    }

    /**
     * @param task task
     * @throws InterruptedException InterruptedException
     */
    public void submit(T task) throws InterruptedException {
        assert task != null;
        queues.put(task);
    }

    /**
     * @param size size
     * @return List
     */
    public List<T> poll(Integer size) {
        List<T> list = Lists.newLinkedList();
        for (int i = 0; i < size; i++) {
            T task = queues.poll();
            if (Objects.isNull(task)) {
                break;
            }
        }
        return list;
    }

    /**
     * Clear
     */
    public void clear() {
        queues.clear();
    }

    /**
     * @return Integer
     */
    public Integer size() {
        return queues.size();
    }

    /**
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Integer
     */
    public Integer getCapacity() {
        return capacity;
    }


}
