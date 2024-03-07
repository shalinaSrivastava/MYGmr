package com.max.ecomaxgo.maxpe.model.dashboad;

import com.google.gson.annotations.SerializedName;

public class LFAds {


    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private String data;
    @SerializedName("lfid")
    private String lfid;
    @SerializedName("category")
    private String category;

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("entryDate")
    private String entryDate;

    @SerializedName("city")
    private String city;
    @SerializedName("lostFoundDate")
    private String lostFoundDate;
    @SerializedName("categoryStatus")
    private String categoryStatus;
    @SerializedName("contactPersonName")
    private String contactPersonName;
    @SerializedName("contactPersonMobile")
    private String contactPersonMobile;

    public String getLfid() {
        return lfid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getCity() {
        return city;
    }

    public String getLostFoundDate() {
        return lostFoundDate;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactPersonMobile() {
        return contactPersonMobile;
    }


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
