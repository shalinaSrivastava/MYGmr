package com.max.ecomaxgo.maxpe.model.login

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
class CardData {
    @SerializedName("cardNumber")
    @Expose
    var cardNumber: String? = null
    @SerializedName("cardExpiry")
    @Expose
    var cardExpiry: String? = null
    @SerializedName("cardStatus")
    @Expose
    var cardStatus: String? = null
}