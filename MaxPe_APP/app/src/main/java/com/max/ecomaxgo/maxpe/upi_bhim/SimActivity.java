package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
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
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SimAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.ApiUPI;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIChecksum;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIInterface;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.max.ecomaxgo.maxpe.util.Constant;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.CustomerBankAccounts;
import com.olive.upi.transport.model.sdk.SDKHandshake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SimActivity extends AppCompatActivity implements OliveUpiEventListener {

    List<SubscriptionInfo> subscription;
    RecyclerView recyclerView;
    LoadingDialog ld;
    SimAdapter simAdapter;
    LinearLayout ss;
    TextView number;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    TelephonyManager telephonyManager;
    TextView msg;
    MaxSharedPreference sp;
    ProgressBar progressBar;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, CreateUpiActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(SimActivity.this);
        progressBar = findViewById(R.id.progress_sim);
        msg = findViewById(R.id.msg_sim_tv);

        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        preferences = getSharedPreferences("max_info", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.apply();
        progressBar.setVisibility(View.GONE);

        recyclerView = findViewById(R.id.SimListRecycler);
        ss = findViewById(R.id.ss);
        number = findViewById(R.id.number);

        sp = new MaxSharedPreference(this);

       // number.setText("+91 " + Upi.temp[Upi.tempSelect][3].substring(2, 12));
       number.setText("+91 " + sp.getUserMobileNum());


        init();

    }

    @SuppressLint("NewApi")
    private void act(int pos) {
        Upi.subscriptionId = subscription.get(pos).getSubscriptionId();
        ld.show();
        ld.setCancelable(false);

     //   editor.putString("tempSelect", String.valueOf(Upi.tempSelect));
        editor.putString("subscriptionId", String.valueOf(Upi.subscriptionId));
        editor.commit();
        checksum();

    }

    @SuppressLint("NewApi")
    public void init() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, 89);
            }
        }

        SubscriptionManager subscriptionManager = getSystemService(SubscriptionManager.class);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        subscription = subscriptionManager.getActiveSubscriptionInfoList();
        simAdapter = new SimAdapter(SimActivity.this, subscription, pos -> act(pos));
        recyclerView.setAdapter(simAdapter);
        simAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
    }
    private void checksum() {

        UPIInterface api = ApiUPI.getUPIClient().create(UPIInterface.class);


        Call call = api.getChecksum(Constant.skey,sp.getUserMobileNum(), sp.getUserToken());

        call.enqueue(new Callback<UPIChecksum>() {

            @Override
            public void onResponse(Call<UPIChecksum> call, Response<UPIChecksum> response) {
                ld.show();
                ld.setCancelable(false);
                if(response.isSuccessful()){

                    UPIChecksum data = response.body();
                    String merchantauthtoken = data.getData().getMerchantauthtoken();
                    initOlive(merchantauthtoken);
                    sp.setBHIM_Token(merchantauthtoken);

                }

            }

            @Override
            public void onFailure(Call<UPIChecksum> call, Throwable t) {
                Toast.makeText(SimActivity.this,""+t, Toast.LENGTH_SHORT);

            }
        });
    }

    private void initOlive(String merchantauthtoken) {
        msg.setText("initiate SDK");
        SDKHandshake sdkHandshake = new SDKHandshake();
       //sdkHandshake.setDeviceid(telephonyManager.getDeviceId());
         sdkHandshake.setDeviceid("911498058335351");
        sdkHandshake.setSubscriptionId(String.valueOf(Upi.subscriptionId));
        sdkHandshake.setCustName("Shanu");
        sdkHandshake.setMerchId(Upi.MerchantId);
        sdkHandshake.setMerchChanId(Upi.MerchChanId);
        sdkHandshake.setSubmerchantid(Upi.Submerchantid);
        sdkHandshake.setUnqTxnId("" + new Date().getTime());
        sdkHandshake.setMerchanttoken(merchantauthtoken);
        OliveUpiManager.getInstance(SimActivity.this).initiateSDK(sdkHandshake);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));
        if(reqType != UpiService.REQUEST_GET_TRANSACTION_HISTORY_V3) {
            if (ld.isShowing())
                ld.show();
        }

        if(reqType == UpiService.REQUEST_SDK_HANDSHAKE) {
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(SimActivity.this).fetchListBanks();
            }
            else {
                msg.setVisibility(View.VISIBLE);
                msg.setText("SDK failed:handshake"+"("+rs+")");}
        }
        else if(reqType == UpiService.REQUEST_LIST_BANKS){
            Result<ArrayList<Bank>> banks = (Result<ArrayList<Bank>>)data;
            if(banks.getCode().equals("00")) {
                Upi.setBanks(banks.getData());
             //  msg.setText("fetching linked accounts");
                OliveUpiManager.getInstance(SimActivity.this).fetchMyAccounts();
            }
         // else msg.setText("SDK failed:list bank");
        }
        else if(reqType == UpiService.REQUEST_ALL_ACCOUNTS_V3)
        {
            ArrayList<CustomerBankAccounts> customerBankAccounts = (ArrayList<CustomerBankAccounts>)data;
            Upi.setCustomerBankAccounts(customerBankAccounts);

            Intent intent = new Intent(SimActivity.this, BankListActivity.class);
            startActivity(intent);
            finishAffinity();
            ld.dismiss();
        }
    }
    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType " + reqType + " data " + new Gson().toJson(data));
     //   msg.setText("SDK Error:"+new Gson().toJson(data));
    }
    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(SimActivity.this).setListener(this);
    }


}