package com.max.ecomaxgo.maxpe.model.prepaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Service : Serializable{
    @SerializedName("operation")
    @Expose
    var operation: String? = null
    @SerializedName("operator_id")
    @Expose
    var operatorId: String? = null;
    override fun toString(): String {
        return "Service(operation=$operation, operatorId=$operatorId)"
    }


}