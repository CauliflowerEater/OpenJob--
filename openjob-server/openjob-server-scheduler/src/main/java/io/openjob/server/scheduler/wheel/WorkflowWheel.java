package io.openjob.server.scheduler.wheel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.openjob.server.scheduler.autoconfigure.SchedulerProperties;


@Component
public class WorkflowWheel extends AbstractWheel {

    private final SchedulerProperties schedulerProperties;

    @Autowired
    public WorkflowWheel(SchedulerProperties schedulerProperties) {
        this.schedulerProperties = schedulerProperties;
    }

    @Override
    public void start() {
        int wheelSize = this.schedulerProperties
                .getWorkflow()
                .getTimingWheelSize();
        if (wheelSize < 1) {
            throw new RuntimeException(String.format("Scheduler timingWheelSize invalid! timingWheelSize=%d", wheelSize));
        }

        this.createWheel(wheelSize, "workflow");
    }

    @Override
    public void stop() {
        this.shutdownWheel("workflow");
    }
}
