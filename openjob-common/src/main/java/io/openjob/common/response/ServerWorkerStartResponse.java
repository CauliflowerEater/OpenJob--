package io.openjob.common.response;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;


@Data
public class ServerWorkerStartResponse implements Serializable {
    private Long appId;
    private String appName;
    private Set<String> workerAddressList;
}
