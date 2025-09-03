package io.openjob.server.log.dto;

import java.util.Map;

import lombok.Data;


@Data
public class ProcessorLogElasticDTO {
    private String taskId;
    private String workerAddress;
    private String message;
    private String throwable;
    private Map<String, String> fields;
    private Long time;
}
