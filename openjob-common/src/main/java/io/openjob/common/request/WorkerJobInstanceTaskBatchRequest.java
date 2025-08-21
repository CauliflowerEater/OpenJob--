package io.openjob.common.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerJobInstanceTaskBatchRequest implements Serializable {

    /**
     * Delivery id.
     */
    private Long deliveryId;

    /**
     * Job instance task list.
     * Aggregation many circle task, if second delay task.
     */
    private List<WorkerJobInstanceTaskRequest> taskRequestList;
}
