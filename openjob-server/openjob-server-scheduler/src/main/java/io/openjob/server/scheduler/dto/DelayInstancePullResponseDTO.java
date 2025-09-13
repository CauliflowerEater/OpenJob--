package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class DelayInstancePullResponseDTO {
    private String topic;
    private String taskId;
    private Long delayId;
    private Long delayPid;
    private String delayParams;
    private String delayExtra;
    private String processorInfo;
    private Integer failRetryTimes;
    private Integer failRetryInterval;
    private Integer executeTimeout;
    private Integer blockingSize;
    private Integer concurrency;
    private Integer failTopicEnable;
    private Integer failTopicConcurrency;
}
