package com.max.ecomaxgo.maxpe.ApiInterface

import com.max.ecomaxgo.maxpe.addmoney.TransferWallet
import com.max.ecomaxgo.maxpe.bbps.Biller
import com.max.ecomaxgo.maxpe.bbps.FetchBiller
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber
import com.max.ecomaxgo.maxpe.dashboad.modle.MyMood
import com.max.ecomaxgo.maxpe.dth.model.Bbps
import com.max.ecomaxgo.maxpe.model.Basic.*
import com.max.ecomaxgo.maxpe.model.Profile
import com.max.ecomaxgo.maxpe.model.login.Card
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.model.prepaid.History
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidDetailsData
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.quiz.model.Quiz
import com.max.ecomaxgo.maxpe.quiz.model.QuizAns
import com.max.ecomaxgo.maxpe.share.ShareIdea
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface RestInetApi {

    @FormUrlEncoded
    @POST("Testing/v41/Basic_Rest/wallet")
    fun wallet(@Field("userid") userid: String, @Field("token") token: String)
    : Call<WalletHolding>

    //login api-----------------------------//Production  prod
    @FormUrlEncoded
    @POST("prod/Wallet/Account/login")
    fun login(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("imei") imei: String,
        @Field("os") os: String,
        @Field("osv") osv: String,
        @Field("device") device: String


    ): Call<Login>

    //otp verified api---------------
    @FormUrlEncoded
    @POST("prod/Wallet/Account/verify")
    fun otpVerify(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("otprno") otprno: String,
        @Field("otp") otp: String
    ): Call<Login>

    @FormUrlEncoded
    @POST("prod/Wallet/Account/resend")
    fun reSendOTP(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("otprno") otprno: String
    ): Call<Login>

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/putName")
    fun updateName(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("fname") fname: String,
        @Field("lname") lname: String
    ): Call<Login>

    //mobile recharge api---------------------start-------------------------
    @FormUrlEncoded
    @POST("prod/Kwik/Recharge/operator")
    fun mobilePrepaid(
        @Field("skey") skey: String
    ): Call<PrepaidMode>

    @FormUrlEncoded
    @POST("prod/Kwik/Recharge/prepaid")
    fun  prepaidDetails(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("amount") amount: String,
        @Field("recharge_number") recharge_number: String,
        @Field("operator_id") operator_id: String,
        @Field("mode") mode: String

    ): Call<PrepaidDetailsData>

    //-------------------------------end-----------------------------------

    //-------------dth all api start------------------------------------

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/balance")
    fun getWalletBalance(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String
    ): Call<Login>

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/addTempMoney")
    fun addMoney(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("amount") amount: String
    ): Call<Login>

    @FormUrlEncoded
    @POST("prod/Wallet/Transfer/wallet")
    fun sendMoneyWalletToWallet(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("amount") amount: String,
        @Field("sent_to") sent_to: String
    ): Call<TransferWallet>

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/transaction")
    fun getHistory(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String
    ): Call<History>

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/avtar")
    fun uploadsProImage(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("pic") pic: String
    ): Call<Profile>
    //---------------------------------BBPS API INTEGRATED START-----------------------------
    @FormUrlEncoded
    @POST("prod/Euronet/Bbps/operator")
    fun getDthOperator(
        @Field("skey") skey: String,
        @Field("category") category: String
    ): Call<Bbps>

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/card")
    fun getCard(
        @Field("skey") skey: String,
        @Field("number") number: String,
        @Field("token") token: String
    ): Call<Card>


    //bbps----------------------------api call-----------------------
    @FormUrlEncoded
    @POST("Testing/Euronet/Bbps/biller")
    fun getBiller(
        @Field("skey") skey: String,
        @Field("category") category: String,
        @Field("billerId") billerId: String
    ): Call<Biller>

    @FormUrlEncoded
    @POST("Testing/Euronet/Bbps/fetch")
    fun fetchBiller(
        @Field("skey") skey: String,
        @Field("billerId") billerId: String,
        @Field("token") token: String,
        @Field("number") number: String,
        @Field("paramName") paramName: String,
        @Field("paramValue") paramValue: String,
        @Field("x") x: String
    ): Call<FetchBiller>

    @FormUrlEncoded
    @POST("prod/Wallet/Quiz/do")
    fun quizDo(
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("skey") skey: String
    ): Call<Quiz>

    @FormUrlEncoded
    @POST("prod/Wallet/Quiz/ans")
    fun quizAns(
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("ans") ans: String,
        @Field("quizid") quizid: String,
        @Field("skey") skey: String
    ): Call<QuizAns>

    //==================share an idea===================
    @FormUrlEncoded
    @POST("prod/Wallet/Other/shareIdea")
    fun shareanides(
        @Field("number") number: String,
        @Field("token") token: String,
        @Field("message") message: String,
        @Field("skey") skey: String
    ): Call<ShareIdea>

    @FormUrlEncoded
    @POST("Other/getMood")
    fun getMood(
        @Field("skey") skey: String?,
        @Field("number") number: String?,
        @Field("token") token: String?
    ): Call<*>?

    @FormUrlEncoded
    @POST("Other/setMood")
    fun setMood(
        @Field("skey") skey: String?,
        @Field("number") number: String?,
        @Field("token") token: String?,
        @Field("mymood") mymood: String?
    ): Call<MyMood?>?

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/card")
    fun getWalletCard(
        @Field("skey") skey: String?,
        @Field("number") number: String?,
        @Field("token") token: String?
    ): Call<CardNumber?>?
}