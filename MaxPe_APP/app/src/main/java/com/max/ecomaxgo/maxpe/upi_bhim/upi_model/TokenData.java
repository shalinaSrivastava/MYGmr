package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenData {
    @SerializedName("merchantauthtoken")
    @Expose
    String merchantauthtoken = null;
    @SerializedName("timeStamp")
    @Expose
    String timeStamp = null;
    @SerializedName("mobilenumber")
    @Expose
    String mobilenumber = null;
    @SerializedName("unqTxnId")
    @Expose
    String unqTxnId = null;

    public String getMerchantauthtoken() {
        return merchantauthtoken;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getUnqTxnId() {
        return unqTxnId;
    }
}
