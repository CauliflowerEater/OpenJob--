package io.openjob.common.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class ServerDelayPullResponse implements Serializable {
    private List<ServerDelayInstanceResponse> delayInstanceResponses;
}
