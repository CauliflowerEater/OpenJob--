package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class WorkerStartRequest implements Serializable {

    private String workerKey;

    private String appName;

    private String address;

    private String version;

    private String protocolType;

    private Metric metric;

    @Data
    public static class Metric {

    }
}

