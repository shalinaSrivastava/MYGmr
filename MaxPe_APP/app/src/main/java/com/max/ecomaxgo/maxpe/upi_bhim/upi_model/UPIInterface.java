package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UPIInterface {
    @FormUrlEncoded
    @POST("UPI/Checksum")
    Call<UPIChecksum> getChecksum
    (@Field("skey") String skey,
     @Field("number")String number,
     @Field("token")String token);


}
