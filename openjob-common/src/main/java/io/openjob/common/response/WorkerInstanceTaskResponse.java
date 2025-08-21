package io.openjob.common.response;

import java.io.Serializable;

import io.openjob.common.request.WorkerJobInstanceTaskRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class WorkerInstanceTaskResponse extends WorkerJobInstanceTaskRequest implements Serializable {
}
