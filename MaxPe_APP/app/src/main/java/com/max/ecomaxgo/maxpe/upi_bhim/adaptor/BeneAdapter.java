package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.BeneIfscFragment;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_fragments.BeneUpiFragment;

import org.jetbrains.annotations.NotNull;

public class BeneAdapter extends FragmentPagerAdapter{

    Context ctx;
    int totalTabs;
    BeneUpiAdapter.BeneOnItemClickListner beneUOnItemClickListner;
    BeneIfscAdapter.BeneOnItemClickListner beneIOnItemClickListner;
    public BeneUpiFragment beneUpiFragment;
    public BeneIfscFragment beneIfscFragment;

    public BeneAdapter(Context ctx, @NonNull @NotNull FragmentManager fm, int totalTabs,
                       BeneUpiAdapter.BeneOnItemClickListner beneUOnItemClickListner,
                       BeneIfscAdapter.BeneOnItemClickListner beneIOnItemClickListner
                       ) {
        super(fm);
        this.ctx = ctx;
        this.totalTabs = totalTabs;
        this.beneUOnItemClickListner = beneUOnItemClickListner;
        this.beneIOnItemClickListner = beneIOnItemClickListner;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                beneUpiFragment = new BeneUpiFragment(beneUOnItemClickListner);
                return beneUpiFragment;
            case 1:
                beneIfscFragment = new BeneIfscFragment(beneIOnItemClickListner);
                return beneIfscFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

}

