package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class DelayItemPullRequestDTO {
    private String topic;
    private Integer size;
}
