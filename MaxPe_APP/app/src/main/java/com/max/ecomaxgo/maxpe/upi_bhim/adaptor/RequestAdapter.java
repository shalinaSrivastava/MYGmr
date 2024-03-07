package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.RequestReceivedFragment;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.RequestSendFragment;

import org.jetbrains.annotations.NotNull;

public class RequestAdapter extends FragmentPagerAdapter {

    Context ctx;
    int totalTabs;
    RequestSendAdapter.RequestOnItemClickListner requestSOnItemClickListner;
    RequestReceivedAdapter.RequestOnItemClickListner requestROnItemClickListner;
    RequestSendFragment requestSendFragment;
    public RequestReceivedFragment requestReceivedFragment;

    public RequestAdapter(Context ctx, @NonNull @NotNull FragmentManager fm, int totalTabs,
                          RequestSendAdapter.RequestOnItemClickListner requestSOnItemClickListner,
                          RequestReceivedAdapter.RequestOnItemClickListner requestROnItemClickListner) {
        super(fm);
        this.ctx = ctx;
        this.totalTabs = totalTabs;
        this.requestSOnItemClickListner = requestSOnItemClickListner;
        this.requestROnItemClickListner = requestROnItemClickListner;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                requestSendFragment = new RequestSendFragment(requestSOnItemClickListner);
                return requestSendFragment;
            case 1:
                requestReceivedFragment = new RequestReceivedFragment(requestROnItemClickListner);
                return requestReceivedFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

}

