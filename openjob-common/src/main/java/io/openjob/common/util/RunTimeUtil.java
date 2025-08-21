package io.openjob.common.util;

public class RunTimeUtil {

    /**
     * Get available processors
     *
     * @return Integer
     */
    public static Integer processors() {
        return Runtime
                .getRuntime()
                .availableProcessors();
    }
}
