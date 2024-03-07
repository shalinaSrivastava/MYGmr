package com.max.ecomaxgo.maxpe.travel.bus_adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.travel.BusListActivity;
import com.max.ecomaxgo.maxpe.travel.SeatDetailActivity;
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;

import java.util.List;

public class BusListAdpter extends RecyclerView.Adapter<BusListAdpter.RecyclerViewHolder> {

    Context context;
    List<BusAvailableTrips.AvailableTrip> list;

    public BusListAdpter(List<BusAvailableTrips.AvailableTrip> list, Context context) {
        this.context=context;
        this.list=list;
    }
    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_buslist_layout,
                    parent, false);
            return new RecyclerViewHolder(view);
        }
        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

          holder._busName.setText(list.get(position).getBusType());

            holder._bSeats.setText("AvailableSeats "+list.get(position).getAvailableSeats());


            holder._bStartTime.setText(list.get(position).getDepartureTime());
            holder._bTotaleTime.setText(list.get(position).getDuration());
           holder._bEndTime.setText(list.get(position).getArrivalTime());
           holder._bAmount.setText(list.get(position).getPrice());
            holder._bTracking.setOnClickListener(view->track());
            MaxSharedPreference mp = new MaxSharedPreference(context);
            mp.setBus_type(list.get(position).getBusType());
            mp.setBus_engineId(list.get(position).getEngineId().toString());
            mp.setBus_tripId(list.get(position).getId());
            mp.setBus_seater(list.get(position).getSeater().toString());
            mp.setBus_sleeper(list.get(position).getSleeper().toString());
            mp.setBus_routeId(list.get(position).getRouteId());
            holder._busCardView.setOnClickListener(view->busIntent());
        }
    private void busIntent() {



        Intent i = new Intent(context, SeatDetailActivity.class);
        context.startActivity(i);

    }
    @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our views.
            private TextView  _busName,_busType,_busRating,
                    _bStartTime,_bTotaleTime,_bEndTime,_bAmount,_bSeats,_bTracking;
            CardView _busCardView;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                _busName= itemView.findViewById(R.id._busName);
                        _busType= itemView.findViewById(R.id._busType);
                _busRating= itemView.findViewById(R.id._busRating);
                        _busType= itemView.findViewById(R.id._busType);
                _bStartTime= itemView.findViewById(R.id._bStartTime);
                        _bTotaleTime= itemView.findViewById(R.id._bTotaleTime);
                _bEndTime= itemView.findViewById(R.id._bEndTime);
                        _bAmount= itemView.findViewById(R.id._bAmount);
                _bSeats= itemView.findViewById(R.id._bSeats);
                        _bTracking= itemView.findViewById(R.id._bTracking);
                _busCardView = itemView.findViewById(R.id._busCardView);


            }
        }
    private void track() {

        LayoutInflater factory = LayoutInflater.from(context);
        final View  dialogView = factory.inflate(R.layout.dialogbox_track_bust, null);
        final AlertDialog dialog = new AlertDialog.Builder(context,R.style.DialogMiddleScreen).create();
        dialog.setView(dialogView);
        dialog.show();
    }
    }
