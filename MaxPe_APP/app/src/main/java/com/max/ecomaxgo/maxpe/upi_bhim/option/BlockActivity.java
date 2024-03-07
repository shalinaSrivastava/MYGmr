package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.BhimDashBoardActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BlockAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Collectbeneblock;

import java.util.ArrayList;

public class BlockActivity extends AppCompatActivity implements OliveUpiEventListener {

    LoadingDialog ld;
    ErrorDialog error;
    ImageView empty;
    RecyclerView recyclerView;
    BlockAdapter blockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        ld = new LoadingDialog(BlockActivity.this);
        error = new ErrorDialog(BlockActivity.this);
        recyclerView =  findViewById(R.id.vpaRecycler);
        empty =  findViewById(R.id.empty);

        if(Upi.getCollectbeneblocks().size()<1)
            empty.setVisibility(View.VISIBLE);
        listSetup();
    }

    private void listSetup() {
        blockAdapter = new BlockAdapter(BlockActivity.this, Upi.getCollectbeneblocks(), new BlockAdapter.BlockOnItemClickListner() {
            @Override
            public void getOperatorPosition(String vpa) {
                set_logOut(vpa);

            }
        });
        recyclerView.setAdapter(blockAdapter);
        blockAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    private void delete(String vpa) {
        ld.show();
        ld.setCancelable(false);
        OliveUpiManager.getInstance(BlockActivity.this).collectBlock(vpa,"U","");
    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(reqType == UpiService.REQUEST_COLLECT_BLOCK_V3){
            Result<Void> rs = (Result<Void>) data;
            if(rs.getCode().equals("00")) {
                OliveUpiManager.getInstance(BlockActivity.this).collectBlocklist();
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_VPA_BLOCK_LIST_V3){
            if(ld.isShowing())
                ld.dismiss();
            Result<ArrayList<Collectbeneblock>> collectbeneblocks = (Result<ArrayList<Collectbeneblock>>) data;
            if(collectbeneblocks.getCode().equals("00")) {
                Upi.setCollectbeneblocks(collectbeneblocks.getData());
                blockAdapter.updateList(Upi.getCollectbeneblocks());
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
        OliveUpiManager.getInstance(BlockActivity.this).setListener(this);
    }
    private void set_logOut(String vpa) {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        tvCancelRequest.setText("Are you sure to UnBlock?");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(vpa);
                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }
}