package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
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
import com.olive.upi.transport.model.CustomerBankAccounts;

import java.util.ArrayList;

public class CardActivity  extends AppCompatActivity implements OliveUpiEventListener {

    ArrayList<CustomerBankAccounts> customerBankAccounts;
    LoadingDialog ld;
    ErrorDialog error;
    SuccessDialog success;

    EditText cardno;
    EditText cardexp;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(CardActivity.this);
        error = new ErrorDialog(CardActivity.this);
        success = new SuccessDialog(CardActivity.this);

        cardno = findViewById(R.id.cardno);
        cardexp = findViewById(R.id.cardexp);
        start = findViewById(R.id.start);

      //  cardno.setText(Upi.temp[Upi.tempSelect][4]);
       // cardexp.setText(Upi.temp[Upi.tempSelect][6]);

        customerBankAccounts = Upi.getCustomerBankAccounts();
        if(cardno == null || cardno.equals("") && cardexp == null || cardexp.equals("")){

        }else {
            start.setOnClickListener(v -> create());
        }

    }

    private void create() {
        String cno = cardno.getText().toString();
        String cexp = cardexp.getText().toString();
        String binn = customerBankAccounts.get(0).getBankCode();
        Account acc = customerBankAccounts.get(0).getAccounts().get(0);
        if(cno.length() != 6)
            Toast.makeText(this,"invalid card no",Toast.LENGTH_SHORT).show();
        if(cexp.length() != 4)
            Toast.makeText(this,"invalid card exp",Toast.LENGTH_SHORT).show();

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(CardActivity.this).activateAccount(binn,acc,cno,cexp);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        if(reqType == UpiService.REQUEST_ACCOUNT_MOBILE_REG) {
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")){
                success.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult(),() -> action()).show();
                success.setCancelable(false);
            }
        }
        else if(reqType == UpiService.REQUEST_ALL_ACCOUNTS_V3)
        {
            ArrayList<CustomerBankAccounts> customerBankAccounts = (ArrayList<CustomerBankAccounts>)data;
            Upi.setCustomerBankAccounts(customerBankAccounts);

            Intent intent = new Intent(CardActivity.this, BhimDashBoardActivity.class);
            startActivity(intent);
            finishAffinity();
        }
    }

    private void action() {
        if(success.isShowing())
            success.dismiss();

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(CardActivity.this).fetchMyAccounts();
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        try {
            if (data != null) {
                Result<Void> rs = (Result<Void>) data;
                if (reqType == UpiService.REQUEST_ACCOUNT_MOBILE_REG) {
                    error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
                }
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
        OliveUpiManager.getInstance(CardActivity.this).setListener(this);
    }

}