package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Token {
    @SerializedName("code")
    @Expose
    String code = null;
    @SerializedName("result")
    @Expose
    String result = null;
    @SerializedName("data")
    @Expose
    TokenData data = null;

    public String getCode() {
        return code;
    }

    public String getResult() {
        return result;
    }

    public TokenData getData() {
        return data;
    }
}

