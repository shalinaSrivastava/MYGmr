package com.max.ecomaxgo.maxpe.travel.hotelAdpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.travel.HotelPreCheck;
import com.max.ecomaxgo.maxpe.travel.SeatDetailActivity;
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;
import com.max.ecomaxgo.maxpe.travel.hotelModel.PreCheckHotel;

import java.util.List;

public class PreCheckAdpter extends RecyclerView.Adapter<PreCheckAdpter.RecyclerViewHolder> {

    Context context;
    List<PreCheckHotel.Room> list;

    public PreCheckAdpter(List<PreCheckHotel.Room> list,Context context) {
        this.context=context;
        this.list=list;
    }

    public PreCheckAdpter(PreCheckHotel.Data data, HotelPreCheck context) {
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_hotel_list,
                parent, false);
        return new RecyclerViewHolder(view);
    }
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

       holder._hLocation.setText(list.get(position).getBookingPolicy());
        holder._hName.setText(list.get(position).getBookingPolicy());


    }
    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return list.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView _hLocation,_hName,_hHighlights,_hAmount,_hDiscount;
        ImageView _hPhoto;
        CardView _busCardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            _hLocation= itemView.findViewById(R.id._hLocation);
            _hName= itemView.findViewById(R.id._hName);
            _hHighlights= itemView.findViewById(R.id._hHighlights);
            _hAmount= itemView.findViewById(R.id._hAmount);
            _hPhoto= itemView.findViewById(R.id._hPhoto);
            _hDiscount= itemView.findViewById(R.id._hDiscount);
            _busCardView= itemView.findViewById(R.id._busCardView);
        }
    }

}