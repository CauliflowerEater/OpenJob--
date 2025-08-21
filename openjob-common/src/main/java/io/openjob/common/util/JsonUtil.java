package io.openjob.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * json encode
     *
     * @param object object
     * @return String
     */
    public static String encode(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json encode failed!", e);
        }
    }

    /**
     * json decode
     *
     * @param json          json
     * @param typeReference typeReference
     * @param <T>           T
     * @return T
     */
    public static <T> T decode(String json, TypeReference<T> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);

        } catch (Exception e) {
            throw new RuntimeException("Json decode failed!", e);
        }
    }

    //这个方法可以省略，decode可以统一走typeReference，只是需要重载一下支持targetClass参数，typeReference还需要额外创建一个typeReference对象。

    /**
     * json decode
     *
     * @param json        json
     * @param targetClass targetClass
     * @param <T>         T
     * @return T
     */
    public static <T> T decode(String json, Class<T> targetClass) {
        try {
            return OBJECT_MAPPER.readValue(json, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Json decode failed!", e);
        }
    }
}
