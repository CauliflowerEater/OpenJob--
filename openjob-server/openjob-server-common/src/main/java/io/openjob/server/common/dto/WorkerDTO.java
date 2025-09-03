package io.openjob.server.common.dto;

import lombok.Data;

@Data
public class WorkerDTO {
    /**
     * App id
     */
    private Long appID;

    /**
     * Namespace id
     */
    private Long namespaceId;

    /**
     * App name
     */
    private String appName;

    /**
     * Worker key
     */
    private String workerKey;

    /**
     * Address
     */
    private String address;
    
    /**
     * Protocol type
     */
    private String protocolType;
}
