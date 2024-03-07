package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

public class TRequest {
    String email;
    String unqCustId;
    String mobilenumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnqCustId() {
        return unqCustId;
    }

    public void setUnqCustId(String unqCustId) {
        this.unqCustId = unqCustId;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
