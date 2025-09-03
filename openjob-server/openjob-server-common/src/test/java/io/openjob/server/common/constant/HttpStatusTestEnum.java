package io.openjob.server.common.constant;

import io.openjob.server.common.exception.HttpStatusExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum HttpStatusTestEnum implements HttpStatusExceptionAssert {
    ONE(1, "http status message");

    private final Integer value;
    private final String message;
}
