package com.max.ecomaxgo.maxpe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class IdTypes : Serializable {
    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("placeholder")
    @Expose
    var placeholder: String? = null
}
