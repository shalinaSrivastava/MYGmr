package com.max.ecomaxgo.maxpe.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class MySMSBroadcastReceiver : BroadcastReceiver() {
    var smsBroadCastSmsReceiverListener: SmsBroadCastSmsReceiverListener? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent?.action) {
            val extras = intent.extras
            val smsRetrieverStatus = extras?.get(SmsRetriever.EXTRA_STATUS) as Status

            when (smsRetrieverStatus.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    // Get SMS message contents
                    var messageIntent = extras.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT)
                    smsBroadCastSmsReceiverListener?.onSuccess(messageIntent)
                }
                CommonStatusCodes.TIMEOUT -> smsBroadCastSmsReceiverListener?.onFailure()
            }
        }
    }

    interface SmsBroadCastSmsReceiverListener {
        fun onSuccess(intent: Intent?)
        fun onFailure()
    }
}
