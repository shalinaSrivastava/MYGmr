package com.max.ecomaxgo.maxpe.dashboad.lostfound.modle;

import com.google.gson.annotations.SerializedName;

public class LFPostAds {


    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;



    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }


}
