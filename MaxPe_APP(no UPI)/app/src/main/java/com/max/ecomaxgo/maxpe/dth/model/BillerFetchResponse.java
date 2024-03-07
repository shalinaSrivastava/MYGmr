package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillerFetchResponse {
    @SerializedName("biller")
    @Expose
    private List<Biller> biller = null;

    public List<Biller> getBiller() {
        return biller;
    }

    public void setBiller(List<Biller> biller) {
        this.biller = biller;
    }

}
