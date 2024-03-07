
package com.max.ecomaxgo.maxpe.dashboad.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardNumber {

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

    public CardNumber withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public CardNumber withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CardNumber withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public CardNumber withData(Data data) {
        this.data = data;
        return this;
    }

    public class Data {

        @SerializedName("card")
        @Expose
        private List<Card> card = null;

        public List<Card> getCard() {
            return card;
        }

        public void setCard(List<Card> card) {
            this.card = card;
        }

        public Data withCard(List<Card> card) {
            this.card = card;
            return this;
        }

    }
    public class Card {

        @SerializedName("provider")
        @Expose
        private String provider;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("number")
        @Expose
        private String number;
        @SerializedName("expiry")
        @Expose
        private String expiry;
        @SerializedName("status")
        @Expose
        private String status;

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public Card withProvider(String provider) {
            this.provider = provider;
            return this;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Card withType(String type) {
            this.type = type;
            return this;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public Card withLogo(String logo) {
            this.logo = logo;
            return this;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Card withNumber(String number) {
            this.number = number;
            return this;
        }

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {
            this.expiry = expiry;
        }

        public Card withExpiry(String expiry) {
            this.expiry = expiry;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Card withStatus(String status) {
            this.status = status;
            return this;
        }

    }

}

