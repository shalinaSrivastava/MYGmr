package com.max.ecomaxgo.maxpe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber

class CardNumber {
    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("error")
    @Expose
    private var error: String? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun withStatus(status: String?): com.max.ecomaxgo.maxpe.model.CardNumber {
        this.status = status
        return this
    }

    fun getError(): String? {
        return error
    }

    fun setError(error: String?) {
        this.error = error
    }

    fun withError(error: String?): com.max.ecomaxgo.maxpe.model.CardNumber {
        this.error = error
        return this
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun withMessage(message: String?): com.max.ecomaxgo.maxpe.model.CardNumber {
        this.message = message
        return this
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }

    fun withData(data: Data?): com.max.ecomaxgo.maxpe.model.CardNumber {
        this.data = data
        return this
    }

    class Data {
        @SerializedName("card")
        @Expose
        var card: List<Card>? = null

        fun withCard(card: List<Card>?): Data {
            this.card = card
            return this
        }
    }

    class Card {
        @SerializedName("provider")
        @Expose
        var provider: String? = null

        @SerializedName("type")
        @Expose
        var type: String? = null

        @SerializedName("logo")
        @Expose
        var logo: String? = null

        @SerializedName("number")
        @Expose
        var number: String? = null

        @SerializedName("expiry")
        @Expose
        var expiry: String? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        fun withProvider(provider: String?): Card {
            this.provider = provider
            return this
        }

        fun withType(type: String?): Card {
            this.type = type
            return this
        }

        fun withLogo(logo: String?): Card {
            this.logo = logo
            return this
        }

        fun withNumber(number: String?): Card {
            this.number = number
            return this
        }

        fun withExpiry(expiry: String?): Card {
            this.expiry = expiry
            return this
        }

        fun withStatus(status: String?): Card {
            this.status = status
            return this
        }
    }

}