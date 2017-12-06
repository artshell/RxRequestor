package com.artshell.requestor;


import java.io.InputStream;
import java.io.Reader;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

public class MapperProvider {
    private ResultConverter mConverter;

    public MapperProvider(ResultConverter converter) {
        mConverter = converter;
    }

    public ResultConverter getConverter() {
        return mConverter;
    }

    public <T> Function<ResponseBody, T> converterFor(Class<T> target) {
        return new ResponseBodyFunction<>(mConverter, target);
    }

    private static class ResponseBodyFunction<T> implements Function<ResponseBody, T> {
        private ResultConverter mConverter;
        private Class<T> clazz;

        ResponseBodyFunction(ResultConverter converter, Class<T> target) {
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
            } else if (clazz == Void.class) {
                return (T) Void.TYPE.newInstance();
            } else {
                return mConverter.apply(clazz, body);
            }
        }
    }
}
