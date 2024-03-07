package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Checksum {

    @POST("generateToken")
    Call<Token> token(@Body TRequest tRequest);

}
