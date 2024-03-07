package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.RequestReceivedActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.RequestSendActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.RequestAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.RequestReceivedAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.RequestSendAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.PendingReqVo;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    ViewPager viewPager;
    TabLayout tabLayout;
    TabLayout.Tab tabs;
    RequestAdapter requestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ld = new LoadingDialog(RequestActivity.this);
        error = new ErrorDialog(RequestActivity.this);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Send"));
        tabLayout.addTab(tabLayout.newTab().setText("Received"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        if(Upi.getPendingReqVos() == null)
            Upi.setPendingReqVos(new ArrayList<PendingReqVo>());

        requestAdapter  = new RequestAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount(), new RequestSendAdapter.RequestOnItemClickListner() {
            @Override
            public void getOperatorPosition(BeneVpa beneVpa) {
                actSend(beneVpa);
            }
        }, new RequestReceivedAdapter.RequestOnItemClickListner() {
            @Override
            public void getOperatorPosition(PendingReqVo pendingReqVo) {
                actReceived(pendingReqVo);
            }
        });
        viewPager.setAdapter(requestAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabs = tab;
                if(tabs.getPosition() == 1) {
                    ld.show();
                    ld.setCancelable(false);
                    startRequestDat();
                }
                else
                    viewPager.setCurrentItem(tabs.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void startRequestDat() {
        OliveUpiManager.getInstance(RequestActivity.this).pendingNotifications();
    }


    private void actSend(BeneVpa beneVpa) {
        Intent intent = new Intent(RequestActivity.this, RequestSendActivity.class);
        intent.putExtra("beneVpa",new Gson().toJson(beneVpa));
        intent.putExtra("bene", "old");
        startActivity(intent);
    }

    private void actReceived(PendingReqVo pendingReqVo) {
        Intent intent = new Intent(RequestActivity.this, RequestReceivedActivity.class);
        intent.putExtra("pendingReqVo",new Gson().toJson(pendingReqVo));
        startActivity(intent);
    }
    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));
        if (ld.isShowing())
            ld.dismiss();

        if (reqType == UpiService.REQUEST_GET_PENDING_TRANSACTION_V3) {
            Result<ArrayList<PendingReqVo>> pendingReqVos = (Result<ArrayList<PendingReqVo>>) data;
            if (pendingReqVos.getCode().equals("00")) {
                Upi.setPendingReqVos(pendingReqVos.getData());
                requestAdapter.requestReceivedFragment.requestReceivedAdapter.updateList(Upi.getPendingReqVos());
                viewPager.setCurrentItem(tabs.getPosition());
            } else {
                error.set(R.drawable.ic_baseline_check_circle_outline_24, pendingReqVos.getResult()).show();
            }
        }
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        try{
            if(data != null) {
                Result<Void> rs = (Result<Void>) data;
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24,"Empty").show();
            }
        }
        catch (Exception ex){
            error.set(R.drawable.ic_baseline_error_outline_24,"Error:"+data).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(RequestActivity.this).setListener(this);
    }
}