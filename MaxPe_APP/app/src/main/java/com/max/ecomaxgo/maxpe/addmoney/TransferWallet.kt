package com.max.ecomaxgo.maxpe.addmoney

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.login.Data

class TransferWallet {
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: DataResponse? = null
}