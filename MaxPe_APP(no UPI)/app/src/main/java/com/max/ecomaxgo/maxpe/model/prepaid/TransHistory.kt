package com.max.ecomaxgo.maxpe.model.prepaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TransHistory {
    @SerializedName("account")
    @Expose
    var account: String? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null
    @SerializedName("service")
    @Expose
    var services: String? = null
    @SerializedName("dateTime")
    @Expose
    var dateTime: String? = null
    @SerializedName("field")
    @Expose
    var field: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
}