
package com.max.ecomaxgo.maxpe.dashboad.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChainListRefer {

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

    public ChainListRefer withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ChainListRefer withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChainListRefer withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ChainListRefer withData(Data data) {
        this.data = data;
        return this;
    }

    public class Chain {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("earning")
        @Expose
        private String earning;
        @SerializedName("chain")
        @Expose
        private String chain;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Chain withUsername(String username) {
            this.username = username;
            return this;
        }

        public String getEarning() {
            return earning;
        }

        public void setEarning(String earning) {
            this.earning = earning;
        }

        public Chain withEarning(String earning) {
            this.earning = earning;
            return this;
        }

        public String getChain() {
            return chain;
        }

        public void setChain(String chain) {
            this.chain = chain;
        }

        public Chain withChain(String chain) {
            this.chain = chain;
            return this;
        }

    }
    public class Data {

        @SerializedName("rfcode")
        @Expose
        private String rfcode;
        @SerializedName("chain")
        @Expose
        private List<Chain> chain = null;

        public String getRfcode() {
            return rfcode;
        }

        public void setRfcode(String rfcode) {
            this.rfcode = rfcode;
        }

        public Data withRfcode(String rfcode) {
            this.rfcode = rfcode;
            return this;
        }

        public List<Chain> getChain() {
            return chain;
        }

        public void setChain(List<Chain> chain) {
            this.chain = chain;
        }

        public Data withChain(List<Chain> chain) {
            this.chain = chain;
            return this;
        }

    }


}




