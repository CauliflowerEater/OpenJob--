//@formatter:off
package io.openjob.common.util;

import java.util.Arrays;

public class FormatStackTraceAsString {

    /**
     * Format stack trace
     * @param e e
     * @return String
     */
    public static String FormatStackTraceAsString(Throwable e) {
        StringBuffer sb = new StringBuffer();
        sb.append(e.getClass().getName()).append(": ").append(e.getMessage()).append('\n');
        Arrays.stream(e.getStackTrace()).forEach(s -> sb.append(s.toString()).append('\n'));
        return sb.toString();
    }
}
