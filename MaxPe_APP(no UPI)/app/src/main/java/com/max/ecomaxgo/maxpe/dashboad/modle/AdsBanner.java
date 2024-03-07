package com.max.ecomaxgo.maxpe.dashboad.modle;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AdsBanner {

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
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AdsBanner withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AdsBanner withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AdsBanner withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public AdsBanner withData(List<Datum> data) {
        this.data = data;
        return this;
    }
    public class Datum {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("prioty")
        @Expose
        private String prioty;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Datum withName(String name) {
            this.name = name;
            return this;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Datum withImage(String image) {
            this.image = image;
            return this;
        }

        public String getPrioty() {
            return prioty;
        }

        public void setPrioty(String prioty) {
            this.prioty = prioty;
        }

        public Datum withPrioty(String prioty) {
            this.prioty = prioty;
            return this;
        }

    }
}


