package com.max.ecomaxgo.maxpe.dth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillerCustomerParam {
    @SerializedName("paramName")
    @Expose
    private String paramName;
    @SerializedName("dataType")
    @Expose
    private String dataType;
    @SerializedName("optional")
    @Expose
    private String optional;
    @SerializedName("minLength")
    @Expose
    private String minLength;
    @SerializedName("maxLength")
    @Expose
    private String maxLength;
    @SerializedName("regex")
    @Expose
    private String regex;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
