package com.max.ecomaxgo.maxpe.dashboad.modle;

import com.google.gson.annotations.SerializedName;

public class MyMood {


    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("mymood")
    private String mymood;



    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getMymood() {
        return mymood;
    }


}
