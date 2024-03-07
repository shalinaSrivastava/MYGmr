package com.max.ecomaxgo.maxpe.model.dashboad;

import com.google.gson.annotations.SerializedName;

public class LFCategory {


    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private String data;
    @SerializedName("category")
    private String category;
    @SerializedName("image")
    private String image;

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

}
