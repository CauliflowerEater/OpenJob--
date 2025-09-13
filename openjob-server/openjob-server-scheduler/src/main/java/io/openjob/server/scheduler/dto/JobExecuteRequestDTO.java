package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class JobExecuteRequestDTO {
    private Long id;

    private String params;

    private String extendParams;
}
