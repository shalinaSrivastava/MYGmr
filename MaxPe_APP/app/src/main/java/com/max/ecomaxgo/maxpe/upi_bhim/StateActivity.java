package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.PendingReqVo;

import java.util.ArrayList;

public class StateActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    ErrorDialog error;
    TextView name;
    TextView upi;
    TextView vpa;
    TextView amt;
    TextView status;
    ImageView simg;
    TextView cdr;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(StateActivity.this);
        error = new ErrorDialog(StateActivity.this);

        name = findViewById(R.id.name);
        upi = findViewById(R.id.upi);
        vpa = findViewById(R.id.vpa);
        amt = findViewById(R.id.amt);
        status = findViewById(R.id.status);
        simg = findViewById(R.id.simg);
        cdr = findViewById(R.id.cdr);
        done = findViewById(R.id.done);

        done.setOnClickListener(view -> done());
        initSet();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startDash();
    }

    void startDash(){
        Intent intent = new Intent(StateActivity.this, DashboadActivity.class);
        startActivity(intent);
        finish();
    }
    private void done() {
        startDash();
    }

    private void initSet() {
        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            if (extra.getString("for").equals("requestprocess")) {
                name.setText(extra.getString("name"));
                upi.setText(extra.getString("upi"));
                vpa.setText(extra.getString("vpa"));
                int amount = Double.valueOf(extra.getString("amt")).intValue();
                amt.setText(String.valueOf(amount));
                cdr.setText("paid by account");

                String st = extra.getString("status").toUpperCase();
                if (st.equals("SUCCESS")) {
                    simg.setImageResource(R.drawable.ic_baseline_check_circle_24);
                }
                else {
                    simg.setImageResource(R.drawable.ic_baseline_error_24);
                }
                status.setText(extra.getString("status"));
                startRequestDat();
            }
            else if (extra.getString("for").equals("requestsend")) {
                name.setText(extra.getString("name"));
                upi.setText(extra.getString("upi"));
                vpa.setText(extra.getString("vpa"));
                int amount = Double.valueOf(extra.getString("amt")).intValue();
                amt.setText(String.valueOf(amount));
                cdr.setText("credit account");

                String st = extra.getString("status").toUpperCase();
                if (st.equals("ACCEPTED COLLECT REQUEST")) {
                    simg.setImageResource(R.drawable.ic_baseline_check_circle_24);
                }
                else {
                    simg.setImageResource(R.drawable.ic_baseline_error_24);
                }
                status.setText(extra.getString("status"));
                startRequestDat();
            }
            else if(extra.getString("for").equals("payupi")){

                name.setText(extra.getString("name"));
                upi.setText(extra.getString("upi"));
                vpa.setText(extra.getString("vpa"));
                int amount = Double.valueOf(extra.getString("amt")).intValue();
                amt.setText(String.valueOf(amount));
                cdr.setText("paid by account");

                String st = extra.getString("status").toUpperCase();
                if (st.equals("SUCCESS")) {
                    simg.setImageResource(R.drawable.ic_baseline_check_circle_24);
                }
                else {
                    simg.setImageResource(R.drawable.ic_baseline_error_24);
                }
                status.setText(extra.getString("status"));
            }
            else if(extra.getString("for").equals("payifsc")){

                name.setText(extra.getString("name"));
                upi.setText(extra.getString("upi"));
                vpa.setText(extra.getString("vpa"));
                int amount = Double.valueOf(extra.getString("amt")).intValue();
                amt.setText(String.valueOf(amount));
                cdr.setText("paid by account");

                String st = extra.getString("status").toUpperCase();
                if (st.equals("SUCCESS")) {
                    simg.setImageResource(R.drawable.ic_baseline_check_circle_24);
                }
                else {
                    simg.setImageResource(R.drawable.ic_baseline_error_24);
                }
                status.setText(extra.getString("status"));
            }
        }
    }

    private void startRequestDat() {
        OliveUpiManager.getInstance(StateActivity.this).pendingNotifications();
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));

        if (reqType == UpiService.REQUEST_GET_PENDING_TRANSACTION_V3){
            Result<ArrayList<PendingReqVo>> pendingReqVos = (Result<ArrayList<PendingReqVo>>) data;
            if(pendingReqVos.getCode().equals("00")) {
                Upi.setPendingReqVos(pendingReqVos.getData());
            }
            else {
                error.set(R.drawable.ic_baseline_check_circle_outline_24, pendingReqVos.getResult()).show();
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
        OliveUpiManager.getInstance(StateActivity.this).setListener(this);
    }

}