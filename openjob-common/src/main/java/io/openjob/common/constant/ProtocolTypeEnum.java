package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ProtocolTypeEnum {
    /**
     * Akka.
     */
    AKKA("akka"),

    /**
     * Http
     */
    HTTP("http"),
    ;

    private final String type;
}
