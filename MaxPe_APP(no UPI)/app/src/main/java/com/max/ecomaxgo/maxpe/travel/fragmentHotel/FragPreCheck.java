package com.max.ecomaxgo.maxpe.travel.fragmentHotel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.HotelPreCheck;
import com.max.ecomaxgo.maxpe.travel.hotelAdpter.PreCheckAdpter;
import com.max.ecomaxgo.maxpe.travel.hotelModel.PreCheckHotel;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragPreCheck extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail_hotel, container, false);
        PreCheck();
        return view;
    }
    private void PreCheck() {
        MaxSharedPreference mp = new MaxSharedPreference(getActivity());
        String a=mp.getHotel_check_in();
        String a2=mp.getHotel_check_Out();
        String a3=mp.getHotel_noAdult();
        String a4=mp.getHotel_totalChild();
        String a5= mp.getHotel_childAge();
        String a6=mp.getHotel_Room();
        String a7=mp.getHotel_place();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.bookHotel(Constant.skey,"", "",
               "", "",
               "","","",
               "","","","",
                "","",
               "","",
               "",
                "","","");
        call.enqueue(new Callback<PreCheckHotel>() {

            @Override
            public void onResponse(Call<PreCheckHotel> call, Response<PreCheckHotel> response) {
                if(response.isSuccessful()) {

                    if (response.body().getMessage().equals("Invalid Request")){

                    }else {
                    }

                }else{
                    Toast.makeText(getActivity(), " no data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PreCheckHotel> call, Throwable t) {

                Toast.makeText(getActivity(), "there is some isssue"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }

}