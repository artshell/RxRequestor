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
import retrofit2.http.Url;

/**
 * @author artshell on 25/11/2017
 */

public interface ApiService {

    /**
     * @param url
     * @return
     */
    @GET
    Flowable<ResponseBody> get(@Url String url);

    /**
     * @param url
     * @param headers
     * @return
     */
    @GET
    Flowable<ResponseBody> getWithHeaders(@Url String url, @HeaderMap Map<String, String> headers);

    /**
     * @param url
     * @param queryPairs
     * @return
     */
    @GET
    Flowable<ResponseBody> getWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs);

    /**
     * @param url
     * @param headers
     * @param queryPairs
     * @return
     */
    @GET
    Flowable<ResponseBody> getWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers);

    /**
     * @param url
     * @return
     */
    @POST
    Flowable<ResponseBody> post(@Url String url);

    /**
     * @param url
     * @param headers
     * @return
     */
    @POST
    Flowable<ResponseBody> postWithHeaders(@Url String url, @HeaderMap Map<String, String> headers);

    /**
     * @param url
     * @param queryPairs
     * @return
     */
    @POST
    Flowable<ResponseBody> postWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs);

    /**
     * @param url
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postFields(@Url String url, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url
     * @param headers
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url
     * @param queryPairs
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url
     * @param queryPairs
     * @param headers
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST
    Flowable<ResponseBody> postWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @FieldMap(encoded = true) Map<String, String> fields);

    /**
     * @param url
     * @param part
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPart(@Url String url, @Part MultipartBody.Part part);

    /**
     * @param url
     * @param headers
     * @param part
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part part);

    /**
     * @param url
     * @param queryPairs
     * @param part
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part MultipartBody.Part part);

    /**
     * @param url
     * @param queryPairs
     * @param headers
     * @param part
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part part);


    /**
     * @param url
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @Part MultipartBody.Part[] parts);

    /**
     * @param url
     * @param headers
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part[] parts);

    /**
     * @param url
     * @param queryPairs
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part MultipartBody.Part[] parts);

    /**
     * @param url
     * @param queryPairs
     * @param headers
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part[] parts);

    /**
     * @param url
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @Part List<MultipartBody.Part> parts);

    /**
     * @param url
     * @param headers
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Part List<MultipartBody.Part> parts);

    /**
     * @param url
     * @param queryPairs
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Part List<MultipartBody.Part> parts);

    /**
     * @param url
     * @param queryPairs
     * @param headers
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Part List<MultipartBody.Part> parts);

    /**
     * @param url
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postParts(@Url String url, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url
     * @param headers
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url
     * @param queryPairs
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url
     * @param headers
     * @param queryPairs
     * @param parts
     * @return
     */
    @Multipart
    @POST
    Flowable<ResponseBody> postPartsWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @PartMap Map<String, RequestBody> parts);

    /**
     * @param url
     * @param body
     * @return
     */
    @POST
    Flowable<ResponseBody> postBody(@Url String url, @Body RequestBody body);

    /**
     * @param url
     * @param headers
     * @param body
     * @return
     */
    @POST
    Flowable<ResponseBody> postBodyWithHeaders(@Url String url, @HeaderMap Map<String, String> headers, @Body RequestBody body);

    /**
     * @param url
     * @param queryPairs
     * @param body
     * @return
     */
    @POST
    Flowable<ResponseBody> postBodyWithParameters(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @Body RequestBody body);

    /**
     * @param url
     * @param headers
     * @param queryPairs
     * @param body
     * @return
     */
    @POST
    Flowable<ResponseBody> postBodyWithEntirety(@Url String url, @QueryMap(encoded = true) Map<String, String> queryPairs, @HeaderMap Map<String, String> headers, @Body RequestBody body);
}
