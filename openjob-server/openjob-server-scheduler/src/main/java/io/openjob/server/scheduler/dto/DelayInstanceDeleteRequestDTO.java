package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class DelayInstanceDeleteRequestDTO {

    /**
     * Task id.
     */
    private String taskId;
}
