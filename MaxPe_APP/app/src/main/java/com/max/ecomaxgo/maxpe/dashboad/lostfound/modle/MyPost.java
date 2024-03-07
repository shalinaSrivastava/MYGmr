package com.max.ecomaxgo.maxpe.dashboad.lostfound.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MyPost {

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

    public MyPost withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public MyPost withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyPost withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public MyPost withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public class Datum {

        @SerializedName("lfid")
        @Expose
        private String lfid;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("entryDate")
        @Expose
        private String entryDate;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("lostFoundDate")
        @Expose
        private String lostFoundDate;
        @SerializedName("categoryStatus")
        @Expose
        private String categoryStatus;
        @SerializedName("contactPersonName")
        @Expose
        private String contactPersonName;
        @SerializedName("contactPersonMobile")
        @Expose
        private String contactPersonMobile;
        @SerializedName("status")
        @Expose
        private String status;

        public String getLfid() {
            return lfid;
        }

        public void setLfid(String lfid) {
            this.lfid = lfid;
        }

        public Datum withLfid(String lfid) {
            this.lfid = lfid;
            return this;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Datum withCategory(String category) {
            this.category = category;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Datum withTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Datum withDescription(String description) {
            this.description = description;
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

        public String getEntryDate() {
            return entryDate;
        }

        public void setEntryDate(String entryDate) {
            this.entryDate = entryDate;
        }

        public Datum withEntryDate(String entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Datum withCity(String city) {
            this.city = city;
            return this;
        }

        public String getLostFoundDate() {
            return lostFoundDate;
        }

        public void setLostFoundDate(String lostFoundDate) {
            this.lostFoundDate = lostFoundDate;
        }

        public Datum withLostFoundDate(String lostFoundDate) {
            this.lostFoundDate = lostFoundDate;
            return this;
        }

        public String getCategoryStatus() {
            return categoryStatus;
        }

        public void setCategoryStatus(String categoryStatus) {
            this.categoryStatus = categoryStatus;
        }

        public Datum withCategoryStatus(String categoryStatus) {
            this.categoryStatus = categoryStatus;
            return this;
        }

        public String getContactPersonName() {
            return contactPersonName;
        }

        public void setContactPersonName(String contactPersonName) {
            this.contactPersonName = contactPersonName;
        }

        public Datum withContactPersonName(String contactPersonName) {
            this.contactPersonName = contactPersonName;
            return this;
        }

        public String getContactPersonMobile() {
            return contactPersonMobile;
        }

        public void setContactPersonMobile(String contactPersonMobile) {
            this.contactPersonMobile = contactPersonMobile;
        }

        public Datum withContactPersonMobile(String contactPersonMobile) {
            this.contactPersonMobile = contactPersonMobile;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Datum withStatus(String status) {
            this.status = status;
            return this;
        }

    }

}
