package com.max.ecomaxgo.maxpe.dashboad.utils;

import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFAds;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFCategory;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFPostAds;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.MyPost;
import com.max.ecomaxgo.maxpe.dashboad.modle.AdsBanner;
import com.max.ecomaxgo.maxpe.dashboad.modle.Banner;
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.modle.Milestone;
import com.max.ecomaxgo.maxpe.dashboad.modle.MyMood;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.modle.WalletBalance;
import com.max.ecomaxgo.maxpe.share.ShareIdea;
import com.max.ecomaxgo.maxpe.travel.bus_model.BlockBusSeat;
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;
import com.max.ecomaxgo.maxpe.travel.bus_model.CityList;
import com.max.ecomaxgo.maxpe.travel.bus_model.DestinationCity;
import com.max.ecomaxgo.maxpe.travel.bus_model.SourceCity;
import com.max.ecomaxgo.maxpe.travel.flight_model.Airportlist;
import com.max.ecomaxgo.maxpe.travel.hotelModel.PreCheckHotel;
import com.max.ecomaxgo.maxpe.travel.hotelModel.SearchHotel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("prod/Account/verify")
    Call<ChainListRefer> getAccVerify(@Query("skey")String skey, @Query("number")String number, @Query("token")String token );

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/listRefer")
    Call<ChainListRefer>getChainList(@Field("skey") String skey, @Field("number")String number, @Field("token")String token);
    @FormUrlEncoded
    @POST("prod/Wallet/Lostfound/category")
    Call<LFCategory> getCategory(@Field("skey")String skey, @Field("number")String number,@Field("token")String token );
    @FormUrlEncoded
    @POST("prod/Wallet/Lostfound/ads")
    Call<LFAds> getAds(@Field("skey")String skey, @Field("number")String number, @Field("token")String token );
    @FormUrlEncoded
    @POST("prod/Wallet/Lostfound/myAds")
    Call<MyPost> getMyAds(@Field("skey")String skey, @Field("number")String number, @Field("token")String token );
    @FormUrlEncoded
    @POST("prod/Wallet/Lostfound/postAds")
    Call<LFPostAds> getPostAds(@Field("skey")String skey,
                               @Field("number")String number,
                               @Field("token")String token,
                               @Field("category")String category,
                               @Field("title")String title,
                               @Field("description")String description,
                               @Field("city")String city,
                               @Field("lostFoundDate")String lostFoundDate,
                               @Field("categoryStatus")String categoryStatus,
                               @Field("contactPersonName")String contactPersonName,
                               @Field("contactPersonMobile")String contactPersonMobile,
                               @Field("token")String pic);

    @FormUrlEncoded
    @POST("prod/Wallet/Other/getMood")
    Call<MyMood> getMood
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Other/setMood")
    Call<MyMood> setMood
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
             @Field("mymood")String mymood);

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/banner")
    Call<AdsBanner> setAds
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/balance")
    Call<WalletBalance> getWalletBalance
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/card")
    Call<CardNumber> getWalletCard
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Other/locBanner")
    Call<Banner> getBanner
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
             @Field("lati")String lat,
             @Field("longi")String logi);
    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/rank")
    Call<Rank> getRank
    (@Field("skey") String skey,
     @Field("number")String number,
     @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Wallet/milestone")
    Call<Milestone> getMilestone
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token);

    @FormUrlEncoded
    @POST("prod/Wallet/Other/shareIdea")
    Call<ShareIdea> shareIdea
            (@Field("skey") String skey,
             @Field("number")String number,
             @Field("token")String token,
            @Field("message")String message);

    @FormUrlEncoded
    @POST("prod/Ease/Bus/listCity")
    Call<CityList> listCity
            (@Field("skey") String skey);
    @FormUrlEncoded
    @POST("prod/Ease/Bus/sourceCity")
    Call<SourceCity> sourceCity
    (@Field("skey") String skey,
     @Field("sourceKey") String sourceKey);

    @FormUrlEncoded
    @POST("prod/Ease/Bus/destinationCity")
    Call<DestinationCity> destinationCity
            (@Field("skey") String skey,
             @Field("sourceId") String sourceId,
             @Field("destinationKey") String destinationKey);
