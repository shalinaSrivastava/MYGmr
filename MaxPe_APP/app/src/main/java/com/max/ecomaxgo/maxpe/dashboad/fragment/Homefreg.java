package com.max.ecomaxgo.maxpe.dashboad.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.addmoney.AddMoneyActivity;
import com.max.ecomaxgo.maxpe.dashboad.TravelCardActivity;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.LostFoundActivity;
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber;
import com.max.ecomaxgo.maxpe.dashboad.modle.WalletBalance;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;

import com.max.ecomaxgo.maxpe.model.login.Login;
import com.max.ecomaxgo.maxpe.paybill.PaybillActivity;
import com.max.ecomaxgo.maxpe.quiz.QuizQuestPage;
import com.max.ecomaxgo.maxpe.upi_bhim.BhimActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.BhimDashBoardActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.CardActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.CreateUpiActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.SimActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.AccountOptionDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.option.MyQRActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.RequestActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.ScanQRActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.SendActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.option.TransActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.ApiUPI;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIChecksum;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIInterface;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.max.ecomaxgo.maxpe.util.Constant;
import com.max.ecomaxgo.maxpe.util.Util;
import com.max.ecomaxgo.maxpe.view.ShareIdeaActivity;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.CustomerBankAccounts;
import com.olive.upi.transport.model.sdk.SDKHandshake;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homefreg extends Fragment implements View.OnClickListener,OliveUpiEventListener{
    CardView cardTransfer,cardViewPaybill,cardViewLostFound,cardShareIdea,cardQuiz,cardViewBhimUpi,bhim_card,cvTravelCard;
    TextView cardName,userName_tv,amount,home_card,tvQuizComingTime,bhim_cardNo,bhim_type,bhim_ifsc,bhim_neme,bhim_balance,bhim_upiId,bhim_bankName,home_rank;
    ImageView bhim_bankLogo,bhim_edit_vpa;
    MaxSharedPreference maxSharedPreference;
    LoadingDialog ld;
    ErrorDialog error;
    AccountOptionDialog optionDialog;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LinearLayout bhim_balance_lay,bhim_check;
    Dialog dialog ;
    CircleImageView home_profileUser;
    LinearLayout bhim_lay;
    CardView bhim_send,bhim_request,bhim_myqr,bhim_Scanner;
    String actToken = "";
    String wAmount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        maxSharedPreference = new MaxSharedPreference(getActivity());
        initView(view);
        if (Util.INSTANCE.compareTimeFrom("12:01") && Util.INSTANCE.compareTimeTo("18:00")){
            tvQuizComingTime.setVisibility(View.VISIBLE);
            countDownStart(Util.INSTANCE.getTodayDate());
        }else if (Util.INSTANCE.compareTimeFrom("18:01") || Util.INSTANCE.compareTimeTo("12:00")){
            tvQuizComingTime.setVisibility(View.VISIBLE);
            countDownStart(Util.INSTANCE.getTomorrowDate());
        }else {
            tvQuizComingTime.setVisibility(View.GONE);
        }
        return view;
    }
    private void initView(View view) {
        cardTransfer = (CardView) view.findViewById(R.id.cardTransfer);
        cardViewPaybill= (CardView) view.findViewById(R.id.cardViewPaybill);
        cardViewLostFound= (CardView) view.findViewById(R.id.cardViewLostFound);
        cardShareIdea= (CardView) view.findViewById(R.id.cardShareIdea);
        cardQuiz= (CardView) view.findViewById(R.id.cardQuiz);
        amount = (TextView)view.findViewById(R.id.amount);
        home_card= (TextView)view.findViewById(R.id.home_card);
        tvQuizComingTime =view.findViewById(R.id.tvTime);
        cardViewBhimUpi= (CardView) view.findViewById(R.id.cardViewBhimUpi);
        bhim_bankLogo= (ImageView)view.findViewById(R.id.bhim_bankLogo);
        bhim_type= (TextView)view.findViewById(R.id.bhim_type);
        bhim_cardNo= (TextView)view.findViewById(R.id.bhim_cardNo);
        bhim_ifsc= (TextView)view.findViewById(R.id.bhim_ifsc);
        bhim_neme= (TextView)view.findViewById(R.id.bhim_name);
        bhim_card= (CardView)view.findViewById(R.id.bhim_card);
        bhim_check = (LinearLayout)view.findViewById(R.id.bhim_check);
        bhim_balance = (TextView)view.findViewById(R.id.bhim_balance);
        bhim_balance_lay = (LinearLayout)view.findViewById(R.id.bhim_balance_lay);
        bhim_upiId = (TextView)view.findViewById(R.id.bhim_upiId);
        bhim_edit_vpa = (ImageView)view.findViewById(R.id.bhim_edit_vpa);
        bhim_bankName= (TextView)view.findViewById(R.id.bhim_bankName);
        home_profileUser = (CircleImageView)view.findViewById(R.id.home_profileUser);
        bhim_balance.setVisibility(View.GONE);
        bhim_balance_lay.setVisibility(View.GONE);
        userName_tv= (TextView)view.findViewById(R.id.db_userName_tv);
        home_rank = (TextView)view.findViewById(R.id.home_rank);
        cvTravelCard= (CardView) view.findViewById(R.id.cvTravelCard);
        bhim_lay= view.findViewById(R.id.bhim_lay);
        cardName=view.findViewById(R.id.cardName);
        bhim_lay.setVisibility(View.GONE);

        bhim_send = view.findViewById(R.id.bhim_send);
        bhim_request = view.findViewById(R.id.bhim_request);
        bhim_myqr = view.findViewById(R.id.bhim_myqr);
        bhim_Scanner = view.findViewById(R.id.bhim_Scanner);

        String profileImage = maxSharedPreference.getUserProfileImg();
        Glide.with(this)
                .load(profileImage)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(home_profileUser);

        if (maxSharedPreference.getMaxUserName().equals("")){
            cardName.setText("");
        }else{
            String fName = maxSharedPreference.getUserFName();
            cardName.setText(fName);
        }

        if (maxSharedPreference.getWALLETCARD().equals("")){

            getLiveWalletCard();
        }else {
            home_card.setText(maxSharedPreference.getWALLETCARD());
        }
           amount.setText(maxSharedPreference.getCARDBALANCE());
            getLiveWalletBalance();


        dialog = new Dialog(getActivity());
        ld = new LoadingDialog(getActivity());
        error = new ErrorDialog(getActivity());
        optionDialog = new AccountOptionDialog(getActivity());
        preferences = getActivity().getSharedPreferences("max_info", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.apply();
        if (maxSharedPreference.getBHIM_DB().equals("true")){
            bhim_card.setVisibility(View.VISIBLE);
            bhim_lay.setVisibility(View.VISIBLE);

            bhim_cardNo.setText(maxSharedPreference.getBHIM_ACCOUNTNO());
            bhim_type.setText(maxSharedPreference.getBHIM_TYPE());
            bhim_ifsc.setText(maxSharedPreference.getBHIM_IFSC());
            bhim_neme.setText(maxSharedPreference.getBHIM_HOLDERNAME());
            bhim_upiId.setText(maxSharedPreference.getBHIM_Vpa());
            bhim_bankName.setText(maxSharedPreference.getBHIM_bankName());
            Glide.with(this)
                    .load(maxSharedPreference.getSaveQRBitmapPathBankLogo())
                    .centerInside()
                    .placeholder(R.drawable.ic_baseline_account_balance_24)
                    .into(bhim_bankLogo);
            checksum();

        }else {
            bhim_card.setVisibility(View.GONE);
            bhim_lay.setVisibility(View.GONE);
        }
        cardTransfer.setOnClickListener(this);
        cardViewPaybill.setOnClickListener(this);
        cardViewLostFound.setOnClickListener(this);
        cardShareIdea.setOnClickListener(this);
        cardQuiz.setOnClickListener(this);
        cardViewBhimUpi.setOnClickListener(this);
        bhim_check.setOnClickListener(this);
        bhim_edit_vpa.setOnClickListener(this);
        cvTravelCard.setOnClickListener(this);
              bhim_send .setOnClickListener(this);
            bhim_request .setOnClickListener(this);
            bhim_myqr.setOnClickListener(this);
            bhim_Scanner.setOnClickListener(this);
    }
    private void getLiveWalletBalance() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getWalletBalance(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<WalletBalance>() {

            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                if(response.isSuccessful()) {

                    WalletBalance data = response.body();
                    wAmount = data.getData().getWallet().getAmount();


                      if (maxSharedPreference.getCARDBALANCE().equals(amount)){
                          amount.setText(maxSharedPreference.getCARDBALANCE());
                      }else {
                          maxSharedPreference.setCARDBALANCE(wAmount);
                          amount.setText(wAmount);
                      }
                }

            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }
    private void getLiveWalletCard() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getWalletCard(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<CardNumber>() {

            @Override
            public void onResponse(Call<CardNumber> call, Response<CardNumber> response) {
                if(response.isSuccessful()) {
                    CardNumber dataCard = response.body();
                    String cardNo = dataCard.getData().getCard().get(0).getNumber();
                    String card = cardNo.substring(0, 4);
                    String card2 = cardNo.substring(4, 8);
                    String card3 = cardNo.substring(8, 12);
                    String card4 = cardNo.substring(12, 16);

                    home_card.setText(card+"  "+card2+"  "+card3+"  "+card4);
                    maxSharedPreference.setWALLETCARD(card+"  "+card2+"  "+card3+"  "+card4);
                }
            }

            @Override
            public void onFailure(Call<CardNumber> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardTransfer:
                Intent i = new Intent(getActivity(),AddMoneyActivity.class);
                startActivity(i);
                break;

            case R.id.cardViewPaybill:
                Intent payInt = new Intent(getActivity(), PaybillActivity.class);
                startActivity(payInt);
                break;
            case R.id.cardViewLostFound:
               Intent lostInt = new Intent(getActivity(), LostFoundActivity.class);
               startActivity(lostInt);
                break;
            case R.id.cardShareIdea:
                Intent shareInt = new Intent(getActivity(), ShareIdeaActivity.class);
                startActivity(shareInt);
                break;
            case R.id.cardQuiz:
                if (maxSharedPreference.getUserFName().equals("")){

                    QuizPopup();

                }else {
                    Intent quizInt = new Intent(getActivity(), QuizQuestPage.class);
                    startActivity(quizInt);
                }
                break;
            case R.id.cardViewBhimUpi:
                    bhimUPI();
                break;
            case R.id.bhim_check:
               // initOlive();
                checksum();
                checkBalance();
                break;
            case R.id.bhim_edit_vpa:

               // initOlive();
                checksum();
                editVPA();
                break;
            case R.id.lcvpa:
                vpaDailog("lcvpa");
                break;
            case R.id.lreset:
                vpaDailog("resetMPIN");
                break;
            case R.id.ldelete:
                vpaDailog("delete");
                break;
            case R.id.lchange:
                vpaDailog("cMPIN");
                break;
            case R.id.cvTravelCard:
                Intent travel = new Intent(getActivity(), TravelCardActivity.class);
                startActivity(travel);
                break;
/*  request.setOnClickListener(view -> );
        send.setOnClickListener(view -> send());*/
            case R.id.bhim_send:
                send();
                break;
            case R.id.bhim_request:
                request();
                break;
            case R.id.bhim_myqr:
                myqr();
                break;
            case R.id.bhim_Scanner:
                scan();
                break;
        }
    }

    private void QuizPopup() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View deleteDialogView = factory.inflate(R.layout.popup_layout, null);

        final AlertDialog deleteDialog = new AlertDialog.Builder(getActivity()).create();
        deleteDialog.setView(deleteDialogView);
        TextView editLName = (TextView)deleteDialogView.findViewById(R.id.editLName);
        TextView editFName = (TextView)deleteDialogView.findViewById(R.id.editFName);
        deleteDialogView.findViewById(R.id.tvSkip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
              //  maxSharedPreference.setUserIsNew("false");
            }
        });
        deleteDialogView.findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
                if (editFName.getText().toString().isEmpty()){
                    editFName.setError(getResources().getString(R.string.error));
                }else if (editLName.getText().toString().isEmpty()){
                    editLName.setError(getResources().getString(R.string.error));
                }
                else  {
                    String lastName=  editLName.getText().toString();
                    String name=  editFName.getText().toString();
                    submitNewUser(name,lastName);
                }

            }
        });
        deleteDialog.show();
    }

    private void submitNewUser(String name,String lastName) {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.updateName(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(),name,lastName);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                if (response.body().getStatus().equals("1")){
                   String name = response.body().getData().getName().getFirst();
                   maxSharedPreference.setUserFName(response.body().getData().getName().getFirst());
                   maxSharedPreference.setUserLName(response.body().getData().getName().getLast());
                   maxSharedPreference.setUserIsNew("false");

                }

                Toast.makeText(getActivity(), "submited", Toast.LENGTH_SHORT);

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }

    private void vpaDailog(String dType) {
        Account account = new Account();
        account.setName(maxSharedPreference.getBHIM_HOLDERNAME());
        account.setAeba(maxSharedPreference.getBHIM_aeba());
        account.setMbeba(maxSharedPreference.getBHIM_Mbeba());
        account.setMmid(maxSharedPreference.getBHIM_mmid());
        account.setIfsc(maxSharedPreference.getBHIM_IFSC());
        account.setMaskedAccnumber(maxSharedPreference.getBHIM_maskedAccnumber());
        account.setStatus(maxSharedPreference.getBHIM_Status());
        account.setType(maxSharedPreference.getBHIM_TYPE());
        account.setVpa(maxSharedPreference.getBHIM_Vpa());
        account.setBalance(maxSharedPreference.getBHIM_Balance());
        account.setBalTime(maxSharedPreference.getBHIM_BalTime());
        account.setAccRefNumber(maxSharedPreference.getBHIM_accRefNumber());
        account.setdType(maxSharedPreference.getBHIM_dType());
        if (dType.equals("resetMPIN")) {
           Intent intent = new Intent(getActivity(), CardActivity.class);
            intent.putExtra("position",1);
            startActivity(intent);
        }  else if (dType.equals("delete")) {
            setDelete();
          /*  ld.show();
            ld.setCancelable(false);
            OliveUpiManager.getInstance(getActivity()).accountRemove(account);*/

        }else if (dType.equals("cMPIN")){
            ld.show();
            ld.setCancelable(false);

            OliveUpiManager.getInstance(getActivity()).changeMpin(
                    Upi.getCustomerBankAccounts().get(0).getBankCode(),
                    Upi.getCustomerBankAccounts().get(0).getAccounts().get(0));

        }
    }

    private void editVPA() {
        TextView vpa,acc;
        LinearLayout lcvpa,lreset,ldelete,lchange;
       // final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_account_option);
       acc = (TextView)dialog.findViewById(R.id.acc);
        vpa = (TextView)dialog.findViewById(R.id.vpa);
        lcvpa= (LinearLayout)dialog.findViewById(R.id.lcvpa);
        lchange = (LinearLayout) dialog.findViewById(R.id.lchange);
        lreset= (LinearLayout)dialog.findViewById(R.id.lreset);
        ldelete= (LinearLayout)dialog.findViewById(R.id.ldelete);
        acc.setText(maxSharedPreference.getBHIM_ACCOUNTNO());
        vpa.setText(maxSharedPreference.getBHIM_Vpa());
        lchange.setOnClickListener(this);
        lcvpa.setOnClickListener(this);
        lreset.setOnClickListener(this);
        ldelete.setOnClickListener(this);
        dialog.show();


    }

    private void checkBalance() {
        ld.show();
        ld.setCancelable(false);
        Account account = new Account();
        account.setBalTime(maxSharedPreference.getBHIM_BalTime());
        account.setAccRefNumber(maxSharedPreference.getBHIM_accRefNumber());
        account.setdType(maxSharedPreference.getBHIM_dType());
        account.setIfsc(maxSharedPreference.getBHIM_IFSC());
        account.setMbeba(maxSharedPreference.getBHIM_Mbeba());
        account.setMmid(maxSharedPreference.getBHIM_mmid());
        account.setMaskedAccnumber(maxSharedPreference.getBHIM_maskedAccnumber());
        account.setName(maxSharedPreference.getBHIM_HOLDERNAME());
        account.setAeba(maxSharedPreference.getBHIM_aeba());
        account.setStatus(maxSharedPreference.getBHIM_Status());
        account.setType(maxSharedPreference.getBHIM_TYPE());
        account.setVpa(maxSharedPreference.getBHIM_Vpa());
        account.setBalance(maxSharedPreference.getBHIM_Balance());
        OliveUpiManager.getInstance(getActivity()).checkBalance(account);
    }
    private void countDownStart(String timerDate) {

        String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        Handler handlerTimer = new Handler();
        Runnable runnableTimer = new Runnable() {
            @Override
            public void run() {
                try {

                    handlerTimer.postDelayed(this, 1000);

                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
                    Date event_date = dateFormat.parse(timerDate);
                    Date current_date = new Date();


                    if (!current_date.after(event_date)) {
                        Long diff = event_date.getTime() - current_date.getTime();
//                        val Days = diff / (24 * 60 * 60 * 1000)
                        Long Hours = diff / (60 * 60 * 1000) % 24;
                        Long Minutes = diff / (60 * 1000) % 60;
                        Long Seconds = diff / 1000 % 60;


                        String ss = "";
                        String mm = "";
                        String hh = "";
                        if (Seconds <= 9)
                            ss = "0".concat(String.valueOf(Seconds));
                        else
                            ss = String.valueOf(Seconds);

                        if (Minutes <= 9)
                            mm = "0".concat(String.valueOf(Minutes));
                        else
                            mm = String.valueOf(Minutes);

                        if (Hours <= 9)
                            hh = "0".concat(String.valueOf(Hours));
                        else
                            hh = String.valueOf(Hours);


                        tvQuizComingTime.setText(hh + " : " + mm + " : " + ss );

                    } else {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };handlerTimer.postDelayed(runnableTimer,0);
    }
    private void bhimUPI() {

            if (maxSharedPreference.getBHIM_DB().equals("true")){

                Intent intent = new Intent( getActivity(), BhimDashBoardActivity.class);
                getActivity().startActivity(intent);
            }else {
                Intent intent = new Intent(getActivity(), CreateUpiActivity.class);
                startActivity(intent);
            }

       // }
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
                OliveUpiManager.getInstance(getActivity()).fetchListBanks();
            }
        }
        else if(reqType == UpiService.REQUEST_LIST_BANKS){
            Result<ArrayList<Bank>> banks = (Result<ArrayList<Bank>>)data;
            if(banks.getCode().equals("00")) {
                Upi.setBanks(banks.getData());
                //   msg.setText("fetching linked accounts");
                OliveUpiManager.getInstance(getActivity()).fetchMyAccounts();
            }
            // else msg.setText("SDK failed:list bank");
        }else if(reqType == UpiService.REQUEST_ALL_ACCOUNTS_V3)
        {
            ArrayList<CustomerBankAccounts> customerBankAccounts = (ArrayList<CustomerBankAccounts>)data;
            Upi.setCustomerBankAccounts(customerBankAccounts);

        }
      else if (reqType == UpiService.REQUEST_GET_BALANCE) {
            Result<String> rs = (Result<String>) data;
            if (rs.getCode().equals("00")) {
                bhim_balance_lay.setVisibility(View.VISIBLE);
                bhim_balance.setVisibility(View.VISIBLE);
                bhim_balance.setText(rs.getData());

            } else {
                error.set(R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
            }
        } else if (reqType == UpiService.REQUEST_GET_CHANGE_MPIN) {
            Result<Void> rs = (Result<Void>) data;
            if (rs.getCode().equals("00")) {
                dialog.dismiss();
                error.set(R.drawable.ic_baseline_check_circle_outline_24, rs.getResult()).show();
            } else {
                ld.dismiss();

                error.set(R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
            }
        }
        else if(reqType == UpiService.REQUEST_GET_ACCOUNT_REMOVE_V3)
        {
            Result<String> sign = (Result<String>) data;
            if(sign.getCode().equals("00"))
            {
                bhim_card.setVisibility(View.GONE);
                bhim_lay.setVisibility(View.GONE);
                maxSharedPreference.setBHIM_DB("");
                dialog.dismiss();
                Upi.setCustomerBankAccounts(null);
                Upi.setBeneVpa(null);
                Upi.setBeneIfsc(null);
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24, sign.getResult()).show();
            }
        } else if (reqType == UpiService.REQUEST_GET_VPA_V3) {
            Result<ArrayList<BeneVpa>> beneVpa = (Result<ArrayList<BeneVpa>>) data;
            if (beneVpa.getCode().equals("00")) {
                Upi.setBene(beneVpa.getData());
               if (actToken.equals("send"))
                    startSend();
                else if (actToken.equals("request"))
                    startRequest();
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24, beneVpa.getResult()).show();
            }
        }else if(reqType == UpiService.REQUEST_GENERATE_INTENT_SIGN)
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


        else if(reqType == UpiService.REQUEST_GET_CUSTOMER_deregister_V3)
        {
            Result<String> sign = (Result<String>) data;
            if(sign.getCode().equals("00"))
            {
                Upi.setCustomerBankAccounts(null);
                Upi.setBeneVpa(null);
                Upi.setBeneIfsc(null);
                Intent intent = new Intent(getActivity(), CreateUpiActivity.class);
                startActivity(intent);
                getActivity().finishAffinity();
            }
            else{
                error.set(R.drawable.ic_baseline_error_outline_24, sign.getResult()).show();
            }
        }
    }
    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType " + reqType + " data " + new Gson().toJson(data));
      //  Toast.makeText(getActivity(),"SDK Error:"+new Gson().toJson(data),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume() {
        super.onResume();
        ld.dismiss();
        dialog.dismiss();
        OliveUpiManager.getInstance(getActivity()).setListener(this);
    }
    private void initOlive(String BHIM_Token) {
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
        sdkHandshake.setMerchanttoken(BHIM_Token);
        OliveUpiManager.getInstance(getActivity()).initiateSDK(sdkHandshake);
    }
    boolean allRight()
    {
        checksum();
        if(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa().equals("")) {
            Toast.makeText(getActivity(),"Please Complect your UPI Process",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getMbeba().equals("Y")) {
            Toast.makeText(getActivity(),"Please Complect your UPI Process",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    private void scan() {
        if(allRight()) {
            startScan();
        }
    }
    private void startScan() {
        Intent intent = new Intent(getActivity(), ScanQRActivity.class);
        startActivity(intent);
    }

    private void setDelete() {

        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(getActivity()).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        tvCancelRequest.setText("Are you sure to Delete Account");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ld.show();
                ld.setCancelable(false);
                Account account = new Account();
                account.setName(maxSharedPreference.getBHIM_HOLDERNAME());
                account.setAeba(maxSharedPreference.getBHIM_aeba());
                account.setMbeba(maxSharedPreference.getBHIM_Mbeba());
                account.setMmid(maxSharedPreference.getBHIM_mmid());
                account.setIfsc(maxSharedPreference.getBHIM_IFSC());
                account.setMaskedAccnumber(maxSharedPreference.getBHIM_maskedAccnumber());
                account.setStatus(maxSharedPreference.getBHIM_Status());
                account.setType(maxSharedPreference.getBHIM_TYPE());
                account.setVpa(maxSharedPreference.getBHIM_Vpa());
                account.setBalance(maxSharedPreference.getBHIM_Balance());
                account.setBalTime(maxSharedPreference.getBHIM_BalTime());
                account.setAccRefNumber(maxSharedPreference.getBHIM_accRefNumber());
                account.setdType(maxSharedPreference.getBHIM_dType());
                OliveUpiManager.getInstance(getActivity()).accountRemove(account);
                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }


    private void checksum() {
        UPIInterface api = ApiUPI.getUPIClient().create(UPIInterface.class);
        Call call = api.getChecksum(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());

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
                Toast.makeText(getActivity(),""+t, Toast.LENGTH_SHORT);

            }
        });
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
                    OliveUpiManager.getInstance(getActivity()).generateSignedQR(intentdata);
                } catch (Exception e) {
                    error.set(R.drawable.ic_baseline_error_outline_24, "Error:" + e).show();
                }
            } else {
                startMyQr();
            }
        }
    }
    private void request() {
        if(allRight()) {
            if (Upi.getBeneVpa() == null) {
                ld.show();
                ld.setCancelable(false);
                actToken = "request";
                OliveUpiManager.getInstance(getActivity()).fetchVPAList();
            } else {
                startRequest();
            }
        }
    }
    private void startMyQr() {
        Intent intent = new Intent(getActivity(), MyQRActivity.class);
        startActivity(intent);
    }
    private void startRequest(){
        Intent intent = new Intent(getActivity(), RequestActivity.class);
        startActivity(intent);
    }

    private void startSend() {
        Intent intent = new Intent(getActivity(), SendActivity.class);
        startActivity(intent);
    }
    private void send() {
        if(allRight()) {
            if (Upi.getBeneVpa() == null) {
                ld.show();
                ld.setCancelable(false);
                actToken = "send";
                OliveUpiManager.getInstance(getActivity()).fetchVPAList();
            } else {
                startSend();
            }
        }
    }

}
