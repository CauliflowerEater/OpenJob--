package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class WorkerDelayItemPullRequest implements Serializable {
    private String topic;
    private Integer size;

    /**
     * Non arg constructor for Serializable.
     */
    @SuppressWarnings("unused")
    public WorkerDelayItemPullRequest() {
    }

    public WorkerDelayItemPullRequest(String topic, Integer size) {
        this.topic = topic;
        this.size = size;
    }
}
