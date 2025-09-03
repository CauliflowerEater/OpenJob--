package io.openjob.server.common.exception;

import io.openjob.server.common.constant.BaseEnum;
import lombok.Getter;

@Getter
public class CodeException extends RuntimeException {

    /**
     * Base enum
     */
    private final BaseEnum baseNum;

    /**
     * Args
     */
    private final Object[] args;

    /**
     * New exception
     *
     * @param baseEnum baseEnum
     * @param args     args
     * @param message  message
     */
    public CodeException(BaseEnum baseEnum, Object[] args, String message) {
        super(message);
        this.baseNum = baseEnum;
        this.args = args;
    }

    /**
     * New exception
     *
     * @param baseEnum baseEnum
     * @param args     args
     * @param message  message
     * @param cause    cause
     */
    public CodeException(BaseEnum baseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.baseNum = baseEnum;
        this.args = args;
    }
}
