package io.openjob.common.constant;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TimeExpressionTypeEnum {

    /**
     * None for workflow.
     */
    NONE("none"),

    /**
     * Cron.
     */
    CRON("cron"),

    /**
     * Fixed rate.
     */
    FIXED_RATE("fixedRate"),

    /**
     * Second delay.
     */
    SECOND_DELAY("secondDelay"),

    /**
     * One time.
     */
    ONE_TIME("oneTime"),
    ;

    public static final List<String> CRON_TYPES = Arrays.asList(CRON.type, ONE_TIME.type);
    private final String type;

    public static Boolean isCron(String type) {
        return CRON
                .getType()
                .equals(type);
    }

    public static Boolean isFixedRate(String type) {
        return FIXED_RATE
                .getType()
                .equals(type);
    }

    public static Boolean isSecondDelay(String type) {
        return SECOND_DELAY
                .getType()
                .equals(type);
    }

    public static Boolean isOneTime(String type) {
        return ONE_TIME
                .getType()
                .equals(type);
    }
}
