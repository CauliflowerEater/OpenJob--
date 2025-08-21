package io.openjob.common.util;

import io.openjob.common.constant.StatusEnum;
import io.openjob.common.response.Result;


public class ResultUtil {
    public static Boolean isSuccess(Result<?> result) {
        return StatusEnum.SUCCESS
                .getStatus()
                .equals(result.getStatus());
    }
}
