package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.AccountAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.AccountOptionDialog;
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

public class VpaActivity extends AppCompatActivity implements OliveUpiEventListener {

    LinearLayout exist;
    EditText vpa;
    TextView ovpa;
    Button link;
    LoadingDialog ld;
    ErrorDialog error;
    SuccessDialog success;
    Account account;
    Result<ArrayList<CustomerBankAccounts>> customerBankAccounts;
    String new_vpa;
    String inte;
    MaxSharedPreference sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpa);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(VpaActivity.this);
        error = new ErrorDialog(VpaActivity.this);
        success = new SuccessDialog(VpaActivity.this);

        exist = findViewById(R.id.exist);
        vpa = findViewById(R.id.vpa);
        ovpa = findViewById(R.id.ovpa);
        link = findViewById(R.id.link);
         sp = new MaxSharedPreference(this);
        Bundle extra = getIntent().getExtras();
        inte = extra.getString("inte");
        if(inte != null && (inte.equals("dash") || inte.equals("dashc")))
            account = Upi.getCustomerBankAccounts().get(0).getAccounts().get(0);
        else
            account = Upi.getAccounts().get(extra.getInt("position"));

        if(account.getVpa() == null || account.getVpa().equals(""))
        {

            exist.setVisibility(View.GONE);
            ovpa.setText("");
            vpa.setText(sp.getBHIM_Vpa());
        }
        else{
            exist.setVisibility(View.VISIBLE);
            ovpa.setText(account.getVpa());

            new_vpa = account.getVpa();
            new_vpa = new_vpa.substring(0,new_vpa.indexOf("@"));
            vpa.setText(new_vpa);
        }

        link.setOnClickListener(view -> start());
    }

    private void start() {
        String vp = vpa.getText().toString();
        if(vp.equals("")) {
            Toast.makeText(this, "Please Enter UPI ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(vp.length() <= 3 || vp.length() > 20){
            Toast.makeText(this,"Please Enter Valid UPI ID",Toast.LENGTH_SHORT).show();
            return;
        }

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(VpaActivity.this).updateVPA(vp,account);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));

        if(ld.isShowing())
            ld.dismiss();
        if(reqType == UpiService.REQUEST_SAVE_ACCOUNT_V3){
            customerBankAccounts = (Result<ArrayList<CustomerBankAccounts>>)data;
            if(customerBankAccounts.getCode().equals("00")) {
                Upi.setCustomerBankAccounts(customerBankAccounts.getData());
                success.set(R.drawable.ic_baseline_check_circle_outline_24, customerBankAccounts.getResult(),() -> action()).show();
                success.setCancelable(false);
                MaxSharedPreference sp = new MaxSharedPreference(this);
                if (sp.getDEREGISTER().equals( "true")){
                    sp.setDEREGISTER("");
                    sp.setBHIM_Vpa(vpa.getText().toString()+"@axis");
                }else {
                    sp.setBHIM_Vpa(vpa.getText().toString());
                }


            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,customerBankAccounts.getResult()).show();
            }
        }
    }

    private void action() {
        if(success.isShowing())
            success.dismiss();
        if (inte != null && inte.equals("link")) {
            Upi.getAccounts().get(0).setVpa(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa());
            Intent intent = new Intent(this, AccountLinkActivity.class);
            startActivity(intent);
        }
        else if (inte != null && inte.equals("dashc")) {
            Intent intent = new Intent(this, DashboadActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, CardActivity.class);
            startActivity(intent);
        }
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
                if (reqType == UpiService.REQUEST_SAVE_ACCOUNT_V3) {
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
        OliveUpiManager.getInstance(VpaActivity.this).setListener(this);
    }

}