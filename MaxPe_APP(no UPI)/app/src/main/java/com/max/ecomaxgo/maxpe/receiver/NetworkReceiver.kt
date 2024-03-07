package com.max.ecomaxgo.maxpe.receiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class NetworkReceiver : BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            if (isOnline(context!!)) {
                sendMessage(context, true)
                Log.e("keshav", "Online Connect Intenet ")
            } else {
                sendMessage(context, false)
//                Toast.makeText(context, "No Internet Connected", Toast.LENGTH_SHORT).show()
                Log.e("keshav", "Conectivity Failure !!! ")
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    // Send an Intent with an action named "custom-event-name". The Intent sent should
// be received by the ReceiverActivity.
    private fun sendMessage(context: Context?, isConnected:Boolean) {
        val intent = Intent("custom-event-name")
        intent.putExtra("checkNetwork", isConnected)
        intent.putExtra("message", "This is my message!")
        LocalBroadcastManager.getInstance(context!!).sendBroadcast(intent)
    }

    fun isOnline(context: Context): Boolean {
        return try {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            //should check null because in airplane mode it will be null
            netInfo != null && netInfo.isConnected
        } catch (e: java.lang.NullPointerException) {
            e.printStackTrace()
            false
        }
    }
}