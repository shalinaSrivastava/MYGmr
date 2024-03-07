package com.max.ecomaxgo.maxpe.model.Basic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Available {
    @SerializedName("currency")
    @Expose
    var currency: String? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null
}
