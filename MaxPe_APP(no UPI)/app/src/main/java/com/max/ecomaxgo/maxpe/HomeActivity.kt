package com.max.ecomaxgo.maxpe

import android.media.session.MediaSession
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.gson.GsonBuilder
import com.max.ecomaxgo.maxpe.ApiInterface.ApiInterface
import com.max.ecomaxgo.maxpe.ApiInterface.RestInetApi
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.dth.BroadBandProviderActivity
import com.max.ecomaxgo.maxpe.model.login.Login
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.drawer_layout.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var maxPreference: MaxSharedPreference
    var retrofit: Retrofit? = null
    lateinit var apiInterface: ApiInterface
    lateinit var token: MediaSession.Token

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController
        bottom_nav_view.setupWithNavController(navController)


//        if (retrofit == null){
//            val logging= HttpLoggingInterceptor()
//            logging.level= HttpLoggingInterceptor.Level.BODY
//            val  httpclient= OkHttpClient.Builder()
//            httpclient.addInterceptor{chain->
//                val original=chain.request()
//                val  request=original.newBuilder()
//                val request1=request.build()
//                chain.proceed(request1)
//            }
//            httpclient.connectTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
//            httpclient.readTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
//            httpclient.addInterceptor(logging)
//
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//            retrofit = Retrofit.Builder()
//                .baseUrl("http://13.232.64.54:8097/")
//                .client(httpclient.build())
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//        }

//        apiInterface = retrofit!!.create(ApiInterface::class.java)
//        val call: Call<Token> = apiInterface.checkSumToken("maxpe@ecomaxgo.in", "918143111212", "918143111212")
//        call.enqueue(object : Callback<Token>{
//            override fun onResponse(call: Call<Token>, response: Response<Token>) {
//                token = response.body()!!
//                Log.e("token response ", " :: ${response.body()}")
//
//            }
//
//            override fun onFailure(call: Call<Token>, t: Throwable) {
//
//            }
//        })

    }



}