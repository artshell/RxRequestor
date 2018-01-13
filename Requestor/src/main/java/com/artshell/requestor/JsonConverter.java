/*
 * Copyright 2017 artshell. https://github.com/artshell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artshell.requestor;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

public final class JsonConverter implements Converter {
    private Gson gson = new Gson();

    public static JsonConverter create() {
        return new JsonConverter();
    }

    @Override
    public <T> T apply(Class<T> target, ResponseBody body) throws IOException {
        try {
            return gson.fromJson(body.charStream(), target);
        } finally {
            body.close();
        }
    }
}
