package com.max.ecomaxgo.maxpe.LocalStorage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

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
    var WalletCard: String?
        get() = newsPreference.getString("walletcard", "")

        set(walletcard) {
            newsEditor.putString("walletcard", walletcard)
            newsEditor.commit()
        }
    var WalletBalance: String?
        get() = newsPreference.getString("walletBalance", "")

        set(walletBalance) {
            newsEditor.putString("walletBalance", walletBalance)
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

    var Bus_Sourcekey: String?
        get() = newsPreference.getString("sourcekey", "")

        set(sourcekey) {
            newsEditor.putString("sourcekey", sourcekey)
            newsEditor.commit()
        }
    var Bus_SourceId: String?
        get() = newsPreference.getString("sourceId", "")

        set(sourceId) {
            newsEditor.putString("sourceId", sourceId)
            newsEditor.commit()
        }
    var Bus_DestinationId: String?
        get() = newsPreference.getString("destinationId", "")

        set(destinationId) {
            newsEditor.putString("destinationId", destinationId)
            newsEditor.commit()
        }
    var Bus_DestinationKey: String?
        get() = newsPreference.getString("destinationKey", "")

        set(destinationKey) {
            newsEditor.putString("destinationKey", destinationKey)
            newsEditor.commit()
        }
    var Bus_Date: String?
        get() = newsPreference.getString("date", "")

        set(date) {
            newsEditor.putString("date", date)
            newsEditor.commit()
        }

    var Bus_type: String?
        get() = newsPreference.getString("busType", "")

        set(busType) {
            newsEditor.putString("busType", busType)
            newsEditor.commit()
        }
    var Bus_tripId: String?
        get() = newsPreference.getString("tripId", "")

        set(tripId) {
            newsEditor.putString("tripId", tripId)
            newsEditor.commit()
        }
    var Bus_seater: String?
        get() = newsPreference.getString("seater", "")

        set(seater) {
            newsEditor.putString("seater", seater)
            newsEditor.commit()
        }
    var Bus_sleeper: String?
        get() = newsPreference.getString("sleeper", "")

        set(sleeper) {
            newsEditor.putString("sleeper", sleeper)
            newsEditor.commit()
        }
    var Bus_routeId: String?
        get() = newsPreference.getString("routeId", "")

        set(routeId) {
            newsEditor.putString("routeId", routeId)
            newsEditor.commit()
        }
    var Bus_engineId: String?
        get() = newsPreference.getString("engineId", "")

        set(engineId) {
            newsEditor.putString("engineId", engineId)
            newsEditor.commit()
        }
    var hotel_check_in: String?
        get() = newsPreference.getString("checkIn", "")

        set(checkIn) {
            newsEditor.putString("checkIn", checkIn)
            newsEditor.commit()
        }
    var hotel_check_Out: String?
        get() = newsPreference.getString("checkOut", "")

        set(checkOut) {
            newsEditor.putString("checkOut", checkOut)
            newsEditor.commit()
        }
    var hotel_Room: String?
        get() = newsPreference.getString("totalRoom", "")

        set(totalRoom) {
            newsEditor.putString("totalRoom", totalRoom)
            newsEditor.commit()
        }
    var hotel_noAdult: String?
        get() = newsPreference.getString("totalAdult", "")

        set(totalAdult) {
            newsEditor.putString("totalAdult", totalAdult)
            newsEditor.commit()
        }
    var hotel_totalChild: String?
        get() = newsPreference.getString("totalChild", "")

        set(totalChild) {
            newsEditor.putString("totalChild", totalChild)
            newsEditor.commit()
        }
    var hotel_childAge: String?
        get() = newsPreference.getString("childAge", "")

        set(childAge) {
            newsEditor.putString("childAge", childAge)
            newsEditor.commit()
        }
    var hotel_place: String?
        get() = newsPreference.getString("place", "")

        set(place) {
            newsEditor.putString("place", place)
            newsEditor.commit()
        }


}