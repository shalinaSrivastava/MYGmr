package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Biller {
    @SerializedName("billerId")
    @Expose
    private String billerId;
    @SerializedName("billerName")
    @Expose
    private String billerName;
    @SerializedName("billerAliasName")
    @Expose
    private String billerAliasName;
    @SerializedName("billerCategoryName")
    @Expose
    private String billerCategoryName;
    @SerializedName("billerMode")
    @Expose
    private String billerMode;
    @SerializedName("billerAcceptsAdhoc")
    @Expose
    private String billerAcceptsAdhoc;
    @SerializedName("parentBiller")
    @Expose
    private String parentBiller;
    @SerializedName("parentBillerId")
    @Expose
    private String parentBillerId;
    @SerializedName("billerOwnerShp")
    @Expose
    private String billerOwnerShp;
    @SerializedName("billerCoverage")
    @Expose
    private String billerCoverage;
    @SerializedName("fetchRequirement")
    @Expose
    private String fetchRequirement;
    @SerializedName("paymentAmountExactness")
    @Expose
    private String paymentAmountExactness;
    @SerializedName("supportBillValidation")
    @Expose
    private String supportBillValidation;
    @SerializedName("billerEffctvFrom")
    @Expose
    private String billerEffctvFrom;
    @SerializedName("billerEffctvTo")
    @Expose
    private String billerEffctvTo;
    @SerializedName("billerTempDeactivationStart")
    @Expose
    private String billerTempDeactivationStart;
    @SerializedName("billerTempDeactivationEnd")
    @Expose
    private String billerTempDeactivationEnd;
    @SerializedName("billerPaymentModes")
    @Expose
    private List<BillerPaymentMode> billerPaymentModes = null;
    @SerializedName("billerPaymentChannels")
    @Expose
    private List<BillerPaymentChannel> billerPaymentChannels = null;
    @SerializedName("billerCustomerParams")
    @Expose
    private List<BillerCustomerParam> billerCustomerParams = null;
    @SerializedName("billerResponseParams")
    @Expose
    private Object billerResponseParams;
    @SerializedName("billerAdditionalInfo")
    @Expose
    private Object billerAdditionalInfo;
    @SerializedName("Status")
    @Expose
    private String status;

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

    public String getBillerAliasName() {
        return billerAliasName;
    }

    public void setBillerAliasName(String billerAliasName) {
        this.billerAliasName = billerAliasName;
    }

    public String getBillerCategoryName() {
        return billerCategoryName;
    }

    public void setBillerCategoryName(String billerCategoryName) {
        this.billerCategoryName = billerCategoryName;
    }

    public String getBillerMode() {
        return billerMode;
    }

    public void setBillerMode(String billerMode) {
        this.billerMode = billerMode;
    }

    public String getBillerAcceptsAdhoc() {
        return billerAcceptsAdhoc;
    }

    public void setBillerAcceptsAdhoc(String billerAcceptsAdhoc) {
        this.billerAcceptsAdhoc = billerAcceptsAdhoc;
    }

    public String getParentBiller() {
        return parentBiller;
    }

    public void setParentBiller(String parentBiller) {
        this.parentBiller = parentBiller;
    }

    public String getParentBillerId() {
        return parentBillerId;
    }

    public void setParentBillerId(String parentBillerId) {
        this.parentBillerId = parentBillerId;
    }

    public String getBillerOwnerShp() {
        return billerOwnerShp;
    }

    public void setBillerOwnerShp(String billerOwnerShp) {
        this.billerOwnerShp = billerOwnerShp;
    }

    public String getBillerCoverage() {
        return billerCoverage;
    }

    public void setBillerCoverage(String billerCoverage) {
        this.billerCoverage = billerCoverage;
    }

    public String getFetchRequirement() {
        return fetchRequirement;
    }

    public void setFetchRequirement(String fetchRequirement) {
        this.fetchRequirement = fetchRequirement;
    }

    public String getPaymentAmountExactness() {
        return paymentAmountExactness;
    }

    public void setPaymentAmountExactness(String paymentAmountExactness) {
        this.paymentAmountExactness = paymentAmountExactness;
    }

    public String getSupportBillValidation() {
        return supportBillValidation;
    }

    public void setSupportBillValidation(String supportBillValidation) {
        this.supportBillValidation = supportBillValidation;
    }

    public String getBillerEffctvFrom() {
        return billerEffctvFrom;
    }

    public void setBillerEffctvFrom(String billerEffctvFrom) {
        this.billerEffctvFrom = billerEffctvFrom;
    }

    public String getBillerEffctvTo() {
        return billerEffctvTo;
    }

    public void setBillerEffctvTo(String billerEffctvTo) {
        this.billerEffctvTo = billerEffctvTo;
    }

    public String getBillerTempDeactivationStart() {
        return billerTempDeactivationStart;
    }

    public void setBillerTempDeactivationStart(String billerTempDeactivationStart) {
        this.billerTempDeactivationStart = billerTempDeactivationStart;
    }

    public String getBillerTempDeactivationEnd() {
        return billerTempDeactivationEnd;
    }

    public void setBillerTempDeactivationEnd(String billerTempDeactivationEnd) {
        this.billerTempDeactivationEnd = billerTempDeactivationEnd;
    }

    public List<BillerPaymentMode> getBillerPaymentModes() {
        return billerPaymentModes;
    }

    public void setBillerPaymentModes(List<BillerPaymentMode> billerPaymentModes) {
        this.billerPaymentModes = billerPaymentModes;
    }

    public List<BillerPaymentChannel> getBillerPaymentChannels() {
        return billerPaymentChannels;
    }

    public void setBillerPaymentChannels(List<BillerPaymentChannel> billerPaymentChannels) {
        this.billerPaymentChannels = billerPaymentChannels;
    }

    public List<BillerCustomerParam> getBillerCustomerParams() {
        return billerCustomerParams;
    }

    public void setBillerCustomerParams(List<BillerCustomerParam> billerCustomerParams) {
        this.billerCustomerParams = billerCustomerParams;
    }

    public Object getBillerResponseParams() {
        return billerResponseParams;
    }

    public void setBillerResponseParams(Object billerResponseParams) {
        this.billerResponseParams = billerResponseParams;
    }

    public Object getBillerAdditionalInfo() {
        return billerAdditionalInfo;
    }

    public void setBillerAdditionalInfo(Object billerAdditionalInfo) {
        this.billerAdditionalInfo = billerAdditionalInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
