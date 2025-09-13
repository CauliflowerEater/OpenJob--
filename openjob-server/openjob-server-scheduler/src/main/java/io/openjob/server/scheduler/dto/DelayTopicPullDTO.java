package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class DelayTopicPullDTO {
    private Long id;
    private Long pid;
    private String topic;
    private String processorInfo;
    private Integer failRetryTimes;
    private Integer failRetryInterval;
    private Integer executeTimeout;
    private Integer concurrency;
    private Integer failTopicEnable;
    private Integer failTopicConcurrency;
}