package com.max.ecomaxgo.maxpe.dth.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Operator {
    @SerializedName("billerId")
    @Expose
    var billerId: String? = null
    @SerializedName("billerName")
    @Expose
    var billerName: String? = null
    @SerializedName("operator_logo")
    @Expose
    var operatorLogo: String? = null
}