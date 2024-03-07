package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.SerializedName;

public class ComplaintReg {
    String status;
    String message;
    @SerializedName("details")
    DetailComplaint detailComplaint;

    public ComplaintReg(String status, String message, DetailComplaint detailComplaint) {
        this.status = status;
        this.message = message;
        this.detailComplaint = detailComplaint;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DetailComplaint getDetailComplaint() {
        return detailComplaint;
    }
}
