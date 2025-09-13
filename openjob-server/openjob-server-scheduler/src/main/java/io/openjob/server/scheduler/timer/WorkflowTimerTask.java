package io.openjob.server.scheduler.timer;


public class WorkflowTimerTask extends AbstractTimerTask {

    /**
     * Timer task.
     *
     * @param taskId     taskId
     * @param slotsId    slotsId
     * @param expiration expiration
     */
    public WorkflowTimerTask(Long taskId, Long slotsId, Long expiration) {
        super(taskId, slotsId, expiration);
    }

    @Override
    public void run() {

    }
}
