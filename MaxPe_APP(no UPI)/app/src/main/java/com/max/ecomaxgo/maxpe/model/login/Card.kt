package com.max.ecomaxgo.maxpe.model.login

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Card {
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
    var data: CardData? = null
}