package com.max.ecomaxgo.maxpe.dashboad.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.modle.AdsBanner;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.List;

public class AdsBanerAdpter extends RecyclerView.Adapter<AdsBanerAdpter.RecyclerViewHolder> {

        List<AdsBanner.Datum >list;
    Context context;
        public AdsBanerAdpter(List<AdsBanner.Datum>list, Context context){
         this.list=list;
            this.context=context;
        }



    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_ads, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

            String hotelPic = list.get(position).getImage();
            Glide.with(context)
                    .load(hotelPic)
                    .centerCrop()
                    .placeholder(R.drawable._ahotel)
                    .into(holder.ads_banner);

        }



        @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {

            private ImageView ads_banner;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                ads_banner = itemView.findViewById(R.id.ads_banner);


            }
        }
    }
