package com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.VpaNewActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendUpiAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

public class SendUpiFragment extends Fragment {
    LoadingDialog ld;
    RecyclerView sendVpaRecycler;
    LinearLayout all;
    SendUpiAdapter sendUpiAdapter;
    SendUpiAdapter.SendOnItemClickListner sendOnItemClickListner;

    public SendUpiFragment(SendUpiAdapter.SendOnItemClickListner sendOnItemClickListner)
    {
        this.sendOnItemClickListner = sendOnItemClickListner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sendupi, container, false);

        sendVpaRecycler = view.findViewById(R.id.vpaRecycler);
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
        intent.putExtra("for","send");
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        sendUpiAdapter.updateList(Upi.getBeneVpa());
    }

    private void vpaSetup() {
        sendUpiAdapter = new SendUpiAdapter(getContext(), Upi.getBeneVpa(), sendOnItemClickListner);
        sendVpaRecycler.setAdapter(sendUpiAdapter);
        sendUpiAdapter.notifyDataSetChanged();
        sendVpaRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
    }
}
