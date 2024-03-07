package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.max.ecomaxgo.maxpe.R;

public class RecieptActivity extends AppCompatActivity {

    String Amount;
    String billDate;
    String paymentRefNo;
    String BillerID;
    String AdditionalInformation;
    String MerchantRefNo;
    String ResponseMessage;
    String ResponseCode;
    String ResponseDescription;
    String billNumber;
    String euronetRefNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Intent intentSent = getIntent();
        Amount = intentSent.getStringExtra("Amount");
        billDate = intentSent.getStringExtra("BillDate");
        paymentRefNo = intentSent.getStringExtra("PaymentRefNo");
        intentSent.getStringExtra("BillerID");
        AdditionalInformation = intentSent.getStringExtra("AdditionalInformation");
        MerchantRefNo = intentSent.getStringExtra("MerchantRefNo");
        ResponseMessage = intentSent.getStringExtra("ResponseMessage");
        ResponseCode = intentSent.getStringExtra("ResponseCode");
        ResponseDescription = intentSent.getStringExtra("ResponseDescription");
        billNumber = intentSent.getStringExtra("BillNumber");
        euronetRefNo = intentSent.getStringExtra("EuronetRefNo");

        TextView EuronetRefNo = (TextView) findViewById(R.id.euro_net);
        EuronetRefNo.setText(euronetRefNo);
        TextView BillDate = (TextView) findViewById(R.id.bill_date);
        BillDate.setText(billDate);
        TextView PaymentRefNo = (TextView) findViewById(R.id.PaymentRefNo);
        PaymentRefNo.setText(paymentRefNo);
        TextView BillerNumber = (TextView) findViewById(R.id.biller_number);
        BillerNumber.setText(billNumber);

        intentSent.getStringExtra("BillerID");
        intentSent.getStringExtra("AdditionalInformation");
        intentSent.getStringExtra("MerchantRefNo");
        intentSent.getStringExtra("ResponseMessage");
        intentSent.getStringExtra("ResponseCode");
        intentSent.getStringExtra("ResponseDescription");
        intentSent.getStringExtra("BillNumber");
        intentSent.getStringExtra("EuronetRefNo");
    }
}