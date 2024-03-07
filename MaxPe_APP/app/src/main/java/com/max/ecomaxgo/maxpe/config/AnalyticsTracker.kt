package com.max.ecomaxgo.maxpe.config

import android.content.Context
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import com.max.ecomaxgo.maxpe.R

class AnalyticsTracker ()
/**
 * Don't instantiate directly - use [.getInstance] instead.
 */ {

    private var mContext: Context? = null
    constructor(context: Context) :this(){
        mContext = context.applicationContext
    }

    enum class Target {
        APP
        // Add more trackers here if you need, and update the code in #get(Target) below
    }

    private var sInstance: AnalyticsTracker? = null

    @Synchronized
    fun initialize(context: Context) {
        check(sInstance == null) { "Extra call to initialize analytics trackers" }
        sInstance = AnalyticsTracker(context)
    }

    @Synchronized
    fun getInstance(): AnalyticsTracker? {
        checkNotNull(sInstance) { "Call initialize() before getInstance()" }
        return sInstance
    }

    private val mTrackers: MutableMap<Target, Tracker?> = HashMap<Target, Tracker?>()

    @Synchronized
    operator fun get(target: Target): Tracker? {
        if (!mTrackers.containsKey(target)) {
            val tracker: Tracker
            when (target) {
                Target.APP -> tracker =
                    GoogleAnalytics.getInstance(mContext).newTracker(R.xml.app_tracker)
                else -> throw IllegalArgumentException("Unhandled analytics target $target")
            }
            mTrackers[target] = tracker
        }
        return mTrackers[target]
    }
}