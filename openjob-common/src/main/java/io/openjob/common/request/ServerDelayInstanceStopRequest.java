package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerDelayInstanceStopRequest implements Serializable {
    private String taskId;
}
