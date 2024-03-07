package com.max.ecomaxgo.maxpe.travel.bus_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlockBusSeat {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("isTransactionCreated")
        @Expose
        private Boolean isTransactionCreated;
        @SerializedName("transactionid")
        @Expose
        private String transactionid;
        @SerializedName("error")
        @Expose
        private String error;
        @SerializedName("validFor")
        @Expose
        private String validFor;
        @SerializedName("transactionScreenId")
        @Expose
        private String transactionScreenId;
        @SerializedName("totalAmount")
        @Expose
        private Integer totalAmount;
        @SerializedName("isFareRecheck")
        @Expose
        private Boolean isFareRecheck;
        @SerializedName("fareBreak")
        @Expose
        private Object fareBreak;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("BaseTotal")
        @Expose
        private Integer baseTotal;
        @SerializedName("ResponseKey")
        @Expose
        private String responseKey;
        @SerializedName("IsInsurance")
        @Expose
        private Boolean isInsurance;
        @SerializedName("IsInsuranceAMT")
        @Expose
        private Integer isInsuranceAMT;
        @SerializedName("TraceId")
        @Expose
        private Object traceId;

        public Boolean getIsTransactionCreated() {
            return isTransactionCreated;
        }

        public void setIsTransactionCreated(Boolean isTransactionCreated) {
            this.isTransactionCreated = isTransactionCreated;
        }

        public String getTransactionid() {
            return transactionid;
        }

        public void setTransactionid(String transactionid) {
            this.transactionid = transactionid;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getValidFor() {
            return validFor;
        }

        public void setValidFor(String validFor) {
            this.validFor = validFor;
        }

        public String getTransactionScreenId() {
            return transactionScreenId;
        }

        public void setTransactionScreenId(String transactionScreenId) {
            this.transactionScreenId = transactionScreenId;
        }

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Boolean getIsFareRecheck() {
            return isFareRecheck;
        }

        public void setIsFareRecheck(Boolean isFareRecheck) {
            this.isFareRecheck = isFareRecheck;
        }

        public Object getFareBreak() {
            return fareBreak;
        }

        public void setFareBreak(Object fareBreak) {
            this.fareBreak = fareBreak;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Integer getBaseTotal() {
            return baseTotal;
        }

        public void setBaseTotal(Integer baseTotal) {
            this.baseTotal = baseTotal;
        }

        public String getResponseKey() {
            return responseKey;
        }

        public void setResponseKey(String responseKey) {
            this.responseKey = responseKey;
        }

        public Boolean getIsInsurance() {
            return isInsurance;
        }

        public void setIsInsurance(Boolean isInsurance) {
            this.isInsurance = isInsurance;
        }

        public Integer getIsInsuranceAMT() {
            return isInsuranceAMT;
        }

        public void setIsInsuranceAMT(Integer isInsuranceAMT) {
            this.isInsuranceAMT = isInsuranceAMT;
        }

        public Object getTraceId() {
            return traceId;
        }

        public void setTraceId(Object traceId) {
            this.traceId = traceId;
        }

    }
}

