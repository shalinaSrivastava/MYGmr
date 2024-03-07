package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.BeneIfscAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

public class BeneIfscFragment extends Fragment {
    LoadingDialog ld;
    RecyclerView beneVpaRecycler;
    LinearLayout all;
    public BeneIfscAdapter beneIfscAdapter;
    BeneIfscAdapter.BeneOnItemClickListner beneOnItemClickListner;

    public BeneIfscFragment(BeneIfscAdapter.BeneOnItemClickListner beneOnItemClickListner)
    {
        this.beneOnItemClickListner = beneOnItemClickListner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_beneifsc, container, false);

        beneVpaRecycler = view.findViewById(R.id.vpaRecycler);
//        all = view.findViewById(R.id.all);
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                act();
//            }
//        });
        ifcsSetup();

        return view;
    }

    private void ifcsSetup() {
        beneIfscAdapter = new BeneIfscAdapter(getContext(), Upi.getBeneIfsc(), beneOnItemClickListner);
        beneVpaRecycler.setAdapter(beneIfscAdapter);
        beneIfscAdapter.notifyDataSetChanged();
        beneVpaRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        beneIfscAdapter.updateList(Upi.getBeneIfsc());
    }
}