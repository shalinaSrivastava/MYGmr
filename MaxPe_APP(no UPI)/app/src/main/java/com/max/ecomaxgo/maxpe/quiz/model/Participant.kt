package com.max.ecomaxgo.maxpe.quiz.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Participant {
    @SerializedName("fname")
    @Expose
    val fname: String? = null
    @SerializedName("lnane")
    @Expose
    val lname: String? = null
    @SerializedName("image")
    @Expose
    val image: String? = null
    @SerializedName("credited")
    @Expose
    val credited: String? = null
    @SerializedName("attempt_date")
    @Expose
    val attemptDate: String? = null

}