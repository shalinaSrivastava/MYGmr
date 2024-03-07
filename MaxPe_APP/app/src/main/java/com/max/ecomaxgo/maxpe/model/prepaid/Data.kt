package com.max.ecomaxgo.maxpe.model.prepaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("recharge_number")
    @Expose
    var recharge_number: String? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null;
    @SerializedName("recharge")
    @Expose
    var recharge: String? = null
    @SerializedName("operator_id")
    @Expose
    var operatorId: String? = null
    @SerializedName("operator_detail")
    @Expose
    var operatorDetail: OperatorDetail? = null
}