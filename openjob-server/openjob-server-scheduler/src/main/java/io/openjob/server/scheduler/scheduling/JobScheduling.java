package io.openjob.server.scheduler.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.openjob.server.scheduler.constant.SchedulerConstant;
import io.openjob.server.scheduler.service.JobSchedulingService;


/**
 * 时间轮系统的调度类;
 * 负责的是jobInstance的调度;
 */
@Component
public class JobScheduling {
    private final JobSchedulingService jobSchedulingService;

    @Autowired
    public JobScheduling(JobSchedulingService jobSchedulingService) {
        this.jobSchedulingService = jobSchedulingService;
    }

    @Scheduled(initialDelay = SchedulerConstant.JOB_INITIAL_DELAY, fixedDelay = SchedulerConstant.JOB_FIXED_DELAY)
    public void scheduleJob() {
        this.jobSchedulingService.scheduleJob();
    }

    @Scheduled(initialDelay = SchedulerConstant.JOB_INITIAL_DELAY, fixedDelay = SchedulerConstant.JOB_FIXED_DELAY)
    public void scheduleFailoverJob() {
        this.jobSchedulingService.scheduleFailoverJob();
    }
}
