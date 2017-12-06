package com.artshell.requestor;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;
import com.artshell.requestor.utils.ClassExclude;
import com.artshell.requestor.utils.Objects;
import com.artshell.requestor.utils.Validates;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

/**
 * @author artshell on 25/11/2017
 */

public class RxRequestor {
    private Retrofit mRetrofit;
    private ApiService mDelegate;
    private MapperProvider mProvider;

    private RxRequestor(Retrofit retrofit, ApiService delegate, MapperProvider provider) {
        mRetrofit = retrofit;
        mDelegate = delegate;
        mProvider = provider;
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param <T>
     * @return
     */
    public <T> Flowable<T> get(Class<T> target, String url) {
        ClassExclude.exclude(target);
        return mDelegate.get(url).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> getWithHeaders(Class<T> target, String url, Map<String, String> headers) {
        Validates.check(target, headers);
        return mDelegate.getWithHeaders(url, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> getWithParameters(Class<T> target, String url, Map<String, String> queryPairs) {
        Validates.check(target, queryPairs);
        return mDelegate.getWithParameters(url, queryPairs).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> getWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers) {
        Validates.check(target, queryPairs, headers);
        return mDelegate.getWithEntirety(url, queryPairs, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param <T>
     * @return
     */
    public <T> Flowable<T> post(Class<T> target, String url) {
        ClassExclude.exclude(target);
        return mDelegate.post(url).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postWithHeaders(Class<T> target, String url, Map<String, String> headers) {
        Validates.check(target, headers);
        return mDelegate.postWithHeaders(url, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postWithParameters(Class<T> target, String url, Map<String, String> queryPairs) {
        Validates.check(target, queryPairs);
        return mDelegate.postWithParameters(url, queryPairs).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param fields refer to {@link FieldMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postFields(Class<T> target, String url, Map<String, String> fields) {
        Validates.check(target, fields);
        return mDelegate.postFields(url, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param fields  refer to {@link FieldMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postWithHeaders(Class<T> target, String url, Map<String, String> headers, Map<String, String> fields) {
        Validates.check(target, headers, fields);
        return mDelegate.postWithHeaders(url, headers, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param fields     refer to {@link FieldMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postWithParameters(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> fields) {
        Validates.check(target, queryPairs, fields);
        return mDelegate.postWithParameters(url, queryPairs, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param fields     refer to {@link FieldMap}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, Map<String, String> fields) {
        Validates.check(target, queryPairs, headers, fields);
        return mDelegate.postWithEntirety(url, queryPairs, headers, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param part   refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPart(Class<T> target, String url, MultipartBody.Part part) {
        ClassExclude.exclude(target);
        return mDelegate.postPart(url, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param part    refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartWithHeaders(Class<T> target, String url, Map<String, String> headers, MultipartBody.Part part) {
        Validates.check(target, headers);
        return mDelegate.postPartWithHeaders(url, headers, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param part       refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartWithParameters(Class<T> target, String url, Map<String, String> queryPairs, MultipartBody.Part part) {
        Validates.check(target, queryPairs);
        return mDelegate.postPartWithParameters(url, queryPairs, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param part       refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, MultipartBody.Part part) {
        Validates.check(target, queryPairs, headers);
        return mDelegate.postPartWithEntirety(url, queryPairs, headers, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, MultipartBody.Part[] parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, MultipartBody.Part[] parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, MultipartBody.Part[] parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, MultipartBody.Part[] parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, List<MultipartBody.Part> parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, List<MultipartBody.Part> parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, List<MultipartBody.Part> parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, List<MultipartBody.Part> parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, Map<String, RequestBody> parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, Map<String, RequestBody> parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, Map<String, RequestBody> parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, Map<String, RequestBody> parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param body   refer to {@link ResponseBody}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postBody(Class<T> target, String url, RequestBody body) {
        ClassExclude.exclude(target);
        return mDelegate.postBody(url, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param headers refer to {@link HeaderMap}
     * @param body    refer to {@link ResponseBody}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postBodyWithHeaders(Class<T> target, String url, Map<String, String> headers, RequestBody body) {
        Validates.check(target, headers);
        return mDelegate.postBodyWithHeaders(url, headers, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param body       refer to {@link ResponseBody}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postBodyWithParameters(Class<T> target, String url, Map<String, String> queryPairs, RequestBody body) {
        Validates.check(target, queryPairs);
        return mDelegate.postBodyWithParameters(url, queryPairs, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}, {@link Void}
     * @param url
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param body       refer to {@link ResponseBody}
     * @param <T>
     * @return
     */
    public <T> Flowable<T> postBodyWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, RequestBody body) {
        Validates.check(target, queryPairs, headers);
        return mDelegate.postBodyWithEntirety(url, queryPairs, headers, body).map(mProvider.converterFor(target));
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private Retrofit mRetrofit;
        private ApiService mDelegate;
        private MapperProvider mProvider;
        private ResultConverter mConverter;

        public Builder() {
        }

        Builder(RxRequestor requestor) {
            this.mRetrofit = requestor.mRetrofit;
            this.mDelegate = requestor.mDelegate;
            this.mProvider = requestor.mProvider;
            this.mConverter = mProvider.getConverter();
        }

        public Builder setRetrofit(Retrofit retrofit) {
            Objects.requireNonNull(retrofit, "retrofit == null");
            boolean hasFactory = Stream.of(retrofit.callAdapterFactories())
                    .anyMatch(new Predicate<CallAdapter.Factory>() {
                        @Override
                        public boolean test(CallAdapter.Factory value) {
                            return value instanceof RxJava2CallAdapterFactory || RxJava2CallAdapterFactory.class.isAssignableFrom(value.getClass());
                        }
                    });
            Objects.requireNonNull(hasFactory ? "" : null, "You must add RxJava2CallAdapterFactory for retrofit by Retrofit.Builder#addCallAdapterFactory()");
            Objects.requireNonNull(retrofit.baseUrl(), "You must add baseUrl for retrofit by Retrofit.Builder#baseUrl()");
            mRetrofit = retrofit;
            return this;
        }

        public Builder useSelfConverter(ResultConverter converter) {
            Objects.requireNonNull(converter, "converter == null");
            mConverter = converter;
            return this;
        }

        public RxRequestor build() {
            mDelegate = mRetrofit.create(ApiService.class);
            mConverter = mConverter == null ? new DefaultConverter() : mConverter;
            mProvider = new MapperProvider(mConverter);
            return new RxRequestor(mRetrofit, mDelegate, mProvider);
        }
    }
}
