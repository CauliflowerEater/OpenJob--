package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class TopicFailCounterDTO {
    private String topic;
    private Long count;
}
