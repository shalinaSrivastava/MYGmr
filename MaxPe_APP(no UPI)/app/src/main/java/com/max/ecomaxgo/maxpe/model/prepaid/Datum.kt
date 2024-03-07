package com.max.ecomaxgo.maxpe.model.prepaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Datum : Serializable{
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("operator_name")
    @Expose
    var operatorName: String? = null
    @SerializedName("operator_logo")
    @Expose
    var operatorLogo: String? = null
    @SerializedName("service_type")
    @Expose
    var serviceType: String? = null
    @SerializedName("service")
    @Expose
    var service: List<Service>? = null

}