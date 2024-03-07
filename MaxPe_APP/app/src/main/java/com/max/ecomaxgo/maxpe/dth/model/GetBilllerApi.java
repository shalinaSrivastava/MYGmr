package com.max.ecomaxgo.maxpe.dth.model;

import android.text.Editable;

import com.max.ecomaxgo.maxpe.bbps.Biller;
import com.max.ecomaxgo.maxpe.bbps.FetchBiller;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetBilllerApi {
    @FormUrlEncoded
    @POST("prod/Euronet/Bbps/biller")
    Call<Biller> biller(@Field("skey") String skey,
                        @Field("billerId") String billerId);

    @FormUrlEncoded
    @POST("prod/Euronet/Bbps/fetch")
    Call<FetchBiller> fetchBill(@Field("skey") String skey,
                                @Field("billerId") String billerId,
                                @Field("number") String number,
                                @Field("token") String token,
                                @Field("paramName") String paramName,
                                @Field("paramValue") String paramValue);

    @FormUrlEncoded
    @POST("prod/Euronet/Bbps/validate")
    Call<Validate> validate(@Field("skey") String skey,
                            @Field("billerId") String billerId,
                            @Field("number") String number,
                            @Field("token") String token,
                            @Field("paramName") String paramName,
                            @Field("paramValue") String paramValue,
                            @Field("amount") String amount);

    @FormUrlEncoded
    @POST("prod/Euronet/Bbps/pay")
    Call<BillPay> billPay(@Field("skey") String skey,
                          @Field("number") String number,
                          @Field("token") String token,
                          @Field("billerId") String billerId,
                          @Field("amount") String paisaAmount,
                          @Field("billToken") String billToken,
                          @Field("mode") String mode);

    @FormUrlEncoded
    @POST("billpaymentval")
    Call<BillPaymentVal> billPaymentVal(@Field("BillerId") String BillerId,
                                        @Field("skey") String skey,
                                        @Field("Amount") String Amount,
                                        @Field("EuronetRefNo") String EuronetRefNo,
                                        @Field("BillPaymentToken") String BillPaymentToken);

    @FormUrlEncoded
    @POST("complaintreg")
    Call<ComplaintReg> complaintReg(@Field("PaymentRefNo") String PaymentRefNo,
                                    @Field("Description") Editable Description,
                                    @Field("Disposition") Editable Disposition,
                                    @Field("skey") String skey);
}