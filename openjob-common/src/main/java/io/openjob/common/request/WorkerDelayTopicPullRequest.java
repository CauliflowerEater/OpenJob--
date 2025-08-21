package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class WorkerDelayTopicPullRequest implements Serializable {
    private String appName;
}
