package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillPaymentData {
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("billerId")
    @Expose
    private String billerId;
    @SerializedName("billerName")
    @Expose
    private String billerName;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("PaymentRefNo")
    @Expose
    private String paymentRefNo;
    @SerializedName("payment")
    @Expose
    private String payment;
    @SerializedName("paramValue")
    @Expose
    private String paramValue;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("logo")
    @Expose
    private String logo;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
