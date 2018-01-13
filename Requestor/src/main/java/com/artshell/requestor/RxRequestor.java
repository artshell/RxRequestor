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

import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;
import com.artshell.requestor.utils.ClassExclude;
import com.artshell.requestor.utils.Objects;
import com.artshell.requestor.utils.Validates;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.HttpUrl;
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
    private Protocol mType;
    private MapperProvider mProvider;

    private RxRequestor(Retrofit retrofit, ApiService delegate, Protocol type, MapperProvider provider) {
        mRetrofit = retrofit;
        mDelegate = delegate;
        mType = type;
        mProvider = provider;
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> get(Class<T> target, String url) {
        ClassExclude.exclude(target);
        return mDelegate.get(url).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithHeaders(Class<T> target, String url, Map<String, String> headers) {
        Validates.check(target, headers);
        return mDelegate.getWithHeaders(url, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithParameters(Class<T> target, String url, Map<String, String> queryPairs) {
        Validates.check(target, queryPairs);
        return mDelegate.getWithParameters(url, queryPairs).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers) {
        Validates.check(target, queryPairs, headers);
        return mDelegate.getWithEntirety(url, queryPairs, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryNames key/value pairs of {@link String} array
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithQueryNames(Class<T> target, String url, String[] queryNames) {
        Validates.check(target, queryNames);
        return mDelegate.getWithQueryNames(url, queryNames).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryNames key/value pairs of {@link String} of array
     * @param headers    refer to {@link HeaderMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithEntirety(Class<T> target, String url, String[] queryNames, Map<String, String> headers) {
        Validates.check(target, queryNames, headers);
        return mDelegate.getWithEntirety(url, queryNames, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryNames key/value pairs of {@link String} of Array
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithQueryNames(Class<T> target, String url, List<String> queryNames) {
        Validates.check(target, queryNames);
        return mDelegate.getWithQueryNames(url, queryNames).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryNames key/value pairs of {@link String} of {@link List}
     * @param headers    refer to {@link HeaderMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> getWithEntirety(Class<T> target, String url, List<String> queryNames, Map<String, String> headers) {
        Validates.check(target, queryNames, headers);
        return mDelegate.getWithEntirety(url, queryNames, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> post(Class<T> target, String url) {
        ClassExclude.exclude(target);
        return mDelegate.post(url).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postWithHeaders(Class<T> target, String url, Map<String, String> headers) {
        Validates.check(target, headers);
        return mDelegate.postWithHeaders(url, headers).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postWithParameters(Class<T> target, String url, Map<String, String> queryPairs) {
        Validates.check(target, queryPairs);
        return mDelegate.postWithParameters(url, queryPairs).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param fields refer to {@link FieldMap}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postFields(Class<T> target, String url, Map<String, String> fields) {
        Validates.check(target, fields);
        return mDelegate.postFields(url, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param fields  refer to {@link FieldMap}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postWithHeaders(Class<T> target, String url, Map<String, String> headers, Map<String, String> fields) {
        Validates.check(target, headers, fields);
        return mDelegate.postWithHeaders(url, headers, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param fields     refer to {@link FieldMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postWithParameters(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> fields) {
        Validates.check(target, queryPairs, fields);
        return mDelegate.postWithParameters(url, queryPairs, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param fields     refer to {@link FieldMap}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, Map<String, String> fields) {
        Validates.check(target, queryPairs, headers, fields);
        return mDelegate.postWithEntirety(url, queryPairs, headers, fields).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param part   refer to {@link MultipartBody.Part}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPart(Class<T> target, String url, MultipartBody.Part part) {
        ClassExclude.exclude(target);
        return mDelegate.postPart(url, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param part    refer to {@link MultipartBody.Part}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartWithHeaders(Class<T> target, String url, Map<String, String> headers, MultipartBody.Part part) {
        Validates.check(target, headers);
        return mDelegate.postPartWithHeaders(url, headers, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param part       refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartWithParameters(Class<T> target, String url, Map<String, String> queryPairs, MultipartBody.Part part) {
        Validates.check(target, queryPairs);
        return mDelegate.postPartWithParameters(url, queryPairs, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param part       refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, MultipartBody.Part part) {
        Validates.check(target, queryPairs, headers);
        return mDelegate.postPartWithEntirety(url, queryPairs, headers, part).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, MultipartBody.Part[] parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, MultipartBody.Part[] parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, MultipartBody.Part[] parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, MultipartBody.Part[] parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, List<MultipartBody.Part> parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, List<MultipartBody.Part> parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, List<MultipartBody.Part> parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, List<MultipartBody.Part> parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param parts  refer to {@link MultipartBody.Part}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postParts(Class<T> target, String url, Map<String, RequestBody> parts) {
        Validates.check(target, parts);
        return mDelegate.postParts(url, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param parts   refer to {@link MultipartBody.Part}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithHeaders(Class<T> target, String url, Map<String, String> headers, Map<String, RequestBody> parts) {
        Validates.check(target, headers, parts);
        return mDelegate.postPartsWithHeaders(url, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithParameters(Class<T> target, String url, Map<String, String> queryPairs, Map<String, RequestBody> parts) {
        Validates.check(target, queryPairs, parts);
        return mDelegate.postPartsWithParameters(url, queryPairs, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param parts      refer to {@link MultipartBody.Part}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postPartsWithEntirety(Class<T> target, String url, Map<String, String> queryPairs, Map<String, String> headers, Map<String, RequestBody> parts) {
        Validates.check(target, queryPairs, headers, parts);
        return mDelegate.postPartsWithEntirety(url, queryPairs, headers, parts).map(mProvider.converterFor(target));
    }

    /**
     * @param target custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *               {@link java.io.InputStream}, {@link String}
     * @param url    {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param body   refer to {@link ResponseBody}
     * @param <T>    a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postBody(Class<T> target, String url, RequestBody body) {
        ClassExclude.exclude(target);
        return mDelegate.postBody(url, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target  custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                {@link java.io.InputStream}, {@link String}
     * @param url     {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param headers refer to {@link HeaderMap}
     * @param body    refer to {@link ResponseBody}
     * @param <T>     a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postBodyWithHeaders(Class<T> target, String url, Map<String, String> headers, RequestBody body) {
        Validates.check(target, headers);
        return mDelegate.postBodyWithHeaders(url, headers, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param body       refer to {@link ResponseBody}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
     */
    public <T> Flowable<T> postBodyWithParameters(Class<T> target, String url, Map<String, String> queryPairs, RequestBody body) {
        Validates.check(target, queryPairs);
        return mDelegate.postBodyWithParameters(url, queryPairs, body).map(mProvider.converterFor(target));
    }

    /**
     * @param target     custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                   {@link java.io.InputStream}, {@link String}
     * @param url        {@link retrofit2.http.Url}, {@link Retrofit.Builder#baseUrl(HttpUrl)}
     * @param queryPairs refer to {@link QueryMap}
     * @param headers    refer to {@link HeaderMap}
     * @param body       refer to {@link ResponseBody}
     * @param <T>        a class
     * @return an instance of {@link Flowable}
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
        private Protocol mType;
        private Converter mConverter;
        private MapperProvider mProvider;

        public Builder() {}

        Builder(RxRequestor requestor) {
            this.mRetrofit = requestor.mRetrofit;
            this.mDelegate = requestor.mDelegate;
            this.mType = requestor.mType;
            this.mProvider = requestor.mProvider;
            this.mConverter = mProvider.getConverter();
        }

        /**
         * @param retrofit {@link Retrofit}
         * @return an instance of {@link Builder}
         */
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

        /**
         * @param type type of data, defer to {@link Protocol}
         * @return
         */
        public Builder supportBy(Protocol type) {
            Objects.requireNonNull(type, "type == null");
            mType = type;
            return this;
        }

        /**
         * Optional configuration
         * @param converter refer to {@link JsonConverter} or {@link XmlConverter} if custom yourself Converter
         * @return an instance of {@link Builder}
         */
        public Builder customConverter(Converter converter) {
            Objects.requireNonNull(converter, "converter == null");
            mConverter = converter;
            return this;
        }

        public RxRequestor build() {
            Objects.requireNonNull(mRetrofit, "mRetrofit == null, You must provider an instance of Retrofit by setRetrofit()");
            Objects.requireNonNull(mType, "mType == null, You must provider an instance of Protocol by supportBy()");
            mDelegate = mRetrofit.create(ApiService.class);
            mConverter = mConverter != null ? mConverter : mType == Protocol.JSON ? JsonConverter.create() : XmlConverter.createNonStrict();
            mProvider = new MapperProvider(mConverter);
            return new RxRequestor(mRetrofit, mDelegate, mType, mProvider);
        }
    }
}
