package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobInstanceStopEnum {

    /**
     * Normal stop
     */
    NORMAL(1, "Normal stop"),

    /**
     * Timout stop
     */
    TIMEOUT(2, "Timeout stop"),
    ;

    private final Integer type;
    private final String message;

    public static Boolean isNormal(Integer type) {
        return NORMAL
                .getType()
                .equals(type);
    }

    public static Boolean isTimeout(Integer type) {
        return TIMEOUT
                .getType()
                .equals(type);
    }
}
