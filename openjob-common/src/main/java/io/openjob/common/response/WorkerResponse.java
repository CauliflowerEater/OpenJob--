package io.openjob.common.response;

import java.io.Serializable;

import lombok.Data;


@Data
public class WorkerResponse implements Serializable {
    private Long deliveryId;

    /**
     * Non arg constructor for Serializable.
     */
    @SuppressWarnings("unused")
    public WorkerResponse() {
    }

    public WorkerResponse(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}
