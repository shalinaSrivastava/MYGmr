package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FetchBiller {
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
    private FetchData data;

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

    public FetchData getData() {
        return data;
    }

    public void setData(FetchData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FetchBiller{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
