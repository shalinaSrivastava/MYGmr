package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RequestSendActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    ErrorDialog error;

    TextView mvpa;
    TextView vpa;
    TextView name;
    EditText nickname;
    EditText amount;
    EditText remark;
    EditText pdate;
    ImageView pdt;
    CheckBox add;
    Button rsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_send);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(RequestSendActivity.this);
        error = new ErrorDialog(RequestSendActivity.this);

        mvpa = findViewById(R.id.mvpa);
        vpa = findViewById(R.id.vpa);
        name = findViewById(R.id.name);
        nickname = findViewById(R.id.nickname);
        amount = findViewById(R.id.amount);
        remark = findViewById(R.id.remark);
        pdate = findViewById(R.id.pdate);
        pdt = findViewById(R.id.pdt);
        add = findViewById(R.id.add);
        rsend = findViewById(R.id.rsend);

        initSet();
        rsend.setOnClickListener(view -> rsend());
        pdt.setOnClickListener(view -> pdt());
        pdate.setEnabled(false);
    }

    private void pdt() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(Calendar.HOUR,i);
                calendar.set(Calendar.MINUTE,i1);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                pdate.setText(simpleDateFormat.format(calendar.getTime())+":00");
            }
        };

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);

                new TimePickerDialog(RequestSendActivity.this,
                        timeSetListener,
                        calendar.get(Calendar.HOUR),
                        calendar.get(Calendar.MINUTE),
                        true
                ).show();

            }
        };

        new DatePickerDialog(RequestSendActivity.this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    String upi;
    String remak;
    String amountDecimal;
    String datetime;
    private void rsend() {
        upi = vpa.getText().toString().trim();
        String rname = name.getText().toString().trim();
        String nick = nickname.getText().toString().trim();

        String amt = amount.getText().toString().trim();
        if(amt == null || amt.equals("")) {
            Toast.makeText(this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        }

        String datetime = pdate.getText().toString().trim();
        if(datetime == null || datetime.equals("")) {
            Toast.makeText(this, "Please Enter Pay by Date", Toast.LENGTH_SHORT).show();
            return;
        }

        remak = remark.getText().toString().trim();
        if(remak == null || remak.equals(""))
            remak = "";

        if(nick == null || nick.equals(""))
            nick = "";
        else
            nick = nick.toUpperCase();


        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        amountDecimal = df.format(Integer.parseInt(amt));

        ld.show();
        ld.setCancelable(false);
        if(add.getVisibility() == View.VISIBLE && add.isChecked()){
            OliveUpiManager.getInstance(RequestSendActivity.this).savevpa(upi,rname,nick);
        }
        else {
            process();
        }
    }

    private void process() {
        OliveUpiManager.getInstance(RequestSendActivity.this).initiateCollect(
                Upi.getCustomerBankAccounts().get(0).getAccounts().get(0),
                upi,
                amountDecimal,
                remak,
                Upi.getCustomerBankAccounts().get(0).getBankCode(),
                datetime,
                Upi.MerchantVpa,
                Upi.MerchantId,
                Upi.Submerchantid,
                Upi.MerchChanId,
                "P2P",
                "",
                "",
                "",
                ""
        );
    }

    private void initSet() {
        mvpa.setText(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa());

        Bundle extra = getIntent().getExtras();
        if(extra.getString("bene") != null && extra.getString("bene").equals("old")) {

            BeneVpa beneVpa = new Gson().fromJson(extra.getString("beneVpa"),BeneVpa.class);
            vpa.setText(beneVpa.getVpa());
            name.setText(beneVpa.getName());

            if(beneVpa.getNickname() == null || beneVpa.getNickname().equals(""))
            {
                nickname.setVisibility(View.GONE);
                nickname.setText("");
            }
            else
            {
                nickname.setVisibility(View.VISIBLE);
                nickname.setText(beneVpa.getNickname());
            }
            nickname.setEnabled(false);
            add.setVisibility(View.GONE);
        }
        else
        {
            vpa.setText(extra.getString("upi"));
            name.setText(extra.getString("name"));
            nickname.setText("");

            nickname.setEnabled(true);
            nickname.setInputType(InputType.TYPE_CLASS_TEXT);
            add.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));

        if(reqType != UpiService.REQUEST_SAVE_VPA_V3) {
            if (ld.isShowing())
                ld.dismiss();
        }

        if(reqType == UpiService.REQUEST_SAVE_VPA_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(RequestSendActivity.this).fetchVPAList();
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
                error.set(R.drawable.ic_baseline_error_outline_24,beneVpa.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_COLLECT){
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
        Intent intent = new Intent(RequestSendActivity.this,StateActivity.class);
        intent.putExtra("status",status);
        intent.putExtra("rfcode",rfcode);
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("upi",vpa.getText().toString());
        intent.putExtra("vpa",mvpa.getText().toString());
        intent.putExtra("amt",amount.getText().toString());
        intent.putExtra("for","requestsend");
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
        OliveUpiManager.getInstance(RequestSendActivity.this).setListener(this);
    }
}
