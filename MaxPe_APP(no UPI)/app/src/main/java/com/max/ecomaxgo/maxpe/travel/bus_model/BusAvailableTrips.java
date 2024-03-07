package com.max.ecomaxgo.maxpe.travel.bus_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BusAvailableTrips {

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
    public class AvailableTrip {

        @SerializedName("AC")
        @Expose
        private Boolean ac;
        @SerializedName("ArrivalTime")
        @Expose
        private String arrivalTime;
        @SerializedName("AvailableSeats")
        @Expose
        private String availableSeats;
        @SerializedName("busType")
        @Expose
        private String busType;
        @SerializedName("BusTypeId")
        @Expose
        private String busTypeId;
        @SerializedName("CancellationPolicy")
        @Expose
        private Object cancellationPolicy;
        @SerializedName("departureTime")
        @Expose
        private String departureTime;
        @SerializedName("doj")
        @Expose
        private String doj;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("bdPoints")
        @Expose
        private List<BdPoint__1> bdPoints = null;
        @SerializedName("dpPoints")
        @Expose
        private List<DpPoint> dpPoints = null;
        @SerializedName("fareDetail")
        @Expose
        private List<FareDetail> fareDetail = null;
        @SerializedName("fares")
        @Expose
        private List<String> fares = null;
        @SerializedName("Travels")
        @Expose
        private String travels;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("routeId")
        @Expose
        private String routeId;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("seater")
        @Expose
        private Boolean seater;
        @SerializedName("sleeper")
        @Expose
        private Boolean sleeper;
        @SerializedName("idProofRequired")
        @Expose
        private Object idProofRequired;
        @SerializedName("liveTrackingAvailable")
        @Expose
        private Boolean liveTrackingAvailable;
        @SerializedName("nonAC")
        @Expose
        private Boolean nonAC;
        @SerializedName("operatorid")
        @Expose
        private String operatorid;
        @SerializedName("partialCancellationAllowed")
        @Expose
        private Object partialCancellationAllowed;
        @SerializedName("tatkalTime")
        @Expose
        private Object tatkalTime;
        @SerializedName("vehicleType")
        @Expose
        private String vehicleType;
        @SerializedName("zeroCancellationTime")
        @Expose
        private Object zeroCancellationTime;
        @SerializedName("mTicketEnabled")
        @Expose
        private String mTicketEnabled;
        @SerializedName("sortDepTime")
        @Expose
        private Integer sortDepTime;
        @SerializedName("engineId")
        @Expose
        private Integer engineId;
        @SerializedName("cancelPolicyList")
        @Expose
        private List<CancelPolicy> cancelPolicyList = null;
        @SerializedName("isVolvo")
        @Expose
        private Boolean isVolvo;
        @SerializedName("isCancellable")
        @Expose
        private Boolean isCancellable;
        @SerializedName("status")
        @Expose
        private Object status;
        @SerializedName("totalSeat")
        @Expose
        private String totalSeat;
        @SerializedName("departureDate")
        @Expose
        private String departureDate;
        @SerializedName("arrivalDate")
        @Expose
        private String arrivalDate;
        @SerializedName("Discount")
        @Expose
        private Integer discount;
        @SerializedName("Commission")
        @Expose
        private Integer commission;
        @SerializedName("markup")
        @Expose
        private String markup;
        @SerializedName("TDS")
        @Expose
        private Integer tds;
        @SerializedName("STF")
        @Expose
        private Integer stf;
        @SerializedName("lstamenities")
        @Expose
        private Object lstamenities;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("bookedSeats")
        @Expose
        private Object bookedSeats;
        @SerializedName("fareString")
        @Expose
        private Object fareString;
        @SerializedName("lstSeat")
        @Expose
        private Object lstSeat;
        @SerializedName("BpId")
        @Expose
        private String bpId;
        @SerializedName("DpId")
        @Expose
        private String dpId;
        @SerializedName("BpDpLayout")
        @Expose
        private Boolean bpDpLayout;
        @SerializedName("RefrenceNumber")
        @Expose
        private String refrenceNumber;
        @SerializedName("IsSpecial")
        @Expose
        private Boolean isSpecial;
        @SerializedName("DisplayMsg")
        @Expose
        private Object displayMsg;
        @SerializedName("isBordDropFirst")
        @Expose
        private Integer isBordDropFirst;
        @SerializedName("IsSingleLeady")
        @Expose
        private Integer isSingleLeady;
        @SerializedName("allowedConcessions")
        @Expose
        private Object allowedConcessions;
        @SerializedName("rt")
        @Expose
        private Object rt;
        @SerializedName("rtCus")
        @Expose
        private Object rtCus;
        @SerializedName("IsCache")
        @Expose
        private Boolean isCache;
        @SerializedName("IsCovidSafe")
        @Expose
        private Boolean isCovidSafe;
        @SerializedName("ststatus")
        @Expose
        private Boolean ststatus;
        @SerializedName("cpnCode")
        @Expose
        private Object cpnCode;
        @SerializedName("cpMsg")
        @Expose
        private Object cpMsg;
        @SerializedName("priceWithOutDiscount")
        @Expose
        private Object priceWithOutDiscount;
        @SerializedName("operatordiscount")
        @Expose
        private Integer operatordiscount;

        public Boolean getAc() {
            return ac;
        }

        public void setAc(Boolean ac) {
            this.ac = ac;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public String getAvailableSeats() {
            return availableSeats;
        }

        public void setAvailableSeats(String availableSeats) {
            this.availableSeats = availableSeats;
        }

        public String getBusType() {
            return busType;
        }

        public void setBusType(String busType) {
            this.busType = busType;
        }

        public String getBusTypeId() {
            return busTypeId;
        }

        public void setBusTypeId(String busTypeId) {
            this.busTypeId = busTypeId;
        }

        public Object getCancellationPolicy() {
            return cancellationPolicy;
        }

        public void setCancellationPolicy(Object cancellationPolicy) {
            this.cancellationPolicy = cancellationPolicy;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public String getDoj() {
            return doj;
        }

        public void setDoj(String doj) {
            this.doj = doj;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public List<BdPoint__1> getBdPoints() {
            return bdPoints;
        }

        public void setBdPoints(List<BdPoint__1> bdPoints) {
            this.bdPoints = bdPoints;
        }

        public List<DpPoint> getDpPoints() {
            return dpPoints;
        }

        public void setDpPoints(List<DpPoint> dpPoints) {
            this.dpPoints = dpPoints;
        }

        public List<FareDetail> getFareDetail() {
            return fareDetail;
        }

        public void setFareDetail(List<FareDetail> fareDetail) {
            this.fareDetail = fareDetail;
        }

        public List<String> getFares() {
            return fares;
        }

        public void setFares(List<String> fares) {
            this.fares = fares;
        }

        public String getTravels() {
            return travels;
        }

        public void setTravels(String travels) {
            this.travels = travels;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRouteId() {
            return routeId;
        }

        public void setRouteId(String routeId) {
            this.routeId = routeId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Boolean getSeater() {
            return seater;
        }

        public void setSeater(Boolean seater) {
            this.seater = seater;
        }

        public Boolean getSleeper() {
            return sleeper;
        }

        public void setSleeper(Boolean sleeper) {
            this.sleeper = sleeper;
        }

        public Object getIdProofRequired() {
            return idProofRequired;
        }

        public void setIdProofRequired(Object idProofRequired) {
            this.idProofRequired = idProofRequired;
        }

        public Boolean getLiveTrackingAvailable() {
            return liveTrackingAvailable;
        }

        public void setLiveTrackingAvailable(Boolean liveTrackingAvailable) {
            this.liveTrackingAvailable = liveTrackingAvailable;
        }

        public Boolean getNonAC() {
            return nonAC;
        }

        public void setNonAC(Boolean nonAC) {
            this.nonAC = nonAC;
        }

        public String getOperatorid() {
            return operatorid;
        }

        public void setOperatorid(String operatorid) {
            this.operatorid = operatorid;
        }

        public Object getPartialCancellationAllowed() {
            return partialCancellationAllowed;
        }

        public void setPartialCancellationAllowed(Object partialCancellationAllowed) {
            this.partialCancellationAllowed = partialCancellationAllowed;
        }

        public Object getTatkalTime() {
            return tatkalTime;
        }

        public void setTatkalTime(Object tatkalTime) {
            this.tatkalTime = tatkalTime;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public Object getZeroCancellationTime() {
            return zeroCancellationTime;
        }

        public void setZeroCancellationTime(Object zeroCancellationTime) {
            this.zeroCancellationTime = zeroCancellationTime;
        }

        public String getmTicketEnabled() {
            return mTicketEnabled;
        }

        public void setmTicketEnabled(String mTicketEnabled) {
            this.mTicketEnabled = mTicketEnabled;
        }

        public Integer getSortDepTime() {
            return sortDepTime;
        }

        public void setSortDepTime(Integer sortDepTime) {
            this.sortDepTime = sortDepTime;
        }

        public Integer getEngineId() {
            return engineId;
        }

        public void setEngineId(Integer engineId) {
            this.engineId = engineId;
        }

        public List<CancelPolicy> getCancelPolicyList() {
            return cancelPolicyList;
        }

        public void setCancelPolicyList(List<CancelPolicy> cancelPolicyList) {
            this.cancelPolicyList = cancelPolicyList;
        }

        public Boolean getIsVolvo() {
            return isVolvo;
        }

        public void setIsVolvo(Boolean isVolvo) {
            this.isVolvo = isVolvo;
        }

        public Boolean getIsCancellable() {
            return isCancellable;
        }

        public void setIsCancellable(Boolean isCancellable) {
            this.isCancellable = isCancellable;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getTotalSeat() {
            return totalSeat;
        }

        public void setTotalSeat(String totalSeat) {
            this.totalSeat = totalSeat;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Integer getCommission() {
            return commission;
        }

        public void setCommission(Integer commission) {
            this.commission = commission;
        }

        public String getMarkup() {
            return markup;
        }

        public void setMarkup(String markup) {
            this.markup = markup;
        }

        public Integer getTds() {
            return tds;
        }

        public void setTds(Integer tds) {
            this.tds = tds;
        }

        public Integer getStf() {
            return stf;
        }

        public void setStf(Integer stf) {
            this.stf = stf;
        }

        public Object getLstamenities() {
            return lstamenities;
        }

        public void setLstamenities(Object lstamenities) {
            this.lstamenities = lstamenities;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getBookedSeats() {
            return bookedSeats;
        }

        public void setBookedSeats(Object bookedSeats) {
            this.bookedSeats = bookedSeats;
        }

        public Object getFareString() {
            return fareString;
        }

        public void setFareString(Object fareString) {
            this.fareString = fareString;
        }

        public Object getLstSeat() {
            return lstSeat;
        }

        public void setLstSeat(Object lstSeat) {
            this.lstSeat = lstSeat;
        }

        public String getBpId() {
            return bpId;
        }

        public void setBpId(String bpId) {
            this.bpId = bpId;
        }

        public String getDpId() {
            return dpId;
        }

        public void setDpId(String dpId) {
            this.dpId = dpId;
        }

        public Boolean getBpDpLayout() {
            return bpDpLayout;
        }

        public void setBpDpLayout(Boolean bpDpLayout) {
            this.bpDpLayout = bpDpLayout;
        }

        public String getRefrenceNumber() {
            return refrenceNumber;
        }

        public void setRefrenceNumber(String refrenceNumber) {
            this.refrenceNumber = refrenceNumber;
        }

        public Boolean getIsSpecial() {
            return isSpecial;
        }

        public void setIsSpecial(Boolean isSpecial) {
            this.isSpecial = isSpecial;
        }

        public Object getDisplayMsg() {
            return displayMsg;
        }

        public void setDisplayMsg(Object displayMsg) {
            this.displayMsg = displayMsg;
        }

        public Integer getIsBordDropFirst() {
            return isBordDropFirst;
        }

        public void setIsBordDropFirst(Integer isBordDropFirst) {
            this.isBordDropFirst = isBordDropFirst;
        }

        public Integer getIsSingleLeady() {
            return isSingleLeady;
        }

        public void setIsSingleLeady(Integer isSingleLeady) {
            this.isSingleLeady = isSingleLeady;
        }

        public Object getAllowedConcessions() {
            return allowedConcessions;
        }

        public void setAllowedConcessions(Object allowedConcessions) {
            this.allowedConcessions = allowedConcessions;
        }

        public Object getRt() {
            return rt;
        }

        public void setRt(Object rt) {
            this.rt = rt;
        }

        public Object getRtCus() {
            return rtCus;
        }

        public void setRtCus(Object rtCus) {
            this.rtCus = rtCus;
        }

        public Boolean getIsCache() {
            return isCache;
        }

        public void setIsCache(Boolean isCache) {
            this.isCache = isCache;
        }

        public Boolean getIsCovidSafe() {
            return isCovidSafe;
        }

        public void setIsCovidSafe(Boolean isCovidSafe) {
            this.isCovidSafe = isCovidSafe;
        }

        public Boolean getStstatus() {
            return ststatus;
        }

        public void setStstatus(Boolean ststatus) {
            this.ststatus = ststatus;
        }

        public Object getCpnCode() {
            return cpnCode;
        }

        public void setCpnCode(Object cpnCode) {
            this.cpnCode = cpnCode;
        }

        public Object getCpMsg() {
            return cpMsg;
        }

        public void setCpMsg(Object cpMsg) {
            this.cpMsg = cpMsg;
        }

        public Object getPriceWithOutDiscount() {
            return priceWithOutDiscount;
        }

        public void setPriceWithOutDiscount(Object priceWithOutDiscount) {
            this.priceWithOutDiscount = priceWithOutDiscount;
        }

        public Integer getOperatordiscount() {
            return operatordiscount;
        }

        public void setOperatordiscount(Integer operatordiscount) {
            this.operatordiscount = operatordiscount;
        }

    }
    public class BdPoint {

        @SerializedName("bdPoint")
        @Expose
        private String bdPoint;
        @SerializedName("bdLongName")
        @Expose
        private String bdLongName;
        @SerializedName("bdid")
        @Expose
        private String bdid;
        @SerializedName("bdlocation")
        @Expose
        private String bdlocation;
        @SerializedName("landmark")
        @Expose
        private Object landmark;
        @SerializedName("prime")
        @Expose
        private Object prime;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("contactNumber")
        @Expose
        private String contactNumber;

        public String getBdPoint() {
            return bdPoint;
        }

        public void setBdPoint(String bdPoint) {
            this.bdPoint = bdPoint;
        }

        public String getBdLongName() {
            return bdLongName;
        }

        public void setBdLongName(String bdLongName) {
            this.bdLongName = bdLongName;
        }

        public String getBdid() {
            return bdid;
        }

        public void setBdid(String bdid) {
            this.bdid = bdid;
        }

        public String getBdlocation() {
            return bdlocation;
        }

        public void setBdlocation(String bdlocation) {
            this.bdlocation = bdlocation;
        }

        public Object getLandmark() {
            return landmark;
        }

        public void setLandmark(Object landmark) {
            this.landmark = landmark;
        }

        public Object getPrime() {
            return prime;
        }

        public void setPrime(Object prime) {
            this.prime = prime;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

    }

    public class BdPoint__1 {

        @SerializedName("bdPoint")
        @Expose
        private String bdPoint;
        @SerializedName("bdLongName")
        @Expose
        private String bdLongName;
        @SerializedName("bdid")
        @Expose
        private String bdid;
        @SerializedName("bdlocation")
        @Expose
        private String bdlocation;
        @SerializedName("landmark")
        @Expose
        private Object landmark;
        @SerializedName("prime")
        @Expose
        private Object prime;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("contactNumber")
        @Expose
        private String contactNumber;

        public String getBdPoint() {
            return bdPoint;
        }

        public void setBdPoint(String bdPoint) {
            this.bdPoint = bdPoint;
        }

        public String getBdLongName() {
            return bdLongName;
        }

        public void setBdLongName(String bdLongName) {
            this.bdLongName = bdLongName;
        }

        public String getBdid() {
            return bdid;
        }

        public void setBdid(String bdid) {
            this.bdid = bdid;
        }

        public String getBdlocation() {
            return bdlocation;
        }

        public void setBdlocation(String bdlocation) {
            this.bdlocation = bdlocation;
        }

        public Object getLandmark() {
            return landmark;
        }

        public void setLandmark(Object landmark) {
            this.landmark = landmark;
        }

        public Object getPrime() {
            return prime;
        }

        public void setPrime(Object prime) {
            this.prime = prime;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

    }
    public class CancelPolicy {

        @SerializedName("timeFrom")
        @Expose
        private Integer timeFrom;
        @SerializedName("timeTo")
        @Expose
        private Integer timeTo;
        @SerializedName("percentageCharge")
        @Expose
        private Integer percentageCharge;
        @SerializedName("flatCharge")
        @Expose
        private Integer flatCharge;
        @SerializedName("isFlat")
        @Expose
        private Boolean isFlat;
        @SerializedName("seatno")
        @Expose
        private Object seatno;
        @SerializedName("Message")
        @Expose
        private Object message;

        public Integer getTimeFrom() {
            return timeFrom;
        }

        public void setTimeFrom(Integer timeFrom) {
            this.timeFrom = timeFrom;
        }

        public Integer getTimeTo() {
            return timeTo;
        }

        public void setTimeTo(Integer timeTo) {
            this.timeTo = timeTo;
        }

        public Integer getPercentageCharge() {
            return percentageCharge;
        }

        public void setPercentageCharge(Integer percentageCharge) {
            this.percentageCharge = percentageCharge;
        }

        public Integer getFlatCharge() {
            return flatCharge;
        }

        public void setFlatCharge(Integer flatCharge) {
            this.flatCharge = flatCharge;
        }

        public Boolean getIsFlat() {
            return isFlat;
        }

        public void setIsFlat(Boolean isFlat) {
            this.isFlat = isFlat;
        }

        public Object getSeatno() {
            return seatno;
        }

        public void setSeatno(Object seatno) {
            this.seatno = seatno;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

    }

    public class Data {

        @SerializedName("bdPoints")
        @Expose
        private List<BdPoint> bdPoints = null;
        @SerializedName("TotalSeats")
        @Expose
        private Integer totalSeats;
        @SerializedName("AvailableTrips")
        @Expose
        private List<AvailableTrip> availableTrips = null;
        @SerializedName("SpecialTrips")
        @Expose
        private List<Object> specialTrips = null;
        @SerializedName("droppingPoints")
        @Expose
        private List<DroppingPoint> droppingPoints = null;
        @SerializedName("MinDeptTime")
        @Expose
        private Object minDeptTime;
        @SerializedName("MaxDeptTime")
        @Expose
        private Object maxDeptTime;
        @SerializedName("MaxPrice")
        @Expose
        private String maxPrice;
        @SerializedName("JourneyDate")
        @Expose
        private String journeyDate;
        @SerializedName("MinPrice")
        @Expose
        private String minPrice;
        @SerializedName("TotalTrips")
        @Expose
        private Integer totalTrips;
        @SerializedName("Source")
        @Expose
        private String source;
        @SerializedName("sourceId")
        @Expose
        private Integer sourceId;
        @SerializedName("Destination")
        @Expose
        private String destination;
        @SerializedName("destinationId")
        @Expose
        private Integer destinationId;
        @SerializedName("busOperator")
        @Expose
        private List<Object> busOperator = null;
        @SerializedName("sessionId")
        @Expose
        private Object sessionId;
        @SerializedName("creationDate")
        @Expose
        private String creationDate;
        @SerializedName("sortDate")
        @Expose
        private String sortDate;
        @SerializedName("sortMaxDepTime")
        @Expose
        private Integer sortMaxDepTime;
        @SerializedName("sortMinDepTime")
        @Expose
        private Integer sortMinDepTime;
        @SerializedName("isBusAvailable")
        @Expose
        private Boolean isBusAvailable;
        @SerializedName("TraceId")
        @Expose
        private String traceId;
        @SerializedName("IsCache")
        @Expose
        private Boolean isCache;
        @SerializedName("ResponseTime")
        @Expose
        private Object responseTime;
        @SerializedName("DataParsingTime")
        @Expose
        private Object dataParsingTime;
        @SerializedName("STTrips")
        @Expose
        private Object sTTrips;
        @SerializedName("ST")
        @Expose
        private Object st;

        public List<BdPoint> getBdPoints() {
            return bdPoints;
        }

        public void setBdPoints(List<BdPoint> bdPoints) {
            this.bdPoints = bdPoints;
        }

        public Integer getTotalSeats() {
            return totalSeats;
        }

        public void setTotalSeats(Integer totalSeats) {
            this.totalSeats = totalSeats;
        }

        public List<AvailableTrip> getAvailableTrips() {
            return availableTrips;
        }

        public void setAvailableTrips(List<AvailableTrip> availableTrips) {
            this.availableTrips = availableTrips;
        }

        public List<Object> getSpecialTrips() {
            return specialTrips;
        }

        public void setSpecialTrips(List<Object> specialTrips) {
            this.specialTrips = specialTrips;
        }

        public List<DroppingPoint> getDroppingPoints() {
            return droppingPoints;
        }

        public void setDroppingPoints(List<DroppingPoint> droppingPoints) {
            this.droppingPoints = droppingPoints;
        }

        public Object getMinDeptTime() {
            return minDeptTime;
        }

        public void setMinDeptTime(Object minDeptTime) {
            this.minDeptTime = minDeptTime;
        }

        public Object getMaxDeptTime() {
            return maxDeptTime;
        }

        public void setMaxDeptTime(Object maxDeptTime) {
            this.maxDeptTime = maxDeptTime;
        }

        public String getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(String maxPrice) {
            this.maxPrice = maxPrice;
        }

        public String getJourneyDate() {
            return journeyDate;
        }

        public void setJourneyDate(String journeyDate) {
            this.journeyDate = journeyDate;
        }

        public String getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(String minPrice) {
            this.minPrice = minPrice;
        }

        public Integer getTotalTrips() {
            return totalTrips;
        }

        public void setTotalTrips(Integer totalTrips) {
            this.totalTrips = totalTrips;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Integer getSourceId() {
            return sourceId;
        }

        public void setSourceId(Integer sourceId) {
            this.sourceId = sourceId;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Integer getDestinationId() {
            return destinationId;
        }

        public void setDestinationId(Integer destinationId) {
            this.destinationId = destinationId;
        }

        public List<Object> getBusOperator() {
            return busOperator;
        }

        public void setBusOperator(List<Object> busOperator) {
            this.busOperator = busOperator;
        }

        public Object getSessionId() {
            return sessionId;
        }

        public void setSessionId(Object sessionId) {
            this.sessionId = sessionId;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public String getSortDate() {
            return sortDate;
        }

        public void setSortDate(String sortDate) {
            this.sortDate = sortDate;
        }

        public Integer getSortMaxDepTime() {
            return sortMaxDepTime;
        }

        public void setSortMaxDepTime(Integer sortMaxDepTime) {
            this.sortMaxDepTime = sortMaxDepTime;
        }

        public Integer getSortMinDepTime() {
            return sortMinDepTime;
        }

        public void setSortMinDepTime(Integer sortMinDepTime) {
            this.sortMinDepTime = sortMinDepTime;
        }

        public Boolean getIsBusAvailable() {
            return isBusAvailable;
        }

        public void setIsBusAvailable(Boolean isBusAvailable) {
            this.isBusAvailable = isBusAvailable;
        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

        public Boolean getIsCache() {
            return isCache;
        }

        public void setIsCache(Boolean isCache) {
            this.isCache = isCache;
        }

        public Object getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(Object responseTime) {
            this.responseTime = responseTime;
        }

        public Object getDataParsingTime() {
            return dataParsingTime;
        }

        public void setDataParsingTime(Object dataParsingTime) {
            this.dataParsingTime = dataParsingTime;
        }

        public Object getSTTrips() {
            return sTTrips;
        }

        public void setSTTrips(Object sTTrips) {
            this.sTTrips = sTTrips;
        }

        public Object getSt() {
            return st;
        }

        public void setSt(Object st) {
            this.st = st;
        }

    }

    public class DpPoint {

        @SerializedName("dpId")
        @Expose
        private String dpId;
        @SerializedName("dpName")
        @Expose
        private String dpName;
        @SerializedName("locatoin")
        @Expose
        private Object locatoin;
        @SerializedName("prime")
        @Expose
        private Object prime;
        @SerializedName("dpTime")
        @Expose
        private String dpTime;
        @SerializedName("contactNumber")
        @Expose
        private Object contactNumber;

        public String getDpId() {
            return dpId;
        }

        public void setDpId(String dpId) {
            this.dpId = dpId;
        }

        public String getDpName() {
            return dpName;
        }

        public void setDpName(String dpName) {
            this.dpName = dpName;
        }

        public Object getLocatoin() {
            return locatoin;
        }

        public void setLocatoin(Object locatoin) {
            this.locatoin = locatoin;
        }

        public Object getPrime() {
            return prime;
        }

        public void setPrime(Object prime) {
            this.prime = prime;
        }

        public String getDpTime() {
            return dpTime;
        }

        public void setDpTime(String dpTime) {
            this.dpTime = dpTime;
        }

        public Object getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(Object contactNumber) {
            this.contactNumber = contactNumber;
        }

    }

    public class DroppingPoint {

        @SerializedName("dpId")
        @Expose
        private String dpId;
        @SerializedName("dpName")
        @Expose
        private String dpName;
        @SerializedName("locatoin")
        @Expose
        private Object locatoin;
        @SerializedName("prime")
        @Expose
        private Object prime;
        @SerializedName("dpTime")
        @Expose
        private String dpTime;
        @SerializedName("contactNumber")
        @Expose
        private Object contactNumber;

        public String getDpId() {
            return dpId;
        }

        public void setDpId(String dpId) {
            this.dpId = dpId;
        }

        public String getDpName() {
            return dpName;
        }

        public void setDpName(String dpName) {
            this.dpName = dpName;
        }

        public Object getLocatoin() {
            return locatoin;
        }

        public void setLocatoin(Object locatoin) {
            this.locatoin = locatoin;
        }

        public Object getPrime() {
            return prime;
        }

        public void setPrime(Object prime) {
            this.prime = prime;
        }

        public String getDpTime() {
            return dpTime;
        }

        public void setDpTime(String dpTime) {
            this.dpTime = dpTime;
        }

        public Object getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(Object contactNumber) {
            this.contactNumber = contactNumber;
        }

    }

    public class FareDetail {

        @SerializedName("baseFare")
        @Expose
        private String baseFare;
        @SerializedName("markupFareAbsolute")
        @Expose
        private Object markupFareAbsolute;
        @SerializedName("markupFarePercentage")
        @Expose
        private Object markupFarePercentage;
        @SerializedName("operatorServiceChargeAbsolute")
        @Expose
        private String operatorServiceChargeAbsolute;
        @SerializedName("operatorServiceChargePercentage")
        @Expose
        private Object operatorServiceChargePercentage;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private String serviceTaxAbsolute;
        @SerializedName("serviceTaxPercentage")
        @Expose
        private Object serviceTaxPercentage;
        @SerializedName("totalFare")
        @Expose
        private Object totalFare;
        @SerializedName("lavyFare")
        @Expose
        private Object lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Object tollFee;
        @SerializedName("srtFee")
        @Expose
        private Object srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Object bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Object bankTrexAmt;
        @SerializedName("totalTax")
        @Expose
        private String totalTax;

        public String getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(String baseFare) {
            this.baseFare = baseFare;
        }

        public Object getMarkupFareAbsolute() {
            return markupFareAbsolute;
        }

        public void setMarkupFareAbsolute(Object markupFareAbsolute) {
            this.markupFareAbsolute = markupFareAbsolute;
        }

        public Object getMarkupFarePercentage() {
            return markupFarePercentage;
        }

        public void setMarkupFarePercentage(Object markupFarePercentage) {
            this.markupFarePercentage = markupFarePercentage;
        }

        public String getOperatorServiceChargeAbsolute() {
            return operatorServiceChargeAbsolute;
        }

        public void setOperatorServiceChargeAbsolute(String operatorServiceChargeAbsolute) {
            this.operatorServiceChargeAbsolute = operatorServiceChargeAbsolute;
        }

        public Object getOperatorServiceChargePercentage() {
            return operatorServiceChargePercentage;
        }

        public void setOperatorServiceChargePercentage(Object operatorServiceChargePercentage) {
            this.operatorServiceChargePercentage = operatorServiceChargePercentage;
        }

        public String getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(String serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Object getServiceTaxPercentage() {
            return serviceTaxPercentage;
        }

        public void setServiceTaxPercentage(Object serviceTaxPercentage) {
            this.serviceTaxPercentage = serviceTaxPercentage;
        }

        public Object getTotalFare() {
            return totalFare;
        }

        public void setTotalFare(Object totalFare) {
            this.totalFare = totalFare;
        }

        public Object getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Object lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Object getTollFee() {
            return tollFee;
        }

        public void setTollFee(Object tollFee) {
            this.tollFee = tollFee;
        }

        public Object getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Object srtFee) {
            this.srtFee = srtFee;
        }

        public Object getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Object bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Object getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Object bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public String getTotalTax() {
            return totalTax;
        }

        public void setTotalTax(String totalTax) {
            this.totalTax = totalTax;
        }

    }
}

