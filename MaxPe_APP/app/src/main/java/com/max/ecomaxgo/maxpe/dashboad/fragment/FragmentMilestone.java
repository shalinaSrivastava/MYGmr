package com.max.ecomaxgo.maxpe.dashboad.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.RankAdpter;
import com.max.ecomaxgo.maxpe.dashboad.modle.Milestone;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMilestone extends Fragment {
    TextView _myCash,_myMile,_convertCash;
    String milestone="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_milestone_layout, container, false);
                _myCash = v.findViewById(R.id._myCash);
                _myMile= v.findViewById(R.id._myMile);
               _convertCash = v.findViewById(R.id._convertCash);
          getMilestone();

        _convertCash.setOnClickListener(view -> convertCash());
        return v;
    }

    private void convertCash() {
        if ( milestone.equals("")){
            _myCash.setText("");
        }else {
           Integer ms=Integer.parseInt(milestone);
          double multy= ms*0.1;
          String rsl = String.valueOf(multy);
            _myCash.setText(rsl);
        }
    }
    private void getMilestone() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getMilestone(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<Milestone>() {
            @Override
            public void onResponse(Call<Milestone> call, Response<Milestone> response) {
                if(response.isSuccessful()) {
                   milestone = response.body().getData().getMilestone();
                    _myMile.setText(milestone);

                }
            }
            @Override
            public void onFailure(Call<Milestone> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }
}