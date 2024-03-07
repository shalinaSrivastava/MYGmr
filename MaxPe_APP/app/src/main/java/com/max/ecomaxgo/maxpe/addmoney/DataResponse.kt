package com.max.ecomaxgo.maxpe.addmoney

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.Basic.Wallet

class DataResponse {
    @SerializedName("sent_to")
    @Expose
    var sent_to: String? = null
    @SerializedName("wallet")
    @Expose
    var wallet: Wallet? = null

}