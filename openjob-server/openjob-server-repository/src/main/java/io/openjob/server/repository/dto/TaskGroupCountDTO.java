package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class TaskGroupCountDTO {
    private String parentTaskId;
    private Long count;

    public TaskGroupCountDTO(String parentTaskId, Long count) {
        this.parentTaskId = parentTaskId;
        this.count = count;
    }
}
