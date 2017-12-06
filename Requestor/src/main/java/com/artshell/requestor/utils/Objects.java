package com.artshell.requestor.utils;

/**
 * Created by artshell on 2017/11/1.
 */

public class Objects {
    private Objects() {
        throw new AssertionError("No com.artshell.utils.common.Objects instances for you!");
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }

    public static <T> T requireNonNull(T obj, String tip) {
        if (obj == null)
            throw new NullPointerException(tip);
        return obj;
    }

    public static <T> T requireNonNull(T obj, Provider<String> tipProvider) {
        if (obj == null)
            throw new NullPointerException(tipProvider.get());
        return obj;
    }
}
