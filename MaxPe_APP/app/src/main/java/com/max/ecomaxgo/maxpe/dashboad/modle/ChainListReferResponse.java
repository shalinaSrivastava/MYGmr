package com.max.ecomaxgo.maxpe.dashboad.modle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ChainListReferResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<ChainListRefer> results;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ChainListRefer> getResults() {
        return results;
    }

    public void setResults(List<ChainListRefer> results) {
        this.results = results;
    }

}
