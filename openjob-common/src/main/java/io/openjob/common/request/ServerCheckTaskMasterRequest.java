package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerCheckTaskMasterRequest implements Serializable {
    private Long jobId;
    private Long jobInstanceId;
}
