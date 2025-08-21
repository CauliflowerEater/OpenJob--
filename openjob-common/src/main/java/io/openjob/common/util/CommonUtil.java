package io.openjob.common.util;

import java.util.Objects;

import io.openjob.common.constant.CommonConstant;

public class CommonUtil {

    /**
     * check input value is not null and equals to {CommonConst.YES}
     *
     * @param val bool int
     * @return bool
     */
    public static boolean isTrue(Integer val) {
        return Objects.nonNull(val) && CommonConstant.YES.equals(val);
    }

    /**
     * check input value is null or not equals to {CommonConst.YES}
     *
     * @param val bool int
     * @return bool
     */
    public static boolean isFalse(Integer val) {
        return Objects.isNull(val) || !CommonConstant.YES.equals(val);
    }
}
