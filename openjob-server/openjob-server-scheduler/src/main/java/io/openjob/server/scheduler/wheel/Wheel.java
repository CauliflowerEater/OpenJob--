package io.openjob.server.scheduler.wheel;

import java.util.List;
import java.util.Set;

import io.openjob.server.repository.entity.JobInstance;
import io.openjob.server.scheduler.timer.AbstractTimerTask;


public interface Wheel {

    /**
     * Start.
     */
    void start();

    /**
     * Stop.
     */
    void stop();

    /**
     * Add timer task.
     *
     * @param timerTasks timerTasks
     */
    void addTimerTask(List<AbstractTimerTask> timerTasks);

    /**
     * Remove task from timing wheel by task ids.
     *
     * @param jobInstances jobInstances
     */
    void removeByTaskId(List<JobInstance> jobInstances);

    /**
     * Remove task from timing wheel by slots ids.
     *
     * @param slotsIds slotsIds
     */
    void removeBySlotsId(Set<Long> slotsIds);
}
