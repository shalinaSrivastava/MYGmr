package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillDetail {
    @SerializedName("AdditionalAmount")
    @Expose
    private List<AdditionalAmount> additionalAmount = null;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("DueDate")
    @Expose
    private String dueDate;
    @SerializedName("CustConvFee")
    @Expose
    private Object custConvFee;
    @SerializedName("CustConvDesc")
    @Expose
    private Object custConvDesc;
    @SerializedName("BillDate")
    @Expose
    private String billDate;
    @SerializedName("BillNumber")
    @Expose
    private String billNumber;
    @SerializedName("BillPeriod")
    @Expose
    private String billPeriod;

    public List<AdditionalAmount> getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(List<AdditionalAmount> additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Object getCustConvFee() {
        return custConvFee;
    }

    public void setCustConvFee(Object custConvFee) {
        this.custConvFee = custConvFee;
    }

    public Object getCustConvDesc() {
        return custConvDesc;
    }

    public void setCustConvDesc(Object custConvDesc) {
        this.custConvDesc = custConvDesc;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(String billPeriod) {
        this.billPeriod = billPeriod;
    }
}
