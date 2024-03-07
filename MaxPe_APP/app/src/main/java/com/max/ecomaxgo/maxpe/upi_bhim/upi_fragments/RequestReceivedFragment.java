package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.RequestReceivedAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

public class RequestReceivedFragment extends Fragment {
    LoadingDialog ld;
    RecyclerView requestVpaRecycler;
    public RequestReceivedAdapter requestReceivedAdapter;
    RequestReceivedAdapter.RequestOnItemClickListner requestOnItemClickListner;

    public RequestReceivedFragment(RequestReceivedAdapter.RequestOnItemClickListner requestOnItemClickListner)
    {
        this.requestOnItemClickListner = requestOnItemClickListner;
    }

    @Override
    public void onResume() {
        super.onResume();
        requestReceivedAdapter.updateList(Upi.getPendingReqVos());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_requestreceived, container, false);

        requestVpaRecycler = view.findViewById(R.id.vpaRecycler);
        vpaSetup();

        return view;
    }


    private void vpaSetup() {
        requestReceivedAdapter = new RequestReceivedAdapter(getContext(), Upi.getPendingReqVos(), requestOnItemClickListner);
        requestVpaRecycler.setAdapter(requestReceivedAdapter);
        requestReceivedAdapter.notifyDataSetChanged();
        requestVpaRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
    }

}
