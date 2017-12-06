package com.artshell.requestor;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

public interface ResultConverter {
    /**
     * @param target    custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                  {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param body
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T apply(Class<T> target, ResponseBody body) throws IOException;
}