/*________________Bus________________*/
    @FormUrlEncoded
    @POST("prod/Ease/Bus/availableTrips")
    Call<BusAvailableTrips> busAvailableTrips
            (@Field("skey") String skey,
             @Field("sourceId") String sourceId,
             @Field("destinationId") String destinationId,
             @Field("date") String date);
    @FormUrlEncoded
    @POST("prod/Ease/Bus/seatDetail")
    Call<DestinationCity> seatDetail
            (@Field("skey") String skey,
             @Field("sourceId") String sourceId,
             @Field("sourceCity") String sourceCity,
             @Field("destinationId") String destinationKey,
             @Field("destinationCity") String destinationCity,
             @Field("date") String date,
             @Field("tripId") String tripId,
             @Field("routeId") String routeId,
             @Field("seater") String seater,
             @Field("sleeper") String sleeper,
             @Field("engineId") String engineId);
    @FormUrlEncoded
    @POST("prod/Ease/Bus/blockSeat")
    Call<BlockBusSeat> blockBusSeat
            (@Field("skey") String skey,
             @Field("sourceId") String sourceId,
             @Field("sourceCity") String sourceCity,
             @Field("destinationId") String destinationKey,
             @Field("destinationCity") String destinationCity,
             @Field("date") String date,
             @Field("tripId") String tripId,
             @Field("routeId") String routeId,
             @Field("engineId") String engineId,
             @Field("mobile") String mobile,
             @Field("email") String email,
             @Field("idProofType") String idProofType,
             @Field("idProofNo") String idProofNo,
             @Field("address") String address,
             @Field("busType") String busType,
             @Field("bId") String bId,
             @Field("bLoc") String bLoc,
             @Field("arrTime") String arrTime,
             @Field("deptTime") String deptTime,
             @Field("travelName") String travelName,
             @Field("bPoint") String bPoint,
             @Field("bTime") String bTime,
             @Field("bLandmark") String bLandmark,
             @Field("bContNo") String bContNo,
             @Field("dId") String dId,
             @Field("dName") String dName,
             @Field("dLoc") String dLoc,
             @Field("dTime") String dTime,
             @Field("duration") String duration,
             @Field("markup") String markup,
             @Field("commission") String commission,
             @Field("discount") String discount,
             @Field("tTitle") String tTitle,
             @Field("tFname") String tFname,
             @Field("tLname") String tLname,
             @Field("tSeatNo") String tSeatNo,
             @Field("tSeatType") String tSeatType,
             @Field("tFare") String tFare,
             @Field("tAge") String tAge,
             @Field("tGender") String tGender);

    @FormUrlEncoded
    @POST("prod/Ease/Bus/bookSeat")
    Call<BlockBusSeat> busBookSeat
            (@Field("skey") String skey,
             @Field("sourceId") String sourceId,
             @Field("transactionId") String destinationKey);
    /*________________Airport________________*/
    @FormUrlEncoded
    @POST("UAT/Ease/Flights/airportlist")
    Call<Airportlist> airportlist
            (@Field("skey") String skey);
    @FormUrlEncoded
    @POST("UAT/Ease/Flights/flightsearch")
    Call<Airportlist> flightsearch
            (@Field("TravelDate") String travelDate,
             @Field("Origin") String origin,
             @Field("Destination") String destination,
             @Field("Adult") String adult,
             @Field("Child") String child,
             @Field("Infant") String infant,
             @Field("ReturnDate") String returnDate,
             @Field("TripType") String tripType);

    /*________________Hotel________________*/

    @FormUrlEncoded
    @POST("prod/Ease/Hotel/searchHotel")
    Call<SearchHotel> searchHotel
            (@Field("skey") String skey,
             @Field("key") String key,
             @Field("checkInDate") String checkInDate,
             @Field("checkOutDate") String checkOutDate,
             @Field("noOfRooms") String noOfRooms,
             @Field("adult") String adult,
             @Field("child") String child,
             @Field("childAge") String childAge);
    @FormUrlEncoded
    @POST("prod/Ease/Hotel/preCheck")
    Call<PreCheckHotel> preCheckHotel
    (@Field("skey") String skey,
     @Field("key") String key,
     @Field("checkInDate") String checkInDate,
     @Field("checkOutDate") String checkOutDate,
     @Field("noOfRooms") String noOfRooms,
     @Field("adult") String adult,
     @Field("child") String child,
     @Field("childAge") String childAge,
     @Field("eMTCommonId") String eMTCommonId,
     @Field("engine") String engine,
     @Field("rateKey") String rateKey,
     @Field("hotelID") String hotelID,
     @Field("mealType") String mealType,
     @Field("roomType") String roomType,
     @Field("roomTypeCode") String roomTypeCode,
     @Field("rateCode") String rateCode);
    @FormUrlEncoded
    @POST("prod/Ease/Hotel/bookHotel")
    Call<PreCheckHotel> bookHotel
            (@Field("skey") String skey,
             @Field("key") String key,
             @Field("checkInDate") String checkInDate,
             @Field("checkOutDate") String checkOutDate,
             @Field("noOfRooms") String noOfRooms,
             @Field("adult") String adult,
             @Field("adultAge") String adultAge,
             @Field("adultFName") String adultFName,
             @Field("child") String child,
             @Field("childAge") String childAge,
             @Field("childFName") String childFName,
             @Field("childLName") String childLName,
             @Field("eMTCommonId") String eMTCommonId,
             @Field("engine") String engine,
             @Field("rateKey") String rateKey,
             @Field("hotelID") String hotelID,
             @Field("mealType") String mealType,
             @Field("roomType") String roomType,
             @Field("roomTypeCode") String roomTypeCode,
             @Field("rateCode") String rateCode);

}
