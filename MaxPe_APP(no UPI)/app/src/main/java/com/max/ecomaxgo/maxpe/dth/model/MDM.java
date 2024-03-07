package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MDM {
    @SerializedName("BillerFetchResponse")
    @Expose
    private BillerFetchResponse billerFetchResponse;

    public BillerFetchResponse getBillerFetchResponse() {
        return billerFetchResponse;
    }

    public void setBillerFetchResponse(BillerFetchResponse billerFetchResponse) {
        this.billerFetchResponse = billerFetchResponse;
    }
}
