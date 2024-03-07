package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import com.google.gson.annotations.SerializedName;
public class UPIChecksum {

    @SerializedName("code")

    private String code;
    @SerializedName("result")

    private String result;
    @SerializedName("data")

    private Data data;
    @SerializedName("riskScoreValue")

    private Object riskScoreValue;
    @SerializedName("checkSum")

    private Object checkSum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UPIChecksum withCode(String code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UPIChecksum withResult(String result) {
        this.result = result;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public UPIChecksum withData(Data data) {
        this.data = data;
        return this;
    }

    public Object getRiskScoreValue() {
        return riskScoreValue;
    }

    public void setRiskScoreValue(Object riskScoreValue) {
        this.riskScoreValue = riskScoreValue;
    }

    public UPIChecksum withRiskScoreValue(Object riskScoreValue) {
        this.riskScoreValue = riskScoreValue;
        return this;
    }

    public Object getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(Object checkSum) {
        this.checkSum = checkSum;
    }

    public UPIChecksum withCheckSum(Object checkSum) {
        this.checkSum = checkSum;
        return this;
    }

    public class Data {

        @SerializedName("merchantauthtoken")
        private String merchantauthtoken;

        public String getMerchantauthtoken() {
            return merchantauthtoken;
        }

        public void setMerchantauthtoken(String merchantauthtoken) {
            this.merchantauthtoken = merchantauthtoken;
        }

        public Data withMerchantauthtoken(String merchantauthtoken) {
            this.merchantauthtoken = merchantauthtoken;
            return this;
        }

    }

}
