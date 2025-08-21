package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BoolIntEnum {
    /**
     * Yes is true
     */
    YES(1),

    /**
     * NO: false
     */
    NO(2),
    ;

    private final Integer type;
}
