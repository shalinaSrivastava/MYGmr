package com.max.ecomaxgo.maxpe.util

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Util {
    fun getFormatedDateTime(dateStr: String, strReadFormat: String, strWriteFormat: String): String {
        var formattedDate = dateStr
        val readFormat = SimpleDateFormat(strReadFormat, Locale.getDefault())
        val writeFormat = SimpleDateFormat(strWriteFormat, Locale.getDefault())
        var date: Date? = null

        try {
            date = readFormat.parse(dateStr)
        } catch (e: ParseException) {
        }

        if (date != null) {
            formattedDate = writeFormat.format(date)
        }
        return formattedDate
    }

    fun compareTime(dayTime:String):Boolean{
        val isCheckTime: Boolean
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val CurrentTime = sdf.format(c.time)
//        val getTestTime = "12:01"

        Log.e("current Time ", " :: $CurrentTime")
        isCheckTime = CurrentTime > dayTime
        return isCheckTime
    }

    fun compareTimeEquality(checkTime:String):Boolean{
        val isCheckTime: Boolean
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val getCurrentTime = sdf.format(c.time)
//        val getTestTime = "12:01"

        Log.e("current Time ", " :: $getCurrentTime")
        isCheckTime = getCurrentTime == checkTime
        return isCheckTime
    }

    fun getTodayDate():String {
        val calendar = Calendar.getInstance()
        val todayDate: Date = calendar.time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val todayAsString: String = dateFormat.format(todayDate)+" 18:00:00"
        return todayAsString
    }

    fun getTomorrowDate():String{
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrowDate = calendar.time

        val tomorrowAsString: String = dateFormat.format(tomorrowDate)+" 12:00:00"
        return tomorrowAsString
    }

    fun compareTimeFrom(dayTime:String):Boolean{
        val isCheckTime: Boolean
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val CurrentTime = sdf.format(c.time)
//        val getTestTime = "12:01"

        Log.e("current Time ", " :: $CurrentTime")
        isCheckTime = CurrentTime > dayTime
        return isCheckTime
    }

    fun compareTimeTo(eveningTime:String):Boolean{
        val isCheckTime: Boolean
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val CurrentTime = sdf.format(c.time)
//        val getTestTime = "12:01"

        Log.e("current Time ", " :: $CurrentTime")
        isCheckTime =  CurrentTime < eveningTime
        return isCheckTime
    }
}