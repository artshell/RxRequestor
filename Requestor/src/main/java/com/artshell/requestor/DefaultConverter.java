package com.artshell.requestor;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

public class DefaultConverter implements ResultConverter {
    private Gson gson = new Gson();

    @Override
    public <T> T apply(Class<T> target, ResponseBody body) throws IOException {
        try {
            return gson.fromJson(body.string(), target);
        } finally {
            body.close();
        }
    }
}
