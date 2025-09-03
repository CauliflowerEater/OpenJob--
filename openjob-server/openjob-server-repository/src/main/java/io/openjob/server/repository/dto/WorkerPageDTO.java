package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class WorkerPageDTO {
    /**
     * List page
     */
    private Integer page;

    /**
     * List size. default 10
     */
    private Integer size;

    /**
     * Appid
     */
    private Long appId;

    /**
     * NamespaceId
     */
    private Long namespaceId;

    /**
     * Address
     */
    private String address;
}
