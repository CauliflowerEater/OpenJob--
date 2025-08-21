package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerSubmitJobInstanceRequest implements Serializable {
    private Long jobId;
    private Long jobInstanceId;
    private Long circleId;
    private Long dispatchVersion;
    private String jobParamType;
    private String jobParams;
    private String jobExtendParamsType;
    private String jobExtendParams;
    private Long workflowId;
    private String processorType;
    private String processorInfo;
    private String executeType;
    private Integer failRetryTimes;
    private Integer failRetryInterval;
    private Integer executeTimeout;
    private Integer concurrency;
    private String timeExpressionType;
    private String timeExpression;
    private Integer executeOnce;
}
