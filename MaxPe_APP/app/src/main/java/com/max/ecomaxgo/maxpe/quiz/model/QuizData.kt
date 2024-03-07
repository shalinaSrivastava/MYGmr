package com.max.ecomaxgo.maxpe.quiz.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class QuizData {
    @SerializedName("result")
    @Expose
    val result: String? = null
    @SerializedName("duration")
    @Expose
    val duration: String? = null
    @SerializedName("participant")
    @Expose
    val participant: List<Participant>? = null
    @SerializedName("lastWinner")
    @Expose
    val lastWinner: List<Participant>? = null
    @SerializedName("quizid")
    @Expose
    val quizid: String? = null
    @SerializedName("question")
    @Expose
    val question: String? = null
    @SerializedName("option")
    @Expose
    val option: Option? = null
}