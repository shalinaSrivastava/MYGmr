package com.max.ecomaxgo.maxpe.dth.model;

public class ComplaintModel {
    String date;
    String id;
    String time;

    public ComplaintModel(String date, String id, String time) {
        this.date = date;
        this.id = id;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
