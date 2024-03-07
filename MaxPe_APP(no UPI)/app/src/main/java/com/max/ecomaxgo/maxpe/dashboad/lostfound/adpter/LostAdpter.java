package com.max.ecomaxgo.maxpe.dashboad.lostfound.adpter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFAds;

import java.util.List;

public class LostAdpter extends RecyclerView.Adapter<LostAdpter.RecyclerViewHolder> {

        List<LFAds.Datum>list;
         Context cntx;
        public LostAdpter(Context cntx,List<LFAds.Datum> list){
         this.list=list;
         this.cntx=cntx;

        }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_lost, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

                holder._litem.setText(list.get(position).getCategory());
                holder._llocation.setText(list.get(position).getCity());
                holder._ldate.setText(list.get(position).getEntryDate());
                holder._lcontactName.setText(list.get(position).getContactPersonName());
                holder._lcontactNumber.setText(list.get(position).getContactPersonMobile());
                holder._ldescrip.setText(list.get(position).getDescription());
                holder._lFounddate.setText(list.get(position).getLostFoundDate());
                holder._lcontactNumber.setTextColor(cntx.getResources().getColor(R.color.darkblue));

            Glide.with(cntx)
                    .load(list.get(position).getImage())
                    .centerCrop()
                    .placeholder(R.drawable._delhi)
                    .into(holder._lostPhoto);

    }

    @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our views.
            private TextView _litem,_llocation,_ldate,_lcontactName,_lcontactNumber,_ldescrip,_lFounddate;
            ImageView _lostPhoto;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                        _litem= itemView.findViewById(R.id._litem);
                        _llocation= itemView.findViewById(R.id._llocation);
                        _ldate= itemView.findViewById(R.id._ldate);
                        _lcontactName= itemView.findViewById(R.id._lcontactName);
                        _lcontactNumber= itemView.findViewById(R.id._lcontactNumber);
                        _ldescrip= itemView.findViewById(R.id._ldescrip);
                       _lFounddate= itemView.findViewById(R.id._lFounddate);
                        _lostPhoto= itemView.findViewById(R.id._lostPhoto);

            }
        }
    }
