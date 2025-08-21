package io.openjob.common.response;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerHeartbeatSystemResponse implements Serializable {

    /**
     * Cluster version
     */
    private Long clusterVersion;

    /**
     * Cluster delay version
     */
    private Long clusterDelayVersion;
}
