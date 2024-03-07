package com.max.ecomaxgo.maxpe.LocalStorage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.olive.upi.transport.model.BeneVpa
import android.preference.PreferenceManager
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MaxSharedPreference(mContext : Context) {

    companion object {
        private const val prefs_name = "max_info"
        private const val mode = 0 }


    @SuppressLint("WrongConstant")
    private val newsPreference: SharedPreferences = mContext.getSharedPreferences(
        prefs_name,
       mode

    )
    private val newsEditor: SharedPreferences.Editor

    init {
        newsEditor = newsPreference.edit()
        newsEditor.apply()
    }

    fun clear() {
        newsEditor.clear()
        newsEditor.commit()
    }

    var isLocationON: Boolean?
        get() = newsPreference.getBoolean("locOnKey", false)
        set(locationON) {
            newsEditor.putBoolean("locOnKey", locationON?:false)
            newsEditor.commit()
        }

    /*var OffersImage: String?
        get() = newsPreference.getString("offersImageKey", "")
        set(OffersImage) {
            newsEditor.putString("offersImageKey", OffersImage)
            newsEditor.commit()
        }*/

    var RefferalCode: String?
        get() = newsPreference.getString("referKey", "")
        set(referPlayStoreKey) {
            newsEditor.putString("referKey", referPlayStoreKey)
            newsEditor.commit()
        }

    var bannerListInString: String?
        get() = newsPreference.getString("bannerListKey", "")
        set(bannerList) {
            newsEditor.putString("bannerListKey", bannerList)
            newsEditor.commit()
        }

    var operatorDataListInString: String?
        get() = newsPreference.getString("operatorListKey", "")
        set(operatorList) {
            newsEditor.putString("operatorListKey", operatorList)
            newsEditor.commit()
        }

    var operatorDataBBPSListInString: String?
        get() = newsPreference.getString("operatorBBPSKey", "")
        set(operatorBBPS) {
            newsEditor.putString("operatorBBPSKey", operatorBBPS)
            newsEditor.commit()
        }

    var kycLocationDataList: String?
        get() = newsPreference.getString("kycLocationKey", "")
        set(kycLocation) {
            newsEditor.putString("kycLocationKey", kycLocation)
            newsEditor.commit()
        }

    var cabCityDataList: String?
        get() = newsPreference.getString("cabDataKey", "")
        set(cabCityData) {
            newsEditor.putString("cabDataKey", cabCityData)
            newsEditor.commit()
        }

    var busStopDataList: String?
        get() = newsPreference.getString("busStopDataKey", "")
        set(busStopData) {
            newsEditor.putString("busStopDataKey", busStopData)
            newsEditor.commit()
        }

    var userId: String?
        get() = newsPreference.getString("userIdKey", "")
        set(idKey) {
            newsEditor.putString("userIdKey", idKey)
            newsEditor.commit()
        }

    var OtpNo: String?
        get() = newsPreference.getString("otpNoKey", "")
        set(otprno) {
            newsEditor.putString("otpNoKey", otprno)
            newsEditor.commit()
        }

    var MaxUserName: String?
        get() = newsPreference.getString("usernameKey", "")
        set(uname) {
            newsEditor.putString("usernameKey", uname)
            newsEditor.commit()
        }

    var UserMobileNum: String?
        get() = newsPreference.getString("mobNumberKey", "")
        set(mobKey) {
            newsEditor.putString("mobNumberKey", mobKey)
            newsEditor.commit()
        }

    var UserIsNew: String?
        get() = newsPreference.getString("isNewKey", "")
        set(isNew) {
            newsEditor.putString("isNewKey", isNew)
            newsEditor.commit()
        }

    var UserFName: String?
        get() = newsPreference.getString("userFNameKey", "")
        set(userFName) {
            newsEditor.putString("userFNameKey", userFName)
            newsEditor.commit()
        }

    var UserLName: String?
        get() = newsPreference.getString("userLNameKey", "")
        set(userLName) {
            newsEditor.putString("userLNameKey", userLName)
            newsEditor.commit()
        }

    var UserEmail: String?
        get() = newsPreference.getString("emailKey", "")
        set(emailKeys) {
            newsEditor.putString("emailKey", emailKeys)
            newsEditor.commit()
        }

    var UserToken: String?
        get() = newsPreference.getString("tokenKey", "")
        set(token) {
            newsEditor.putString("tokenKey", token)
            newsEditor.commit()
        }

    var UserOtprno: String?
        get() = newsPreference.getString("otprnoKey", "")
        set(otprkey) {
            newsEditor.putString("otprkey", otprkey)
            newsEditor.commit()
        }

    var UserWallet: String?
        get() = newsPreference.getString("tokenKey", "")
        set(wallet) {
            newsEditor.putString("wallet", wallet)
            newsEditor.commit()
        }

    var IxigoAuthUserToken: String?
        get() = newsPreference.getString("ixigotokenKey", "")
        set(ixigoToken) {
            newsEditor.putString("ixigotokenKey", ixigoToken)
            newsEditor.commit()
        }

    var fbTokenBoolean: Boolean?
        get() = newsPreference.getBoolean("fbTknKey", true)
        set(tknValue) {
            newsEditor.putBoolean("fbTknKey", tknValue?:false)
            newsEditor.commit()
        }

    var fbNotificationToken: String?
        get() = newsPreference.getString("fbTokenKey", "")
        set(notfToken) {
            newsEditor.putString("fbTokenKey", notfToken)
            newsEditor.commit()
        }

    var WalletFundTranserLimit: String?
        get() = newsPreference.getString("fundTransferLimitKey", "")
        set(fundLimitKey) {
            newsEditor.putString("fundTransferLimitKey", fundLimitKey)
            newsEditor.commit()
        }

    var UserAmountLimit: String?
        get() = newsPreference.getString("amountLimitKey", "")
        set(limitKey) {
            newsEditor.putString("amountLimitKey", limitKey)
            newsEditor.commit()
        }

    var WalletError: String?
        get() = newsPreference.getString("walletErrorKey", "0")
        set(walletErr) {
            newsEditor.putString("walletErrorKey", walletErr)
            newsEditor.commit()
        }

    var userWelcomeMsg: String?
        get() = newsPreference.getString("welcomeMsgKey", "")
        set(userWelcome) {
            newsEditor.putString("welcomeMsgKey", userWelcome)
            newsEditor.commit()
        }

    var UserProfileImg: String?
        get() = newsPreference.getString("profileImgKey", "")
        set(profileImageKey) {
            newsEditor.putString("profileImgKey", profileImageKey)
            newsEditor.commit()
        }

    var UserNetAmount: String?
        get() = newsPreference.getString("netAmountKey", "")
        set(AmountKey) {
            newsEditor.putString("netAmountKey", AmountKey)
            newsEditor.commit()
        }


    var userAmount: String?
        get() = newsPreference.getString("amountKey", "")
        set(amountKey) {
            newsEditor.putString("amountKey", amountKey)
            newsEditor.commit()
        }

    var UserKycValue: String?
        get() = newsPreference.getString("userKycKey", "")
        set(kycKey) {
            newsEditor.putString("userKycKey", kycKey)
            newsEditor.commit()
        }

    var AddMoneyAmountToWallet: String?
        get() = newsPreference.getString("addMoneyKey", "")

        set(addMoneytoWallet) {
            newsEditor.putString("addMoneyKey", addMoneytoWallet)
            newsEditor.commit()
        }

    var GenderValue: String?
        get() = newsPreference.getString("genderKey", "")

        set(genderKeyValue) {
            newsEditor.putString("genderKey", genderKeyValue)
            newsEditor.commit()
        }

    var TitleValue: String?
        get() = newsPreference.getString("titleKey", "")

        set(titleValueKey) {
            newsEditor.putString("titleKey", titleValueKey)
            newsEditor.commit()
        }

    var UtilityType: String?
        get() = newsPreference.getString("utilTypeKey", "")

        set(UtilType) {
            newsEditor.putString("utilTypeKey", UtilType)
            newsEditor.commit()
        }

    var UtilityTitle: String?
        get() = newsPreference.getString("titleUKey", "")

        set(UtileTitleKey) {
            newsEditor.putString("titleUKey", UtileTitleKey)
            newsEditor.commit()
        }

    var UtilityTypeHint: String?
        get() = newsPreference.getString("utilHintKey", "")

        set(UtilHintKey) {
            newsEditor.putString("utilHintKey", UtilHintKey)
            newsEditor.commit()
        }

    var RechargeType: String?
        get() = newsPreference.getString("rechTypeKey", "")

        set(RechType) {
            newsEditor.putString("rechTypeKey", RechType)
            newsEditor.commit()
        }

    var RechargeTitle: String?
        get() = newsPreference.getString("rechUKey", "")

        set(RechTitleKey) {
            newsEditor.putString("rechUKey", RechTitleKey)
            newsEditor.commit()
        }

    var RechargeTypeHint: String?
        get() = newsPreference.getString("rechHintKey", "")

        set(RechHintKey) {
            newsEditor.putString("rechHintKey", RechHintKey)
            newsEditor.commit()
        }

    /*var Loclatitude: String?
        get() = newsPreference.getString("latitude", "")

        set(latitude) {
            newsEditor.putString("latitude", latitude)
            newsEditor.commit()
        }
    var Loclongitude: String?
        get() = newsPreference.getString("longitude", "")

        set(longitude) {
            newsEditor.putString("longitude", longitude)
            newsEditor.commit()
        }*/

    var SaveQRBitmapPath: String?
        get() = newsPreference.getString("qrPathKey", "")

        set(bitmapPath) {
            newsEditor.putString("qrPathKey", bitmapPath)
            newsEditor.commit()
        }

    var SaveQRBitmapPathRegister: String?
        get() = newsPreference.getString("qrPathKeyReg", "")

        set(bitmapPathReg) {
            newsEditor.putString("qrPathKeyReg", bitmapPathReg)
            newsEditor.commit()
        }


    var SaveQRBitmapPathBankLogo: String?
        get() = newsPreference.getString("bankLogo", "")
        set(bankLogo) {
            newsEditor.putString("bankLogo", bankLogo)
            newsEditor.commit()
        }

    var BHIM_DB: String?
        get() = newsPreference.getString("bhim", "")

        set(bhim) {
            newsEditor.putString("bhim", bhim)
            newsEditor.commit()
        }
    var BHIM_ACCOUNTNO: String?
        get() = newsPreference.getString("accountNo", "")

        set(accountNo) {
            newsEditor.putString("accountNo", accountNo)
            newsEditor.commit()
        }
    var BHIM_HOLDERNAME: String?
        get() = newsPreference.getString("holdername", "")

        set(holdername) {
            newsEditor.putString("holdername", holdername)
            newsEditor.commit()
        }
    var BHIM_IFSC: String?
        get() = newsPreference.getString("ifsc", "")

        set(ifsc) {
            newsEditor.putString("ifsc", ifsc)
            newsEditor.commit()
        }
    var BHIM_TYPE: String?
        get() = newsPreference.getString("type", "")

        set(type) {
            newsEditor.putString("type", type)
            newsEditor.commit()
        }
    var BHIM_Token: String?
        get() = newsPreference.getString("btoken", "")

        set(btoken) {
            newsEditor.putString("btoken", btoken)
            newsEditor.commit()
        }
    var BHIM_bankName: String?
        get() = newsPreference.getString("bankName", "")

        set(bankName) {
            newsEditor.putString("bankName", bankName)
            newsEditor.commit()
        }
    var BHIM_mmid: String?
        get() = newsPreference.getString("mmid", "")

        set(mmid) {
            newsEditor.putString("mmid", mmid)
            newsEditor.commit()
        }
    var BHIM_accRefNumber: String?
        get() = newsPreference.getString("accRefNumber", "")

        set(accRefNumber) {
            newsEditor.putString("accRefNumber", accRefNumber)
            newsEditor.commit()
        }
    var BHIM_maskedAccnumber: String?
        get() = newsPreference.getString("maskedAccnumber", "")

        set(maskedAccnumber) {
            newsEditor.putString("maskedAccnumber", maskedAccnumber)
            newsEditor.commit()
        }

    var BHIM_Status: String?
        get() = newsPreference.getString("Status", "")

        set(Status) {
            newsEditor.putString("Status", Status)
            newsEditor.commit()
        }
    var BHIM_Vpa: String?
        get() = newsPreference.getString("Vpa", "")

        set(Vpa) {
            newsEditor.putString("Vpa", Vpa)
            newsEditor.commit()
        }
    var BHIM_dType: String?
        get() = newsPreference.getString("dType", "")

        set(dType) {
            newsEditor.putString("dType", dType)
            newsEditor.commit()
        }
    var BHIM_Balance: String?
        get() = newsPreference.getString("Balance", "")

        set(Balance) {
            newsEditor.putString("Balance", Balance)
            newsEditor.commit()
        }
    var BHIM_Mbeba: String?
        get() = newsPreference.getString("Mbeba", "")

        set(Mbeba) {
            newsEditor.putString("Mbeba", Mbeba)
            newsEditor.commit()
        }

    var BHIM_BalTime: String?
        get() = newsPreference.getString("BalTime", "")

        set(BalTime) {
            newsEditor.putString("BalTime", BalTime)
            newsEditor.commit()
        }
    var BHIM_aeba: String?
        get() = newsPreference.getString("aeba", "")

        set(aeba) {
            newsEditor.putString("aeba", aeba)
            newsEditor.commit()
        }


    var DEREGISTER: String?
        get() = newsPreference.getString("deregister", "")

        set(deregister) {
            newsEditor.putString("deregister", deregister)
            newsEditor.commit()
        }
    var WALLETCARD: String?
        get() = newsPreference.getString("WalletCard", "")

        set(WalletCard) {
            newsEditor.putString("WalletCard", WalletCard)
            newsEditor.commit()
        }
    var CARDBALANCE: String?
        get() = newsPreference.getString("CardBalance", "")

        set(CardBalance) {
            newsEditor.putString("CardBalance", CardBalance)
            newsEditor.commit()
        }

/*    List<Connection> connections = entity.getConnections();
// convert java object to JSON format,
// and returned as JSON formatted string
    String connectionsJSONString = new Gson().toJson(connections);
    editor.putString(KEY_CONNECTIONS, connectionsJSONString);
    editor.commit();*/

    //Retrieve the values
   /* Set<BenVal> set = myScores.getStringSet("key", null);

//Set the values
    Set<String> set = new HashSet<String>();
    set.addAll(listOfExistingScores);
    scoreEditor.putStringSet("key", set);
    scoreEditor.commit();*/
   /* open fun saveArrayList(list: ArrayList<String?>?, key: String?) {
       *//* val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor = prefs.edit()*//*
        val gson = Gson()
        val json = gson.toJson(list)
        newsEditor.putString(key, json)
        newsEditor.apply() // This line is IMPORTANT !!!
    }*/

    fun getArrayList(key: String?): ArrayList<String?>? {
       // val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val gson = Gson()
        val json = newsPreference.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
        return gson.fromJson(json, type)
    }

    fun saveArrayList(beneVpa: Result<ArrayList<BeneVpa>>, beneVpa1: String) {
        val gson = Gson()
        val json = gson.toJson(beneVpa)
        newsEditor.putString(beneVpa1, json)
        newsEditor.apply() // This line is IMPORTANT !!!
    }


}