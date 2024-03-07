package com.max.ecomaxgo.maxpe.dashboad.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.adpter.RankAdpter;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.modle.WalletBalance;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class FragmentRank extends Fragment {
    RecyclerView _fregRank_list_rv;
    TextView _fregRank_tv,_fregRankaway_tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank_layout, container, false);
        _fregRank_list_rv =(RecyclerView)view.findViewById(R.id._fregRank_list_rv);
        _fregRank_tv = (TextView)view.findViewById(R.id._fregRank_tv);
        _fregRankaway_tv= (TextView)view.findViewById(R.id._fregRankaway_tv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        _fregRank_list_rv.setLayoutManager(llm);
        getRank();
        return view;
    }
    private void getRank() {
        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getRank(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());
        call.enqueue(new Callback<Rank>() {
            @Override
            public void onResponse(Call<Rank> call, Response<Rank> response) {
                if(response.isSuccessful()) {
                    RankAdpter adpter = new RankAdpter(response.body().getData().getTopList());
                    _fregRank_list_rv.setAdapter(adpter);
                    _fregRank_tv.setText(response.body().getData().getMyRank().getRank());
                    _fregRankaway_tv.setText(response.body().getData().getMyRank().getAmount());
                }
            }
            @Override
            public void onFailure(Call<Rank> call, Throwable t) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);

            }
        });
    }


}