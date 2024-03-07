package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {

    public Checksum init()
    {
        Interceptor interceptor = new Interceptor() {
            public Response intercept(Chain param1Chain) throws IOException {
                Request request = param1Chain.request();
                Request.Builder builder = request.newBuilder();
                builder.method(request.method(), request.body());
                return param1Chain.proceed(builder.build());
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.interceptors().add(interceptor);
        builder.connectTimeout(10L, TimeUnit.SECONDS);
        builder.readTimeout(90L, TimeUnit.SECONDS);
        builder.interceptors().add(httpLoggingInterceptor);

        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.232.64.54:8097/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(Checksum.class);
    }

}
