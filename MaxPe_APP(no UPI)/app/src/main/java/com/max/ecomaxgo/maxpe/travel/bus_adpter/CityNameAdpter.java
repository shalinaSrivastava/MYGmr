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
import com.max.ecomaxgo.maxpe.travel.bus_model.CityList;

import java.util.List;

public class CityNameAdpter extends RecyclerView.Adapter<CityNameAdpter.RecyclerViewHolder> {

        List<CityList.Datum >list;
        public  static Integer CITY_Id=null;
        Context context;
    AlertDialog deleteDialog;
    TextView textView;
    String placeType;
    MaxSharedPreference mp;
    public CityNameAdpter(Context context, List<CityList.Datum> list, AlertDialog deleteDialog,
                              TextView textView, String placeType){
         this.list=list;
            this.context=context;
            this.textView=textView;
            this.placeType=placeType;
            this.deleteDialog=deleteDialog;
        }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_cityname_layout,
                    parent, false);
            return new RecyclerViewHolder(view);
        }

        @SuppressLint("RecyclerView")
        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.adpt_cityName.setText(list.get(position).getName());
             mp = new MaxSharedPreference(context);
            holder.adpt_cityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (placeType.equals("source")){
                        CITY_Id=list.get(position).getId();
                        mp.setBus_SourceId(list.get(position).getId().toString());
                        mp.setBus_Sourcekey(list.get(position).getName());
                        textView.setText(list.get(position).getName());
                    }else if (placeType.equals("destination")){
                        CITY_Id=list.get(position).getId();
                        mp.setBus_DestinationId(list.get(position).getId().toString());
                        mp.setBus_DestinationKey(list.get(position).getName());
                        textView.setText(list.get(position).getName());

                    }else {
                        mp.setHotel_place(list.get(position).getName());
                        CITY_Id=list.get(position).getId();
                        textView.setText(list.get(position).getName());
                    }
                    placeType="";
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
