package com.max.ecomaxgo.maxpe.ApiInterface

import android.media.session.MediaSession
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("generateToken")
    fun checkSumToken(
        @Field("email") email: String,
        @Field("unqCustId") unqCustId: String,
        @Field("mobilenumber") mobilenumber: String
    ): Call<MediaSession.Token>
}