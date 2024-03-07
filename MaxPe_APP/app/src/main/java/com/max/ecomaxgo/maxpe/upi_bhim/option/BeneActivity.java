package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BeneAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BeneIfscAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BeneUpiAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.BeneVpa;

import java.util.ArrayList;

public class BeneActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    BeneAdapter beneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bene);
        ld = new LoadingDialog(BeneActivity.this);
        error = new ErrorDialog(BeneActivity.this);


        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("UPI ID"));
        tabLayout.addTab(tabLayout.newTab().setText("IFSC"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        beneAdapter  = new BeneAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount(), new BeneUpiAdapter.BeneOnItemClickListner() {
            @Override
            public void getOperatorPosition(String vpa) {
                act(vpa);
            }
        }, new BeneIfscAdapter.BeneOnItemClickListner() {
            @Override
            public void getOperatorPosition(String vpa) {
                act(vpa);
            }
        });
        viewPager.setAdapter(beneAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void act(String vpa) {
        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(BeneActivity.this).removevpa(vpa);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        if(reqType == UpiService.REQUEST_GET_VPA_REMOVE_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(BeneActivity.this).fetchVPAList();
            }
        }


        if(reqType == UpiService.REQUEST_GET_VPA_REMOVE){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(BeneActivity.this).fetchVPAList();
            }
        }
        else if(reqType == UpiService.REQUEST_GET_VPA_V3){
            if(ld.isShowing())
                ld.dismiss();
            Result<ArrayList<BeneVpa>> beneVpa = (Result<ArrayList<BeneVpa>>)data;
            if(beneVpa.getCode().equals("00")) {
                Upi.setBene(beneVpa.getData());
                beneAdapter.beneUpiFragment.beneUpiAdapter.updateList(Upi.getBeneVpa());
                beneAdapter.beneIfscFragment.beneIfscAdapter.updateList(Upi.getBeneIfsc());
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
        OliveUpiManager.getInstance(BeneActivity.this).setListener(this);
    }
}