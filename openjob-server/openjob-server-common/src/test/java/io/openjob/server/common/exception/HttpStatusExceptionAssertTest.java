package io.openjob.server.common.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.openjob.server.common.constant.HttpStatusTestEnum;


public class HttpStatusExceptionAssertTest {
    @Test
    public void testThrownException() {
        Assertions.assertThrows(HttpStatusException.class, HttpStatusTestEnum.ONE::throwException);
    }

    @Test
    public void testAssert() {
        Assertions.assertThrows(HttpStatusException.class, () -> HttpStatusTestEnum.ONE.assertIsTrue(false));
    }
}
