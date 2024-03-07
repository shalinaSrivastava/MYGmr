package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BankAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;

import java.util.ArrayList;

public class BankListActivity extends AppCompatActivity  implements OliveUpiEventListener {
    BankAdapter bankAdapter;

    RecyclerView recyclerView;
    TextView number;
    EditText filter;
    Result<ArrayList<Account>> account;
    ArrayList<Bank> banks;

    LoadingDialog ld;
    ErrorDialog error;
    MaxSharedPreference sp;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, SimActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(BankListActivity.this);
        error = new ErrorDialog(BankListActivity.this);
        recyclerView =  findViewById(R.id.bankListRecycler);
        number = findViewById(R.id.number);
        filter = findViewById(R.id.filter);
        sp = new MaxSharedPreference(this);

        //number.setText("+91 "+ Upi.temp[Upi.tempSelect][3].substring(2,12));
        number.setText("+91 "+ sp.getUserMobileNum());


        banks = Upi.getBanks();
        listSetup();
    }

    private void listSetup() {
        bankAdapter = new BankAdapter(BankListActivity.this, banks, bank -> select(bank));
        recyclerView.setAdapter(bankAdapter);
        bankAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    void filter(String text){
        ArrayList<Bank> temp = new ArrayList();
        for(Bank d: banks){
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        bankAdapter.updateList(temp);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        if(ld.isShowing())
            ld.dismiss();
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_FETCH_ACCOUNT_V3){
            account = (Result<ArrayList<Account>>)data;
            if(account.getCode().equals("00")) {
                Upi.setAccounts(account.getData());
                Intent intent = new Intent(this,BankActivity.class);
                startActivity(intent);
            }
            else {
                error.set(R.drawable.ic_baseline_account_balance_24,account.getResult()).show();
            }
        }
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        if(ld.isShowing())
            ld.dismiss();
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        try {
            if (data != null) {
                Result<Void> rs = (Result<Void>) data;
                if (reqType == UpiService.REQUEST_FETCH_ACCOUNT_V3) {
                    error.set(R.drawable.ic_baseline_account_balance_24,rs.getResult()).show();
                }
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24,"Empty").show();
            }
        }
        catch (Exception ex){
            error.set(R.drawable.ic_baseline_error_outline_24,"Error:"+data).show();
        }
    }

    private void select(Bank bank) {
        ld.show();
        ld.setCancelable(false);
        Upi.setSelectedBank(bank);
        OliveUpiManager.getInstance(BankListActivity.this).FetchAccountonIIN(bank.getIin());
    }

    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(BankListActivity.this).setListener(this);
    }


}