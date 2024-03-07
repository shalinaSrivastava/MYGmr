package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.BeneVpa;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SendUPIActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    ErrorDialog error;

    TextView vpa;
    TextView upi;
    TextView name;
    EditText nickname;
    EditText amount;
    EditText remark;
    CheckBox add;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_upiactivity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(SendUPIActivity.this);
        error = new ErrorDialog(SendUPIActivity.this);

        vpa = findViewById(R.id.vpa);
        upi = findViewById(R.id.upi);
        name = findViewById(R.id.name);
        nickname = findViewById(R.id.nickname);
        amount = findViewById(R.id.amount);
        remark = findViewById(R.id.remark);
        add = findViewById(R.id.add);
        pay = findViewById(R.id.pay);

        initSet();
        pay.setOnClickListener(view -> pay());
    }

    BeneVpa beneVpa;
    String remak;
    String amountDecimal;
    private void pay() {
        String upii = upi.getText().toString().trim();
        String rname = name.getText().toString().trim();
        String nick = nickname.getText().toString().trim();

        String amt = amount.getText().toString().trim();
        if(amt == null || amt.equals("")) {
            Toast.makeText(this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        }

        remak = remark.getText().toString().trim();
        if(remak == null || remak.equals(""))
            remak = "";

        if(nick == null || nick.equals(""))
            nick = "";
        else
            nick = nick.toUpperCase();

        beneVpa = new BeneVpa();
        beneVpa.setVpa(upii);
        beneVpa.setName(rname);
        beneVpa.setNickname(nick);

        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        amountDecimal = df.format(Integer.parseInt(amt));

        ld.show();
        ld.setCancelable(false);
        if(add.getVisibility() == View.VISIBLE && add.isChecked()){
            OliveUpiManager.getInstance(SendUPIActivity.this).savevpa(upii,rname,nick);
        }else {
            process();
        }
    }

    private void process() {
        OliveUpiManager.getInstance(SendUPIActivity.this).initiatePay
                (Upi.getCustomerBankAccounts().get(0).
                                getAccounts().get(0),
                beneVpa,
                amountDecimal,
                remak,
                Upi.MerchantVpa,
                Upi.MerchantId,
                Upi.Submerchantid,
                Upi.MerchChanId,
                "P2P",
                "",
                "",
                "",
                "",
                "",
                "",
                "");
    }


    private void initSet() {
        vpa.setText(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa());
        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            if (extra.getString("bene") != null && extra.getString("bene").equals("old")) {

                BeneVpa beneVpa = new Gson().fromJson(extra.getString("beneVpa"), BeneVpa.class);
                upi.setText(beneVpa.getVpa());
                name.setText(beneVpa.getName());

                if (beneVpa.getNickname() == null || beneVpa.getNickname().equals("")) {
                    nickname.setVisibility(View.GONE);
                    nickname.setText("");
                } else {
                    nickname.setVisibility(View.VISIBLE);
                    nickname.setText(beneVpa.getNickname());
                }
                nickname.setEnabled(false);
                add.setVisibility(View.GONE);
            } else if (extra.getString("for") != null && extra.getString("for").equals("scan")) {
                upi.setText(extra.getString("vpa"));
                name.setText(extra.getString("name"));

                nickname.setEnabled(false);
                nickname.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
            }
            else
            {
                upi.setText(extra.getString("upi"));
                name.setText(extra.getString("name"));
                nickname.setText("");

                nickname.setVisibility(View.VISIBLE);
                nickname.setEnabled(true);
                add.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_SAVE_VPA_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(SendUPIActivity.this).fetchVPAList();
            }
            else{
                if(ld.isShowing())
                    ld.dismiss();
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_GET_VPA_V3){
            Result<ArrayList<BeneVpa>> beneVpa = (Result<ArrayList<BeneVpa>>)data;
            if(beneVpa.getCode().equals("00")) {
                Upi.setBene(beneVpa.getData());
                process();
            }else{
                if(ld.isShowing())
                    ld.dismiss();
                error.set(R.drawable.ic_baseline_error_outline_24,beneVpa.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_PAY){
            if(ld.isShowing())
                ld.dismiss();
            Result<String> rs = (Result<String>) data;
            if(rs.getCode().equals("00")) {
                startState(rs.getData(),rs.getResult());
            }
            else {
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
    }

    private void startState(String rfcode,String status) {
        Intent intent = new Intent(SendUPIActivity.this,StateActivity.class);
        intent.putExtra("status",status);
        intent.putExtra("rfcode",rfcode);
        intent.putExtra("vpa",vpa.getText().toString());
        intent.putExtra("upi",upi.getText().toString());
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("amt",amount.getText().toString());
        intent.putExtra("for","payupi");
        startActivity(intent);
        finishAffinity();
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
        OliveUpiManager.getInstance(SendUPIActivity.this).setListener(this);
    }
}