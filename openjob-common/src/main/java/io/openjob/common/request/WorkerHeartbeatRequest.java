package io.openjob.common.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerHeartbeatRequest implements Serializable {
    private Long appId;

    private String appName;

    private String address;

    private String version;

    /**
     * Running job instance ids.
     */
    private List<Long> runningJobInstanceIds;
}
