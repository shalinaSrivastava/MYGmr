package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.SendIfscActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.SendUPIActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendIfscAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendUpiAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.BeneIfsc;
import com.olive.upi.transport.model.BeneVpa;

public class SendActivity extends AppCompatActivity {
    LoadingDialog ld;
    ErrorDialog error;

    SendAdapter sendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ld = new LoadingDialog(SendActivity.this);
        error = new ErrorDialog(SendActivity.this);


        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("UPI ID"));
        tabLayout.addTab(tabLayout.newTab().setText("IFSC"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        sendAdapter  = new SendAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount(), new SendUpiAdapter.SendOnItemClickListner() {
            @Override
            public void getOperatorPosition(BeneVpa beneVpa) {
                actVpa(beneVpa);
            }
        }, new SendIfscAdapter.SendOnItemClickListner() {
            @Override
            public void getOperatorPosition(BeneIfsc beneIfsc) {
                actIfsc(beneIfsc);
            }
        }
        );
        viewPager.setAdapter(sendAdapter);
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

    private void actVpa(BeneVpa beneVpa) {
        Intent intent = new Intent(SendActivity.this, SendUPIActivity.class);
        intent.putExtra("beneVpa",new Gson().toJson(beneVpa));
        intent.putExtra("bene", "old");
        startActivity(intent);
    }

    private void actIfsc(BeneIfsc beneIfsc) {
        Intent intent = new Intent(SendActivity.this, SendIfscActivity.class);
        intent.putExtra("beneIfsc",new Gson().toJson(beneIfsc));
        intent.putExtra("bene", "old");
        startActivity(intent);
    }

}