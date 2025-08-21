package io.openjob.common.response;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;


@Data
public class ServerHeartbeatResponse implements Serializable {

    /**
     * Worker address list.
     */
    private Set<String> workerAddressList;

    private ServerHeartbeatSystemResponse systemResponse;
}
