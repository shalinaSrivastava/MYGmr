package com.max.ecomaxgo.maxpe.model.Basic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WalletFundTransferLimit {
    @SerializedName("remain")
    @Expose
    var remain: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null
}