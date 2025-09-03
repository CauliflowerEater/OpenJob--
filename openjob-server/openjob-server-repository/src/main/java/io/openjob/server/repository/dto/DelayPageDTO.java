package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class DelayPageDTO {
    private Long namespaceId;

    private Long appId;

    private String name;

    private String topic;

    private Integer page;

    private Integer size;
}
