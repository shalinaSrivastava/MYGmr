package com.max.ecomaxgo.maxpe.travel.bus_adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.travel.bus_model.DestinationCity;

import java.util.List;

public class DestinationNameAdpter extends RecyclerView.Adapter<DestinationNameAdpter.RecyclerViewHolder> {

        List<DestinationCity.Datum >list;
    TextView destination;
    AlertDialog deleteDialog;
    Context context;
        public DestinationNameAdpter(Context context,List<DestinationCity.Datum> list, AlertDialog deleteDialog, TextView destination){
           this.context=context;
            this.list=list;
            this.destination=destination;
            this.deleteDialog=deleteDialog;

        }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_cityname_layout, parent, false);
            return new RecyclerViewHolder(view);
        }

        @SuppressLint("RecyclerView")
        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.adpt_cityName.setText(list.get(position).getName());
            holder.adpt_cityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MaxSharedPreference mp = new MaxSharedPreference(context);
                    mp.setBus_DestinationId(list.get(position).getId().toString());
                    mp.setBus_DestinationKey(list.get(position).getName());
                    destination.setText(list.get(position).getName());
                    deleteDialog.dismiss();
                }
            });
        }



        @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our views.
            private TextView adpt_cityName;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                adpt_cityName = itemView.findViewById(R.id.adpt_cityName);


            }
        }
    }
