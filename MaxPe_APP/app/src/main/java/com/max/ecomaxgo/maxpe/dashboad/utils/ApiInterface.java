package com.max.ecomaxgo.maxpe.dashboad.utils;

import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.MyPost;
import com.max.ecomaxgo.maxpe.dashboad.modle.Banner;
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFAds;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFCategory;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFPostAds;
import com.max.ecomaxgo.maxpe.dashboad.modle.Milestone;
import com.max.ecomaxgo.maxpe.dashboad.modle.MyMood;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.modle.WalletBalance;
import com.max.ecomaxgo.maxpe.model.login.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Account/verify")
    Call<ChainListRefer> getAccVerify(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );

    @FormUrlEncoded
    @POST("Wallet/listRefer")
    Call<ChainListRefer>getChainList(@Field("skey") String skey, @Field("number")String number, @Field("token")String token);
    @FormUrlEncoded
    @POST("Lostfound/category")
    Call<LFCategory> getCategory(@Field("skey")String skey, @Field("number")String number,@Field("token")String token );
    @FormUrlEncoded
    @POST("Lostfound/ads")
    Call<LFAds> getAds(@Field("skey")String skey, @Field("number")String number, @Field("token")String token );
    @FormUrlEncoded
    @POST("Lostfound/myAds")
    Call<MyPost> getMyAds(@Field("skey")String skey, @Field("number")String number, @Field("token")String token );
    @FormUrlEncoded
    @POST("Lostfound/postAds")
    Call<LFPostAds> getPostAds(@Field("skey")String skey,
                               @Field("number")String number,
                               @Field("token")String token,
                               @Field("category")String category,
                               @Field("title")String title,
                               @Field("description")String description,
                               @Field("city")String city,
                               @Field("lostFoundDate")String lostFoundDate,
                               @Field("categoryStatus")String categoryStatus,
                               @Field("contactPersonName")String contactPersonName,
                               @Field("contactPersonMobile")String contactPersonMobile,
                               @Field("token")String pic);

    @FormUrlEncoded
    @POST("Other/getMood")
    Call<MyMood> getMood
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("Other/setMood")
    Call<MyMood> setMood
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
             @Field("mymood")String mymood);

    @FormUrlEncoded
    @POST("Wallet/balance")
    Call<WalletBalance> getWalletBalance
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("Wallet/card")
    Call<CardNumber> getWalletCard
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("Other/locBanner")
    Call<Banner> getBanner
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
             @Field("lati")String lat,
             @Field("longi")String logi);
    @FormUrlEncoded
    @POST("Wallet/rank")
    Call<Rank> getRank
    (@Field("skey") String skey,
     @Field("number")String number,
     @Field("token")String token);

    @FormUrlEncoded
    @POST("Wallet/milestone")
    Call<Milestone> getMilestone
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("Wallet/putName")
    Call<Login> updateName
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
             @Field("fname")String fname,
             @Field("lname")String lname);


}
