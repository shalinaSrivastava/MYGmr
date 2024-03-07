package com.max.ecomaxgo.maxpe.model.Basic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DEFAULT {
    @SerializedName("available")
    @Expose
    var available: Available? = null

    @SerializedName("withholding")
    @Expose
    var withholding: Withholding? = null
}
