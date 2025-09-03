package io.openjob.server.log.dto;

import java.util.List;

import lombok.Data;


@Data
public class ProcessorLogDTO {
    private String taskId;
    private String workerAddress;
    private List<ProcessorLogFieldDTO> fields;
    private Long time;
}
