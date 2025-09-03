package io.openjob.server.common.exception;

import java.text.MessageFormat;

public interface HttpStatusExceptionAssert extends BaseExceptionAssert {

    /**
     * New exception
     *
     * @param args args
     * @return RuntimeException
     */
    default RuntimeException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new HttpStatusException(this, args, msg);
    }

    /**
     * New exception
     *
     * @param cause exception
     * @param args  args
     * @return RuntimeException
     */
    default RuntimeException newException(Throwable cause, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new HttpStatusException(this, args, msg, cause);
    }
}
