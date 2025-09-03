package io.openjob.server.common.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.openjob.server.common.constant.CodeTestEnum;


public class CodeExceptionAssertTest {

    @Test
    public void testThrownException() {
        Assertions.assertThrows(CodeException.class, CodeTestEnum.ONE::throwException);
    }

    @Test
    public void testAssert() {
        Assertions.assertThrows(CodeException.class, () -> CodeTestEnum.ONE.assertIsTrue(false));
    }
}
