package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Biller {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private BillerData data;

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

    public BillerData getData() {
        return data;
    }

    public void setData(BillerData data) {
        this.data = data;
    }

}
