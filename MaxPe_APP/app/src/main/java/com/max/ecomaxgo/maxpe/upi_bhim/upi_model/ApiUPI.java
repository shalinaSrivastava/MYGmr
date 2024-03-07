package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUPI {
    public static String _UPI_url ="https://maxpe.in/api/index.php/prod/";
    private static Retrofit retrofit;
    public static Retrofit getUPIClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(_UPI_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}

