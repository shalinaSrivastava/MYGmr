package com.max.ecomaxgo.maxpe.quiz.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Quiz {
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("error")
    @Expose
    val error: String? = null
    @SerializedName("message")
    @Expose
    val message: String? = null
    @SerializedName("data")
    @Expose
    val data: QuizData? = null
}