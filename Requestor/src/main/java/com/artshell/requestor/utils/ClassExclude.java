package com.artshell.requestor.utils;

/**
 * Created by artshell on 2017/11/22.
 */

public class ClassExclude {
    public static <T> void exclude(Class<T> clz) {
        Objects.requireNonNull(clz, "clz == null");
        if (clz == byte.class || clz == Byte.class || clz == byte[].class) {
            throw new IllegalStateException("You should use Byte[].class as parameterize type, eg: Flowable<Byte[]>> post(Byte[].class ...)");
        }
    }
}
