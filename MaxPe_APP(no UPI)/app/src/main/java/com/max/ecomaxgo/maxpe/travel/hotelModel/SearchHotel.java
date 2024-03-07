package com.max.ecomaxgo.maxpe.travel.hotelModel;

 import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

 import java.util.List;

public class SearchHotel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class AvailableRoom {

        @SerializedName("Adult")
        @Expose
        private int adult;
        @SerializedName("Amenity")
        @Expose
        private Object amenity;
        @SerializedName("BookingPolicy")
        @Expose
        private String bookingPolicy;
        @SerializedName("CancellationPolicy")
        @Expose
        private String cancellationPolicy;
        @SerializedName("CashBack")
        @Expose
        private String cashBack;
        @SerializedName("Child")
        @Expose
        private int child;
        @SerializedName("Commission")
        @Expose
        private String commission;
        @SerializedName("Description")
        @Expose
        private Object description;
        @SerializedName("EMTCommonId")
        @Expose
        private String eMTCommonId;
        @SerializedName("EMTFee")
        @Expose
        private int eMTFee;
        @SerializedName("Engine")
        @Expose
        private int engine;
        @SerializedName("HightRate")
        @Expose
        private Object hightRate;
        @SerializedName("HotelDiscount")
        @Expose
        private int hotelDiscount;
        @SerializedName("HotelID")
        @Expose
        private String hotelID;
        @SerializedName("Id")
        @Expose
        private int id;
        @SerializedName("IsHoldBooking")
        @Expose
        private boolean isHoldBooking;
        @SerializedName("MarkupValue")
        @Expose
        private int markupValue;
        @SerializedName("Meal")
        @Expose
        private String meal;
        @SerializedName("NP")
        @Expose
        private int np;
        @SerializedName("Offer")
        @Expose
        private Object offer;
        @SerializedName("Price")
        @Expose
        private int price;
        @SerializedName("SalesTax")
        @Expose
        private int salesTax;
        @SerializedName("ServiceFee")
        @Expose
        private int serviceFee;
        @SerializedName("SuppDetails")
        @Expose
        private Object suppDetails;
        @SerializedName("TotalPrice")
        @Expose
        private int totalPrice;
        @SerializedName("cnxPolicy")
        @Expose
        private Object cnxPolicy;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;
        @SerializedName("promoDescription")
        @Expose
        private Object promoDescription;
        @SerializedName("rateInfo")
        @Expose
        private Object rateInfo;
        @SerializedName("rateKey")
        @Expose
        private String rateKey;
        @SerializedName("ratePlanCode")
        @Expose
        private String ratePlanCode;
        @SerializedName("roomID")
        @Expose
        private Object roomID;
        @SerializedName("roomImage")
        @Expose
        private Object roomImage;
        @SerializedName("roomType")
        @Expose
        private String roomType;
        @SerializedName("roomTypeCode")
        @Expose
        private String roomTypeCode;
        @SerializedName("surchargeTotal")
        @Expose
        private int surchargeTotal;

        public int getAdult() {
            return adult;
        }

        public void setAdult(int adult) {
            this.adult = adult;
        }

        public Object getAmenity() {
            return amenity;
        }

        public void setAmenity(Object amenity) {
            this.amenity = amenity;
        }

        public String getBookingPolicy() {
            return bookingPolicy;
        }

        public void setBookingPolicy(String bookingPolicy) {
            this.bookingPolicy = bookingPolicy;
        }

        public String getCancellationPolicy() {
            return cancellationPolicy;
        }

        public void setCancellationPolicy(String cancellationPolicy) {
            this.cancellationPolicy = cancellationPolicy;
        }

        public String getCashBack() {
            return cashBack;
        }

        public void setCashBack(String cashBack) {
            this.cashBack = cashBack;
        }

        public int getChild() {
            return child;
        }

