package com.max.ecomaxgo.maxpe.model.Basic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wallet {
    @SerializedName("funds")
    @Expose
    var funds: Funds? = null
    @SerializedName("limit")
    @Expose
    var limit: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null
}