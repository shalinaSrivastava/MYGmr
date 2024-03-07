package com.max.ecomaxgo.maxpe.dashboad.modle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WalletBalance {

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

    public WalletBalance withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public WalletBalance withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WalletBalance withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public WalletBalance withData(Data data) {
        this.data = data;
        return this;
    }

    public class Data {

        @SerializedName("wallet")
        @Expose
        private Wallet wallet;

        public Wallet getWallet() {
            return wallet;
        }

        public void setWallet(Wallet wallet) {
            this.wallet = wallet;
        }

        public Data withWallet(Wallet wallet) {
            this.wallet = wallet;
            return this;
        }

    }


    public class Wallet {

        @SerializedName("error")
        @Expose
        private Boolean error;
        @SerializedName("amount")
        @Expose
        private String amount;

        public Boolean getError() {
            return error;
        }

        public void setError(Boolean error) {
            this.error = error;
        }

        public Wallet withError(Boolean error) {
            this.error = error;
            return this;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public Wallet withAmount(String amount) {
            this.amount = amount;
            return this;
        }

    }


}
