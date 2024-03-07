package com.max.ecomaxgo.maxpe.dashboad.lostfound.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFAds;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFPostAds;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Found extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_found, container, false);
    }

    private void lostAndFoundPostAds() {
        String category = "", title = "", description = "", city = "", lostFoundDate = "", categoryStatus = "", contactPersonName = "", contactPersonMobile = "", pic = "";

        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.getPostAds(Constant.skey, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(), category, title, description, city, lostFoundDate, categoryStatus, contactPersonName, contactPersonMobile, pic);
        call.enqueue(new Callback<List<LFPostAds>>() {
            @Override
            public void onResponse(Call<List<LFPostAds>> call, Response<List<LFPostAds>> response) {

                if (response.body() != null) {

                    Toast.makeText(getActivity(), "response", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "Not" + response.code(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<LFPostAds>> call, Throwable t) {
                Toast.makeText(getActivity(), "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void lostAndFoundAds() {

        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getAds(Constant.skey, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<List<LFAds>>() {
            @Override
            public void onResponse(Call<List<LFAds>> call, Response<List<LFAds>> response) {

                if (response.body() != null) {

                    Toast.makeText(getActivity(), "response", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(getActivity(), "Not" + response.code(), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<List<LFAds>> call, Throwable t) {
                Toast.makeText(getActivity(), "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }
}