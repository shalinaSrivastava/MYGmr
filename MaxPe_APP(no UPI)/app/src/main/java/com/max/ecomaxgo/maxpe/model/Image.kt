package com.max.ecomaxgo.maxpe.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("error")
    @Expose
    var error: Boolean? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
}