        public void setChild(int child) {
            this.child = child;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getEMTCommonId() {
            return eMTCommonId;
        }

        public void setEMTCommonId(String eMTCommonId) {
            this.eMTCommonId = eMTCommonId;
        }

        public int getEMTFee() {
            return eMTFee;
        }

        public void setEMTFee(int eMTFee) {
            this.eMTFee = eMTFee;
        }

        public int getEngine() {
            return engine;
        }

        public void setEngine(int engine) {
            this.engine = engine;
        }

        public Object getHightRate() {
            return hightRate;
        }

        public void setHightRate(Object hightRate) {
            this.hightRate = hightRate;
        }

        public int getHotelDiscount() {
            return hotelDiscount;
        }

        public void setHotelDiscount(int hotelDiscount) {
            this.hotelDiscount = hotelDiscount;
        }

        public String getHotelID() {
            return hotelID;
        }

        public void setHotelID(String hotelID) {
            this.hotelID = hotelID;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsHoldBooking() {
            return isHoldBooking;
        }

        public void setIsHoldBooking(boolean isHoldBooking) {
            this.isHoldBooking = isHoldBooking;
        }

        public int getMarkupValue() {
            return markupValue;
        }

        public void setMarkupValue(int markupValue) {
            this.markupValue = markupValue;
        }

        public String getMeal() {
            return meal;
        }

        public void setMeal(String meal) {
            this.meal = meal;
        }

        public int getNp() {
            return np;
        }

        public void setNp(int np) {
            this.np = np;
        }

        public Object getOffer() {
            return offer;
        }

        public void setOffer(Object offer) {
            this.offer = offer;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSalesTax() {
            return salesTax;
        }

        public void setSalesTax(int salesTax) {
            this.salesTax = salesTax;
        }

        public int getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(int serviceFee) {
            this.serviceFee = serviceFee;
        }

        public Object getSuppDetails() {
            return suppDetails;
        }

        public void setSuppDetails(Object suppDetails) {
            this.suppDetails = suppDetails;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Object getCnxPolicy() {
            return cnxPolicy;
        }

        public void setCnxPolicy(Object cnxPolicy) {
            this.cnxPolicy = cnxPolicy;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public Object getPromoDescription() {
            return promoDescription;
        }

        public void setPromoDescription(Object promoDescription) {
            this.promoDescription = promoDescription;
        }

        public Object getRateInfo() {
            return rateInfo;
        }

        public void setRateInfo(Object rateInfo) {
            this.rateInfo = rateInfo;
        }

        public String getRateKey() {
            return rateKey;
        }

        public void setRateKey(String rateKey) {
            this.rateKey = rateKey;
        }

        public String getRatePlanCode() {
            return ratePlanCode;
        }

        public void setRatePlanCode(String ratePlanCode) {
            this.ratePlanCode = ratePlanCode;
        }

        public Object getRoomID() {
            return roomID;
        }

        public void setRoomID(Object roomID) {
            this.roomID = roomID;
        }

        public Object getRoomImage() {
            return roomImage;
        }

        public void setRoomImage(Object roomImage) {
            this.roomImage = roomImage;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public String getRoomTypeCode() {
            return roomTypeCode;
        }

        public void setRoomTypeCode(String roomTypeCode) {
            this.roomTypeCode = roomTypeCode;
        }

        public int getSurchargeTotal() {
            return surchargeTotal;
        }

        public void setSurchargeTotal(int surchargeTotal) {
            this.surchargeTotal = surchargeTotal;
        }

    }

    public class Data {

        @SerializedName("CheckInDate")
        @Expose
        private String checkInDate;
        @SerializedName("CheckOutDate")
        @Expose
        private String checkOutDate;
        @SerializedName("Error")
        @Expose
        private Object error;
        @SerializedName("HotelCount")
        @Expose
        private int hotelCount;
        @SerializedName("Nights")
        @Expose
        private int nights;
        @SerializedName("SearchKey")
        @Expose
        private String searchKey;
        @SerializedName("TimeSpan")
        @Expose
        private String timeSpan;
        @SerializedName("TotalHotel")
        @Expose
        private int totalHotel;
        @SerializedName("hotellist")
        @Expose
        private List<Hotel> hotellist = null;
        @SerializedName("htlPlcy")
        @Expose
        private Object htlPlcy;
        @SerializedName("sessionID")
        @Expose
        private String sessionID;

        public String getCheckInDate() {
            return checkInDate;
        }

        public void setCheckInDate(String checkInDate) {
            this.checkInDate = checkInDate;
        }

        public String getCheckOutDate() {
            return checkOutDate;
        }

        public void setCheckOutDate(String checkOutDate) {
            this.checkOutDate = checkOutDate;
        }

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }

        public int getHotelCount() {
            return hotelCount;
        }

        public void setHotelCount(int hotelCount) {
            this.hotelCount = hotelCount;
        }

        public int getNights() {
            return nights;
        }

        public void setNights(int nights) {
            this.nights = nights;
        }

        public String getSearchKey() {
            return searchKey;
        }

        public void setSearchKey(String searchKey) {
            this.searchKey = searchKey;
        }

        public String getTimeSpan() {
            return timeSpan;
        }

        public void setTimeSpan(String timeSpan) {
            this.timeSpan = timeSpan;
        }

        public int getTotalHotel() {
            return totalHotel;
        }

        public void setTotalHotel(int totalHotel) {
            this.totalHotel = totalHotel;
        }

        public List<Hotel> getHotellist() {
            return hotellist;
        }

        public void setHotellist(List<Hotel> hotellist) {
            this.hotellist = hotellist;
        }

        public Object getHtlPlcy() {
            return htlPlcy;
        }

        public void setHtlPlcy(Object htlPlcy) {
            this.htlPlcy = htlPlcy;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

    }
    public class Hotel {

        @SerializedName("AvailableRoom")
        @Expose
        private List<AvailableRoom> availableRoom = null;
        @SerializedName("CashBack")
        @Expose
        private String cashBack;
        @SerializedName("Category")
        @Expose
        private String category;
        @SerializedName("ChName")
        @Expose
        private Object chName;
        @SerializedName("CheckInTime")
        @Expose
        private String checkInTime;
        @SerializedName("CheckOutTime")
        @Expose
        private String checkOutTime;
        @SerializedName("Commission")
        @Expose
        private String commission;
        @SerializedName("Distance")
        @Expose
        private String distance;
        @SerializedName("EMTCommonID")
        @Expose
        private String eMTCommonID;
        @SerializedName("EngineType")
        @Expose
        private int engineType;
        @SerializedName("HotelHighlights")
        @Expose
        private String hotelHighlights;
        @SerializedName("HotelURL")
        @Expose
        private String hotelURL;
        @SerializedName("ImageThumbUrl")
        @Expose
        private String imageThumbUrl;
        @SerializedName("IsCached")
        @Expose
        private boolean isCached;
        @SerializedName("IsSafety")
        @Expose
        private boolean isSafety;
        @SerializedName("MostViewed")
        @Expose
        private boolean mostViewed;
        @SerializedName("MostViewedNo")
        @Expose
        private int mostViewedNo;
        @SerializedName("PromoDescription")
        @Expose
        private Object promoDescription;
        @SerializedName("SuppDetails")
        @Expose
        private Object suppDetails;
        @SerializedName("TotalPrice")
        @Expose
        private int totalPrice;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("countryCode")
        @Expose
        private String countryCode;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;
        @SerializedName("hdiscount")
        @Expose
        private int hdiscount;
        @SerializedName("hotelID")
        @Expose
        private String hotelID;
        @SerializedName("hotelName")
        @Expose
        private String hotelName;
        @SerializedName("htlPlcy")
        @Expose
        private Object htlPlcy;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longtitude")
        @Expose
        private String longtitude;
        @SerializedName("plcy")
        @Expose
        private Object plcy;
        @SerializedName("price")
        @Expose
        private int price;
        @SerializedName("ranking")
        @Expose
        private Object ranking;
        @SerializedName("rankingoutof")
        @Expose
        private Object rankingoutof;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("surchargeTotal")
        @Expose
        private int surchargeTotal;
        @SerializedName("tripAdvisorRating")
        @Expose
        private int tripAdvisorRating;
        @SerializedName("tripAdvisorRatingUrl")
        @Expose
        private String tripAdvisorRatingUrl;
        @SerializedName("tripAdvisorReviewCount")
        @Expose
        private int tripAdvisorReviewCount;
        @SerializedName("tripType")
        @Expose
        private Object tripType;
        @SerializedName("tripid")
        @Expose
        private Object tripid;

        public List<AvailableRoom> getAvailableRoom() {
            return availableRoom;
        }

        public void setAvailableRoom(List<AvailableRoom> availableRoom) {
            this.availableRoom = availableRoom;
        }

        public String getCashBack() {
            return cashBack;
        }

        public void setCashBack(String cashBack) {
            this.cashBack = cashBack;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getChName() {
            return chName;
        }

        public void setChName(Object chName) {
            this.chName = chName;
        }

        public String getCheckInTime() {
            return checkInTime;
        }

        public void setCheckInTime(String checkInTime) {
            this.checkInTime = checkInTime;
        }

        public String getCheckOutTime() {
            return checkOutTime;
        }

        public void setCheckOutTime(String checkOutTime) {
            this.checkOutTime = checkOutTime;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getEMTCommonID() {
            return eMTCommonID;
        }

        public void setEMTCommonID(String eMTCommonID) {
            this.eMTCommonID = eMTCommonID;
        }

        public int getEngineType() {
            return engineType;
        }

        public void setEngineType(int engineType) {
            this.engineType = engineType;
        }

        public String getHotelHighlights() {
            return hotelHighlights;
        }

        public void setHotelHighlights(String hotelHighlights) {
            this.hotelHighlights = hotelHighlights;
        }

        public String getHotelURL() {
            return hotelURL;
        }

        public void setHotelURL(String hotelURL) {
            this.hotelURL = hotelURL;
        }

        public String getImageThumbUrl() {
            return imageThumbUrl;
        }

        public void setImageThumbUrl(String imageThumbUrl) {
            this.imageThumbUrl = imageThumbUrl;
        }

        public boolean isIsCached() {
            return isCached;
        }

        public void setIsCached(boolean isCached) {
            this.isCached = isCached;
        }

        public boolean isIsSafety() {
            return isSafety;
        }

        public void setIsSafety(boolean isSafety) {
            this.isSafety = isSafety;
        }

        public boolean isMostViewed() {
            return mostViewed;
        }

        public void setMostViewed(boolean mostViewed) {
            this.mostViewed = mostViewed;
        }

        public int getMostViewedNo() {
            return mostViewedNo;
        }

        public void setMostViewedNo(int mostViewedNo) {
            this.mostViewedNo = mostViewedNo;
        }

        public Object getPromoDescription() {
            return promoDescription;
        }

        public void setPromoDescription(Object promoDescription) {
            this.promoDescription = promoDescription;
        }

        public Object getSuppDetails() {
            return suppDetails;
        }

        public void setSuppDetails(Object suppDetails) {
            this.suppDetails = suppDetails;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public int getHdiscount() {
            return hdiscount;
        }

        public void setHdiscount(int hdiscount) {
            this.hdiscount = hdiscount;
        }

        public String getHotelID() {
            return hotelID;
        }

        public void setHotelID(String hotelID) {
            this.hotelID = hotelID;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public Object getHtlPlcy() {
            return htlPlcy;
        }

        public void setHtlPlcy(Object htlPlcy) {
            this.htlPlcy = htlPlcy;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongtitude() {
            return longtitude;
        }

        public void setLongtitude(String longtitude) {
            this.longtitude = longtitude;
        }

        public Object getPlcy() {
            return plcy;
        }

        public void setPlcy(Object plcy) {
            this.plcy = plcy;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Object getRanking() {
            return ranking;
        }

        public void setRanking(Object ranking) {
            this.ranking = ranking;
        }

        public Object getRankingoutof() {
            return rankingoutof;
        }

        public void setRankingoutof(Object rankingoutof) {
            this.rankingoutof = rankingoutof;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public int getSurchargeTotal() {
            return surchargeTotal;
        }

        public void setSurchargeTotal(int surchargeTotal) {
            this.surchargeTotal = surchargeTotal;
        }

        public int getTripAdvisorRating() {
            return tripAdvisorRating;
        }

        public void setTripAdvisorRating(int tripAdvisorRating) {
            this.tripAdvisorRating = tripAdvisorRating;
        }

        public String getTripAdvisorRatingUrl() {
            return tripAdvisorRatingUrl;
        }

        public void setTripAdvisorRatingUrl(String tripAdvisorRatingUrl) {
            this.tripAdvisorRatingUrl = tripAdvisorRatingUrl;
        }

        public int getTripAdvisorReviewCount() {
            return tripAdvisorReviewCount;
        }

        public void setTripAdvisorReviewCount(int tripAdvisorReviewCount) {
            this.tripAdvisorReviewCount = tripAdvisorReviewCount;
        }

        public Object getTripType() {
            return tripType;
        }

        public void setTripType(Object tripType) {
            this.tripType = tripType;
        }

        public Object getTripid() {
            return tripid;
        }

        public void setTripid(Object tripid) {
            this.tripid = tripid;
        }

    }
}