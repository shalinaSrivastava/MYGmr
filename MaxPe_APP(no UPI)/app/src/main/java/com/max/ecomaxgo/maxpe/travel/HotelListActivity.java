package com.max.ecomaxgo.maxpe.travel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.BusListAdpter;
import com.max.ecomaxgo.maxpe.travel.hotelAdpter.HotelListAdpter;
import com.max.ecomaxgo.maxpe.travel.hotelModel.SearchHotel;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class HotelListActivity extends AppCompatActivity {
    RecyclerView _hList;
    ImageView _back;
    TextView _title,_date;
    ProgressBar loader;
    MaxSharedPreference mp;
    TextView noResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        _hList = findViewById(R.id._hList);
        loader=findViewById(R.id._hLoader);
        _back=findViewById(R.id._back);
        noResult=findViewById(R.id.noResult);
        _title=findViewById(R.id._Htitle);
        _date=findViewById(R.id._Hdate);
        noResult.setVisibility(View.GONE);
        _back.setOnClickListener(view->finish());
         mp= new MaxSharedPreference(this);
        _title.setText(mp.getHotel_place());
        _date.setText(mp.getHotel_check_in()+" to "+mp.getHotel_check_Out());
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        _hList.setLayoutManager(llm);
        availableHotel();
    }
    private void availableHotel() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        String a=mp.getHotel_place();
        String a1=mp.getHotel_noAdult();
        String a2=mp.getHotel_totalChild();
        String a3=mp.getHotel_childAge();

        Call call = apiService.searchHotel(Constant.skey,mp.getHotel_place(),
                mp.getHotel_check_in(),mp.getHotel_check_Out(),mp.getHotel_Room(),mp.getHotel_noAdult(),
                mp.getHotel_totalChild(),
                mp.getHotel_childAge());

        call.enqueue(new Callback<SearchHotel>() {

            @Override
            public void onResponse(Call<SearchHotel> call, Response<SearchHotel> response) {

                loader.setVisibility(View.GONE);
                //
                if(response.isSuccessful()) {
                    if (response.body().getMessage().equals("Authentications Failed")){
                        noResult.setVisibility(View.VISIBLE);
                    }else if (response.body().getMessage().equals("Invalid Credential")){
                        noResult.setVisibility(View.VISIBLE);
                    }else  {
                        if (response.body().getMessage().equals("Success")) {

                            if (response.body().getData().getHotellist()!=null) {
                                noResult.setVisibility(View.GONE);
                                HotelListAdpter list = new HotelListAdpter(
                                        response.body().getData().getHotellist(), HotelListActivity.this);
                                _hList.setAdapter(list);

                            } else {
                                noResult.setVisibility(View.VISIBLE);
                            }




                        } else {
                            noResult.setVisibility(View.VISIBLE);


                        }


                    }

                }else{
                    noResult.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onFailure(Call<SearchHotel> call, Throwable t) {
                loader.setVisibility(View.GONE);
                noResult.setVisibility(View.VISIBLE);
                noResult.setText("Oops! No results\n there is something wrong\n"+"("+t+")");
               // Toast.makeText(HotelListActivity.this, " onFailure"+t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}