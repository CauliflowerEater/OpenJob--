package io.openjob.server.common.exception;

import java.text.MessageFormat;

public interface CodeExceptionAssert extends BaseExceptionAssert {

    default RuntimeException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new CodeException(this, args, msg);

    }

    default RuntimeException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new CodeException(this, args, msg, t);
    }
}
