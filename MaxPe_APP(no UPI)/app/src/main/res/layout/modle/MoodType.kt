package com.max.ecomaxgo.maxpe.dashboad.modle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.login.Data

class MoodType {

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("error")
    @Expose
    var error: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("mymood")
    @Expose
    var myMoodType: String? = null
}