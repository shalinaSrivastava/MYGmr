package com.max.ecomaxgo.maxpe.config

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.StandardExceptionParser
import com.google.android.gms.analytics.Tracker
import com.max.ecomaxgo.maxpe.receiver.AppSignatureHelper
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class DexApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@DexApplication))

//        bind() from singleton { NetworkConnectionInterceptor(instance()) }
//        bind() from singleton { FlightApiInterface(instance()) }
//        bind() from singleton { MaxpeDatabase(instance()) }
//        bind() from singleton { AvailableFlightRepo(instance(), instance()) }
//        bind() from singleton { FlightSearchRepository(instance(), instance()) }
//        bind() from singleton { FlightWayPointVMRepo(instance(), instance()) }
//        bind() from singleton { BookingFlightRepo(instance(), instance()) }
//        bind() from singleton { TravellerRepo(instance(), instance()) }
//        bind() from provider { FlightViewModelFactory(instance()) }
//        bind() from provider { AvailableFlightFactory(instance()) }
//        bind() from provider { FlightWayPointVMFactory(instance()) }
//        bind() from provider { BookingFlightFactory(instance()) }
//        bind() from provider { TravellerFactory(instance()) }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)

        retrofitconfig.initRetrofit()
        analyticsTracker = AnalyticsTracker()
    }

    private lateinit var analyticsTracker: AnalyticsTracker

    override fun onCreate() {
        super.onCreate()
        //FacebookSdk.sdkInitialize(this)

        analyticsTracker.initialize(this)
        analyticsTracker.getInstance()!![AnalyticsTracker.Target.APP]
        val appSignature = AppSignatureHelper(this)
        Log.v("AppSignature", appSignature.appSignatures.toString())
    }

    @Synchronized
    fun getGoogleAnalyticsTracker(): Tracker {
//        val analyticsTrackers: AnalyticsTracker = AnalyticsTracker(this).getInstance()!!
        return analyticsTracker.get(AnalyticsTracker.Target.APP)!!
    }

    /***
     * Tracking screen view
     *
     * @param screenName screen name to be displayed on GA dashboard
     */
    fun trackScreenView(screenName: String?) {
        val t: Tracker = getGoogleAnalyticsTracker()
        // Set screen name.
        t.setScreenName(screenName)
        // Send a screen view.
        t.send(HitBuilders.ScreenViewBuilder().build())
        GoogleAnalytics.getInstance(this).dispatchLocalHits()
    }

    /***
     * Tracking exception
     *
     * @param e exception to be tracked
     */
    fun trackException(e: Exception?) {
        if (e != null) {
            val t: Tracker = getGoogleAnalyticsTracker()
            t.send(
                HitBuilders.ExceptionBuilder()
                    .setDescription(
                        StandardExceptionParser(this, null)
                            .getDescription(Thread.currentThread().name, e)
                    )
                    .setFatal(false)
                    .build()
            )
        }
    }

    /***
     * Tracking event
     *
     * @param category event category
     * @param action   action of the event
     * @param label    label
     */
    fun trackEvent(
        category: String?,
        action: String?,
        label: String?
    ) {
        val t: Tracker = getGoogleAnalyticsTracker()
        // Build and send an Event.
        t.send(HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build())
    }
}