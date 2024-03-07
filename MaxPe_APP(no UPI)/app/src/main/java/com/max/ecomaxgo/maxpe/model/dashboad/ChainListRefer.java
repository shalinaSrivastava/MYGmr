package com.max.ecomaxgo.maxpe.model.dashboad;

import com.google.gson.annotations.SerializedName;

public class ChainListRefer{

    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private String data;
    @SerializedName("rfcode")
    private String rfcode;
    @SerializedName("chain")
    private String chain;
    @SerializedName("username")
    private String username;
    @SerializedName("earning")
    private String earning;
  //  @SerializedName("chain")
   // private String chain;


    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getRfcode() {
        return rfcode;
    }

    public String getChain() {
        return chain;
    }

    public String getUsername() {
        return username;
    }

    public String getEarning() {
        return earning;
    }
}
