package com.max.ecomaxgo.maxpe.bbps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillerPaymentChannel {
    @SerializedName("paymentChannel")
    @Expose
    private String paymentChannel;
    @SerializedName("minLimit")
    @Expose
    private String minLimit;
    @SerializedName("maxLimit")
    @Expose
    private String maxLimit;

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(String minLimit) {
        this.minLimit = minLimit;
    }

    public String getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(String maxLimit) {
        this.maxLimit = maxLimit;
    }
}
