package com.max.ecomaxgo.maxpe.dashboad.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.modle.Rank;

import java.util.List;

public class RankAdpter extends RecyclerView.Adapter<RankAdpter.RecyclerViewHolder> {

    List<Rank.Top> topList;

    public RankAdpter(List<Rank.Top> topList) {
        this.topList=topList;
    }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_rank_layout, parent, false);
            return new RecyclerViewHolder(view);
        }
        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder._adptR_name_tv.setText(topList.get(position).getName());
            holder._adptR_amount.setText(topList.get(position).getAmount());
            holder._adptR_rank_tv.setText(topList.get(position).getRank());

        }


        @Override
        public int getItemCount() {
            return topList.size();
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            private TextView _adptR_name_tv,_adptR_amount,_adptR_rank_tv;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                _adptR_name_tv = itemView.findViewById(R.id._adptR_name_tv);
                _adptR_amount = itemView.findViewById(R.id._adptR_amount);
                _adptR_rank_tv = itemView.findViewById(R.id._adptR_rank_tv);

            }
        }
    }
