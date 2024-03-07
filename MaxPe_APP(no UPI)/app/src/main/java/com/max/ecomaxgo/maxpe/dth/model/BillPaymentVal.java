package com.max.ecomaxgo.maxpe.dth.model;

import java.util.List;

public class BillPaymentVal {
    String status;
    String message;
    List<DetailBillPaymentVal> DetailBillPaymentVal;

    public BillPaymentVal(String status, String message, List<DetailBillPaymentVal> DetailBillPaymentVal) {
        this.status = status;
        this.message = message;
        this.DetailBillPaymentVal = DetailBillPaymentVal;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<DetailBillPaymentVal> getDetails4() {
        return DetailBillPaymentVal;
    }
}
