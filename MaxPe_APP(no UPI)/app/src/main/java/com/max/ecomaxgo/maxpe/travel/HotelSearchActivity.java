package com.max.ecomaxgo.maxpe.travel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.CityNameAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.SourceNameAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_model.CityList;
import com.max.ecomaxgo.maxpe.travel.bus_model.SourceCity;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSearchActivity extends AppCompatActivity {

    TextView placeName,inMonth,_inDate,_outMonth,_outDate,hotelSearch,noRoom;
    LinearLayout out_date_lay,in_date_lay,noRoom_lay;
    final Calendar calendar= Calendar.getInstance();
    ProgressBar bLoader;
    SourceNameAdpter sourceAdpter;
    String hotel_check_in="";
    String hotel_check_out="";
    MaxSharedPreference mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);
        mp= new MaxSharedPreference(this);
        intview();
        today();
        getTomorrowDate();
    }
    private void intview() {
        placeName = findViewById(R.id.placeName);
        out_date_lay = findViewById(R.id.out_date_lay);
        in_date_lay = findViewById(R.id.in_date_lay);
        inMonth= findViewById(R.id.inMonth);
        _inDate= findViewById(R.id._inDate);
        _outMonth= findViewById(R.id._outMonth);
        _outDate= findViewById(R.id._outDate);
        hotelSearch=findViewById(R.id.hotelSearch);
        noRoom_lay=findViewById(R.id.noRoom_lay);
        noRoom=findViewById(R.id.noRoom);
        placeName.setOnClickListener(view->placeName());
        hotelSearch.setOnClickListener(view->searchIntent());
       // noRoom_lay.setOnClickListener(view->addRoom());

        DatePickerDialog.OnDateSetListener dateIn =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        DatePickerDialog.OnDateSetListener dateOut =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);
                updateOut();
            }
        };
        in_date_lay.setOnClickListener(view-> new DatePickerDialog(this,dateIn,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show());
        out_date_lay.setOnClickListener(view-> new DatePickerDialog(this,dateOut,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show());
    }

    private void searchIntent() {

        if (placeName.getText().toString().isEmpty()){
            placeName.setError(getResources().getString(R.string.error));
        }
        else  {
            mp.setHotel_place(placeName.getText().toString());
            mp.setHotel_check_in(hotel_check_in);
            mp.setHotel_check_Out(hotel_check_out);
            mp.setHotel_Room("1");
            mp.setHotel_noAdult("2");
            mp.setHotel_childAge("2,4");
            mp.setHotel_totalChild("2");
            startActivity(new Intent(this,HotelListActivity.class));
        }
    }

    private void updateLabel(){

        String checkIn ="yyyy/MM/dd";
        String month="MMM-yyyy";
        String date="dd";
        SimpleDateFormat checkInFormate=new SimpleDateFormat(checkIn, Locale.US);
        SimpleDateFormat monthFormate=new SimpleDateFormat(month, Locale.US);
        SimpleDateFormat dateFormat=new SimpleDateFormat(date, Locale.US);
        _inDate.setText(dateFormat.format(calendar.getTime()));
        inMonth.setText(monthFormate.format(calendar.getTime()));
        hotel_check_in=checkInFormate.format(calendar.getTime());

    }

    private void updateOut(){

        String checkOut ="yyyy/MM/dd";
        String month="MMM-yyyy";
        String date="dd";
        SimpleDateFormat checkOutFormate=new SimpleDateFormat(checkOut, Locale.US);
        SimpleDateFormat monthFormate=new SimpleDateFormat(month, Locale.US);
        SimpleDateFormat dateFormat=new SimpleDateFormat(date, Locale.US);
        _outDate.setText(dateFormat.format(calendar.getTime()));
        _outMonth.setText(monthFormate.format(calendar.getTime()));
        hotel_check_out=checkOutFormate.format(calendar.getTime());

    }
    private void getTomorrowDate() {


            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = calendar.getTime();
            DateFormat month = new SimpleDateFormat("MMM-yyyy");

        DateFormat checkOut = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat date = new SimpleDateFormat("dd");
            String tomMonth = month.format(tomorrow);
        String tomdate = date.format(tomorrow);
        _outDate.setText(tomdate);
        _outMonth.setText(tomMonth);
        hotel_check_out= checkOut.format(tomorrow);
    }

    private void today() {
        hotel_check_in  = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault()).format(new Date());
            String month = new SimpleDateFormat("MMM-yyyy", Locale.getDefault()).format(new Date());
        String date = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        _inDate.setText(date);
        inMonth.setText(month);


    }
    private void placeName() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.city_name_layout, null);
        AlertDialog deleteDialog = new AlertDialog.Builder(this,android.R.style.Theme_Material_Light_NoActionBar_Fullscreen).
                create();
        RecyclerView cityList =deleteDialogView.findViewById(R.id.cityList);
        bLoader =deleteDialogView.findViewById(R.id.bLoader);
        bLoader.setVisibility(View.VISIBLE);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        cityList.setLayoutManager(llm);

        deleteDialog.setView(deleteDialogView);
        EditText _search_et_citylay = (EditText)deleteDialogView.findViewById(R.id._search_et_citylay);
        _search_et_citylay.setText("");
        placelist(cityList,bLoader,deleteDialog);

        Handler textSearchHandler  = new Handler();
        _search_et_citylay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                textSearchHandler.removeCallbacksAndMessages(null);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textSearchHandler.removeCallbacksAndMessages(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

                    if ( _search_et_citylay.getText().toString().isEmpty()){
                        bLoader.setVisibility(View.GONE);
                        textSearchHandler.removeCallbacksAndMessages(null);
                    }else {
                        textSearchHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                String sourceName = _search_et_citylay.getText().toString();
                                bLoader.setVisibility(View.VISIBLE);
                                sourceList(sourceName, cityList, deleteDialog);

                            }
                        }, 10);

                }


            }
        });
        deleteDialogView.findViewById(R.id._back_citylay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();
    }

    private void placelist( RecyclerView cityList, ProgressBar bLoader, AlertDialog deleteDialog) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.listCity(Constant.skey);
        call.enqueue(new Callback<CityList>(){
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {
                bLoader.setVisibility(View.GONE);
                if(response.isSuccessful()) {

                    CityNameAdpter cityNameAdpter = new CityNameAdpter(HotelSearchActivity.this,response.body().getData(),
                            deleteDialog,placeName,"");
                    cityList.setAdapter(cityNameAdpter);

                }else{
                    Toast.makeText(HotelSearchActivity.this, " No Data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CityList> call, Throwable t) {
                bLoader.setVisibility(View.GONE);
                Toast.makeText(HotelSearchActivity.this, " onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRoom() {
       /* TextView   _hD_rating;
        ImageView _hDPhoto,_hD_back;
        LinearLayout room_lay;

        LayoutInflater factory = LayoutInflater.from(this);
        final View  dialogView = factory.inflate(R.layout.hotel_room_layout, null);
        final AlertDialog dialog = new AlertDialog.Builder(this,R.style.DialogMiddleScreen).create();
        dialog=dialogView.findViewById(R.id.room_lay);
        deleteDialog.setView(deleteDialogView);
        dialog.show();*/

        LayoutInflater factory = LayoutInflater.from(this);
        final View dView = factory.inflate(R.layout.hotel_room_layout, null);
        AlertDialog dialog = new AlertDialog.Builder(this,
                android.R.style.Theme_Material_Light_NoActionBar_Fullscreen).create();

        dialog.setView(dView);
        dView.findViewById(R.id._h_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }
    private void sourceList(String sourceName , RecyclerView sourceList, AlertDialog deleteDialog) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.sourceCity(Constant.skey,sourceName);
        call.enqueue(new Callback<SourceCity>() {
            @Override
            public void onResponse(Call<SourceCity> call, Response<SourceCity> response) {
                bLoader.setVisibility(View.GONE);
                if(response.isSuccessful()) {
                    sourceAdpter = new SourceNameAdpter(HotelSearchActivity.this,response.body().getData(),
                            deleteDialog,placeName);
                    sourceList.setAdapter(sourceAdpter);

                }else{
                    Toast.makeText(HotelSearchActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<SourceCity> call, Throwable t) {
                bLoader.setVisibility(View.GONE);
                Toast.makeText(HotelSearchActivity.this, " onFailure", Toast.LENGTH_SHORT).show();

            }
        });

    }

}