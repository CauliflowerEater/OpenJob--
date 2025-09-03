package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class JobPageDTO {
    private Long namespaceId;

    private Long appId;

    private String name;

    private Integer status;

    private Integer page;

    private Integer size;
}
