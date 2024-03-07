package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.QueryAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

public class QueryActivity extends AppCompatActivity {

    LoadingDialog ld;
    ErrorDialog error;

    ImageView empty;
    RecyclerView recyclerView;
    QueryAdapter queryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        ld = new LoadingDialog(QueryActivity.this);
        error = new ErrorDialog(QueryActivity.this);

        recyclerView = findViewById(R.id.vpaRecycler);
        empty = findViewById(R.id.empty);

        if(Upi.getQuery().size()<1)
            empty.setVisibility(View.VISIBLE);
        listSetup();
    }

    private void listSetup() {
        String myvpa = Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa();
        queryAdapter = new QueryAdapter(QueryActivity.this,myvpa, Upi.getQuery(), new QueryAdapter.QueryOnItemClickListner() {
            @Override
            public void getOperatorPosition(int pos) {

            }
        });
        recyclerView.setAdapter(queryAdapter);
        queryAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

}