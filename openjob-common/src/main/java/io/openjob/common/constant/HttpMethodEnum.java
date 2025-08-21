package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum HttpMethodEnum {
    /**
     * GET
     */
    FORM("GET"),

    /**
     * POST
     */
    JSON("POST"),
    ;

    private final String type;
}
