package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class DelayInstanceTotalDTO {
    private String topic;
    private Long total;

    public DelayInstanceTotalDTO(String topic, Long total) {
        this.topic = topic;
        this.total = total;
    }
}
