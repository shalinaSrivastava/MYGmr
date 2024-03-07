package com.max.ecomaxgo.maxpe.model.Basic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WalletHolding {
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("wallet")
    @Expose
    var wallet: Wallet? = null
    @SerializedName("kyc")
    @Expose
    var kyc: String? = null
    @SerializedName("walletFundTransferLimit")
    @Expose
    var walletFundTransferLimit: WalletFundTransferLimit? = null

    @SerializedName("miles")
    @Expose
    var miles: String? = null
}