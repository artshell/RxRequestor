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

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/**
 * @author artshell on 25/11/2017
 */

public interface ApiService {

    /**
     * @param url an instance of {@link String}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> get(@Url String url);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithHeaders(@Url String url, @HeaderMap Map<String, String> headers);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs);

    /**
     * @param url        an instance of {@link String}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers);

    /**
     * @param url        an instance of {@link String}
     * @param queryNames eg. String[] queryNames = {"price=12", "count=56"};
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithQueryNames(@Url String url, @QueryName(encoded = true) String[] queryNames);

    /**
     * @param url        an instance of {@link String}
     * @param queryNames eg. String[] queryNames = {"price=12", "count=56"}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithEntirety(@Url String url, @QueryName(encoded = true) String[] queryNames, @HeaderMap Map<String, String> headers);

    /**
     * @param url        an instance of {@link String}
     * @param queryNames eg. List<String> queryNames = new ArrayList<>(); queryNames.add("price=12")
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithQueryNames(@Url String url, @QueryName(encoded = true) List<String> queryNames);

    /**
     * @param url        an instance of {@link String}
     * @param queryNames eg. List<String> queryNames = new ArrayList<>(); queryNames.add("price=12")
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @return an instance of {@link Flowable}
     */
    @GET
    Flowable<ResponseBody> getWithEntirety(@Url String url, @QueryName(encoded = true) List<String> queryNames, @HeaderMap Map<String, String> headers);

    /**
     * @param url an instance of {@link String}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> post(@Url String url);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postWithHeaders(@Url String url, @HeaderMap Map<String, String> headers);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs);

    /**
     * @param url    an instance of {@link String}
     * @param fields {@link Map}, defer to {@link FieldMap}
     * @return an instance of {@link Flowable}
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postFields(@Url String url, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param fields  {@link Map}, defer to {@link FieldMap}
     * @return an instance of {@link Flowable}
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param fields     {@link Map}, defer to {@link FieldMap}
     * @return an instance of {@link Flowable}
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param fields     {@link Map}, defer to {@link FieldMap}
     * @return an instance of {@link Flowable}
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url  an instance of {@link String}
     * @param part an instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPart(@Url String url, @Part MultipartBody.Part part);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param part    an instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part part);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param part       an instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part MultipartBody.Part part);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param part       an instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part part);


    /**
     * @param url   an instance of {@link String}
     * @param parts an array instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @Part MultipartBody.Part[] parts);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param parts   an array instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part[] parts);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param parts      an array instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part MultipartBody.Part[] parts);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param parts      an array instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part[] parts);

    /**
     * @param url   an instance of {@link String}
     * @param parts a {@link List} instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @Part List<MultipartBody.Part> parts);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param parts   a {@link List}  instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part List<MultipartBody.Part> parts);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param parts      a {@link List}  instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part List<MultipartBody.Part> parts);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param parts      a {@link List}  instance of {@link MultipartBody.Part}, defer to {@link Part}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part List<MultipartBody.Part> parts);

    /**
     * @param url   an instance of {@link String}
     * @param parts {@link String}/{@link RequestBody} pairs, defer to {@link PartMap}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param parts   {@link String}/{@link RequestBody} pairs, defer to {@link PartMap}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param parts      {@link String}/{@link RequestBody} pairs, defer to {@link PartMap}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url        an instance of {@link String}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param parts      {@link String}/{@link RequestBody} pairs, defer to {@link PartMap}
     * @return an instance of {@link Flowable}
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url  an instance of {@link String}
     * @param body an instance of {@link RequestBody}, defer to {@link Body}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postBody(@Url String url, @Body RequestBody body);

    /**
     * @param url     an instance of {@link String}
     * @param headers {@link Map}, defer to {@link HeaderMap}
     * @param body    an instance of {@link RequestBody}, defer to {@link Body}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postBodyWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Body RequestBody body);

    /**
     * @param url        an instance of {@link String}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param body       an instance of {@link RequestBody}, defer to {@link Body}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postBodyWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Body RequestBody body);

    /**
     * @param url        an instance of {@link String}
     * @param headers    {@link Map}, defer to {@link HeaderMap}
     * @param queryPairs {@link Map}, defer to {@link QueryMap}
     * @param body       an instance of {@link RequestBody}, defer to {@link Body}
     * @return an instance of {@link Flowable}
     */
    @POST
    Flowable<ResponseBody> postBodyWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Body RequestBody body);
}
