
        package com.max.ecomaxgo.maxpe.travel.hotelModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


        public class PreCheckHotel {

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
            public class Room {

                @SerializedName("BookingPolicy")
                @Expose
                private String bookingPolicy;
                @SerializedName("Cancellationpolicy")
                @Expose
                private String cancellationpolicy;
                @SerializedName("Cashback")
                @Expose
                private String cashback;
                @SerializedName("Commission")
                @Expose
                private Integer commission;
                @SerializedName("EMTCommonID")
                @Expose
                private String eMTCommonID;
                @SerializedName("EMTFee")
                @Expose
                private Integer eMTFee;
                @SerializedName("Engine")
                @Expose
                private Integer engine;
                @SerializedName("HightRate")
                @Expose
                private Object hightRate;
                @SerializedName("IsHoldBooking")
                @Expose
                private Boolean isHoldBooking;
                @SerializedName("MarkupValue")
                @Expose
                private Integer markupValue;
                @SerializedName("Meal")
                @Expose
                private Meal meal;
                @SerializedName("MultiRoom")
                @Expose
                private Object multiRoom;
                @SerializedName("OccupencyPerRoom")
                @Expose
                private Object occupencyPerRoom;
                @SerializedName("Price")
                @Expose
                private Integer price;
                @SerializedName("RateDescription")
                @Expose
                private Object rateDescription;
                @SerializedName("RoomImages")
                @Expose
                private Object roomImages;
                @SerializedName("SalesTax")
                @Expose
                private Integer salesTax;
                @SerializedName("SearchKey")
                @Expose
                private Object searchKey;
                @SerializedName("ServiceFee")
                @Expose
                private Integer serviceFee;
                @SerializedName("averageBaseRate")
                @Expose
                private Object averageBaseRate;
                @SerializedName("averageRate")
                @Expose
                private Object averageRate;
                @SerializedName("cancellationRules")
                @Expose
                private Object cancellationRules;
                @SerializedName("checkInInstruction")
                @Expose
                private Object checkInInstruction;
                @SerializedName("cnxPolicy")
                @Expose
                private Object cnxPolicy;
                @SerializedName("commissionableUsdTotal")
                @Expose
                private Object commissionableUsdTotal;
                @SerializedName("currencyCode")
                @Expose
                private String currencyCode;
                @SerializedName("currentAllotment")
                @Expose
                private Object currentAllotment;
                @SerializedName("deepLink")
                @Expose
                private Object deepLink;
                @SerializedName("depositRequired")
                @Expose
                private Object depositRequired;
                @SerializedName("freeStay")
                @Expose
                private Object freeStay;
                @SerializedName("hotelAddress")
                @Expose
                private Object hotelAddress;
                @SerializedName("hotelCity")
                @Expose
                private Object hotelCity;
                @SerializedName("hotelCountry")
                @Expose
                private Object hotelCountry;
                @SerializedName("hotelDiscount")
                @Expose
                private Integer hotelDiscount;
                @SerializedName("hotelID")
                @Expose
                private String hotelID;
                @SerializedName("hotelName")
                @Expose
                private Object hotelName;
                @SerializedName("htlDisc")
                @Expose
                private Integer htlDisc;
                @SerializedName("immediateChargeRequired")
                @Expose
                private Object immediateChargeRequired;
                @SerializedName("maxNightlyRate")
                @Expose
                private Object maxNightlyRate;
                @SerializedName("minGuestRate")
                @Expose
                private Object minGuestRate;
                @SerializedName("nightlyRateTotal")
                @Expose
                private Object nightlyRateTotal;
                @SerializedName("nonRefundable")
                @Expose
                private Object nonRefundable;
                @SerializedName("numberOfRoomsRequested")
                @Expose
                private Object numberOfRoomsRequested;
                @SerializedName("promoDescription")
                @Expose
                private Object promoDescription;
                @SerializedName("promoId")
                @Expose
                private Object promoId;
                @SerializedName("propertyId")
                @Expose
                private Object propertyId;
                @SerializedName("quotedOccupancy")
                @Expose
                private Object quotedOccupancy;
                @SerializedName("rateCode")
                @Expose
                private String rateCode;
                @SerializedName("rateInfo")
                @Expose
                private Object rateInfo;
                @SerializedName("rateKey")
                @Expose
                private String rateKey;
                @SerializedName("rateOccupancyPerRoom")
                @Expose
                private Object rateOccupancyPerRoom;
                @SerializedName("roomAmenities")
                @Expose
                private Object roomAmenities;
                @SerializedName("roomRateDescription")
                @Expose
                private Object roomRateDescription;
                @SerializedName("roomRateDescriptionLong")
                @Expose
                private Object roomRateDescriptionLong;
                @SerializedName("roomType")
                @Expose
                private String roomType;
                @SerializedName("roomTypeCode")
                @Expose
                private String roomTypeCode;
                @SerializedName("roomTypeDescription")
                @Expose
                private Object roomTypeDescription;
                @SerializedName("roomTypeDescriptionLong")
                @Expose
                private Object roomTypeDescriptionLong;
                @SerializedName("roomTypeId")
                @Expose
                private Object roomTypeId;
                @SerializedName("smokingPreferences")
                @Expose
                private Object smokingPreferences;
                @SerializedName("supplierID")
                @Expose
                private Object supplierID;
                @SerializedName("supplierType")
                @Expose
                private Object supplierType;
                @SerializedName("surchargeTotal")
                @Expose
                private Integer surchargeTotal;
                @SerializedName("taxRate")
                @Expose
                private String taxRate;
                @SerializedName("total")
                @Expose
                private Integer total;

                public String getBookingPolicy() {
                    return bookingPolicy;
                }

                public void setBookingPolicy(String bookingPolicy) {
                    this.bookingPolicy = bookingPolicy;
                }

                public String getCancellationpolicy() {
                    return cancellationpolicy;
                }

                public void setCancellationpolicy(String cancellationpolicy) {
                    this.cancellationpolicy = cancellationpolicy;
                }

                public String getCashback() {
                    return cashback;
                }

                public void setCashback(String cashback) {
                    this.cashback = cashback;
                }

                public Integer getCommission() {
                    return commission;
                }

                public void setCommission(Integer commission) {
                    this.commission = commission;
                }

                public String getEMTCommonID() {
                    return eMTCommonID;
                }

                public void setEMTCommonID(String eMTCommonID) {
                    this.eMTCommonID = eMTCommonID;
                }

                public Integer getEMTFee() {
                    return eMTFee;
                }

                public void setEMTFee(Integer eMTFee) {
                    this.eMTFee = eMTFee;
                }

                public Integer getEngine() {
                    return engine;
                }

                public void setEngine(Integer engine) {
                    this.engine = engine;
                }

                public Object getHightRate() {
                    return hightRate;
                }

                public void setHightRate(Object hightRate) {
                    this.hightRate = hightRate;
                }

                public Boolean getIsHoldBooking() {
                    return isHoldBooking;
                }

                public void setIsHoldBooking(Boolean isHoldBooking) {
                    this.isHoldBooking = isHoldBooking;
                }

                public Integer getMarkupValue() {
                    return markupValue;
                }

                public void setMarkupValue(Integer markupValue) {
                    this.markupValue = markupValue;
                }

                public Meal getMeal() {
                    return meal;
                }

                public void setMeal(Meal meal) {
                    this.meal = meal;
                }

                public Object getMultiRoom() {
                    return multiRoom;
                }

                public void setMultiRoom(Object multiRoom) {
                    this.multiRoom = multiRoom;
                }

                public Object getOccupencyPerRoom() {
                    return occupencyPerRoom;
                }

                public void setOccupencyPerRoom(Object occupencyPerRoom) {
                    this.occupencyPerRoom = occupencyPerRoom;
                }

                public Integer getPrice() {
                    return price;
                }

                public void setPrice(Integer price) {
                    this.price = price;
                }

                public Object getRateDescription() {
                    return rateDescription;
                }

                public void setRateDescription(Object rateDescription) {
                    this.rateDescription = rateDescription;
                }

                public Object getRoomImages() {
                    return roomImages;
                }

                public void setRoomImages(Object roomImages) {
                    this.roomImages = roomImages;
                }

                public Integer getSalesTax() {
                    return salesTax;
                }

                public void setSalesTax(Integer salesTax) {
                    this.salesTax = salesTax;
                }

                public Object getSearchKey() {
                    return searchKey;
                }

                public void setSearchKey(Object searchKey) {
                    this.searchKey = searchKey;
                }

                public Integer getServiceFee() {
                    return serviceFee;
                }

                public void setServiceFee(Integer serviceFee) {
                    this.serviceFee = serviceFee;
                }

                public Object getAverageBaseRate() {
                    return averageBaseRate;
                }

                public void setAverageBaseRate(Object averageBaseRate) {
                    this.averageBaseRate = averageBaseRate;
                }

                public Object getAverageRate() {
                    return averageRate;
                }

                public void setAverageRate(Object averageRate) {
                    this.averageRate = averageRate;
                }

                public Object getCancellationRules() {
                    return cancellationRules;
                }

                public void setCancellationRules(Object cancellationRules) {
                    this.cancellationRules = cancellationRules;
                }

                public Object getCheckInInstruction() {
                    return checkInInstruction;
                }

                public void setCheckInInstruction(Object checkInInstruction) {
                    this.checkInInstruction = checkInInstruction;
                }

                public Object getCnxPolicy() {
                    return cnxPolicy;
                }

                public void setCnxPolicy(Object cnxPolicy) {
                    this.cnxPolicy = cnxPolicy;
                }

                public Object getCommissionableUsdTotal() {
                    return commissionableUsdTotal;
                }

                public void setCommissionableUsdTotal(Object commissionableUsdTotal) {
                    this.commissionableUsdTotal = commissionableUsdTotal;
                }

                public String getCurrencyCode() {
                    return currencyCode;
                }

                public void setCurrencyCode(String currencyCode) {
                    this.currencyCode = currencyCode;
                }

                public Object getCurrentAllotment() {
                    return currentAllotment;
                }

                public void setCurrentAllotment(Object currentAllotment) {
                    this.currentAllotment = currentAllotment;
                }

                public Object getDeepLink() {
                    return deepLink;
                }

                public void setDeepLink(Object deepLink) {
                    this.deepLink = deepLink;
                }

                public Object getDepositRequired() {
                    return depositRequired;
                }

                public void setDepositRequired(Object depositRequired) {
                    this.depositRequired = depositRequired;
                }

                public Object getFreeStay() {
                    return freeStay;
                }

                public void setFreeStay(Object freeStay) {
                    this.freeStay = freeStay;
                }

                public Object getHotelAddress() {
                    return hotelAddress;
                }

                public void setHotelAddress(Object hotelAddress) {
                    this.hotelAddress = hotelAddress;
                }

                public Object getHotelCity() {
                    return hotelCity;
                }

                public void setHotelCity(Object hotelCity) {
                    this.hotelCity = hotelCity;
                }

                public Object getHotelCountry() {
                    return hotelCountry;
                }

                public void setHotelCountry(Object hotelCountry) {
                    this.hotelCountry = hotelCountry;
                }

                public Integer getHotelDiscount() {
                    return hotelDiscount;
                }

                public void setHotelDiscount(Integer hotelDiscount) {
                    this.hotelDiscount = hotelDiscount;
                }

                public String getHotelID() {
                    return hotelID;
                }

                public void setHotelID(String hotelID) {
                    this.hotelID = hotelID;
                }

                public Object getHotelName() {
                    return hotelName;
                }

                public void setHotelName(Object hotelName) {
                    this.hotelName = hotelName;
                }

                public Integer getHtlDisc() {
                    return htlDisc;
                }

                public void setHtlDisc(Integer htlDisc) {
                    this.htlDisc = htlDisc;
                }

                public Object getImmediateChargeRequired() {
                    return immediateChargeRequired;
                }

                public void setImmediateChargeRequired(Object immediateChargeRequired) {
                    this.immediateChargeRequired = immediateChargeRequired;
                }

                public Object getMaxNightlyRate() {
                    return maxNightlyRate;
                }

                public void setMaxNightlyRate(Object maxNightlyRate) {
                    this.maxNightlyRate = maxNightlyRate;
                }

                public Object getMinGuestRate() {
                    return minGuestRate;
                }

                public void setMinGuestRate(Object minGuestRate) {
                    this.minGuestRate = minGuestRate;
                }

                public Object getNightlyRateTotal() {
                    return nightlyRateTotal;
                }

                public void setNightlyRateTotal(Object nightlyRateTotal) {
                    this.nightlyRateTotal = nightlyRateTotal;
                }

                public Object getNonRefundable() {
                    return nonRefundable;
                }

                public void setNonRefundable(Object nonRefundable) {
                    this.nonRefundable = nonRefundable;
                }

                public Object getNumberOfRoomsRequested() {
                    return numberOfRoomsRequested;
                }

                public void setNumberOfRoomsRequested(Object numberOfRoomsRequested) {
                    this.numberOfRoomsRequested = numberOfRoomsRequested;
                }

                public Object getPromoDescription() {
                    return promoDescription;
                }

                public void setPromoDescription(Object promoDescription) {
                    this.promoDescription = promoDescription;
                }

                public Object getPromoId() {
                    return promoId;
                }

                public void setPromoId(Object promoId) {
                    this.promoId = promoId;
                }

                public Object getPropertyId() {
                    return propertyId;
                }

                public void setPropertyId(Object propertyId) {
                    this.propertyId = propertyId;
                }

                public Object getQuotedOccupancy() {
                    return quotedOccupancy;
                }

                public void setQuotedOccupancy(Object quotedOccupancy) {
                    this.quotedOccupancy = quotedOccupancy;
                }

                public String getRateCode() {
                    return rateCode;
                }

                public void setRateCode(String rateCode) {
                    this.rateCode = rateCode;
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

                public Object getRateOccupancyPerRoom() {
                    return rateOccupancyPerRoom;
                }

                public void setRateOccupancyPerRoom(Object rateOccupancyPerRoom) {
                    this.rateOccupancyPerRoom = rateOccupancyPerRoom;
                }

                public Object getRoomAmenities() {
                    return roomAmenities;
                }

                public void setRoomAmenities(Object roomAmenities) {
                    this.roomAmenities = roomAmenities;
                }

                public Object getRoomRateDescription() {
                    return roomRateDescription;
                }

                public void setRoomRateDescription(Object roomRateDescription) {
                    this.roomRateDescription = roomRateDescription;
                }

                public Object getRoomRateDescriptionLong() {
                    return roomRateDescriptionLong;
                }

                public void setRoomRateDescriptionLong(Object roomRateDescriptionLong) {
                    this.roomRateDescriptionLong = roomRateDescriptionLong;
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

                public Object getRoomTypeDescription() {
                    return roomTypeDescription;
                }

                public void setRoomTypeDescription(Object roomTypeDescription) {
                    this.roomTypeDescription = roomTypeDescription;
                }

                public Object getRoomTypeDescriptionLong() {
                    return roomTypeDescriptionLong;
                }

                public void setRoomTypeDescriptionLong(Object roomTypeDescriptionLong) {
                    this.roomTypeDescriptionLong = roomTypeDescriptionLong;
                }

                public Object getRoomTypeId() {
                    return roomTypeId;
                }

                public void setRoomTypeId(Object roomTypeId) {
                    this.roomTypeId = roomTypeId;
                }

                public Object getSmokingPreferences() {
                    return smokingPreferences;
                }

                public void setSmokingPreferences(Object smokingPreferences) {
                    this.smokingPreferences = smokingPreferences;
                }

                public Object getSupplierID() {
                    return supplierID;
                }

                public void setSupplierID(Object supplierID) {
                    this.supplierID = supplierID;
                }

                public Object getSupplierType() {
                    return supplierType;
                }

                public void setSupplierType(Object supplierType) {
                    this.supplierType = supplierType;
                }

                public Integer getSurchargeTotal() {
                    return surchargeTotal;
                }

                public void setSurchargeTotal(Integer surchargeTotal) {
                    this.surchargeTotal = surchargeTotal;
                }

                public String getTaxRate() {
                    return taxRate;
                }

                public void setTaxRate(String taxRate) {
                    this.taxRate = taxRate;
                }

                public Integer getTotal() {
                    return total;
                }

                public void setTotal(Integer total) {
                    this.total = total;
                }
                public class Meal {

                    @SerializedName("mealName")
                    @Expose
                    private String mealName;
                    @SerializedName("mealType")
                    @Expose
                    private String mealType;

                    public String getMealName() {
                        return mealName;
                    }

                    public void setMealName(String mealName) {
                        this.mealName = mealName;
                    }

                    public String getMealType() {
                        return mealType;
                    }

                    public void setMealType(String mealType) {
                        this.mealType = mealType;
                    }

                }

            }

            public class Data {

                @SerializedName("Rooms")
                @Expose
                private Rooms rooms;
                @SerializedName("SessionId")
                @Expose
                private Object sessionId;
                @SerializedName("error")
                @Expose
                private Object error;

                public Rooms getRooms() {
                    return rooms;
                }

                public void setRooms(Rooms rooms) {
                    this.rooms = rooms;
                }

                public Object getSessionId() {
                    return sessionId;
                }

                public void setSessionId(Object sessionId) {
                    this.sessionId = sessionId;
                }

                public Object getError() {
                    return error;
                }

                public void setError(Object error) {
                    this.error = error;
                }

            }
            public class Rooms {

                @SerializedName("Room")
                @Expose
                private List<Room> room = null;
                @SerializedName("runno")
                @Expose
                private Object runno;

                public List<Room> getRoom() {
                    return room;
                }

                public void setRoom(List<Room> room) {
                    this.room = room;
                }

                public Object getRunno() {
                    return runno;
                }

                public void setRunno(Object runno) {
                    this.runno = runno;
                }

            }
}

