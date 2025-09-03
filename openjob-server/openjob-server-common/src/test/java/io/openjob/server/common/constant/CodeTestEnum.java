package io.openjob.server.common.constant;

import io.openjob.server.common.exception.CodeExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CodeTestEnum implements CodeExceptionAssert {
    ONE(1, "code message");

    private final Integer value;
    private final String message;
}
