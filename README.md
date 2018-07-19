### Introduction
General http request encapsulate base on Retrofit, OkHttp and RxJava, support for [`java`](https://docs.oracle.com/javase/tutorial/index.html) and [`Android`](https://developer.android.com/index.html). Support result types：`coutom type`, [`ResponseBody`](http://square.github.io/okhttp/3.x/okhttp/okhttp3/RequestBody.html), [`Byte arrays`](https://docs.oracle.com/javase/8/docs/api/java/lang/Byte.html), [`Reader`](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html), [`InputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), [`String`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [`Void`](https://docs.oracle.com/javase/8/docs/api/java/lang/Void.html). Data protocol includes `json` and `xml`

### Getting started
##### Add dependencies
```java
implementation 'com.artshell:RxRequestor:1.0.5'
```

##### Simple Usage
```java
import com.artshell.requestor.Protocol;
import com.artshell.requestor.RxRequestor;

import java.io.InputStream;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class Test {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                /* more settings */
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.github.com") /* Your server address */
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .validateEagerly(true)
                .client(client)
                /* more settings */
                .build();

        RxRequestor requestor = new RxRequestor.Builder()
                .setRetrofit(retrofit)
                .supportBy(Protocol.JSON)
                .build();
                
        
        // Example A
        // login whith user_id and password
        Map<String, String> pairs = new HashMap<>();
        pairs.put("user_id", "artshell");
        pairs.put("password", "123456");
        /*
        * {
        *   "code": "1000",
        *   "msg" : "success",
        *   "data" : "welcome artshell"
        * }
        */
        Flowable<LoginEntity> loginSource = requestor.postFields(LoginEntity.class, "user/login", pairs);
        
        
        // Example B
        /*
        * {
        *   "code": "1000",
        *   "msg" : "success",
        *   "data" : "hello world"
        * }
        */
        // Custom type (JSON entity), eg.
        Flowable<HelloWorld> helloSource = requestor.get(HelloEntity.class, "index/welcome");

        // ResponseBody
        Flowable<ResponseBody> bodySource = requestor.get(ResponseBody.class, "index/welcome");

        // Byte arrays
        Flowable<Byte[]> byteSource = requestor.get(Byte[].class, "index/welcome");

        // Reader
        Flowable<Reader> readerSource = requestor.get(Reader.class, "index/welcome");

        // InputStream
        Flowable<InputStream> streamSource = requestor.get(InputStream.class, "index/welcome");

        // String
        Flowable<String> stringSource = requestor.get(String.class, "index/welcome");

        // Void
        Flowable<Void> ignoreSource = requestor.get(Void.class, "index/welcome");
        
    }
}
```
Other methods details see [`RxRquestor`](https://github.com/artshell/RxRequestor/blob/master/Requestor/src/main/java/com/artshell/requestor/RxRequestor.java)

##### Especially Usage
Custom converter, for more detail see [`JsonConverter`](https://github.com/artshell/RxRequestor/blob/master/Requestor/src/main/java/com/artshell/requestor/JsonConverter.java) and [`XmlConverter`](https://github.com/artshell/RxRequestor/blob/master/Requestor/src/main/java/com/artshell/requestor/XmlConverter.java)
```java
RxRequestor requestor = new RxRequestor.Builder()
        .setRetrofit(retrofit)
        .supportBy(Protocol.JSON)
        .customConverter(xxxJsonConverter) /* your custom converter */
        .build();
```
