package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.SerializedName;

public class FetchBill {
    String status;
    String message;
    @SerializedName("details")
    DetailFetchBill fetchBillDetails;

    public FetchBill(String status, String message, DetailFetchBill DetailFetchBill) {
        this.status = status;
        this.message = message;
        this.fetchBillDetails = DetailFetchBill;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DetailFetchBill getDetails() {
        return fetchBillDetails;
    }

}
