package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateData {
    @SerializedName("BillerID")
    @Expose
    private String BillerID;
    @SerializedName("billToken")
    @Expose
    private String billToken;

    public String getBillerID() {
        return BillerID;
    }

    public void setBillerID(String billerID) {
        BillerID = billerID;
    }

    public String getBillToken() {
        return billToken;
    }

    public void setBillToken(String billToken) {
        this.billToken = billToken;
    }
}
