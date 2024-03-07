package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FetchData {
    @SerializedName("BillerID")
    @Expose
    private String billerID;
    @SerializedName("billToken")
    @Expose
    private String billToken;
//    @SerializedName("billerAcceptsAdhoc")
//    @Expose
//    private String billerAcceptsAdhoc;
    @SerializedName("paymentAmountExactness")
    @Expose
    private String paymentAmountExactness;
    @SerializedName("BillDetail")
    @Expose
    private BillDetail billDetail;

    public String getBillerID() {
        return billerID;
    }

    public void setBillerID(String billerID) {
        this.billerID = billerID;
    }

    public String getBillToken() {
        return billToken;
    }

    public void setBillToken(String billToken) {
        this.billToken = billToken;
    }

//    public String getBillerAcceptsAdhoc() {
//        return billerAcceptsAdhoc;
//    }
//
//    public void setBillerAcceptsAdhoc(String billerAcceptsAdhoc) {
//        this.billerAcceptsAdhoc = billerAcceptsAdhoc;
//    }

    public String getPaymentAmountExactness() {
        return paymentAmountExactness;
    }

    public void setPaymentAmountExactness(String paymentAmountExactness) {
        this.paymentAmountExactness = paymentAmountExactness;
    }

    public BillDetail getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
    }

}