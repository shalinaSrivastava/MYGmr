package com.max.ecomaxgo.maxpe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.Basic.Wallet
import com.max.ecomaxgo.maxpe.model.Basic.WalletFundTransferLimit

class PutIdKyc {
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("fname")
    @Expose
    var FirstName: String? = null
    @SerializedName("lname")
    @Expose
    var LastName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("idType")
    @Expose
    var idType: ArrayList<IdTypes>? = null

    @SerializedName("refId")
    @Expose
    var refId: String? = null

    @SerializedName("offer_image")
    @Expose
    var offer_image: String? = null

    @SerializedName("number")
    @Expose
    var number: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("userid")
    @Expose
    var userid: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null

    @SerializedName("wallet")
    @Expose
    var wallet: Wallet? = null

    @SerializedName("kyc")
    @Expose
    var kyc: String? = null

    @SerializedName("walletFundTransferLimit")
    @Expose
    var walletFundTransferLimit: WalletFundTransferLimit? = null

    @SerializedName("oreg")
    @Expose
    var oldRegisterKey: String? = null

    @SerializedName("miles")
    @Expose
    var miles: String? = null
}