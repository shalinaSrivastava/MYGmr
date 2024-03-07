package com.max.ecomaxgo.maxpe.dashboad.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //https://maxpe.in/api/index.php/prod/UPI/Checksum

    public static String _URL ="https://maxpe.in/api/index.php/prod/Wallet/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
