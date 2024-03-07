package com.max.ecomaxgo.maxpe.dth.model;

import java.util.List;

public class BillDetail {
    List<AdditionalAmount> additionalAmounts;
    String CustomerName;
    String Amount;
    String DueDate;
    String CustConvFee;
    String CustConvDesc;
    String BillDate;
    String BillNumber;
    String BillPeriod;

    public BillDetail(List<AdditionalAmount> additionalAmounts, String customerName, String amount, String dueDate, String custConvFee, String custConvDesc, String billDate, String billNumber, String billPeriod) {
        this.additionalAmounts = additionalAmounts;
        CustomerName = customerName;
        Amount = amount;
        DueDate = dueDate;
        CustConvFee = custConvFee;
        CustConvDesc = custConvDesc;
        BillDate = billDate;
        BillNumber = billNumber;
        BillPeriod = billPeriod;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "additionalAmounts=" + additionalAmounts +
                ", CustomerName='" + CustomerName + '\'' +
                ", Amount='" + Amount + '\'' +
                ", DueDate='" + DueDate + '\'' +
                ", CustConvFee='" + CustConvFee + '\'' +
                ", CustConvDesc='" + CustConvDesc + '\'' +
                ", BillDate='" + BillDate + '\'' +
                ", BillNumber='" + BillNumber + '\'' +
                ", BillPeriod='" + BillPeriod + '\'' +
                '}';
    }

    public void setAdditionalAmounts(List<AdditionalAmount> additionalAmounts) {
        this.additionalAmounts = additionalAmounts;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public void setCustConvFee(String custConvFee) {
        CustConvFee = custConvFee;
    }

    public void setCustConvDesc(String custConvDesc) {
        CustConvDesc = custConvDesc;
    }

    public void setBillDate(String billDate) {
        BillDate = billDate;
    }

    public void setBillNumber(String billNumber) {
        BillNumber = billNumber;
    }

    public void setBillPeriod(String billPeriod) {
        BillPeriod = billPeriod;
    }

    public List<AdditionalAmount> getAdditionalAmounts() {
        return additionalAmounts;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getAmount() {
        return Amount;
    }

    public String getDueDate() {
        return DueDate;
    }

    public String getCustConvFee() {
        return CustConvFee;
    }

    public String getCustConvDesc() {
        return CustConvDesc;
    }

    public String getBillDate() {
        return BillDate;
    }

    public String getBillNumber() {
        return BillNumber;
    }

    public String getBillPeriod() {
        return BillPeriod;
    }
}
