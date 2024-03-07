package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.addmoney.AddMoneyActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.AccountAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.option.BeneActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.Collectbeneblock;
import com.olive.upi.transport.model.CustomerBankAccounts;
import com.olive.upi.transport.model.CustomerVpa;
import com.olive.upi.transport.model.TranHistory;
import com.olive.upi.transport.model.sdk.SDKHandshake;

import java.util.ArrayList;
import java.util.Date;

public class BhimActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    ErrorDialog error;
    MaxSharedPreference sp;
    TelephonyManager telephonyManager;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    TextView msg;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhim);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        progressBar = findViewById(R.id.progress_bhim);
        ld = new LoadingDialog(BhimActivity.this);
        error = new ErrorDialog(BhimActivity.this);

        sp = new MaxSharedPreference(this);
        msg = findViewById(R.id.msg_bhim);
        progressBar.setVisibility(View.VISIBLE);
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        initOlive();

    }
    private void initOlive() {
       // msg.setText("initiate SDK");
        SDKHandshake sdkHandshake = new SDKHandshake();
        //sdkHandshake.setDeviceid(telephonyManager.getDeviceId());
        sdkHandshake.setDeviceid("911498058335351");
        sdkHandshake.setSubscriptionId(String.valueOf(Upi.subscriptionId));
        sdkHandshake.setCustName("ghfygfv");
        sdkHandshake.setMerchId(Upi.MerchantId);
        sdkHandshake.setMerchChanId(Upi.MerchChanId);
        sdkHandshake.setSubmerchantid(Upi.Submerchantid);
        sdkHandshake.setUnqTxnId("" + new Date().getTime());
        sdkHandshake.setMerchanttoken(sp.getBHIM_Token());
        OliveUpiManager.getInstance(BhimActivity.this).initiateSDK(sdkHandshake);
    }
    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_SDK_HANDSHAKE) {
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(BhimActivity.this).fetchListBanks();
            }
            else msg.setText("SDK failed:handshake");
        }
        else if(reqType == UpiService.REQUEST_LIST_BANKS){
            Result<ArrayList<Bank>> banks = (Result<ArrayList<Bank>>)data;
            if(banks.getCode().equals("00")) {
                Upi.setBanks(banks.getData());
                msg.setText("fetching linked accounts");
                OliveUpiManager.getInstance(BhimActivity.this).fetchMyAccounts();
            }
            else msg.setText("SDK failed:list bank");
        }
        else if(reqType == UpiService.REQUEST_ALL_ACCOUNTS_V3)
        {
            ArrayList<CustomerBankAccounts> customerBankAccounts = (ArrayList<CustomerBankAccounts>)data;
            Upi.setCustomerBankAccounts(customerBankAccounts);

            if(customerBankAccounts.size() < 1)
            {
                Intent intent = new Intent(this, CreateUpiActivity.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(this, BhimDashBoardActivity.class);
                startActivity(intent);
            }
            finishAffinity();
        }
    }
    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType " + reqType + " data " + new Gson().toJson(data));
        msg.setText("SDK Error:"+new Gson().toJson(data));
    }
    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(BhimActivity.this).setListener(this);
    }
}