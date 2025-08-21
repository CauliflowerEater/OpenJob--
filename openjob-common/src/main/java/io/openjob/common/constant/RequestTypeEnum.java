package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum RequestTypeEnum {
    /**
     * Server
     */
    SERVER("server"),

    /**
     * Agent
     */
    AGENT("agent"),
    ;

    private final String type;
}
