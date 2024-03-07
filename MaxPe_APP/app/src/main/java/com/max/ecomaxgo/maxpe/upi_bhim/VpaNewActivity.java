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
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.PayerInfo;

public class VpaNewActivity extends AppCompatActivity implements OliveUpiEventListener {

    EditText vpa;
    Button verify;
    LoadingDialog ld;
    ErrorDialog error;
    String screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpa_new);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(VpaNewActivity.this);
        error = new ErrorDialog(VpaNewActivity.this);

        Bundle extra = getIntent().getExtras();
        screen = extra.getString("for");

        vpa = findViewById(R.id.vpa);
        verify = findViewById(R.id.verify);
        verify.setOnClickListener(view -> verify());
    }

    private void verify() {
        String vp = vpa.getText().toString();
        if(vp == null || vp.equals("")) {
            Toast.makeText(this, "Please Enter UPI ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(vp.length() <= 3 || vp.length() > 20){
            Toast.makeText(this,"Please Enter Valid UPI ID",Toast.LENGTH_SHORT).show();
            return;
        }

        PayerInfo payerinfo = new PayerInfo();
        payerinfo.setAccountnumber(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getAccRefNumber());
        payerinfo.setPayervpa(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa());
        payerinfo.setName(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getName());
//        payerinfo.setMcc(Upi.MCC);

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(VpaNewActivity.this).checkvpa(vp,payerinfo);
    }


    private void startSave(String name) {
        if(screen.equals("bene")) {
            Intent intent = new Intent(VpaNewActivity.this, VpaFetchActivity.class);
            intent.putExtra("upi", vpa.getText().toString());
            intent.putExtra("name", name);
            startActivityForResult(intent, 1);
        }
        else if(screen.equals("send"))
        {
            Intent intent = new Intent(VpaNewActivity.this, SendUPIActivity.class);
            intent.putExtra("upi",vpa.getText().toString());
            intent.putExtra("name",name);
            startActivity(intent);
        }
        else if(screen.equals("rsend"))
        {
            Intent intent = new Intent(VpaNewActivity.this, RequestSendActivity.class);
            intent.putExtra("upi",vpa.getText().toString());
            intent.putExtra("name",name);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        if(reqType == UpiService.REQUEST_VERIFY_VPA2){
            Result<String> rs = (Result<String>) data;
            if(rs.getCode().equals("00")) {
                startSave(rs.getData());

            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
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
        OliveUpiManager.getInstance(VpaNewActivity.this).setListener(this);
    }
}