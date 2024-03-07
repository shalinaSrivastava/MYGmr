package com.max.ecomaxgo.maxpe.LocalStorage


import kotlin.collections.ArrayList

class AppSession {

    companion object {
        private var instance: AppSession? = null

        fun getInstance(): AppSession {
            if (instance == null) {
                instance = AppSession()
            }
            return instance as AppSession
        }


    }
    //flight booking local storage
//    var legsData = FlightSearchResult.FlightData.JourneyData.SegmentData.BondData.LegData()
//    var flightListData = FlightSearchResult.FlightData()
//    var bondsDataList = ArrayList<FlightSearchResult.FlightData.JourneyData.SegmentData.BondData>()
//    var segmentDataList = ArrayList<FlightSearchResult.FlightData.JourneyData.SegmentData>()
//    var flightBookingDtl = FlightBookingDetail()



}