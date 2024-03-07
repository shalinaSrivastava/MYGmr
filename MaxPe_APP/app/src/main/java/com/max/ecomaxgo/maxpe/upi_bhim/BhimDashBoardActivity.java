package com.max.ecomaxgo.maxpe.upi_bhim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.LoginActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.AccountAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.AccountOptionDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.option.BeneActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.BlockActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.MyQRActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.QueryActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.RequestActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.ScanQRActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.SendActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.TransActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.ApiUPI;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIChecksum;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIInterface;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.max.ecomaxgo.maxpe.util.Constant;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.Collectbeneblock;
import com.olive.upi.transport.model.CustomerBankAccounts;
import com.olive.upi.transport.model.CustomerVpa;
import com.olive.upi.transport.model.TranHistory;
import com.olive.upi.transport.model.sdk.SDKHandshake;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BhimDashBoardActivity extends AppCompatActivity implements OliveUpiEventListener{

    LoadingDialog ld;
    ErrorDialog error;
    AccountOptionDialog optionDialog;
    CardView request;
    CardView send;
    CardView bene;
    CardView history;
    CardView query;
    CardView myqr;
    CardView block;
    CardView deregister;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView bhim_back;
    MaxSharedPreference sp;
    AccountAdapter accountAdapter;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,DashboadActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhim_dashboard);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(BhimDashBoardActivity.this);
        error = new ErrorDialog(BhimDashBoardActivity.this);
        optionDialog = new AccountOptionDialog(BhimDashBoardActivity.this);
        preferences = getSharedPreferences("max_info", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.apply();

        request = findViewById(R.id.request);
        send = findViewById(R.id.send);
        bene = findViewById(R.id.bene);
        history = findViewById(R.id.history);
        query = findViewById(R.id.bd_myQuery);
        myqr = findViewById(R.id.myqr);
        block = findViewById(R.id.block);
        deregister = findViewById(R.id.deregister);
        sp = new MaxSharedPreference(this);
        bhim_back = findViewById(R.id.bhim_back);
        request.setOnClickListener(view -> request());
        send.setOnClickListener(view -> send());
        bene.setOnClickListener(view -> bene());
        history.setOnClickListener(view -> history());
        query.setOnClickListener(view -> query());
        myqr.setOnClickListener(view -> myqr());
        block.setOnClickListener(view -> block());
        deregister.setOnClickListener(view -> deregister());
        bhim_back.setOnClickListener(view-> back());
        accountSetup();
    }
    private void accountSetup() {
        accountAdapter = new AccountAdapter(BhimDashBoardActivity.this, Upi.getCustomerBankAccounts(), new AccountAdapter.AccountOnItemClickListner(){
            @Override
            public void getOperatorPosition(int pos, String type) {
                start(pos,type);
            }
        });
    }

    int position;
    private void start(int pos, String type) {
        this.position = pos;
        if(type.equals("amt"))
        {
            ld.show();
            ld.setCancelable(false);
            Account account = Upi.getCustomerBankAccounts().get(pos).getAccounts().get(0);
            OliveUpiManager.getInstance(BhimDashBoardActivity.this).checkBalance(account);
        }
    }

    private void back() {
        Intent intent = new Intent(this,DashboadActivity.class);
        startActivity(intent);
        finishAffinity();
    }
    private void deregister() {
        set_logOut();

    }
    boolean allRight()

    {
        checksum();
        if(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa().equals("")) {
            return false;
        }
        if(!Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getMbeba().equals("Y")) {
            return false;
        }

        return true;
    }

    private void block() {
        if(allRight()) {
            ld.show();
            ld.setCancelable(false);
            OliveUpiManager.getInstance(BhimDashBoardActivity.this).collectBlocklist();
        }
    }
    private void myqr() {
        if(allRight()) {
            if (Upi.getUri().isEmpty()) {
                Upi.setUri(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0));
            }

            if (Upi.getSign().isEmpty()) {
                try {
                    byte[] data = Upi.getUri().getBytes("UTF-8");
                    String intentdata = Base64.encodeToString(data, Base64.NO_WRAP);
                    ld.show();
                    ld.setCancelable(false);
                    OliveUpiManager.getInstance(BhimDashBoardActivity.this).generateSignedQR(intentdata);
                } catch (Exception e) {
                    error.set(R.drawable.ic_baseline_error_outline_24, "Error:" + e).show();
                }
            } else {
                startMyQr();
            }
        }
    }


    private void query() {
        if(allRight()) {
            ld.show();
            ld.setCancelable(false);
            OliveUpiManager.getInstance(BhimDashBoardActivity.this).queryList();
        }
    }

    private void history() {
        if(allRight()) {
            Calendar from = Calendar.getInstance();
            from.add(Calendar.MONTH, -2);

            Calendar to = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            ld.show();
            ld.setCancelable(false);
//        OliveUpiManager.getInstance(DashBoardActivity.this).tranHistory(dateFormat.format(from.getTime()),dateFormat.format(to.getTime()));
            OliveUpiManager.getInstance(BhimDashBoardActivity.this).tranHistory("23/09/2021", dateFormat.format(to.getTime()));
        }
    }

    String actToken = "";
    private void bene() {
        if(allRight()) {
            if (Upi.getBeneVpa() == null) {
                ld.show();
                ld.setCancelable(false);
                actToken = "bene";
                OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchVPAList();
            } else {
                startBene();
            }
        }
    }

    private void send() {
        if(allRight()) {
            if (Upi.getBeneVpa() == null) {
                ld.show();
                ld.setCancelable(false);
                actToken = "send";
                OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchVPAList();
            } else {
                startSend();
            }
        }
    }

    private void request() {
        if(allRight()) {
            if (Upi.getBeneVpa() == null) {
                ld.show();
                ld.setCancelable(false);
                actToken = "request";
                OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchVPAList();
            } else {
                startRequest();
            }
        }
    }

  @Override
  public void onSuccessResponse(int reqType, Object data) {
      Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));
      if(reqType != UpiService.REQUEST_GET_TRANSACTION_HISTORY_V3) {
          if (ld.isShowing())
              ld.dismiss();
      }
      if(reqType == UpiService.REQUEST_SDK_HANDSHAKE) {
          Result<Void> rs = (Result<Void>) data;
          if(rs.getCode().equals("00")) {
              OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchListBanks();
          }
        //  else msg.setText("SDK failed:handshake");
      }
      else if(reqType == UpiService.REQUEST_LIST_BANKS){
          Result<ArrayList<Bank>> banks = (Result<ArrayList<Bank>>)data;
          if(banks.getCode().equals("00")) {
              Upi.setBanks(banks.getData());
           //   msg.setText("fetching linked accounts");
              OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchMyAccounts();
          }
         // else msg.setText("SDK failed:list bank");
      }
      else if(reqType == UpiService.REQUEST_ALL_ACCOUNTS_V3)
      {
          ArrayList<CustomerBankAccounts> customerBankAccounts = (ArrayList<CustomerBankAccounts>)data;
          Upi.setCustomerBankAccounts(customerBankAccounts);

         /* if(customerBankAccounts.size() < 1)
          {
              Intent intent = new Intent(this, CreateUpiActivity.class);
              startActivity(intent);
          }
          else {
              Intent intent = new Intent(this, BhimDashBoardActivity.class);
              startActivity(intent);
          }
          finishAffinity();*/
      }

      if (reqType == UpiService.REQUEST_GET_BALANCE) {
          Result<String> rs = (Result<String>) data;
          if (rs.getCode().equals("00")) {
              Toast.makeText(BhimDashBoardActivity.this,"Balance"+rs.getData(),Toast.LENGTH_SHORT).show();
             Upi.getCustomerBankAccounts().get(position).getAccounts().get(0).setBalance(rs.getData());
              accountAdapter.updateList(Upi.getCustomerBankAccounts());
          } else {
              error.set(R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
          }
      }else if (reqType == UpiService.REQUEST_GET_CHANGE_MPIN) {
          Result<Void> rs = (Result<Void>) data;
          if (rs.getCode().equals("00")) {
              error.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult()).show();
          } else {
              error.set(R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
          }
      } else if (reqType == UpiService.REQUEST_GET_VPA_V3) {
          Result<ArrayList<BeneVpa>> beneVpa = (Result<ArrayList<BeneVpa>>) data;
          if (beneVpa.getCode().equals("00")) {
              Upi.setBene(beneVpa.getData());
              if (actToken.equals("bene"))
                  startBene();
              else if (actToken.equals("send"))
                  startSend();
              else if (actToken.equals("request"))
                  startRequest();
          } else {
              error.set(R.drawable.ic_baseline_error_outline_24, beneVpa.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_VPA_BLOCK_LIST_V3)
      {
          Result<ArrayList<Collectbeneblock>> collectbeneblocks = (Result<ArrayList<Collectbeneblock>>) data;
          if(collectbeneblocks.getCode().equals("00")) {
              Upi.setCollectbeneblocks(collectbeneblocks.getData());
              startBlock();
          }
          else {
              error.set(R.drawable.ic_baseline_error_outline_24, collectbeneblocks.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_GET_TRANSACTION_HISTORY_V3)
      {
          Result<ArrayList<TranHistory>> transHistory = (Result<ArrayList<TranHistory>>) data;
          if(transHistory.getCode().equals("00"))
          {
              Upi.setTranHistory(transHistory.getData());
              OliveUpiManager.getInstance(BhimDashBoardActivity.this).fetchCustomerVpa();
          }
          else{
              if (ld.isShowing())
                  ld.dismiss();
              error.set(R.drawable.ic_baseline_error_outline_24, transHistory.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_GET_CUSTOMER_VPALIST_V3)
      {
          Result<ArrayList<CustomerVpa>> customerVpa = (Result<ArrayList<CustomerVpa>>) data;
          if(customerVpa.getCode().equals("00"))
          {
              Upi.setCustomerVpa(customerVpa.getData());
              startTrans();
          }
          else{
              error.set(R.drawable.ic_baseline_error_outline_24, customerVpa.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_LIST_QUERIES_V3)
      {
          Result<ArrayList<TranHistory>> transHistory = (Result<ArrayList<TranHistory>>) data;
          if(transHistory.getCode().equals("00"))
          {
              Upi.setQuery(transHistory.getData());
              startQuery();
          }
          else{
              error.set(R.drawable.ic_baseline_error_outline_24, transHistory.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_GENERATE_INTENT_SIGN)
      {
          Result<String> sign = (Result<String>) data;
          if(sign.getCode().equals("00"))
          {
              Upi.setSign(sign.getData());
              startMyQr();
          }
          else{
              error.set(R.drawable.ic_baseline_error_outline_24, sign.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_GET_ACCOUNT_REMOVE_V3)
      {
          Result<String> sign = (Result<String>) data;
          if(sign.getCode().equals("00"))
          {
              Upi.setCustomerBankAccounts(null);
              Upi.setBeneVpa(null);
              Upi.setBeneIfsc(null);
              Intent intent = new Intent(this, CreateUpiActivity.class);
              startActivity(intent);
              finishAffinity();
          }
          else{
              error.set(R.drawable.ic_baseline_error_outline_24, sign.getResult()).show();
          }
      }
      else if(reqType == UpiService.REQUEST_GET_CUSTOMER_deregister_V3)
      {
          Result<String> sign = (Result<String>) data;
          if(sign.getCode().equals("00"))
          {
              Upi.setCustomerBankAccounts(null);
              Upi.setBeneVpa(null);
              Upi.setBeneIfsc(null);
              sp.setDEREGISTER("true");
              Intent intent = new Intent(this, CreateUpiActivity.class);
              startActivity(intent);
              finishAffinity();
          }
          else{
              error.set(R.drawable.ic_baseline_error_outline_24, sign.getResult()).show();
          }
      }


  }

    private void startMyQr() {
        Intent intent = new Intent(BhimDashBoardActivity.this, MyQRActivity.class);
        startActivity(intent);
    }

    private void startTrans() {
        Intent intent = new Intent(BhimDashBoardActivity.this, TransActivity.class);
        startActivity(intent);
    }

    private void startBlock() {
        Intent intent = new Intent(BhimDashBoardActivity.this, BlockActivity.class);
        startActivity(intent);
    }

    private void startRequest(){
        Intent intent = new Intent(BhimDashBoardActivity.this, RequestActivity.class);
        startActivity(intent);
    }

    private void startSend() {
        Intent intent = new Intent(BhimDashBoardActivity.this, SendActivity.class);
        startActivity(intent);
    }

    private void startBene() {
        Intent intent = new Intent(BhimDashBoardActivity.this, BeneActivity.class);
        startActivity(intent);
    }

    private void startQuery() {
        Intent intent = new Intent(BhimDashBoardActivity.this, QueryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));
        if(ld.isShowing())
            ld.dismiss();
        try{
            if(data != null) {
                Result<Void> rs = (Result<Void>) data;
                if(rs.getCode().equals("10001"))
                    return;
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
        OliveUpiManager.getInstance(BhimDashBoardActivity.this).setListener(this);
       // accountAdapter.notifyDataSetChanged();
    }
    private void initOlive(String bhimToken) {
        // msg.setText("initiate SDK");
        SDKHandshake sdkHandshake = new SDKHandshake();
        //sdkHandshake.setDeviceid(telephonyManager.getDeviceId());
        sdkHandshake.setDeviceid("911498058335351");
        sdkHandshake.setSubscriptionId(String.valueOf(Upi.subscriptionId));
        sdkHandshake.setCustName("ghfygfv");
        sdkHandshake.setMerchId(Upi.MerchantId);
        sdkHandshake.setMerchChanId(Upi.MerchChanId);
        sdkHandshake.setSubmerchantid(Upi.Submerchantid);
        sdkHandshake.setUnqTxnId("" + new Date().getTime());
        sdkHandshake.setMerchanttoken(bhimToken);
        OliveUpiManager.getInstance(BhimDashBoardActivity.this).initiateSDK(sdkHandshake);
    }

    private void set_logOut() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        tvCancelRequest.setText("Are you sure to Deregister?");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxSharedPreference sp = new MaxSharedPreference(BhimDashBoardActivity.this);
                sp.setBHIM_DB("");
                ld.show();
                ld.setCancelable(false);
                OliveUpiManager.getInstance(BhimDashBoardActivity.this).deRegister();
                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }


    private void checksum() {

        UPIInterface api = ApiUPI.getUPIClient().create(UPIInterface.class);


        Call call = api.getChecksum(Constant.skey,sp.getUserMobileNum(), sp.getUserToken());

        call.enqueue(new Callback<UPIChecksum>() {

            @Override
            public void onResponse(Call<UPIChecksum> call, Response<UPIChecksum> response) {
                if(response.isSuccessful()){

                    UPIChecksum data = response.body();
                    String merchantauthtoken = data.getData().getMerchantauthtoken();
                    initOlive(merchantauthtoken);

                }

            }

            @Override
            public void onFailure(Call<UPIChecksum> call, Throwable t) {
                Toast.makeText(BhimDashBoardActivity.this,""+t, Toast.LENGTH_SHORT);

            }
        });
    }
}
