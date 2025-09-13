package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class StopTaskRequestDTO {
    private Long jobInstanceId;

    private Long dispatchVersion;

    private Long circleId;

    private String taskId;
}
