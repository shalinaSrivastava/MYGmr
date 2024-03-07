package com.max.ecomaxgo.maxpe.dth.model;

import java.util.List;

public class DetailFetchBill {
    String EuronetRefNo;
    String BillPaymentToken;
    String PaymentRefNo;
    String ResponseCode;
    String ResponseMessage;
    String ResponseDescription;
    List<AdditionalInformation> AdditionalInformation;
    BillDetail BillDetail;
    //    String CustomerName;
//    String Amount;
//    String DueDate;
//    String CustConvFee;
//    String CustConvDesc;
//    String BillDate;
//    String BillNumber;
//    String BillPeriod;
    String BillerID;
    String RechargePlans;

    public DetailFetchBill(String euronetRefNo, String billPaymentToken, String paymentRefNo, String responseCode, String responseMessage, String responseDescription, List<AdditionalInformation> additionalInformation, BillDetail billDetail, String billerID, String rechargePlans) {
        EuronetRefNo = euronetRefNo;
        BillPaymentToken = billPaymentToken;
        PaymentRefNo = paymentRefNo;
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        ResponseDescription = responseDescription;
        AdditionalInformation = additionalInformation;
        BillDetail = billDetail;
        BillerID = billerID;
        RechargePlans = rechargePlans;
    }

    public String getEuronetRefNo() {
        return EuronetRefNo;
    }

    public String getBillPaymentToken() {
        return BillPaymentToken;
    }

    public String getPaymentRefNo() {
        return PaymentRefNo;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public List<AdditionalInformation> getAdditionalInformation() {
        return AdditionalInformation;
    }

    public BillDetail getBillDetail() {
        return BillDetail;
    }

//    public String getCustomerName() {
//        return CustomerName;
//    }
//
//    public String getAmount() {
//        return Amount;
//    }
//
//    public String getDueDate() {
//        return DueDate;
//    }
//
//    public String getCustConvFee() {
//        return CustConvFee;
//    }
//
//    public String getCustConvDesc() {
//        return CustConvDesc;
//    }
//
//    public String getBillDate() {
//        return BillDate;
//    }

    @Override
    public String toString() {
        return "DetailFetchBill{" +
                "EuronetRefNo='" + EuronetRefNo + '\'' +
                ", BillPaymentToken='" + BillPaymentToken + '\'' +
                ", PaymentRefNo='" + PaymentRefNo + '\'' +
                ", ResponseCode='" + ResponseCode + '\'' +
                ", ResponseMessage='" + ResponseMessage + '\'' +
                ", ResponseDescription='" + ResponseDescription + '\'' +
                ", AdditionalInformation=" + AdditionalInformation +
                ", BillDetail=" + BillDetail +
                ", BillerID='" + BillerID + '\'' +
                ", RechargePlans='" + RechargePlans + '\'' +
                '}';
    }


//    public String getBillNumber() {
//        return BillNumber;
//    }
//
//    public String getBillPeriod() {
//        return BillPeriod;
//    }

    public String getBillerID() {
        return BillerID;
    }

    public String getRechargePlans() {
        return RechargePlans;
    }


}
