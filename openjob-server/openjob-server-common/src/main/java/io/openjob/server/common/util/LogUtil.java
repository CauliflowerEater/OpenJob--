package io.openjob.server.common.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogUtil {

    /**
     * Log and throw
     *
     * @param message message
     */
    public static void logAndThrow(String message) {
        log.error(message);
        throw new RuntimeException(message);
    }
}
