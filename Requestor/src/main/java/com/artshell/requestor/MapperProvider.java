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

import java.io.InputStream;
import java.io.Reader;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

final class MapperProvider {
    private Converter mConverter;

    public MapperProvider(Converter converter) {
        mConverter = converter;
    }

    public Converter getConverter() {
        return mConverter;
    }

    public <T> Function<ResponseBody, T> converterFor(Class<T> target) {
        return new ResponseBodyFunction<>(mConverter, target);
    }

    private static class ResponseBodyFunction<T> implements Function<ResponseBody, T> {
        private Converter mConverter;
        private Class<T> clazz;

        ResponseBodyFunction(Converter converter, Class<T> target) {
            mConverter = converter;
            this.clazz = target;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T apply(ResponseBody body) throws Exception {
            if (clazz == ResponseBody.class) {
                return (T) body;
            } else if (clazz == Byte[].class) {
                byte[] bts = body.bytes();
                Byte[] copy = new Byte[bts.length];
                for (int i = 0; i < bts.length; i++) {
                    copy[i] = bts[i];
                }
                return (T) copy;
            } else if (clazz == Reader.class) {
                return (T) body.charStream();
            } else if (clazz == InputStream.class) {
                return (T) body.byteStream();
            } else if (clazz == String.class) {
                return (T) body.string();
            } else {
                return mConverter.apply(clazz, body);
            }
        }
    }
}
