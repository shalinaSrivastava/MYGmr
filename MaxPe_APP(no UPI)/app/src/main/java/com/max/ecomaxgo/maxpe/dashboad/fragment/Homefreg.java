package com.max.ecomaxgo.maxpe.dashboad.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.addmoney.AddMoneyActivity;
import com.max.ecomaxgo.maxpe.dashboad.adpter.AdsBanerAdpter;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.adpter.SliderAdapter;
import com.max.ecomaxgo.maxpe.dashboad.modle.AdsBanner;
import com.max.ecomaxgo.maxpe.travel.TravelCardActivity;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.LostFoundActivity;
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.modle.WalletBalance;
import com.max.ecomaxgo.maxpe.dashboad.share.IdeaShareActivity;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.paybill.PaybillActivity;
import com.max.ecomaxgo.maxpe.quiz.QuizQuestPage;

import com.max.ecomaxgo.maxpe.util.Constant;
import com.max.ecomaxgo.maxpe.util.Util;
import com.smarteist.autoimageslider.SliderView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class Homefreg extends Fragment implements View.OnClickListener{
    CardView cardTransfer,cardViewPaybill,cardViewLostFound,cardShareIdea,cardQuiz,cardViewBhimUpi,bhim_card,cvTravelCard,card_Gk;
    TextView db_scan,userName_tv,amount,home_card,tvQuizComingTime,bhim_cardNo,gk_Timer,bhim_type,bhim_ifsc,bhim_neme,bhim_balance,bhim_upiId,bhim_bankName,tvMyRank;
    ImageView bhim_bankLogo,bhim_edit_vpa,w_checkBalance;
    MaxSharedPreference maxSharedPreference;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LinearLayout bhim_balance_lay,bhim_check;
    Dialog dialog ;
    CircleImageView home_profileUser;
    ImageView db_notify;
    ProgressBar progressBar;
    String wAmount;
    SliderView ads_slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        maxSharedPreference = new MaxSharedPreference(getActivity());
      //  home_card.setText(maxSharedPreference.getWalletCard());

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
        setAds();
        if (maxSharedPreference.getWalletCard().equals("")){

            getLiveWalletCard();
        }else {
            home_card.setText(maxSharedPreference.getWalletCard());
        }

           String balance = amount.getText().toString();
        amount.setText(maxSharedPreference.getWalletBalance());
        if (maxSharedPreference.getWalletBalance().equals(balance)){
            amount.setText(maxSharedPreference.getWalletBalance());
        }else {
            getLiveWalletBalance();
        }
       // getRank();




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
        userName_tv= (TextView)view.findViewById(R.id.userName);//userName
        db_scan =(TextView)view.findViewById(R.id.db_scan);
        cvTravelCard= (CardView) view.findViewById(R.id.cvTravelCard);
        card_Gk=view.findViewById(R.id.card_Gk);
        db_notify = (ImageView)view.findViewById(R.id.db_notify);
        tvMyRank=(TextView)view.findViewById(R.id.tvMyRank);
        w_checkBalance=view.findViewById(R.id.w_checkBalance);
        progressBar=view.findViewById(R.id.hLoader);
        progressBar.setVisibility(View.GONE);
        ads_slider=view.findViewById(R.id.ads_slider);
        gk_Timer=view.findViewById(R.id.gk_Timer);

        tvMyRank.setText("Rank  ");


        String profileImage = maxSharedPreference.getUserProfileImg();
        Glide.with(this)
                .load(profileImage)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(home_profileUser);

        if (maxSharedPreference.getMaxUserName().equals("")){
          //  userName_tv.setText(maxSharedPreference.getUserMobileNum());

        }else{
            String fName = maxSharedPreference.getUserFName();
            userName_tv.setText(fName);

        }
        String fName = maxSharedPreference.getUserFName();
        userName_tv.setText(fName);


        dialog = new Dialog(getActivity());

        preferences = getActivity().getSharedPreferences("max_info", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.apply();
        bhim_card.setVisibility(View.GONE);
        db_scan.setVisibility(View.GONE);
        cardTransfer.setOnClickListener(this);
        cardViewPaybill.setOnClickListener(this);
        cardViewLostFound.setOnClickListener(this);
        cardShareIdea.setOnClickListener(this);
        cardQuiz.setOnClickListener(this);
        cardViewBhimUpi.setOnClickListener(this);
        bhim_check.setOnClickListener(this);
        bhim_edit_vpa.setOnClickListener(this);
        db_scan.setOnClickListener(this);
        cvTravelCard.setOnClickListener(this);
        card_Gk.setOnClickListener(this);
        db_notify.setOnClickListener(this);
        w_checkBalance.setOnClickListener(this);
    }
    private void getLiveWalletBalance() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getWalletBalance(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<WalletBalance>() {

            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                if(response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);


                    WalletBalance data = response.body();
                    wAmount = data.getData().getWallet().getAmount();
                    maxSharedPreference.setWalletBalance(wAmount);
                    amount.setText(wAmount);

                }

            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }

    private void getRank() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getRank(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<Rank>() {
            @Override
            public void onResponse(Call<Rank> call, Response<Rank> response) {
                if(response.isSuccessful()) {

                    tvMyRank.setText("Rank  "+response.body().getData().getMyRank().getRank());
                }
            }
            @Override
            public void onFailure(Call<Rank> call, Throwable t) {
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
                Intent shareInt = new Intent(getActivity(), IdeaShareActivity.class);
                startActivity(shareInt);
                break;
            case R.id.cardQuiz:
                Intent quizInt = new Intent(getActivity(), QuizQuestPage.class);
                startActivity(quizInt);
                break;
            case R.id.cardViewBhimUpi:
                setComingSoon();
                  //  bhimUPI();
                break;
            case R.id.cvTravelCard:
                Intent travel = new Intent(getActivity(), TravelCardActivity.class);
                startActivity(travel);
                break;
            case R.id.db_notify:
             /*   Intent Inotify = new Intent(getActivity(), NotificationActivity.class);
                startActivity(Inotify);*/
                break;
            case R.id.card_Gk:
                Intent gk = new Intent(getActivity(), QuizQuestPage.class);
                startActivity(gk);
                break;
            case R.id.w_checkBalance:
                progressBar.setVisibility(View.VISIBLE);
                getLiveWalletBalance();
                break;
        }
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
                        gk_Timer.setText(hh + " : " + mm + " : " + ss );

                    } else {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };handlerTimer.postDelayed(runnableTimer,0);
    }
    private void setComingSoon() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);

        final AlertDialog deleteDialog = new AlertDialog.Builder(getActivity()).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        TextView tvCancelNo = (TextView)deleteDialogView.findViewById(R.id.tvCancelNo);
        TextView tvCancelYes= (TextView)deleteDialogView.findViewById(R.id.tvCancelYes);
        tvCancelRequest.setText("Coming soon");
        tvCancelNo.setVisibility(View.GONE);
        tvCancelYes.setText("OK");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }
    private void setAds() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.setAds(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<AdsBanner>() {
            @Override
            public void onResponse(Call<AdsBanner> call, Response<AdsBanner> response) {
                if(response.isSuccessful()) {
                    SliderAdapter ads=new SliderAdapter(getActivity(),response.body().getData());
                    ads_slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                    ads_slider.setSliderAdapter(ads);
                    ads_slider.setScrollTimeInSec(3);
                    ads_slider.setAutoCycle(true);
                    ads_slider.startAutoCycle();
                }
            }
            @Override
            public void onFailure(Call<AdsBanner> call, Throwable t) {
                Toast.makeText(getActivity(), "faild", Toast.LENGTH_SHORT);

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
                    maxSharedPreference.setWalletCard(card+"   "+card2+"   "+card3+"   "+card4);
                    home_card.setText(card+"   "+card2+"   "+card3+"   "+card4);
                }
            }

            @Override
            public void onFailure(Call<CardNumber> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }
}
