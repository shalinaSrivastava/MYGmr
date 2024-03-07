package com.max.ecomaxgo.maxpe.travel.hotelModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookHotel {

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

    public BookHotel withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public BookHotel withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookHotel withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public BookHotel withData(Data data) {
        this.data = data;
        return this;
    }
    public class Data {

        @SerializedName("Error")
        @Expose
        private Object error;
        @SerializedName("HotelEmailAddress")
        @Expose
        private Object hotelEmailAddress;
        @SerializedName("HotelPhoneNumber")
        @Expose
        private Object hotelPhoneNumber;
        @SerializedName("ImportantInfo")
        @Expose
        private Object importantInfo;
        @SerializedName("confirmationNumbers")
        @Expose
        private List<String> confirmationNumbers = null;
        @SerializedName("itineraryId")
        @Expose
        private String itineraryId;
        @SerializedName("processWithConfirmation")
        @Expose
        private String processWithConfirmation;
        @SerializedName("rateKey")
        @Expose
        private Object rateKey;
        @SerializedName("reservationNumbers")
        @Expose
        private Object reservationNumbers;
        @SerializedName("reservationStatusCode")
        @Expose
        private String reservationStatusCode;
        @SerializedName("transactionid")
        @Expose
        private Integer transactionid;

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }

        public Data withError(Object error) {
            this.error = error;
            return this;
        }

        public Object getHotelEmailAddress() {
            return hotelEmailAddress;
        }

        public void setHotelEmailAddress(Object hotelEmailAddress) {
            this.hotelEmailAddress = hotelEmailAddress;
        }

        public Data withHotelEmailAddress(Object hotelEmailAddress) {
            this.hotelEmailAddress = hotelEmailAddress;
            return this;
        }

        public Object getHotelPhoneNumber() {
            return hotelPhoneNumber;
        }

        public void setHotelPhoneNumber(Object hotelPhoneNumber) {
            this.hotelPhoneNumber = hotelPhoneNumber;
        }

        public Data withHotelPhoneNumber(Object hotelPhoneNumber) {
            this.hotelPhoneNumber = hotelPhoneNumber;
            return this;
        }

        public Object getImportantInfo() {
            return importantInfo;
        }

        public void setImportantInfo(Object importantInfo) {
            this.importantInfo = importantInfo;
        }

        public Data withImportantInfo(Object importantInfo) {
            this.importantInfo = importantInfo;
            return this;
        }

        public List<String> getConfirmationNumbers() {
            return confirmationNumbers;
        }

        public void setConfirmationNumbers(List<String> confirmationNumbers) {
            this.confirmationNumbers = confirmationNumbers;
        }

        public Data withConfirmationNumbers(List<String> confirmationNumbers) {
            this.confirmationNumbers = confirmationNumbers;
            return this;
        }

        public String getItineraryId() {
            return itineraryId;
        }

        public void setItineraryId(String itineraryId) {
            this.itineraryId = itineraryId;
        }

        public Data withItineraryId(String itineraryId) {
            this.itineraryId = itineraryId;
            return this;
        }

        public String getProcessWithConfirmation() {
            return processWithConfirmation;
        }

        public void setProcessWithConfirmation(String processWithConfirmation) {
            this.processWithConfirmation = processWithConfirmation;
        }

        public Data withProcessWithConfirmation(String processWithConfirmation) {
            this.processWithConfirmation = processWithConfirmation;
            return this;
        }

        public Object getRateKey() {
            return rateKey;
        }

        public void setRateKey(Object rateKey) {
            this.rateKey = rateKey;
        }

        public Data withRateKey(Object rateKey) {
            this.rateKey = rateKey;
            return this;
        }

        public Object getReservationNumbers() {
            return reservationNumbers;
        }

        public void setReservationNumbers(Object reservationNumbers) {
            this.reservationNumbers = reservationNumbers;
        }

        public Data withReservationNumbers(Object reservationNumbers) {
            this.reservationNumbers = reservationNumbers;
            return this;
        }

        public String getReservationStatusCode() {
            return reservationStatusCode;
        }

        public void setReservationStatusCode(String reservationStatusCode) {
            this.reservationStatusCode = reservationStatusCode;
        }

        public Data withReservationStatusCode(String reservationStatusCode) {
            this.reservationStatusCode = reservationStatusCode;
            return this;
        }

        public Integer getTransactionid() {
            return transactionid;
        }

        public void setTransactionid(Integer transactionid) {
            this.transactionid = transactionid;
        }

        public Data withTransactionid(Integer transactionid) {
            this.transactionid = transactionid;
            return this;
        }

    }
}


