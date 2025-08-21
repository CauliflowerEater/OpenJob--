package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class WorkerStopRequest implements Serializable {
    private String workerKey;

    private String appName;

    private String address;
}
