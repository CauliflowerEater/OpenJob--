package io.openjob.common.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerDelayPullRequest implements Serializable {
    private String workerAddress;
    private List<WorkerDelayItemPullRequest> pullItems;
}