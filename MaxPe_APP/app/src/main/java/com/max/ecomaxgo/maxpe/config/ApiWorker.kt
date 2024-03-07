package com.max.ecomaxgo.maxpe.config

import com.google.gson.GsonBuilder
import com.max.ecomaxgo.maxpe.ApiInterface.RestInetApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object ApiWorker {
    fun initRetrofit() {
        val logging= HttpLoggingInterceptor()
        logging.level= HttpLoggingInterceptor.Level.BODY
        val  httpclient=OkHttpClient.Builder()
        httpclient.addInterceptor{chain->
            val original=chain.request()
            val  request=original.newBuilder()
            val request1=request.build()
            chain.proceed(request1)
        }

        httpclient.connectTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
        httpclient.readTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
        httpclient.addInterceptor(logging)
//    private var mClient: OkHttpClient? = null
//    private var mGsonConverter: GsonConverterFactory? = null
//
//    /**
//     * Don't forget to remove Interceptors (or change Logging Level to NONE)
//     * in production! Otherwise people will be able to see your request and response on Log Cat.
//     */
//    val client: OkHttpClient
//        @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
//        get() {
//            if (mClient == null) {
//                val interceptor = HttpLoggingInterceptor()
//                interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//                val httpBuilder = OkHttpClient.Builder()
//                httpBuilder
//                    .connectTimeout(120, TimeUnit.SECONDS)
//                    .readTimeout(120, TimeUnit.SECONDS)
//                    .addInterceptor(interceptor)  /// show all JSON in logCat
//                    .addInterceptor { chain ->
//                        val original = chain.request()
//
//                        val requestBuilder = original.newBuilder()
////                        .addHeader("Authorization", AUTH)
//                            .addHeader("Content-Type", "application/json")
////                            .method(original.method(), original.body())
//
//                        val request = requestBuilder.build()
//                        chain.proceed(request)
//                    }
//                mClient = httpBuilder.build()
//
//            }
//            return mClient!!
//        }
//
//
//    val gsonConverter: GsonConverterFactory
//        get() {
//            if (mGsonConverter == null) {
//                mGsonConverter = GsonConverterFactory
//                    .create(
//                        GsonBuilder()
//                            .setLenient()
//                            .disableHtmlEscaping()
//                            .create()
//                    )
//            }
//            return mGsonConverter!!
       }
}