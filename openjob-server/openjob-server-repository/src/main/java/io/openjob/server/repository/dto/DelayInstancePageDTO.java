package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class DelayInstancePageDTO {
    private Long namespaceId;

    private Long appId;

    private Long delayId;

    private String taskId;

    private Integer status;

    private Integer page;

    private Integer size;

    private Long beginTime;

    private Long endTime;
}
