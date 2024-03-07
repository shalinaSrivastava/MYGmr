package com.max.ecomaxgo.maxpe.dth.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class DthOperator {
    @SerializedName("category")
    @Expose
    var category: String? = null
    @SerializedName("operator")
    @Expose
    var operator: List<Operator>? = null
}