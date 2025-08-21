package io.openjob.common.response;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerResponse implements Serializable {
    private Long deliveryId;

    /**
     * Non arg constructor for Serializable.
     */
    @SuppressWarnings("unused")
    public ServerResponse() {
    }

    public ServerResponse(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}
