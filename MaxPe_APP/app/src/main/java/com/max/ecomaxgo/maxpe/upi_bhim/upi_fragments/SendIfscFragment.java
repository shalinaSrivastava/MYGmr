package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.SendIfscActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendIfscAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

import org.jetbrains.annotations.NotNull;

public class SendIfscFragment extends Fragment {
    LoadingDialog ld;
    LinearLayout all;
    RecyclerView sendIfscRecycler;
    SendIfscAdapter sendIfscAdapter;
    SendIfscAdapter.SendOnItemClickListner sendOnItemClickListner;

    public SendIfscFragment(SendIfscAdapter.SendOnItemClickListner sendOnItemClickListner) {
        this.sendOnItemClickListner = sendOnItemClickListner;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sendifsc, container, false);

        sendIfscRecycler = view.findViewById(R.id.vpaRecycler);
        all = view.findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act();
            }
        });
        ifscSetup();

        return view;
    }

    private void ifscSetup() {
        sendIfscAdapter = new SendIfscAdapter(getContext(), Upi.getBeneIfsc(), sendOnItemClickListner);
        sendIfscRecycler.setAdapter(sendIfscAdapter);
        sendIfscAdapter.notifyDataSetChanged();
        sendIfscRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        sendIfscAdapter.updateList(Upi.getBeneIfsc());
    }

    private void act() {
        Intent intent = new Intent(getContext(), SendIfscActivity.class);
        startActivity(intent);
    }


}
