package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.TransQueryActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.TransAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.TranHistory;

public class TransActivity extends AppCompatActivity {

    LoadingDialog ld;
    ErrorDialog error;

    ImageView empty;
    RecyclerView recyclerView;
    TransAdapter transAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        ld = new LoadingDialog(TransActivity.this);
        error = new ErrorDialog(TransActivity.this);

        recyclerView = findViewById(R.id.vpaRecycler);
        empty =  findViewById(R.id.empty);

        if(Upi.getTranHistory().size()<1)
            empty.setVisibility(View.VISIBLE);
        listSetup();
    }

    private void listSetup() {

        String myvpa = Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa();
        transAdapter = new TransAdapter(TransActivity.this,myvpa, Upi.getTranHistory(), new TransAdapter.TransOnItemClickListner() {

            @Override
            public void getOperatorPosition(TranHistory tranHistory) {
                startTransQuery(tranHistory);
            }
        });
        recyclerView.setAdapter(transAdapter);
        transAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    private void startTransQuery(TranHistory tranHistory) {
        Intent intent = new Intent(TransActivity.this, TransQueryActivity.class);
        intent.putExtra("trans",new Gson().toJson(tranHistory));
        startActivity(intent);
    }
}