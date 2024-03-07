package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.SuccessDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.CustomerBankAccounts;

import java.util.ArrayList;

public class AccountLinkActivity extends AppCompatActivity implements OliveUpiEventListener {
    ArrayList<CustomerBankAccounts> customerBankAccounts;
    LoadingDialog ld;
    ErrorDialog error;
    SuccessDialog success;
    TextView name;
    TextView acc;
    TextView ifsc;
    TextView type;
    ImageView blogo;
    TextView bname;
    TextView vpa;
    LinearLayout pinset;

    Button upi;
    Button link;
    Button mpin;
    Button done;
    Account account;
    Bank bank;


    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(AccountLinkActivity.this).setListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_link);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(AccountLinkActivity.this);
        error = new ErrorDialog(AccountLinkActivity.this);
        success = new SuccessDialog(AccountLinkActivity.this);

        name = findViewById(R.id.name);
        acc = findViewById(R.id.acc);
        ifsc = findViewById(R.id.ifsc);
        type = findViewById(R.id.type);
        vpa = findViewById(R.id.vpa);
        blogo = findViewById(R.id.bankLogo);
        bname = findViewById(R.id.bankName);
        pinset = findViewById(R.id.pinset);
        upi = findViewById(R.id.upi);
        link = findViewById(R.id.link);
        mpin = findViewById(R.id.mpin);
        done = findViewById(R.id.done);

        account = Upi.getAccounts().get(0);
        bank = Upi.getSelectedBank();

        name.setText(account.getName());
        acc.setText(account.getMaskedAccnumber());
        ifsc.setText(account.getIfsc());
        type.setText(account.getType());
        vpa.setText(account.getVpa());
        bname.setText(bank.getName());

        Glide.with(getApplicationContext())
                .load(bank.getLogo())
                .centerInside()
                .placeholder(R.drawable.ic_baseline_account_balance_24)
                .into(blogo);

        if(account.getMbeba().equals("Y"))
        {
            done.setVisibility(View.VISIBLE);
            mpin.setVisibility(View.VISIBLE);
            pinset.setVisibility(View.VISIBLE);
            link.setText("Reset MPin");
        }

        upi.setOnClickListener(view -> updateUPI());
        link.setOnClickListener(view -> link());
        mpin.setOnClickListener(view -> mpin());
        done.setOnClickListener(view -> action());

    }

    private void mpin() {
        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(AccountLinkActivity.this).changeMpin(bank.getIin(), account);
    }

    private void link() {
        if(Upi.getCustomerBankAccounts() != null)
            Upi.setCustomerBankAccounts(account,bank);
        Intent intent = new Intent(this,CardActivity.class);
        startActivity(intent);
    }

    private void updateUPI() {
        Intent intent = new Intent(this,VpaActivity.class);
        intent.putExtra("inte","link");
        startActivity(intent);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        if(reqType == UpiService.REQUEST_GET_CHANGE_MPIN) {
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")){
                error.set(R.drawable.ic_baseline_check_circle_outline_24,rs.getResult()).show();
//                success.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult(),() -> action()).show();
//                success.setCancelable(false);
            }
        }
    }

    private void action() {
        if(success.isShowing())
            success.dismiss();
        if (vpa.getText().toString().equals("")){
            Toast.makeText(AccountLinkActivity.this,"Please Change UPI ID ",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(AccountLinkActivity.this, DashboadActivity.class);
            startActivity(intent);
            finishAffinity();
        }
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));

        error.set(R.drawable.ic_baseline_error_outline_24,new Gson().toJson(data)).show();
        if(ld.isShowing())
            ld.dismiss();
        try {
            if (data != null) {
                Result<Void> rs = (Result<Void>) data;
                if(rs.getCode().equals("10001"))
                    return;
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24,"Empty").show();
            }
        }
        catch (Exception ex){
            error.set(R.drawable.ic_baseline_error_outline_24,"Error:"+data).show();
        }
    }

}