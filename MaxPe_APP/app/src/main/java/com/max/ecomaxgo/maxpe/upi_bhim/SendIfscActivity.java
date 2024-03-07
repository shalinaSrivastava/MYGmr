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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.SendBankListDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.BeneIfsc;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.BeneVpa;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SendIfscActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    LinearLayout bank;
    TextView bankName;
    ImageView bankLogo;
    SendBankListDialog sendBankListDialog;

    TextView vpa;
    EditText name;
    EditText account;
    EditText ifsc;
    EditText amount;
    EditText remark;
    CheckBox add;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_ifsc);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        sendBankListDialog = new SendBankListDialog(SendIfscActivity.this);
        ld = new LoadingDialog(SendIfscActivity.this);
        error = new ErrorDialog(SendIfscActivity.this);

        bank = findViewById(R.id.bank);
        bankName = findViewById(R.id.bankName);
        bankLogo = findViewById(R.id.bankLogo);

        vpa = findViewById(R.id.vpa);
        name = findViewById(R.id.name);
        account = findViewById(R.id.account);
        ifsc = findViewById(R.id.ifsc);
        amount = findViewById(R.id.amount);
        remark = findViewById(R.id.remark);
        add = findViewById(R.id.add);
        pay = findViewById(R.id.pay);


        pay.setOnClickListener(view -> pay());
        //bank.setOnClickListener(view -> selectBank());
        bank.setVisibility(View.GONE);

        initSet();

    }

    BeneVpa beneVpa;
    String remak;
    String amountDecimal;
    private void pay() {
        String rname = name.getText().toString().trim();
        if(rname == null || rname.equals("")) {
            Toast.makeText(this, "Please Enter Name of Account holder", Toast.LENGTH_SHORT).show();
            return;
        }

        String acc = account.getText().toString().trim();
        if(acc == null || acc.equals("")) {
            Toast.makeText(this, "Please Enter Account Number", Toast.LENGTH_SHORT).show();
            return;
        }

        String ifs = ifsc.getText().toString().trim();
        if(ifs == null || ifs.equals("")) {
            Toast.makeText(this, "Please Enter IFSC Code", Toast.LENGTH_SHORT).show();
            return;
        }

        String amt = amount.getText().toString().trim();
        if(amt == null || amt.equals("")) {
            Toast.makeText(this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        }

        remak = remark.getText().toString().trim();
        if(remak == null || remak.equals(""))
            remak = "";

        ifs = ifs.toUpperCase();
        rname = rname.toUpperCase();

        String upi = acc+"@"+ifs+".ifsc.npci";

        beneVpa = new BeneVpa();
        beneVpa.setVpa(upi);
        beneVpa.setName(rname);
        beneVpa.setNickname("");

        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        amountDecimal = df.format(Integer.parseInt(amt));

        ld.show();
        ld.setCancelable(false);
        if(add.getVisibility() == View.VISIBLE && add.isChecked()){
            OliveUpiManager.getInstance(SendIfscActivity.this).savevpa(upi,rname,"");
        }
        else {
            process();
        }
    }

    private void process() {
        OliveUpiManager.getInstance(SendIfscActivity.this).initiatePay(
                Upi.getCustomerBankAccounts().get(0).getAccounts().get(0),
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

                BeneIfsc beneIfsc = new Gson().fromJson(extra.getString("beneIfsc"), BeneIfsc.class);
                name.setText(beneIfsc.getName());
                account.setText(beneIfsc.getAccount());
                ifsc.setText(beneIfsc.getIfsc());

                name.setEnabled(false);
                account.setEnabled(false);
                ifsc.setEnabled(false);
                add.setVisibility(View.GONE);
            }
        }
        else{
            name.setText("");
            account.setText("");
            ifsc.setText("");

            name.setEnabled(true);
            account.setEnabled(true);
            ifsc.setEnabled(true);
            add.setVisibility(View.VISIBLE);
        }

    }

    private void selectBank() {
        sendBankListDialog.set(new SendBankListDialog.ActOnItemClickListner() {
            @Override
            public void act(Bank bank) {
                bankName.setText(bank.getName());
                Glide.with(SendIfscActivity.this)
                        .load(bank.getLogo())
                        .centerInside()
                        .placeholder(R.drawable.ic_baseline_account_balance_24)
                        .into(bankLogo);
                sendBankListDialog.dismiss();

            }
        }).show();
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_SAVE_VPA_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(SendIfscActivity.this).fetchVPAList();
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
        Intent intent = new Intent(SendIfscActivity.this,StateActivity.class);
        intent.putExtra("status",status);
        intent.putExtra("rfcode",rfcode);
        intent.putExtra("vpa",vpa.getText().toString());
        intent.putExtra("upi",account.getText().toString()+" - "+ifsc.getText().toString());
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("amt",amount.getText().toString());
        intent.putExtra("for","payifsc");
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
        OliveUpiManager.getInstance(SendIfscActivity.this).setListener(this);
    }
}