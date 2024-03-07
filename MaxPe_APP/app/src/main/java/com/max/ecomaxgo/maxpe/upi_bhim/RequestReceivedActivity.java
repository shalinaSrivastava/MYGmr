package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.SuccessDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.PendingReqVo;

import java.util.ArrayList;

public class RequestReceivedActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    SuccessDialog success;

    TextView vpa;
    TextView name;
    TextView upi;
    TextView amt;
    TextView expiry;
    TextView notes;
    TextView remark;
    Button approve;
    Button reject,block;
    PendingReqVo pendingReqVo;
    String upiID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_received);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(RequestReceivedActivity.this);
        error = new ErrorDialog(RequestReceivedActivity.this);
        success = new SuccessDialog(RequestReceivedActivity.this);

        vpa = findViewById(R.id.vpa);
        name = findViewById(R.id.name);
        upi = findViewById(R.id.upi);
        amt = findViewById(R.id.amt);
        expiry = findViewById(R.id.expiry);
        notes = findViewById(R.id.notes);
        remark = findViewById(R.id.remark);

        approve = findViewById(R.id.approve);
        reject = findViewById(R.id.reject);
        block= findViewById(R.id.block);

        initSet();
        approve.setOnClickListener(view -> approve());
        reject.setOnClickListener(view -> reject());
        block.setOnClickListener(view -> set_logOut());

    }

    private void approve() {
        String remrk = remark.getText().toString().trim();
        BeneVpa beneVpa = new BeneVpa();
        beneVpa.setVpa(pendingReqVo.getPayeeVpa());
        beneVpa.setName(pendingReqVo.getBeneName());
        beneVpa.setNickname("");

        ld.show();
        ld.setCancelable(false);

        OliveUpiManager.getInstance(RequestReceivedActivity.this).collectApprove(
                Upi.getCustomerBankAccounts().get(0).getAccounts().get(0),
                beneVpa,
                pendingReqVo.getAmount(),
                remrk,
                pendingReqVo.getTxnid(),
                pendingReqVo.getExpdate(),
                Upi.MerchantVpa,
                Upi.MerchantId,
                Upi.Submerchantid,
                Upi.MerchChanId,
                "P2P"
        );
    }

    private void reject() {
        ld.show();
        ld.setCancelable(false);

        OliveUpiManager.getInstance(RequestReceivedActivity.this).collectReject(pendingReqVo);
    }
    private void block() {
        Bundle extra = getIntent().getExtras();
        if(extra.getString("pendingReqVo") !=null ) {
            ld.show();
            ld.setCancelable(false);
            pendingReqVo = new Gson().fromJson(extra.getString("pendingReqVo"), PendingReqVo.class);
            name.setText(pendingReqVo.getBeneName());
            OliveUpiManager.getInstance(RequestReceivedActivity.this).collectBlock(upiID,"B","fraud");

        }
    }
    private void blockRequest() {
        Bundle extra = getIntent().getExtras();
        if(extra.getString("pendingReqVo") !=null ) {
            ld.show();
            ld.setCancelable(false);
            OliveUpiManager.getInstance(RequestReceivedActivity.this).collectBlock(upiID,"B","fraud");
            OliveUpiManager.getInstance(RequestReceivedActivity.this).collectReject(pendingReqVo);

        }
    }
    private void initSet() {
        Bundle extra = getIntent().getExtras();
        if(extra.getString("pendingReqVo") !=null ) {
            pendingReqVo = new Gson().fromJson(extra.getString("pendingReqVo"), PendingReqVo.class);
            vpa.setText(pendingReqVo.getPayerVpa());
            name.setText(pendingReqVo.getBeneName());
            upi.setText(pendingReqVo.getPayeeVpa());
            upiID =pendingReqVo.getPayeeVpa();
            int amount = Double.valueOf(pendingReqVo.getAmount()).intValue();
            amt.setText(String.valueOf(amount));
            expiry.setText(pendingReqVo.getExpdate());
            notes.setText(pendingReqVo.getNotes());
        }
    }


    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));

        if (ld.isShowing())
            ld.dismiss();

        if(reqType == UpiService.REQUEST_COLLECT_NOTIFICATION_PAY){
            Result<String> rs = (Result<String>) data;
            if(rs.getCode().equals("00")) {
                startState(rs.getData(),rs.getResult());
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_GET_REJECTED_NOTIFICATION)
        {
            Result<String> rs = (Result<String>) data;
            if(rs.getCode().equals("00")) {
                success.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult(),() -> action()).show();
                success.setCancelable(false);
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        } else if (reqType == UpiService.REQUEST_GET_PENDING_TRANSACTION_V3){
            Result<ArrayList<PendingReqVo>> pendingReqVos = (Result<ArrayList<PendingReqVo>>) data;
            if(pendingReqVos.getCode().equals("00")) {
                Upi.setPendingReqVos(pendingReqVos.getData());
                finish();
            }
            else {
                error.set(R.drawable.ic_baseline_check_circle_outline_24, pendingReqVos.getResult()).show();
            }
        }else if (reqType == UpiService.REQUEST_VPA_BLOCK_LIST_V3){
            finish();
        }else if (reqType == UpiService.REQUEST_COLLECT_BLOCK_V3){
            Toast.makeText(this," Blocked ",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void action() {
        if(success.isShowing())
            success.dismiss();
        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(RequestReceivedActivity.this).pendingNotifications();
    }


    private void startState(String rfcode,String result) {
        Intent intent = new Intent(RequestReceivedActivity.this,StateActivity.class);
        intent.putExtra("name",pendingReqVo.getBeneName());
        intent.putExtra("upi",pendingReqVo.getPayeeVpa());
        intent.putExtra("vpa",pendingReqVo.getPayerVpa());
        intent.putExtra("amt",pendingReqVo.getAmount());
        intent.putExtra("status",result);
        intent.putExtra("rfcode",rfcode);
        intent.putExtra("for","requestprocess");
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
        OliveUpiManager.getInstance(RequestReceivedActivity.this).setListener(this);
    }

    private void set_logOut() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.alert_block_layout, null);
        EditText reason_ed = (EditText) findViewById(R.id.reason_ed);

        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        deleteDialogView.findViewById(R.id.tvYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                block();
                deleteDialog.dismiss();
            }
        });

        deleteDialogView.findViewById(R.id.tvNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockRequest();
                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }
}