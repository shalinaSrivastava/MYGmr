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
import com.max.ecomaxgo.maxpe.travel.bus_model.SourceCity;

import java.util.List;

public class SourceNameAdpter extends RecyclerView.Adapter<SourceNameAdpter.RecyclerViewHolder> {

        List<SourceCity.Datum >list;
        public  static String source_Id="";
    AlertDialog deleteDialog;
    TextView sorceName;
    Context context;

        public SourceNameAdpter(Context context,List<SourceCity.Datum> list, AlertDialog deleteDialog, TextView sorceName){

            this.sorceName=sorceName;
            this.list=list;
            this.deleteDialog=deleteDialog;
            this.context=context;

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
            MaxSharedPreference maxSharedPreference=new MaxSharedPreference(context);
           holder.adpt_cityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    source_Id=list.get(position).getId().toString();
                    sorceName.setText(list.get(position).getName());
                    maxSharedPreference.setBus_SourceId(list.get(position).getId().toString());
                    maxSharedPreference.setBus_Sourcekey(list.get(position).getName());
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
