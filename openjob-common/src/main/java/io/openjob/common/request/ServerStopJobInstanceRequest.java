package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerStopJobInstanceRequest implements Serializable {
    private Long jobId;

    private Long jobInstanceId;
}
