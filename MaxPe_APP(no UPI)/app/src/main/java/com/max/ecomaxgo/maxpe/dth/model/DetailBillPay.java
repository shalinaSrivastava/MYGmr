package com.max.ecomaxgo.maxpe.dth.model;

public class DetailBillPay {
    String EuronetRefNo;
    String MerchantRefNo;
    String PaymentRefNo;
    String ApprovalRefNo;
    String ResponseCode;
    String ResponseMessage;
    String ResponseDescription;
    String AdditionalInformation;
    String BillerID;

    public DetailBillPay(String euronetRefNo, String merchantRefNo, String paymentRefNo, String approvalRefNo, String responseCode, String responseMessage, String responseDescription, String additionalInformation, String billerID) {
        EuronetRefNo = euronetRefNo;
        MerchantRefNo = merchantRefNo;
        PaymentRefNo = paymentRefNo;
        ApprovalRefNo = approvalRefNo;
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        ResponseDescription = responseDescription;
        AdditionalInformation = additionalInformation;
        BillerID = billerID;
    }

    public String getEuronetRefNo() {
        return EuronetRefNo;
    }

    public String getMerchantRefNo() {
        return MerchantRefNo;
    }

    public String getPaymentRefNo() {
        return PaymentRefNo;
    }

    public String getApprovalRefNo() {
        return ApprovalRefNo;
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

    public String getAdditionalInformation() {
        return AdditionalInformation;
    }

    public String getBillerID() {
        return BillerID;
    }

    @Override
    public String toString() {
        return "DetailBillPay{" +
                "EuronetRefNo='" + EuronetRefNo + '\'' +
                ", MerchantRefNo='" + MerchantRefNo + '\'' +
                ", PaymentRefNo='" + PaymentRefNo + '\'' +
                ", ApprovalRefNo='" + ApprovalRefNo + '\'' +
                ", ResponseCode='" + ResponseCode + '\'' +
                ", ResponseMessage='" + ResponseMessage + '\'' +
                ", ResponseDescription='" + ResponseDescription + '\'' +
                ", AdditionalInformation='" + AdditionalInformation + '\'' +
                ", BillerID='" + BillerID + '\'' +
                '}';
    }
}
