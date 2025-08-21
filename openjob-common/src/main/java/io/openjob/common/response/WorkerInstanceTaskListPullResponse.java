package io.openjob.common.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerInstanceTaskListPullResponse implements Serializable {
    /**
     * Task list.
     */
    private List<WorkerInstanceTaskResponse> taskList;
}