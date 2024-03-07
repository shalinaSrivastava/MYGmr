package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.SendIfscFragment;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.SendUpiFragment;

import org.jetbrains.annotations.NotNull;

public class SendAdapter extends FragmentPagerAdapter {

    Context ctx;
    int totalTabs;
    SendUpiAdapter.SendOnItemClickListner sendUOnItemClickListner;
    SendIfscAdapter.SendOnItemClickListner sendIOnItemClickListner;
    SendUpiFragment sendUpiFragment;
    SendIfscFragment sendIfscFragment;

    public SendAdapter(Context ctx, @NonNull @NotNull FragmentManager fm, int totalTabs,
                       SendUpiAdapter.SendOnItemClickListner sendUOnItemClickListner,
                       SendIfscAdapter.SendOnItemClickListner sendIOnItemClickListner) {
        super(fm);
        this.ctx = ctx;
        this.totalTabs = totalTabs;
        this.sendUOnItemClickListner = sendUOnItemClickListner;
        this.sendIOnItemClickListner = sendIOnItemClickListner;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                sendUpiFragment = new SendUpiFragment(sendUOnItemClickListner);
                return sendUpiFragment;
            case 1:
                sendIfscFragment = new SendIfscFragment(sendIOnItemClickListner);
                return sendIfscFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

}
