package io.openjob.common.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class WorkerJobInstanceTaskLogRequest implements Serializable {
    private List<List<WorkerJobInstanceTaskLogFieldRequest>> fieldList;
}
