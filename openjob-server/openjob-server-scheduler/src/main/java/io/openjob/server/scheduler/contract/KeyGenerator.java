package io.openjob.server.scheduler.contract;


@FunctionalInterface
public interface KeyGenerator<T> {

    /**
     * Default generator.
     *
     * @param keyPrefix key prefix.
     * @param <T>       type
     * @return KeyGenerator
     */
    static <T> KeyGenerator<T> defGenerator(String keyPrefix) {
        return key -> String.format("%s:%s", keyPrefix, key.toString());
    }

    /**
     * Key generator.
     *
     * @param t type
     * @return String
     */
    String generator(T t);
}