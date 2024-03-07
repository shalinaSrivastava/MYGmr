package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;

public class CreateUpiActivity extends AppCompatActivity{

    LoadingDialog ld;
    ErrorDialog error;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, DashboadActivity.class);
        startActivity(intent);
        finish();
    }

    Button create;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_upi);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(CreateUpiActivity.this);
        error = new ErrorDialog(CreateUpiActivity.this);
        create = findViewById(R.id.create);

        create.setOnClickListener(view -> {start();});
    }

    private void start() {
      //  Intent intent = new Intent(this, BankListActivity.class);
        Intent intent = new Intent(this, SimActivity.class);
        startActivity(intent);
    }


}