package com.max.ecomaxgo.maxpe.dashboad.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;

import java.util.ArrayList;
import java.util.List;

public class ChainAdpter extends RecyclerView.Adapter<ChainAdpter.RecyclerViewHolder> {

        List<ChainListRefer.Chain >list;
        public ChainAdpter( List<ChainListRefer.Chain >list){
         this.list=list;
        }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_chain_layout, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder._adptChain_name_tv.setText(list.get(position).getUsername());
            holder._adptChain_number_tv.setText(list.get(position).getChain());
            holder._adptChain_spent_tv.setText(list.get(position).getEarning());
            holder._adptChain_earned_tv.setText(list.get(position).getEarning());

        }



        @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our views.
            private TextView _adptChain_name_tv,_adptChain_number_tv,_adptChain_spent_tv,_adptChain_earned_tv;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                _adptChain_name_tv = itemView.findViewById(R.id._adptChain_name_tv);
                _adptChain_number_tv = itemView.findViewById(R.id._adptChain_number_tv);
                _adptChain_spent_tv = itemView.findViewById(R.id._adptChain_spent_tv);
                _adptChain_earned_tv = itemView.findViewById(R.id._adptChain_earned_tv);


            }
        }
    }
