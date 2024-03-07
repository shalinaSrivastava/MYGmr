package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LoginActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.VpaNewActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BeneUpiAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog;


public class BeneUpiFragment extends Fragment {
    RecyclerView beneVpaRecycler;
    LinearLayout all;
    public BeneUpiAdapter beneUpiAdapter;
    BeneUpiAdapter.BeneOnItemClickListner beneOnItemClickListner;


    public BeneUpiFragment(BeneUpiAdapter.BeneOnItemClickListner beneOnItemClickListner)
    {
        this.beneOnItemClickListner = beneOnItemClickListner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_beneupi, container, false);

        beneVpaRecycler = view.findViewById(R.id.vpaRecycler);
        all = view.findViewById(R.id.all);
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
        intent.putExtra("for","bene");
        startActivity(intent);
    }

    private void vpaSetup() {
        beneUpiAdapter = new BeneUpiAdapter(getContext(), Upi.getBeneVpa(), beneOnItemClickListner);
        beneVpaRecycler.setAdapter(beneUpiAdapter);
        beneUpiAdapter.notifyDataSetChanged();
        beneVpaRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        beneUpiAdapter.updateList(Upi.getBeneVpa());
    }


}
