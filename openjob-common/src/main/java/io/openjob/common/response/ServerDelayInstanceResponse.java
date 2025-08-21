package io.openjob.common.response;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerDelayInstanceResponse implements Serializable {
    private String topic;
    private Long delayId;
    private Long delayPid;
    private String taskId;
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
