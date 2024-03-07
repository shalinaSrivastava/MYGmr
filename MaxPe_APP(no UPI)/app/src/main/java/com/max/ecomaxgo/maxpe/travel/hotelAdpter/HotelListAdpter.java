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
import com.max.ecomaxgo.maxpe.travel.HotelListActivity;
import com.max.ecomaxgo.maxpe.travel.HotelPreCheck;
import com.max.ecomaxgo.maxpe.travel.SeatDetailActivity;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.BusListAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;
import com.max.ecomaxgo.maxpe.travel.hotelModel.SearchHotel;

import java.util.List;

public class HotelListAdpter extends RecyclerView.Adapter<HotelListAdpter.RecyclerViewHolder> {

    Context context;
    List<SearchHotel.Hotel> list;

    public HotelListAdpter(List<SearchHotel.Hotel> list,  Context context) {
        this.context=context;
        this.list=list;

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

        holder._hLocation.setText(list.get(position).getCity());
        holder._hName.setText(list.get(position).getHotelName());
        holder._hHighlights.setText(list.get(position).getHotelHighlights());
        holder._hAmount.setText(String.valueOf(list.get(position).getTotalPrice()));
      //  holder._hDiscount.setText(list.get(position).);
        String hotelPic = list.get(position).getImageThumbUrl();
        Glide.with(context)
                .load(hotelPic)
                .centerCrop()
                .placeholder(R.drawable._ahotel)
                .into(holder._hPhoto);

        holder._busCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail(position);
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
    private void detail(int position) {
        MaxSharedPreference mp=new MaxSharedPreference(context);
     TextView   _hD_rating,_hd_totalPrice,_hD_Location,_hD_Name,_hd_Date,_hD_highLights,_hD_meal,_hd_checkIn_time,_hd_checkOut_time,_hD_title,
             _hd_Date_out,_hD_roomType,_hD_BookingPolicy,_hD_proceed,_hd_checkIn_date,_hD_latitude,_hD_discount,_hD_cashBack,
             _hD_Address;
        ImageView _hDPhoto,_hD_back;

        LayoutInflater factory = LayoutInflater.from(context);
        final View  dialogView = factory.inflate(R.layout.dialog_hotel_detail, null);
        final AlertDialog dialog = new AlertDialog.Builder(context,R.style.DialogMiddleScreen).create();
        _hDPhoto=dialogView.findViewById(R.id._hDPhoto);
        _hD_back=dialogView.findViewById(R.id._hD_back);
//        _hD_rating=dialogView.findViewById(R.id._hD_rating);
        _hD_Location=dialogView.findViewById(R.id._hD_Location);
        _hd_totalPrice=dialogView.findViewById(R.id._hd_totalPrice);
        _hD_Name=dialogView.findViewById(R.id._hD_Name);
        _hD_highLights=dialogView.findViewById(R.id._hD_highLights);
        _hD_meal=dialogView.findViewById(R.id._hD_meal);
        _hD_title=dialogView.findViewById(R.id._hD_title);

        _hd_Date_out=dialogView.findViewById(R.id._hd_Date_out);
        _hD_roomType=dialogView.findViewById(R.id._hD_roomType);
        _hD_proceed=dialogView.findViewById(R.id._hD_proceed);
        _hd_checkIn_date=dialogView.findViewById(R.id._hd_checkIn_date);
        _hD_latitude=dialogView.findViewById(R.id._hD_latitude);
        _hD_discount=dialogView.findViewById(R.id._hD_discount);
        _hD_cashBack=dialogView.findViewById(R.id._hD_cashBack);
        _hD_BookingPolicy=dialogView.findViewById(R.id._hD_BookingPolicy);
        _hD_Address=dialogView.findViewById(R.id._hD_Address);
        _hD_roomType=dialogView.findViewById(R.id._hD_roomType);
        _hd_checkIn_time=dialogView.findViewById(R.id._hd_checkIn_time);
                _hd_checkOut_time=dialogView.findViewById(R.id._hd_checkOut_time);
        _hD_Location.setText(list.get(position).getCity());
        _hD_Name.setText(list.get(position).getHotelName());
        _hD_highLights.setText(list.get(position).getHotelHighlights());
      //_hD_meal.setText(list.get(position));
        //Address,Latitude(),TotalPrice(),discount,CashBack(),HotelID()
        _hD_latitude.setText(list.get(position).getLatitude());
        _hD_discount.setText(list.get(position).getDistance());
        _hD_cashBack.setText(list.get(position).getCashBack());
        _hd_checkIn_time.setText(list.get(position).getCheckInTime());
        _hd_checkOut_time.setText(list.get(position).getCheckOutTime());
        _hD_title.setText(list.get(position).getHotelName());

        _hd_totalPrice.setText(String.valueOf(list.get(position).getTotalPrice()));
        //_hD_BookingPolicy.setText(list.get(position).);
        _hD_Address.setText(list.get(position).getAddress());
        //_hD_roomType.setText(list.get(position).getAvailableRoom());
//        _hD_roomType.setText(list.get(position).getTripType().toString());
        _hd_checkIn_date.setText(mp.getHotel_check_in());
        _hd_Date_out.setText(mp.getHotel_check_Out());
        String hotelPic = list.get(position).getImageThumbUrl();
        _hD_proceed.setOnClickListener(view->nextActivity(position));
        Glide.with(context)
                .load(hotelPic)
                .centerCrop()
                .placeholder(R.drawable._ahotel)
                .into(_hDPhoto);
        dialog.setView(dialogView);
        _hD_back.setOnClickListener(View->dialog.dismiss());
        dialog.show();


    }

    private void nextActivity(int position) {
        Intent i = new Intent(context, HotelPreCheck.class);
        i.putExtra("key",list.get(position).getCity());
        i.putExtra("eMTCommonId","EMTBHotel-10SHL-1912531735533");
        i.putExtra("engine","10");
        i.putExtra("rateKey","BookingJini|B2C");
        i.putExtra("hotelID","SHL-1912531735533");
        i.putExtra("mealType","Breakfast not included");
        i.putExtra("roomType","Red Velvet Suite" );
        i.putExtra("roomTypeCode","SR-21031002503735");
        i.putExtra("rateCode",list.get(position).getRating());

        context.startActivity(i);
    }
}