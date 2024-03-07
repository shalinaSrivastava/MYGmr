package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

import java.util.ArrayList;

public class VpaFetchActivity extends AppCompatActivity implements OliveUpiEventListener {

    TextView vpa;
    TextView name;
    EditText nick;
    Button save;
    LoadingDialog ld;
    ErrorDialog error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpa_fetch);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(VpaFetchActivity.this);
        error = new ErrorDialog(VpaFetchActivity.this);

        vpa = findViewById(R.id.vpa);
        name = findViewById(R.id.name);
        nick = findViewById(R.id.nick);
        save = findViewById(R.id.save);
        save.setOnClickListener(view -> save());

        Bundle extra = getIntent().getExtras();
        vpa.setText(extra.getString("upi"));
        name.setText(extra.getString("name"));
//        nick.setText(extra.getString("name"));
    }

    private void save() {
        String upi = vpa.getText().toString();
        String rname = name.getText().toString();
        String nickname = nick.getText().toString();
        if(nickname == null || nickname.equals(""))
            nickname = "";
        else
            nickname = nickname.toUpperCase();

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(VpaFetchActivity.this).savevpa(upi,rname,nickname);
    }



    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_SAVE_VPA_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(VpaFetchActivity.this).fetchVPAList();
            }
            else{
                if(ld.isShowing())
                    ld.dismiss();
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_GET_VPA_V3){
            if(ld.isShowing())
                ld.dismiss();
            Result<ArrayList<BeneVpa>> beneVpa = (Result<ArrayList<BeneVpa>>)data;
            if(beneVpa.getCode().equals("00")) {
                Upi.setBene(beneVpa.getData());
                finish();
            }else{
                error.set(R.drawable.ic_baseline_error_outline_24,beneVpa.getResult()).show();
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
        OliveUpiManager.getInstance(VpaFetchActivity.this).setListener(this);
    }
}