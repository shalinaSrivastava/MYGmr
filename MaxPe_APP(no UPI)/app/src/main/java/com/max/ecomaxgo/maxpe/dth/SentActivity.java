package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dth.adapter.SentListAdapter;

import java.util.ArrayList;

public class SentActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ImageView shareiv;
    RecyclerView recyclerview;
    //    EditText tran_amount;
    String PaymentRefNo;
    String BillerID;
    String AdditionalInformation;
    String MerchantRefNo;
    String ResponseMessage;
    String ResponseCode;
    String ResponseDescription;
    String Amount;
    String BillDate;
    String BillNumber;
    String EuronetRefNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);

        shareiv = findViewById(R.id.shareiv);
        shareiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SentActivity.this, RecieptActivity.class);
//                startActivity(intent);
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        Intent intent = getIntent();
        Amount = intent.getStringExtra("Amount");
        BillDate = intent.getStringExtra("BillDate");
        PaymentRefNo = intent.getStringExtra("PaymentRefNo");
        BillerID = intent.getStringExtra("BillerID");
        AdditionalInformation = intent.getStringExtra("AdditionalInformation");
        MerchantRefNo = intent.getStringExtra("MerchantRefNo");
        ResponseMessage = intent.getStringExtra("ResponseMessage");
        ResponseCode = intent.getStringExtra("ResponseCode");
        ResponseDescription = intent.getStringExtra("ResponseDescription");
        BillNumber = intent.getStringExtra("BillNumber");
        EuronetRefNo = intent.getStringExtra("EuronetRefNo");
        BillDate = intent.getStringExtra("BillDate");

        LinearLayoutManager layoutManager = new LinearLayoutManager(SentActivity.this);

        arrayList = new ArrayList<>();

        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");

        //TODO: Fix SentListAdapter
        SentListAdapter adapter = new SentListAdapter(arrayList);
        recyclerview.setAdapter(adapter);

        TextView amount = (TextView) findViewById(R.id.amount);
        amount.setText(Amount);
//        Log.d("Amount: ", Amount);
        TextView billDate = (TextView) findViewById(R.id.billDate);
        billDate.setText(BillDate);

    }

    public void btn_reciept(View view) {
        Intent intentSent = new Intent(this, RecieptActivity.class);
//        intentSent.putExtra("Amount",tran_amount.getText());
        intentSent.putExtra("BillDate",BillDate);
        intentSent.putExtra("PaymentRefNo",PaymentRefNo);
        intentSent.putExtra("BillerID",BillerID);
        intentSent.putExtra("AdditionalInformation",AdditionalInformation);
        intentSent.putExtra("MerchantRefNo",MerchantRefNo);
        intentSent.putExtra("ResponseMessage",ResponseMessage);
        intentSent.putExtra("ResponseCode",ResponseCode);
        intentSent.putExtra("ResponseDescription",ResponseDescription);
        intentSent.putExtra("BillNumber",BillNumber);
        intentSent.putExtra("EuronetRefNo",EuronetRefNo);
        intentSent.putExtra("BillDate",BillDate);
        intentSent.putExtra("PaymentRefNo",PaymentRefNo);
        startActivity(intentSent);

    }
}