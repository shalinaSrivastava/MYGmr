package com.max.ecomaxgo.maxpe.share

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ShareIdea {
    @SerializedName("status")
    @Expose
    var status:String ?= null

    @SerializedName("message")
    @Expose
    var message:String ?= null
}