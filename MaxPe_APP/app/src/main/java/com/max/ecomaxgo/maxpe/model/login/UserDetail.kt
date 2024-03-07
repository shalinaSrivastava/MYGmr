package com.max.ecomaxgo.maxpe.model.login

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
class UserDetail {
    @SerializedName("first")
    @Expose
    val first: String? = null

    @SerializedName("last")
    @Expose
    val last: String? = null
}