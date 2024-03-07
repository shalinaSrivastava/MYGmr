package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.VpaAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.model.BeneVpa;

import java.util.ArrayList;

public class ActionVpaActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    RecyclerView recyclerView;
    LinearLayout add;
    VpaAdapter vpaAdapter;
    ArrayList<BeneVpa> beneVpa;
    BeneVpa vpa;

    @Override
    protected void onResume() {
        super.onResume();
        OliveUpiManager.getInstance(ActionVpaActivity.this).setListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_vpa);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(ActionVpaActivity.this);

        recyclerView = findViewById(R.id.vpaRecycler);
        add = findViewById(R.id.all);

        add.setOnClickListener(view -> open());

        Bundle extra = getIntent().getExtras();
        beneVpa = new Gson().fromJson(extra.getString("vpa"),new TypeToken<ArrayList<BeneVpa>>(){}.getType());

        vpaAdapter = new VpaAdapter(ActionVpaActivity.this,beneVpa, new VpaAdapter.VpaOnItemClickListner() {
            @Override
            public void getOperatorPosition(BeneVpa beneVpa) {
                select(beneVpa);
            }
        });

        recyclerView.setAdapter(vpaAdapter);
        vpaAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    private void select(BeneVpa beneVpa) {

    }

    private void open() {
        Intent intent = new Intent(ActionVpaActivity.this,VpaNewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
//        if(ld.isShowing())
//            ld.dismiss();
//        if(reqType == UpiService.REQUEST_SAVE_ACCOUNT_V3){
//            customerBankAccounts = (Result<ArrayList<CustomerBankAccounts>>)data;
//            if(customerBankAccounts.getCode().equals("00")) {
//                Intent intent = new Intent(this,CardActivity.class);
//                intent.putExtra("customerBankAccounts", new Gson().toJson(customerBankAccounts.getData()));
//                startActivity(intent);
//            }
//            else{
//                new ErrorDialog(VpaActivity.this,R.drawable.ic_baseline_error_outline_24,customerBankAccounts.getResult()).show();
//            }
//        }
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));
//        if(ld.isShowing())
//            ld.dismiss();
//        try{
//            if(data != null) {
//                Result<Void> rs = (Result<Void>) data;
//                if (reqType == UpiService.REQUEST_SAVE_ACCOUNT_V3) {
//                    new ErrorDialog(VpaActivity.this, R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
//                }
//            } else {
//                new ErrorDialog(VpaActivity.this, R.drawable.ic_baseline_error_outline_24, "Empty").show();
//            }
//        }
//        catch (Exception ex){
//            new ErrorDialog(VpaActivity.this,R.drawable.ic_baseline_error_outline_24, "Error:"+data).show();
//        }
    }
}