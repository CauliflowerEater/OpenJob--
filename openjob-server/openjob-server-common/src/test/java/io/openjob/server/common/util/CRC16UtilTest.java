package io.openjob.server.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CRC16UtilTest {
    @Test
    public void testCRC16() {
        int v = CrcUtil.crc16("test".getBytes());
        Assertions.assertEquals(1928, v);
    }
}
