package com.max.ecomaxgo.maxpe.quiz.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Option {
    @SerializedName("a")
    @Expose
    val a: String? = null
    @SerializedName("b")
    @Expose
    val b: String? = null
    @SerializedName("c")
    @Expose
    val c: String? = null
    @SerializedName("d")
    @Expose
    val d: String? = null
}