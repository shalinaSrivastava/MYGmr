package com.max.ecomaxgo.maxpe.travel.bus_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeatDetail {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SeatDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("error");
        sb.append('=');
        sb.append(((this.error == null)?"<null>":this.error));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(CancelPolicy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("timeFrom");
            sb.append('=');
            sb.append(((this.timeFrom == null)?"<null>":this.timeFrom));
            sb.append(',');
            sb.append("timeTo");
            sb.append('=');
            sb.append(((this.timeTo == null)?"<null>":this.timeTo));
            sb.append(',');
            sb.append("percentageCharge");
            sb.append('=');
            sb.append(((this.percentageCharge == null)?"<null>":this.percentageCharge));
            sb.append(',');
            sb.append("flatCharge");
            sb.append('=');
            sb.append(((this.flatCharge == null)?"<null>":this.flatCharge));
            sb.append(',');
            sb.append("isFlat");
            sb.append('=');
            sb.append(((this.isFlat == null)?"<null>":this.isFlat));
            sb.append(',');
            sb.append("seatno");
            sb.append('=');
            sb.append(((this.seatno == null)?"<null>":this.seatno));
            sb.append(',');
            sb.append("message");
            sb.append('=');
            sb.append(((this.message == null)?"<null>":this.message));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class Data {

        @SerializedName("UpperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("LowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("Lower")
        @Expose
        private Lower lower;
        @SerializedName("Upper")
        @Expose
        private Upper upper;
        @SerializedName("listBoardingPoint")
        @Expose
        private List<ListBoardingPoint> listBoardingPoint = null;
        @SerializedName("listDropPoint")
        @Expose
        private List<ListDropPoint> listDropPoint = null;
        @SerializedName("maxcolumn")
        @Expose
        private Integer maxcolumn;
        @SerializedName("maxrow")
        @Expose
        private Integer maxrow;
        @SerializedName("seatAcFare")
        @Expose
        private Integer seatAcFare;
        @SerializedName("seatNacFare")
        @Expose
        private Integer seatNacFare;
        @SerializedName("sleepAcFare")
        @Expose
        private Integer sleepAcFare;
        @SerializedName("sleepNacFare")
        @Expose
        private Integer sleepNacFare;
        @SerializedName("minFare")
        @Expose
        private Integer minFare;
        @SerializedName("maxFare")
        @Expose
        private Integer maxFare;
        @SerializedName("cancelPolicyList")
        @Expose
        private List<CancelPolicy> cancelPolicyList = null;
        @SerializedName("uniquefares")
        @Expose
        private List<Uniquefare> uniquefares = null;
        @SerializedName("TraceId")
        @Expose
        private String traceId;
        @SerializedName("IsCovidSafe")
        @Expose
        private Boolean isCovidSafe;
        @SerializedName("cRate")
        @Expose
        private Integer cRate;
        @SerializedName("childCon")
        @Expose
        private Integer childCon;
        @SerializedName("fCon")
        @Expose
        private Boolean fCon;
        @SerializedName("vnCon")
        @Expose
        private Boolean vnCon;

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public Lower getLower() {
            return lower;
        }

        public void setLower(Lower lower) {
            this.lower = lower;
        }

        public Upper getUpper() {
            return upper;
        }

        public void setUpper(Upper upper) {
            this.upper = upper;
        }

        public List<ListBoardingPoint> getListBoardingPoint() {
            return listBoardingPoint;
        }

        public void setListBoardingPoint(List<ListBoardingPoint> listBoardingPoint) {
            this.listBoardingPoint = listBoardingPoint;
        }

        public List<ListDropPoint> getListDropPoint() {
            return listDropPoint;
        }

        public void setListDropPoint(List<ListDropPoint> listDropPoint) {
            this.listDropPoint = listDropPoint;
        }

        public Integer getMaxcolumn() {
            return maxcolumn;
        }

        public void setMaxcolumn(Integer maxcolumn) {
            this.maxcolumn = maxcolumn;
        }

        public Integer getMaxrow() {
            return maxrow;
        }

        public void setMaxrow(Integer maxrow) {
            this.maxrow = maxrow;
        }

        public Integer getSeatAcFare() {
            return seatAcFare;
        }

        public void setSeatAcFare(Integer seatAcFare) {
            this.seatAcFare = seatAcFare;
        }

        public Integer getSeatNacFare() {
            return seatNacFare;
        }

        public void setSeatNacFare(Integer seatNacFare) {
            this.seatNacFare = seatNacFare;
        }

        public Integer getSleepAcFare() {
            return sleepAcFare;
        }

        public void setSleepAcFare(Integer sleepAcFare) {
            this.sleepAcFare = sleepAcFare;
        }

        public Integer getSleepNacFare() {
            return sleepNacFare;
        }

        public void setSleepNacFare(Integer sleepNacFare) {
            this.sleepNacFare = sleepNacFare;
        }

        public Integer getMinFare() {
            return minFare;
        }

        public void setMinFare(Integer minFare) {
            this.minFare = minFare;
        }

        public Integer getMaxFare() {
            return maxFare;
        }

        public void setMaxFare(Integer maxFare) {
            this.maxFare = maxFare;
        }

        public List<CancelPolicy> getCancelPolicyList() {
            return cancelPolicyList;
        }

        public void setCancelPolicyList(List<CancelPolicy> cancelPolicyList) {
            this.cancelPolicyList = cancelPolicyList;
        }

        public List<Uniquefare> getUniquefares() {
            return uniquefares;
        }

        public void setUniquefares(List<Uniquefare> uniquefares) {
            this.uniquefares = uniquefares;
        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

        public Boolean getIsCovidSafe() {
            return isCovidSafe;
        }

        public void setIsCovidSafe(Boolean isCovidSafe) {
            this.isCovidSafe = isCovidSafe;
        }

        public Integer getcRate() {
            return cRate;
        }

        public void setcRate(Integer cRate) {
            this.cRate = cRate;
        }

        public Integer getChildCon() {
            return childCon;
        }

        public void setChildCon(Integer childCon) {
            this.childCon = childCon;
        }

        public Boolean getfCon() {
            return fCon;
        }

        public void setfCon(Boolean fCon) {
            this.fCon = fCon;
        }

        public Boolean getVnCon() {
            return vnCon;
        }

        public void setVnCon(Boolean vnCon) {
            this.vnCon = vnCon;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("lower");
            sb.append('=');
            sb.append(((this.lower == null)?"<null>":this.lower));
            sb.append(',');
            sb.append("upper");
            sb.append('=');
            sb.append(((this.upper == null)?"<null>":this.upper));
            sb.append(',');
            sb.append("listBoardingPoint");
            sb.append('=');
            sb.append(((this.listBoardingPoint == null)?"<null>":this.listBoardingPoint));
            sb.append(',');
            sb.append("listDropPoint");
            sb.append('=');
            sb.append(((this.listDropPoint == null)?"<null>":this.listDropPoint));
            sb.append(',');
            sb.append("maxcolumn");
            sb.append('=');
            sb.append(((this.maxcolumn == null)?"<null>":this.maxcolumn));
            sb.append(',');
            sb.append("maxrow");
            sb.append('=');
            sb.append(((this.maxrow == null)?"<null>":this.maxrow));
            sb.append(',');
            sb.append("seatAcFare");
            sb.append('=');
            sb.append(((this.seatAcFare == null)?"<null>":this.seatAcFare));
            sb.append(',');
            sb.append("seatNacFare");
            sb.append('=');
            sb.append(((this.seatNacFare == null)?"<null>":this.seatNacFare));
            sb.append(',');
            sb.append("sleepAcFare");
            sb.append('=');
            sb.append(((this.sleepAcFare == null)?"<null>":this.sleepAcFare));
            sb.append(',');
            sb.append("sleepNacFare");
            sb.append('=');
            sb.append(((this.sleepNacFare == null)?"<null>":this.sleepNacFare));
            sb.append(',');
            sb.append("minFare");
            sb.append('=');
            sb.append(((this.minFare == null)?"<null>":this.minFare));
            sb.append(',');
            sb.append("maxFare");
            sb.append('=');
            sb.append(((this.maxFare == null)?"<null>":this.maxFare));
            sb.append(',');
            sb.append("cancelPolicyList");
            sb.append('=');
            sb.append(((this.cancelPolicyList == null)?"<null>":this.cancelPolicyList));
            sb.append(',');
            sb.append("uniquefares");
            sb.append('=');
            sb.append(((this.uniquefares == null)?"<null>":this.uniquefares));
            sb.append(',');
            sb.append("traceId");
            sb.append('=');
            sb.append(((this.traceId == null)?"<null>":this.traceId));
            sb.append(',');
            sb.append("isCovidSafe");
            sb.append('=');
            sb.append(((this.isCovidSafe == null)?"<null>":this.isCovidSafe));
            sb.append(',');
            sb.append("cRate");
            sb.append('=');
            sb.append(((this.cRate == null)?"<null>":this.cRate));
            sb.append(',');
            sb.append("childCon");
            sb.append('=');
            sb.append(((this.childCon == null)?"<null>":this.childCon));
            sb.append(',');
            sb.append("fCon");
            sb.append('=');
            sb.append(((this.fCon == null)?"<null>":this.fCon));
            sb.append(',');
            sb.append("vnCon");
            sb.append('=');
            sb.append(((this.vnCon == null)?"<null>":this.vnCon));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class EightColumn {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(EightColumn.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class ListBoardingPoint {

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
        private Object bdlocation;
        @SerializedName("landmark")
        @Expose
        private String landmark;
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

        public Object getBdlocation() {
            return bdlocation;
        }

        public void setBdlocation(Object bdlocation) {
            this.bdlocation = bdlocation;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ListBoardingPoint.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("bdPoint");
            sb.append('=');
            sb.append(((this.bdPoint == null)?"<null>":this.bdPoint));
            sb.append(',');
            sb.append("bdLongName");
            sb.append('=');
            sb.append(((this.bdLongName == null)?"<null>":this.bdLongName));
            sb.append(',');
            sb.append("bdid");
            sb.append('=');
            sb.append(((this.bdid == null)?"<null>":this.bdid));
            sb.append(',');
            sb.append("bdlocation");
            sb.append('=');
            sb.append(((this.bdlocation == null)?"<null>":this.bdlocation));
            sb.append(',');
            sb.append("landmark");
            sb.append('=');
            sb.append(((this.landmark == null)?"<null>":this.landmark));
            sb.append(',');
            sb.append("prime");
            sb.append('=');
            sb.append(((this.prime == null)?"<null>":this.prime));
            sb.append(',');
            sb.append("time");
            sb.append('=');
            sb.append(((this.time == null)?"<null>":this.time));
            sb.append(',');
            sb.append("contactNumber");
            sb.append('=');
            sb.append(((this.contactNumber == null)?"<null>":this.contactNumber));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
    public class ListDropPoint {

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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ListDropPoint.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("dpId");
            sb.append('=');
            sb.append(((this.dpId == null)?"<null>":this.dpId));
            sb.append(',');
            sb.append("dpName");
            sb.append('=');
            sb.append(((this.dpName == null)?"<null>":this.dpName));
            sb.append(',');
            sb.append("locatoin");
            sb.append('=');
            sb.append(((this.locatoin == null)?"<null>":this.locatoin));
            sb.append(',');
            sb.append("prime");
            sb.append('=');
            sb.append(((this.prime == null)?"<null>":this.prime));
            sb.append(',');
            sb.append("dpTime");
            sb.append('=');
            sb.append(((this.dpTime == null)?"<null>":this.dpTime));
            sb.append(',');
            sb.append("contactNumber");
            sb.append('=');
            sb.append(((this.contactNumber == null)?"<null>":this.contactNumber));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class Lower {

        @SerializedName("firstColumn")
        @Expose
        private Object firstColumn;
        @SerializedName("SecondColumn")
        @Expose
        private Object secondColumn;
        @SerializedName("ThirdColumn")
        @Expose
        private Object thirdColumn;
        @SerializedName("FourthColumn")
        @Expose
        private Object fourthColumn;
        @SerializedName("FifthColumn")
        @Expose
        private Object fifthColumn;
        @SerializedName("SixthColumn")
        @Expose
        private List<SixthColumn> sixthColumn = null;
        @SerializedName("seventhColumn")
        @Expose
        private List<SeventhColumn> seventhColumn = null;
        @SerializedName("eightColumn")
        @Expose
        private List<EightColumn> eightColumn = null;
        @SerializedName("ninethColumn")
        @Expose
        private List<NinethColumn> ninethColumn = null;
        @SerializedName("tenthColumn")
        @Expose
        private Object tenthColumn;
        @SerializedName("eleventhColumn")
        @Expose
        private Object eleventhColumn;
        @SerializedName("tevelthColumn")
        @Expose
        private Object tevelthColumn;
        @SerializedName("thirteenColumn")
        @Expose
        private Object thirteenColumn;

        public Object getFirstColumn() {
            return firstColumn;
        }

        public void setFirstColumn(Object firstColumn) {
            this.firstColumn = firstColumn;
        }

        public Object getSecondColumn() {
            return secondColumn;
        }

        public void setSecondColumn(Object secondColumn) {
            this.secondColumn = secondColumn;
        }

        public Object getThirdColumn() {
            return thirdColumn;
        }

        public void setThirdColumn(Object thirdColumn) {
            this.thirdColumn = thirdColumn;
        }

        public Object getFourthColumn() {
            return fourthColumn;
        }

        public void setFourthColumn(Object fourthColumn) {
            this.fourthColumn = fourthColumn;
        }

        public Object getFifthColumn() {
            return fifthColumn;
        }

        public void setFifthColumn(Object fifthColumn) {
            this.fifthColumn = fifthColumn;
        }

        public List<SixthColumn> getSixthColumn() {
            return sixthColumn;
        }

        public void setSixthColumn(List<SixthColumn> sixthColumn) {
            this.sixthColumn = sixthColumn;
        }

        public List<SeventhColumn> getSeventhColumn() {
            return seventhColumn;
        }

        public void setSeventhColumn(List<SeventhColumn> seventhColumn) {
            this.seventhColumn = seventhColumn;
        }

        public List<EightColumn> getEightColumn() {
            return eightColumn;
        }

        public void setEightColumn(List<EightColumn> eightColumn) {
            this.eightColumn = eightColumn;
        }

        public List<NinethColumn> getNinethColumn() {
            return ninethColumn;
        }

        public void setNinethColumn(List<NinethColumn> ninethColumn) {
            this.ninethColumn = ninethColumn;
        }

        public Object getTenthColumn() {
            return tenthColumn;
        }

        public void setTenthColumn(Object tenthColumn) {
            this.tenthColumn = tenthColumn;
        }

        public Object getEleventhColumn() {
            return eleventhColumn;
        }

        public void setEleventhColumn(Object eleventhColumn) {
            this.eleventhColumn = eleventhColumn;
        }

        public Object getTevelthColumn() {
            return tevelthColumn;
        }

        public void setTevelthColumn(Object tevelthColumn) {
            this.tevelthColumn = tevelthColumn;
        }

        public Object getThirteenColumn() {
            return thirteenColumn;
        }

        public void setThirteenColumn(Object thirteenColumn) {
            this.thirteenColumn = thirteenColumn;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Lower.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("firstColumn");
            sb.append('=');
            sb.append(((this.firstColumn == null)?"<null>":this.firstColumn));
            sb.append(',');
            sb.append("secondColumn");
            sb.append('=');
            sb.append(((this.secondColumn == null)?"<null>":this.secondColumn));
            sb.append(',');
            sb.append("thirdColumn");
            sb.append('=');
            sb.append(((this.thirdColumn == null)?"<null>":this.thirdColumn));
            sb.append(',');
            sb.append("fourthColumn");
            sb.append('=');
            sb.append(((this.fourthColumn == null)?"<null>":this.fourthColumn));
            sb.append(',');
            sb.append("fifthColumn");
            sb.append('=');
            sb.append(((this.fifthColumn == null)?"<null>":this.fifthColumn));
            sb.append(',');
            sb.append("sixthColumn");
            sb.append('=');
            sb.append(((this.sixthColumn == null)?"<null>":this.sixthColumn));
            sb.append(',');
            sb.append("seventhColumn");
            sb.append('=');
            sb.append(((this.seventhColumn == null)?"<null>":this.seventhColumn));
            sb.append(',');
            sb.append("eightColumn");
            sb.append('=');
            sb.append(((this.eightColumn == null)?"<null>":this.eightColumn));
            sb.append(',');
            sb.append("ninethColumn");
            sb.append('=');
            sb.append(((this.ninethColumn == null)?"<null>":this.ninethColumn));
            sb.append(',');
            sb.append("tenthColumn");
            sb.append('=');
            sb.append(((this.tenthColumn == null)?"<null>":this.tenthColumn));
            sb.append(',');
            sb.append("eleventhColumn");
            sb.append('=');
            sb.append(((this.eleventhColumn == null)?"<null>":this.eleventhColumn));
            sb.append(',');
            sb.append("tevelthColumn");
            sb.append('=');
            sb.append(((this.tevelthColumn == null)?"<null>":this.tevelthColumn));
            sb.append(',');
            sb.append("thirteenColumn");
            sb.append('=');
            sb.append(((this.thirteenColumn == null)?"<null>":this.thirteenColumn));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class NinethColumn {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(NinethColumn.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class NinethColumn1 {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(NinethColumn1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }



    public class SeventhColumn {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(SeventhColumn.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public class SeventhColumn__1 {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(SeventhColumn__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
    public class SixthColumn {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(SixthColumn.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
    public class SixthColumn__1 {

        @SerializedName("available")
        @Expose
        private Boolean available;
        @SerializedName("baseFare")
        @Expose
        private Integer baseFare;
        @SerializedName("column")
        @Expose
        private String column;
        @SerializedName("ladiesSeat")
        @Expose
        private Object ladiesSeat;
        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("seatAvail")
        @Expose
        private Integer seatAvail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("row")
        @Expose
        private String row;
        @SerializedName("id")
        @Expose
        private Object id;
        @SerializedName("seatStyle")
        @Expose
        private String seatStyle;
        @SerializedName("width")
        @Expose
        private String width;
        @SerializedName("zIndex")
        @Expose
        private Object zIndex;
        @SerializedName("fare")
        @Expose
        private Integer fare;
        @SerializedName("seatType")
        @Expose
        private String seatType;
        @SerializedName("ImageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("isSleeper")
        @Expose
        private Boolean isSleeper;
        @SerializedName("isAc")
        @Expose
        private Boolean isAc;
        @SerializedName("upperShow")
        @Expose
        private Boolean upperShow;
        @SerializedName("lowerShow")
        @Expose
        private Boolean lowerShow;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("columnNo")
        @Expose
        private Integer columnNo;
        @SerializedName("rowNo")
        @Expose
        private Integer rowNo;
        @SerializedName("seqNo")
        @Expose
        private Integer seqNo;
        @SerializedName("actualfare")
        @Expose
        private Integer actualfare;
        @SerializedName("lavyFare")
        @Expose
        private Integer lavyFare;
        @SerializedName("tollFee")
        @Expose
        private Integer tollFee;
        @SerializedName("srtFee")
        @Expose
        private Integer srtFee;
        @SerializedName("bookingFee")
        @Expose
        private Integer bookingFee;
        @SerializedName("bankTrexAmt")
        @Expose
        private Integer bankTrexAmt;
        @SerializedName("concession")
        @Expose
        private Integer concession;
        @SerializedName("serviceTaxAbsolute")
        @Expose
        private Integer serviceTaxAbsolute;
        @SerializedName("serviceTaxPercent")
        @Expose
        private Integer serviceTaxPercent;
        @SerializedName("convenienceTaxPercent")
        @Expose
        private Integer convenienceTaxPercent;
        @SerializedName("convenienceCharge")
        @Expose
        private Integer convenienceCharge;
        @SerializedName("TotalBookingAmount")
        @Expose
        private Integer totalBookingAmount;
        @SerializedName("isSemiSleeper")
        @Expose
        private Boolean isSemiSleeper;
        @SerializedName("UniqueId")
        @Expose
        private Object uniqueId;
        @SerializedName("Type")
        @Expose
        private Object type;
        @SerializedName("BaseCFare")
        @Expose
        private Integer baseCFare;
        @SerializedName("CFare")
        @Expose
        private Integer cFare;
        @SerializedName("CConcession")
        @Expose
        private Integer cConcession;
        @SerializedName("CBookingFee")
        @Expose
        private Integer cBookingFee;
        @SerializedName("CTollFee")
        @Expose
        private Integer cTollFee;
        @SerializedName("CLavyFee")
        @Expose
        private Integer cLavyFee;
        @SerializedName("CTaxAbsoluteFee")
        @Expose
        private Integer cTaxAbsoluteFee;
        @SerializedName("IsVertical")
        @Expose
        private Boolean isVertical;

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public Integer getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(Integer baseFare) {
            this.baseFare = baseFare;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public Object getLadiesSeat() {
            return ladiesSeat;
        }

        public void setLadiesSeat(Object ladiesSeat) {
            this.ladiesSeat = ladiesSeat;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public Integer getSeatAvail() {
            return seatAvail;
        }

        public void setSeatAvail(Integer seatAvail) {
            this.seatAvail = seatAvail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSeatStyle() {
            return seatStyle;
        }

        public void setSeatStyle(String seatStyle) {
            this.seatStyle = seatStyle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public Object getzIndex() {
            return zIndex;
        }

        public void setzIndex(Object zIndex) {
            this.zIndex = zIndex;
        }

        public Integer getFare() {
            return fare;
        }

        public void setFare(Integer fare) {
            this.fare = fare;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsSleeper() {
            return isSleeper;
        }

        public void setIsSleeper(Boolean isSleeper) {
            this.isSleeper = isSleeper;
        }

        public Boolean getIsAc() {
            return isAc;
        }

        public void setIsAc(Boolean isAc) {
            this.isAc = isAc;
        }

        public Boolean getUpperShow() {
            return upperShow;
        }

        public void setUpperShow(Boolean upperShow) {
            this.upperShow = upperShow;
        }

        public Boolean getLowerShow() {
            return lowerShow;
        }

        public void setLowerShow(Boolean lowerShow) {
            this.lowerShow = lowerShow;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getColumnNo() {
            return columnNo;
        }

        public void setColumnNo(Integer columnNo) {
            this.columnNo = columnNo;
        }

        public Integer getRowNo() {
            return rowNo;
        }

        public void setRowNo(Integer rowNo) {
            this.rowNo = rowNo;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public Integer getActualfare() {
            return actualfare;
        }

        public void setActualfare(Integer actualfare) {
            this.actualfare = actualfare;
        }

        public Integer getLavyFare() {
            return lavyFare;
        }

        public void setLavyFare(Integer lavyFare) {
            this.lavyFare = lavyFare;
        }

        public Integer getTollFee() {
            return tollFee;
        }

        public void setTollFee(Integer tollFee) {
            this.tollFee = tollFee;
        }

        public Integer getSrtFee() {
            return srtFee;
        }

        public void setSrtFee(Integer srtFee) {
            this.srtFee = srtFee;
        }

        public Integer getBookingFee() {
            return bookingFee;
        }

        public void setBookingFee(Integer bookingFee) {
            this.bookingFee = bookingFee;
        }

        public Integer getBankTrexAmt() {
            return bankTrexAmt;
        }

        public void setBankTrexAmt(Integer bankTrexAmt) {
            this.bankTrexAmt = bankTrexAmt;
        }

        public Integer getConcession() {
            return concession;
        }

        public void setConcession(Integer concession) {
            this.concession = concession;
        }

        public Integer getServiceTaxAbsolute() {
            return serviceTaxAbsolute;
        }

        public void setServiceTaxAbsolute(Integer serviceTaxAbsolute) {
            this.serviceTaxAbsolute = serviceTaxAbsolute;
        }

        public Integer getServiceTaxPercent() {
            return serviceTaxPercent;
        }

        public void setServiceTaxPercent(Integer serviceTaxPercent) {
            this.serviceTaxPercent = serviceTaxPercent;
        }

        public Integer getConvenienceTaxPercent() {
            return convenienceTaxPercent;
        }

        public void setConvenienceTaxPercent(Integer convenienceTaxPercent) {
            this.convenienceTaxPercent = convenienceTaxPercent;
        }

        public Integer getConvenienceCharge() {
            return convenienceCharge;
        }

        public void setConvenienceCharge(Integer convenienceCharge) {
            this.convenienceCharge = convenienceCharge;
        }

        public Integer getTotalBookingAmount() {
            return totalBookingAmount;
        }

        public void setTotalBookingAmount(Integer totalBookingAmount) {
            this.totalBookingAmount = totalBookingAmount;
        }

        public Boolean getIsSemiSleeper() {
            return isSemiSleeper;
        }

        public void setIsSemiSleeper(Boolean isSemiSleeper) {
            this.isSemiSleeper = isSemiSleeper;
        }

        public Object getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Object uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Integer getBaseCFare() {
            return baseCFare;
        }

        public void setBaseCFare(Integer baseCFare) {
            this.baseCFare = baseCFare;
        }

        public Integer getCFare() {
            return cFare;
        }

        public void setCFare(Integer cFare) {
            this.cFare = cFare;
        }

        public Integer getCConcession() {
            return cConcession;
        }

        public void setCConcession(Integer cConcession) {
            this.cConcession = cConcession;
        }

        public Integer getCBookingFee() {
            return cBookingFee;
        }

        public void setCBookingFee(Integer cBookingFee) {
            this.cBookingFee = cBookingFee;
        }

        public Integer getCTollFee() {
            return cTollFee;
        }

        public void setCTollFee(Integer cTollFee) {
            this.cTollFee = cTollFee;
        }

        public Integer getCLavyFee() {
            return cLavyFee;
        }

        public void setCLavyFee(Integer cLavyFee) {
            this.cLavyFee = cLavyFee;
        }

        public Integer getCTaxAbsoluteFee() {
            return cTaxAbsoluteFee;
        }

        public void setCTaxAbsoluteFee(Integer cTaxAbsoluteFee) {
            this.cTaxAbsoluteFee = cTaxAbsoluteFee;
        }

        public Boolean getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(Boolean isVertical) {
            this.isVertical = isVertical;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(SixthColumn__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("available");
            sb.append('=');
            sb.append(((this.available == null)?"<null>":this.available));
            sb.append(',');
            sb.append("baseFare");
            sb.append('=');
            sb.append(((this.baseFare == null)?"<null>":this.baseFare));
            sb.append(',');
            sb.append("column");
            sb.append('=');
            sb.append(((this.column == null)?"<null>":this.column));
            sb.append(',');
            sb.append("ladiesSeat");
            sb.append('=');
            sb.append(((this.ladiesSeat == null)?"<null>":this.ladiesSeat));
            sb.append(',');
            sb.append("length");
            sb.append('=');
            sb.append(((this.length == null)?"<null>":this.length));
            sb.append(',');
            sb.append("seatAvail");
            sb.append('=');
            sb.append(((this.seatAvail == null)?"<null>":this.seatAvail));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(',');
            sb.append("row");
            sb.append('=');
            sb.append(((this.row == null)?"<null>":this.row));
            sb.append(',');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("seatStyle");
            sb.append('=');
            sb.append(((this.seatStyle == null)?"<null>":this.seatStyle));
            sb.append(',');
            sb.append("width");
            sb.append('=');
            sb.append(((this.width == null)?"<null>":this.width));
            sb.append(',');
            sb.append("zIndex");
            sb.append('=');
            sb.append(((this.zIndex == null)?"<null>":this.zIndex));
            sb.append(',');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            sb.append("seatType");
            sb.append('=');
            sb.append(((this.seatType == null)?"<null>":this.seatType));
            sb.append(',');
            sb.append("imageUrl");
            sb.append('=');
            sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
            sb.append(',');
            sb.append("isSleeper");
            sb.append('=');
            sb.append(((this.isSleeper == null)?"<null>":this.isSleeper));
            sb.append(',');
            sb.append("isAc");
            sb.append('=');
            sb.append(((this.isAc == null)?"<null>":this.isAc));
            sb.append(',');
            sb.append("upperShow");
            sb.append('=');
            sb.append(((this.upperShow == null)?"<null>":this.upperShow));
            sb.append(',');
            sb.append("lowerShow");
            sb.append('=');
            sb.append(((this.lowerShow == null)?"<null>":this.lowerShow));
            sb.append(',');
            sb.append("gender");
            sb.append('=');
            sb.append(((this.gender == null)?"<null>":this.gender));
            sb.append(',');
            sb.append("columnNo");
            sb.append('=');
            sb.append(((this.columnNo == null)?"<null>":this.columnNo));
            sb.append(',');
            sb.append("rowNo");
            sb.append('=');
            sb.append(((this.rowNo == null)?"<null>":this.rowNo));
            sb.append(',');
            sb.append("seqNo");
            sb.append('=');
            sb.append(((this.seqNo == null)?"<null>":this.seqNo));
            sb.append(',');
            sb.append("actualfare");
            sb.append('=');
            sb.append(((this.actualfare == null)?"<null>":this.actualfare));
            sb.append(',');
            sb.append("lavyFare");
            sb.append('=');
            sb.append(((this.lavyFare == null)?"<null>":this.lavyFare));
            sb.append(',');
            sb.append("tollFee");
            sb.append('=');
            sb.append(((this.tollFee == null)?"<null>":this.tollFee));
            sb.append(',');
            sb.append("srtFee");
            sb.append('=');
            sb.append(((this.srtFee == null)?"<null>":this.srtFee));
            sb.append(',');
            sb.append("bookingFee");
            sb.append('=');
            sb.append(((this.bookingFee == null)?"<null>":this.bookingFee));
            sb.append(',');
            sb.append("bankTrexAmt");
            sb.append('=');
            sb.append(((this.bankTrexAmt == null)?"<null>":this.bankTrexAmt));
            sb.append(',');
            sb.append("concession");
            sb.append('=');
            sb.append(((this.concession == null)?"<null>":this.concession));
            sb.append(',');
            sb.append("serviceTaxAbsolute");
            sb.append('=');
            sb.append(((this.serviceTaxAbsolute == null)?"<null>":this.serviceTaxAbsolute));
            sb.append(',');
            sb.append("serviceTaxPercent");
            sb.append('=');
            sb.append(((this.serviceTaxPercent == null)?"<null>":this.serviceTaxPercent));
            sb.append(',');
            sb.append("convenienceTaxPercent");
            sb.append('=');
            sb.append(((this.convenienceTaxPercent == null)?"<null>":this.convenienceTaxPercent));
            sb.append(',');
            sb.append("convenienceCharge");
            sb.append('=');
            sb.append(((this.convenienceCharge == null)?"<null>":this.convenienceCharge));
            sb.append(',');
            sb.append("totalBookingAmount");
            sb.append('=');
            sb.append(((this.totalBookingAmount == null)?"<null>":this.totalBookingAmount));
            sb.append(',');
            sb.append("isSemiSleeper");
            sb.append('=');
            sb.append(((this.isSemiSleeper == null)?"<null>":this.isSemiSleeper));
            sb.append(',');
            sb.append("uniqueId");
            sb.append('=');
            sb.append(((this.uniqueId == null)?"<null>":this.uniqueId));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null)?"<null>":this.type));
            sb.append(',');
            sb.append("baseCFare");
            sb.append('=');
            sb.append(((this.baseCFare == null)?"<null>":this.baseCFare));
            sb.append(',');
            sb.append("cFare");
            sb.append('=');
            sb.append(((this.cFare == null)?"<null>":this.cFare));
            sb.append(',');
            sb.append("cConcession");
            sb.append('=');
            sb.append(((this.cConcession == null)?"<null>":this.cConcession));
            sb.append(',');
            sb.append("cBookingFee");
            sb.append('=');
            sb.append(((this.cBookingFee == null)?"<null>":this.cBookingFee));
            sb.append(',');
            sb.append("cTollFee");
            sb.append('=');
            sb.append(((this.cTollFee == null)?"<null>":this.cTollFee));
            sb.append(',');
            sb.append("cLavyFee");
            sb.append('=');
            sb.append(((this.cLavyFee == null)?"<null>":this.cLavyFee));
            sb.append(',');
            sb.append("cTaxAbsoluteFee");
            sb.append('=');
            sb.append(((this.cTaxAbsoluteFee == null)?"<null>":this.cTaxAbsoluteFee));
            sb.append(',');
            sb.append("isVertical");
            sb.append('=');
            sb.append(((this.isVertical == null)?"<null>":this.isVertical));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
    public class Uniquefare {

        @SerializedName("Fare")
        @Expose
        private String fare;

        public String getFare() {
            return fare;
        }

        public void setFare(String fare) {
            this.fare = fare;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Uniquefare.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("fare");
            sb.append('=');
            sb.append(((this.fare == null)?"<null>":this.fare));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
    public class Upper {

        @SerializedName("firstColumn")
        @Expose
        private Object firstColumn;
        @SerializedName("SecondColumn")
        @Expose
        private Object secondColumn;
        @SerializedName("ThirdColumn")
        @Expose
        private Object thirdColumn;
        @SerializedName("FourthColumn")
        @Expose
        private Object fourthColumn;
        @SerializedName("FifthColumn")
        @Expose
        private Object fifthColumn;
        @SerializedName("SixthColumn")
        @Expose
        private List<SixthColumn__1> sixthColumn = null;
        @SerializedName("seventhColumn")
        @Expose
        private List<SeventhColumn__1> seventhColumn = null;
        @SerializedName("eightColumn")
        @Expose
        private Object eightColumn;
        @SerializedName("ninethColumn")
        @Expose
        private List<NinethColumn1> ninethColumn = null;
        @SerializedName("tenthColumn")
        @Expose
        private Object tenthColumn;
        @SerializedName("eleventhColumn")
        @Expose
        private Object eleventhColumn;
        @SerializedName("tevelthColumn")
        @Expose
        private Object tevelthColumn;
        @SerializedName("thirteenColumn")
        @Expose
        private Object thirteenColumn;

        public Object getFirstColumn() {
            return firstColumn;
        }

        public void setFirstColumn(Object firstColumn) {
            this.firstColumn = firstColumn;
        }

        public Object getSecondColumn() {
            return secondColumn;
        }

        public void setSecondColumn(Object secondColumn) {
            this.secondColumn = secondColumn;
        }

        public Object getThirdColumn() {
            return thirdColumn;
        }

        public void setThirdColumn(Object thirdColumn) {
            this.thirdColumn = thirdColumn;
        }

        public Object getFourthColumn() {
            return fourthColumn;
        }

        public void setFourthColumn(Object fourthColumn) {
            this.fourthColumn = fourthColumn;
        }

        public Object getFifthColumn() {
            return fifthColumn;
        }

        public void setFifthColumn(Object fifthColumn) {
            this.fifthColumn = fifthColumn;
        }

        public List<SixthColumn__1> getSixthColumn() {
            return sixthColumn;
        }

        public void setSixthColumn(List<SixthColumn__1> sixthColumn) {
            this.sixthColumn = sixthColumn;
        }

        public List<SeventhColumn__1> getSeventhColumn() {
            return seventhColumn;
        }

        public void setSeventhColumn(List<SeventhColumn__1> seventhColumn) {
            this.seventhColumn = seventhColumn;
        }

        public Object getEightColumn() {
            return eightColumn;
        }

        public void setEightColumn(Object eightColumn) {
            this.eightColumn = eightColumn;
        }

        public List<NinethColumn1> getNinethColumn() {
            return ninethColumn;
        }

        public void setNinethColumn(List<NinethColumn1> ninethColumn) {
            this.ninethColumn = ninethColumn;
        }

        public Object getTenthColumn() {
            return tenthColumn;
        }

        public void setTenthColumn(Object tenthColumn) {
            this.tenthColumn = tenthColumn;
        }

        public Object getEleventhColumn() {
            return eleventhColumn;
        }

        public void setEleventhColumn(Object eleventhColumn) {
            this.eleventhColumn = eleventhColumn;
        }

        public Object getTevelthColumn() {
            return tevelthColumn;
        }

        public void setTevelthColumn(Object tevelthColumn) {
            this.tevelthColumn = tevelthColumn;
        }

        public Object getThirteenColumn() {
            return thirteenColumn;
        }

        public void setThirteenColumn(Object thirteenColumn) {
            this.thirteenColumn = thirteenColumn;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Upper.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("firstColumn");
            sb.append('=');
            sb.append(((this.firstColumn == null)?"<null>":this.firstColumn));
            sb.append(',');
            sb.append("secondColumn");
            sb.append('=');
            sb.append(((this.secondColumn == null)?"<null>":this.secondColumn));
            sb.append(',');
            sb.append("thirdColumn");
            sb.append('=');
            sb.append(((this.thirdColumn == null)?"<null>":this.thirdColumn));
            sb.append(',');
            sb.append("fourthColumn");
            sb.append('=');
            sb.append(((this.fourthColumn == null)?"<null>":this.fourthColumn));
            sb.append(',');
            sb.append("fifthColumn");
            sb.append('=');
            sb.append(((this.fifthColumn == null)?"<null>":this.fifthColumn));
            sb.append(',');
            sb.append("sixthColumn");
            sb.append('=');
            sb.append(((this.sixthColumn == null)?"<null>":this.sixthColumn));
            sb.append(',');
            sb.append("seventhColumn");
            sb.append('=');
            sb.append(((this.seventhColumn == null)?"<null>":this.seventhColumn));
            sb.append(',');
            sb.append("eightColumn");
            sb.append('=');
            sb.append(((this.eightColumn == null)?"<null>":this.eightColumn));
            sb.append(',');
            sb.append("ninethColumn");
            sb.append('=');
            sb.append(((this.ninethColumn == null)?"<null>":this.ninethColumn));
            sb.append(',');
            sb.append("tenthColumn");
            sb.append('=');
            sb.append(((this.tenthColumn == null)?"<null>":this.tenthColumn));
            sb.append(',');
            sb.append("eleventhColumn");
            sb.append('=');
            sb.append(((this.eleventhColumn == null)?"<null>":this.eleventhColumn));
            sb.append(',');
            sb.append("tevelthColumn");
            sb.append('=');
            sb.append(((this.tevelthColumn == null)?"<null>":this.tevelthColumn));
            sb.append(',');
            sb.append("thirteenColumn");
            sb.append('=');
            sb.append(((this.thirteenColumn == null)?"<null>":this.thirteenColumn));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }
}

