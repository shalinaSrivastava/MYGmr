package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.olive.upi.transport.model.TranHistory;

public class TransQueryActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    SuccessDialog success;
    TranHistory tranHistory;
    ImageView status;

    TextView act;
    TextView vpa;
    TextView date;
    TextView txn;
    TextView name;
    TextView amt;
    EditText query;
    Button raised;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_query);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(TransQueryActivity.this);
        error = new ErrorDialog(TransQueryActivity.this);
        success = new SuccessDialog(TransQueryActivity.this);

        status = findViewById(R.id.status);
        act = findViewById(R.id.act);
        vpa = findViewById(R.id.vpa);
        name = findViewById(R.id.name);
        txn = findViewById(R.id.txnid);
        date = findViewById(R.id.txndate);
        amt = findViewById(R.id.amt);
        query = findViewById(R.id.query);
        raised = findViewById(R.id.raised);

        initSetup();
        raised.setOnClickListener(view -> raised());

    }

    private void raised() {
        String qry = query.getText().toString().trim();
        if(qry == null || qry.equals("")) {
            Toast.makeText(this, "Please Enter your Query", Toast.LENGTH_SHORT).show();
            return;
        }

        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(TransQueryActivity.this).raiseQuery(
                tranHistory.getTranid(),
                tranHistory.getRefid(),
                Float.valueOf(tranHistory.getAmount()),
                qry);

    }

    private void initSetup() {
        String mvpa = Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa();

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            if(extra.getString("trans") != null)
            {
                tranHistory = new Gson().fromJson(extra.getString("trans"),TranHistory.class);
                String type = tranHistory.getType();
                int amount = Double.valueOf(tranHistory.getAmount()).intValue();
                amt.setText(String.valueOf(amount));
                if(type.equals("PAY"))
                {
                    if(mvpa.equals(tranHistory.getCreditVpa()))
                    {
                        act.setText("Received from");
                        vpa.setText(tranHistory.getDebitVpa());
                        name.setText(tranHistory.getRemitterName());
                    }
                    else{
                        act.setText("Pay to");
                        vpa.setText(tranHistory.getCreditVpa());
                        name.setText(tranHistory.getBeneficiaryName());
                    }
                }
                else if(type.equals("COLLECT"))
                {
                    if(mvpa.equals(tranHistory.getCreditVpa()))
                    {
                        act.setText("Request to");
                        vpa.setText(tranHistory.getDebitVpa());
                        name.setText(tranHistory.getRemitterName());
                    }
                    else{
                        act.setText("Request from");
                        vpa.setText(tranHistory.getCreditVpa());
                        name.setText(tranHistory.getBeneficiaryName());
                    }
                }

                String stat = tranHistory.getStatus();
                if(stat.equals("P"))
                {
                    status.setImageResource(R.drawable.ic_baseline_error_24);
                    status.setColorFilter(ContextCompat.getColor(this,
                            R.color.orange));
                }
                else if(stat.equals("C"))
                {
                    status.setImageResource(R.drawable.ic_baseline_check_circle_24);
                    status.setColorFilter(ContextCompat.getColor(this,
                            R.color.purple_200));
                }
                else if(stat.equals("R"))
                {
                    status.setImageResource(R.drawable.ic_baseline_cancel_24);
                    status.setColorFilter(ContextCompat.getColor(this,
                            R.color.red));
                }

                date.setText(tranHistory.getDateTime());
                txn.setText(tranHistory.getTranid());
            }
        }
    }


    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));

        if (ld.isShowing())
            ld.dismiss();

        if(reqType == UpiService.REQUEST_GET_RAISE_QUERY_V3){
            Result<String> rs = (Result<String>) data;
            if(rs.getCode().equals("00")) {
                success.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult(),() -> action()).show();
                success.setCancelable(false);
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
    }

    private void action() {
        if(success.isShowing())
            success.dismiss();
        Intent intent = new Intent(TransQueryActivity.this, BhimDashBoardActivity.class);
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
        OliveUpiManager.getInstance(TransQueryActivity.this).setListener(this);
    }
}