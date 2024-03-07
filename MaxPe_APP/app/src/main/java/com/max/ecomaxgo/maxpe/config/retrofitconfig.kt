package com.max.ecomaxgo.maxpe.config

import com.google.gson.GsonBuilder
import com.max.ecomaxgo.maxpe.ApiInterface.RestInetApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class retrofitconfig/*: MultiDexApplication()*/ {

    /*override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        if (IxigoSdk.isInitializable()) {
            Log.e("tokenAppl", " :: True")
            val config = Config.Builder(this)
                .clientId("ecomaxgo")
                .apiKey("ecomaxgo!2$")
                .stagingModeEnabled(true)
                .ixigoAuthHelperImplClass(IxigoAuthHelperImpl::class.java)
                .eventCallback(EventCallbackImpl())
                .build()
            IxigoSdk.init(this, config)
        }
        initRetrofit()
    }*/

    companion object {
        lateinit var endpoints: RestInetApi
        //Encryption Interceptor
//        val encryptionInterceptor:EncryptionInterceptor = EncryptionInterceptor(EncryptionImpl())
//        Decryption Interceptor
//        val decryptionInterceptor:DecryptionInterceptor = DecryptionInterceptor(DecryptionImpl())
//        val httpClientOK:OkHttpClient.Builder = OkHttpClient.Builder()



        var BASE_URL_MACHINE = "https://gateway.api.web.aquilatrack.com"
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

            /*val retrofit=Retrofit.Builder()
//                .baseUrl("https://newapi.maxpaywallet.com/index.php/")
                .baseUrl("https://maxpe.in/api/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclient.build())
                .build()*/

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://maxpe.in/api/index.php/")
                .client(httpclient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            endpoints =retrofit.create(RestInetApi::class.java)
        }

        fun getDeviceRetroClient():Retrofit{
            val logging= HttpLoggingInterceptor()
            logging.level= HttpLoggingInterceptor.Level.BODY
            val  httpclient= OkHttpClient.Builder()
            httpclient.addInterceptor{chain->
                val original=chain.request()
                val  request=original.newBuilder()
//                request.addHeader("accept","application/json")
                val request1=request.build()
                chain.proceed(request1)
            }
            httpclient.connectTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
            httpclient.readTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
            httpclient.addInterceptor(logging)

            val retrofitMachine = Retrofit.Builder()
                .baseUrl(BASE_URL_MACHINE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclient.build())
                .build()
            return retrofitMachine
        }
    }
}//   private static final String BASE_URL = "http://www.relinns.me/Viegram/apis/";
// http://ec2-18-221-227-110.us-east-2.compute.amazonaws.com/Viegram/apis/
// private static final String BASE_URL = "http://18.221.232.102/Viegram/apis/";
