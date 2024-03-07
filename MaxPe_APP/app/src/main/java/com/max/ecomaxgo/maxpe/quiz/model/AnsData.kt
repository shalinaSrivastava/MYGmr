package com.max.ecomaxgo.maxpe.quiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.Basic.Wallet

class AnsData {
    @SerializedName("fname")
    @Expose
    val fname: String? = null
    @SerializedName("lname")
    @Expose
    val lname: String? = null
    @SerializedName("image")
    @Expose
    val image: String? = null
    @SerializedName("answer")
    @Expose
    val answer: String? = null
    @SerializedName("winner")
    @Expose
    val winner: String? = null
    @SerializedName("credited")
    @Expose
    val credited: String? = null
    @SerializedName("wallet")
    @Expose
    private val wallet: Wallet? = null
}