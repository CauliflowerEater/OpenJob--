package io.openjob.server.log.dto;

import lombok.Data;


@Data
public class ProcessorLogFieldDTO {
    private String name;
    private String value;

    public ProcessorLogFieldDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
