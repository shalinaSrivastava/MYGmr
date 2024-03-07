package com.max.ecomaxgo.maxpe.util

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Constant {

    const val SecurityKey = "30b81092491d81c5e90990bb06d875498be3b83f8eb9d432d458324e5b4731225e6600cd27ae6e"
    val dfToken = "805f5798502920fb8e683481db8063e4"
    val dfCode = "DFND1"
    const val FlightSkey = "d2k4m5n7q8r9b3k4m6p7q8s2j3m5n6p8r9s2k4m5n7q8r"

    const val bbpsSkey = "d2k4m5n7q8r9b3k4m6p7q8s2j3m5n6p8r9s2k4m5n7q8r"
    const val skey = "142418AgQWGaSEHXoQ58ae75c4"
    const val flightSkey = "75498be3b83f8eb9d432hgjhg5dffdgfd43rdgf54ytf65rfcc"
    var strUserName = "";

   /* private fun printHashKey() {
        try {
            val info: PackageInfo = getPackageManager().getPackageInfo(
                "com.max.ecomaxgo.maxpe",
                PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }*/
}