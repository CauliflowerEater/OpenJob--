package io.openjob.server.repository.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum WorkerStatusEnum {
    /**
     * Online.
     */
    ONLINE(1, "online"),

    /**
     * Offline.
     */
    OFFLINE(2, "offline"),
    ;

    private final Integer status;
    private final String message;
}
