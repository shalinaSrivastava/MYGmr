package com.max.ecomaxgo.maxpe.dashboad.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.MenuContainerActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.fragment.ProfileFragment;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMenu extends Fragment {

   TextView _mRank,_mChain,_mMile,_mTrans,_mContest;
   ImageView _back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewInf = inflater.inflate(R.layout.fragment_menu, container, false);
                 _mRank=viewInf.findViewById(R.id._mRank);
                _mChain=viewInf.findViewById(R.id._mChain);
                _mMile=viewInf.findViewById(R.id._mMile);
                _mTrans=viewInf.findViewById(R.id._mTrans);
             _mContest=viewInf.findViewById(R.id._mTrans);
        _back=viewInf.findViewById(R.id._back);


        _mRank.setOnClickListener(view->callIntent("My Rank"));
        _mChain.setOnClickListener(view->callIntent("My Chain"));
        _mMile.setOnClickListener(view->callIntent("My Milestone"));
        _mContest.setOnClickListener(view->callIntent("Monthly Contest"));
        _mTrans.setOnClickListener(view->callIntent("Transactions"));
        _back.setOnClickListener(view->back());
        return viewInf;
    }

    private void back() {
        Intent intent = new Intent(getActivity(), DashboadActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void callIntent(String TITLE) {
        Intent intent = new Intent(getActivity(), MenuContainerActivity.class);
        intent.putExtra("title", TITLE);
        startActivity(intent);
    }



}