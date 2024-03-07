package com.max.ecomaxgo.maxpe.dashboad.fragment;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.androidgamesdk.gametextinput.Listener;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.adpter.RankAdpter;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListReferResponse;
import com.max.ecomaxgo.maxpe.dashboad.modle.MyMood;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentChain extends Fragment {
      RelativeLayout chain_share_lay;
      String referallCode="";
      RecyclerView _fregChain_rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_chain_layout, container, false);
        chain_share_lay = (RelativeLayout)view.findViewById(R.id._fregChain_share_lay);
        _fregChain_rv = (RecyclerView)view.findViewById(R.id._fregChain_list_rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        _fregChain_rv.setLayoutManager(llm);
       ChainRefer();
        chain_share_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.max.ecomaxgo.maxpe"+"&referrer="+referallCode);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                getActivity().startActivity(shareIntent);
            }
        });
        return view;
    }


    private void ChainRefer() {

        MaxSharedPreference maxSharedPreference = new MaxSharedPreference(getActivity());
        com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call  call = apiService.getChainList(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken());

        call.enqueue(new Callback<ChainListRefer>() {

            @Override
            public void onResponse(Call<ChainListRefer> call, Response<ChainListRefer> response) {

                if(response.isSuccessful()) {
                    ChainAdpter chainAdpter = new ChainAdpter(response.body().getData().getChain());
                    _fregChain_rv.setAdapter(chainAdpter);
                    referallCode = response.body().getData().getRfcode();

                }else{
                    Toast.makeText(getActivity(), " no data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChainListRefer> call, Throwable t) {
                Toast.makeText(getActivity(), "there is some isssue"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }
}