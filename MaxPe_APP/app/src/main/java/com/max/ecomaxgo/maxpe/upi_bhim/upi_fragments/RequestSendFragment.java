package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.VpaNewActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.RequestSendAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;


public class RequestSendFragment extends Fragment {
    LoadingDialog ld;
    RecyclerView requestVpaRecycler;
    LinearLayout all;
    RequestSendAdapter requestSendAdapter;
    RequestSendAdapter.RequestOnItemClickListner requestOnItemClickListner;

    public RequestSendFragment(RequestSendAdapter.RequestOnItemClickListner requestOnItemClickListner)
    {
        this.requestOnItemClickListner = requestOnItemClickListner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_requestsend, container, false);

        requestVpaRecycler = view.findViewById(R.id.vpaRecycler);
        all = view.findViewById(R.id.rqst_all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act();
            }
        });
        vpaSetup();

        return view;
    }

    private void act() {
        Intent intent = new Intent(getContext(), VpaNewActivity.class);
        intent.putExtra("for","rsend");
        startActivity(intent);
    }

    private void vpaSetup() {
        requestSendAdapter = new RequestSendAdapter(getContext(), Upi.getBeneVpa(), requestOnItemClickListner);
        requestVpaRecycler.setAdapter(requestSendAdapter);
        requestSendAdapter.notifyDataSetChanged();
        requestVpaRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        requestSendAdapter.updateList(Upi.getBeneVpa());
    }

}
