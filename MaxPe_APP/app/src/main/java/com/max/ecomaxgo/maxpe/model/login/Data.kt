package com.max.ecomaxgo.maxpe.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.model.Basic.Wallet

class Data {
     @SerializedName("number")
     @Expose
     val number: String? = null

     @SerializedName("otprno")
     @Expose
     val otprno: String? = null
     @SerializedName("token")
     @Expose
     val token: String? = null

     @SerializedName("image")
     @Expose
     val image: String? = null

     @SerializedName("wallet")
     @Expose
     val wallet: Wallet? = null

     @SerializedName("name")
     @Expose
     val name: UserDetail? = null

     @SerializedName("isNew")
     @Expose
     val isNew: String? = null
 }
