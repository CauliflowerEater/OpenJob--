package io.openjob.common.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerDelayStatusRequest implements Serializable {

    /**
     * Delivery id.
     */
    private Long deliveryId;

    /**
     * Delay task list.
     */
    private List<WorkerDelayTaskRequest> taskList;
}
