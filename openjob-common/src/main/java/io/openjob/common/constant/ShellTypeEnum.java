package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ShellTypeEnum {

    /**
     * unix
     */
    UNIX("unix"),

    /**
     * windows
     */
    WINDOWS("windows"),
    ;

    /**
     * Type
     */
    private final String type;
}
