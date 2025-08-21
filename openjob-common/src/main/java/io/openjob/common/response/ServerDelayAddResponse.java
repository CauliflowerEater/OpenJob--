package io.openjob.common.response;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerDelayAddResponse implements Serializable {

    /**
     * Delay task unique id.
     * If is null or blank, will to auto generate.
     */
    private String taskId;
}
