package io.openjob.common.constant;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum InstanceStatusEnum {

    /**
     * Waiting for dispatch.
     */
    WAITING(1, "waiting"),

    /**
     * Running.
     */
    RUNNING(5, "running"),

    /**
     * Success.
     */
    SUCCESS(10, "success"),

    /**
     * Fail.
     */
    FAIL(15, "fail"),

    /**
     * Stop.
     */
    STOP(20, "stop"),

    /**
     * Cancel.
     */
    CANCEL(25, "cancel"),
    ;

    /**
     * Complete status.
     */
    public static final List<Integer> COMPLETE = Arrays.asList(
            SUCCESS.getStatus(),
            FAIL.getStatus(),
            STOP.getStatus(),
            CANCEL.getStatus()
    );
    /**
     * Not complete status.
     */
    public static final List<Integer> NOT_COMPLETE = Arrays.asList(
            WAITING.getStatus(),
            RUNNING.getStatus()
    );
    private final Integer status;
    private final String message;

    /**
     * Is running
     *
     * @param status status
     * @return Boolean
     */
    public static Boolean isRunning(Integer status) {
        return RUNNING
                .getStatus()
                .equals(status);
    }

    /**
     * Is failed
     *
     * @param status status
     * @return Boolean
     */
    public static Boolean isFailed(Integer status) {
        return FAIL
                .getStatus()
                .equals(status);
    }
}
