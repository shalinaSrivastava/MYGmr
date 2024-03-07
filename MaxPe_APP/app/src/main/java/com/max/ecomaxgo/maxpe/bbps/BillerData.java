package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillerData {
    @SerializedName("billerId")
    @Expose
    private String billerId;
    @SerializedName("billerName")
    @Expose
    private String billerName;
    @SerializedName("fetchRequirement")
    @Expose
    private String fetchRequirement;
    @SerializedName("supportBillValidation")
    @Expose
    private String supportBillValidation;
    @SerializedName("billerCategoryName")
    @Expose
    private String billerCategoryName;
    @SerializedName("billerCustomerParams")
    @Expose
    private List<BillerCustomerParam> billerCustomerParams = null;
//    @SerializedName("billerAcceptsAdhoc")
//    @Expose
//    private String billerAcceptsAdhoc;
//    @SerializedName("paymentAmountExactness")
//    @Expose
//    private String paymentAmountExactness;

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

    public String getBillerCategoryName() {
        return billerCategoryName;
    }

    public void setBillerCategoryName(String billerCategoryName) {
        this.billerCategoryName = billerCategoryName;
    }

    public List<BillerCustomerParam> getBillerCustomerParams() {
        return billerCustomerParams;
    }

    public void setBillerCustomerParams(List<BillerCustomerParam> billerCustomerParams) {
        this.billerCustomerParams = billerCustomerParams;
    }

    public String getFetchRequirement() {
        return fetchRequirement;
    }

    public void setFetchRequirement(String fetchRequirement) {
        this.fetchRequirement = fetchRequirement;
    }

    public String getSupportBillValidation() {
        return supportBillValidation;
    }

    public void setSupportBillValidation(String supportBillValidation) {
        this.supportBillValidation = supportBillValidation;
    }
//    public String getBillerAcceptsAdhoc() {
//        return billerAcceptsAdhoc;
//    }
//
//    public void setBillerAcceptsAdhoc(String billerAcceptsAdhoc) {
//        this.billerAcceptsAdhoc = billerAcceptsAdhoc;
//    }
//
//    public String getPaymentAmountExactness() {
//        return paymentAmountExactness;
//    }
//
//    public void setPaymentAmountExactness(String paymentAmountExactness) {
//        this.paymentAmountExactness = paymentAmountExactness;
//    }
}
