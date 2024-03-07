package com.max.ecomaxgo.maxpe.model.dashboad;

import com.max.ecomaxgo.maxpe.dashboad.modle.Banner;



import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("Account/verify")
    Call<ChainListRefer> getAccVerify(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );


    @POST("Wallet/listRefer")
    Call<ChainListRefer> getListRefer(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );


    @POST("Lostfound/category")
    Call<LFCategory> getCategory(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );

    @POST("Lostfound/ads")
    Call<LFAds> getAds(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );
    @POST("Lostfound/postAds")
    Call<LFPostAds> getPostAds(@Query("skey")String skey,
                               @Query("number")String number,
                               @Query("token")String token,
                               @Query("category")String category,
                               @Query("title")String title,
                               @Query("description")String description,
                               @Query("city")String city,
                               @Query("lostFoundDate")String lostFoundDate,
                               @Query("categoryStatus")String categoryStatus,
                               @Query("contactPersonName")String contactPersonName,
                               @Query("contactPersonMobile")String contactPersonMobile,
                               @Query("token")String pic);

@FormUrlEncoded
@POST("Other/locBanner")
Call<Banner> getBanner
(@Field("skey") String skey,
 @Field("number")String number,
 @Field("token")String token,
 @Field("lati")String lat,
    @Field("longi")String logi);

}
