package com.max.ecomaxgo.maxpe.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ProfileData {
    @SerializedName("image")
    @Expose
    var image: Image? = null
}