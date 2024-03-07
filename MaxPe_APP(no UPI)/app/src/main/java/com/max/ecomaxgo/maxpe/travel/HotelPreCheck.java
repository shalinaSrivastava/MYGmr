package com.max.ecomaxgo.maxpe.travel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.hotelModel.PreCheckHotel;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelPreCheck extends AppCompatActivity {
    TextView _booking,noResult;
    RecyclerView preCheck_list;
 EditText _hChildName,  _hChildAge,h_adultAge,h_adultName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_pre_check);

        intView();

        PreCheck();
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        preCheck_list.setLayoutManager(llm);
        _booking.setOnClickListener(view->next());
    }

    private void intView() {
        _hChildName=findViewById(R.id._hChildName);
                _hChildAge=findViewById(R.id._hChildAge);
                h_adultAge=findViewById(R.id.h_adultAge);
                h_adultName=findViewById(R.id.h_adultName);
        _booking=findViewById(R.id._booking);
        preCheck_list=findViewById(R.id.preCheck_list);
        noResult=findViewById(R.id.noResult);
        noResult.setVisibility(View.GONE);
        preCheck_list.setVisibility(View.VISIBLE);
    }

    private void next() {
        noResult.setVisibility(View.GONE);
        preCheck_list.setVisibility(View.GONE);
        /*Fragment fragment_prfile = new FragPreCheck();
        getSupportFragmentManager().beginTransaction().replace(R.id._ContainerView,
                fragment_prfile, fragment_prfile.getClass().getSimpleName()).addToBackStack(null).commit();*/
        _hChildName=findViewById(R.id._hChildName);
        _hChildAge=findViewById(R.id._hChildAge);
        h_adultAge=findViewById(R.id.h_adultAge);
        h_adultName=findViewById(R.id.h_adultName);

        if (_hChildName.getText().toString().isEmpty()){
            _hChildName.setError(getResources().getString(R.string.error));
        }else if (_hChildAge.getText().toString().isEmpty()){
            _hChildAge.setError(getResources().getString(R.string.error));
        }else if (h_adultAge.getText().toString().isEmpty()){
            h_adultAge.setError(getResources().getString(R.string.error));
        }
        else  {
            bookHotel();
        }
    }

    private void bookHotel()  {
            MaxSharedPreference mp = new MaxSharedPreference(this);
            String a=mp.getHotel_check_in();
            String a2=mp.getHotel_check_Out();
            String a3=mp.getHotel_noAdult();
            String a4=mp.getHotel_totalChild();
            String a5= mp.getHotel_childAge();
            String a6=mp.getHotel_Room();
            String a7=mp.getHotel_place();
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call call = apiService.bookHotel(Constant.skey,"", "",
                    "", "",
                    "","","",
                    "","","","",
                    "","",
                    "","",
                    "",
                    "","","");
            call.enqueue(new Callback<PreCheckHotel>() {

                @Override
                public void onResponse(Call<PreCheckHotel> call, Response<PreCheckHotel> response) {
                    if(response.isSuccessful()) {

                        if (response.body().getMessage().equals("Invalid Request")){

                        }else {

                        }

                    }else{
                        Toast.makeText(HotelPreCheck.this, " no data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PreCheckHotel> call, Throwable t) {

                    Toast.makeText(HotelPreCheck.this, "there is some isssue"+t, Toast.LENGTH_SHORT).show();

                }
            });

        }

    private void PreCheck() {
        MaxSharedPreference mp = new MaxSharedPreference(this);
        String a=mp.getHotel_check_in();
        String a2=mp.getHotel_check_Out();
        String a3=mp.getHotel_noAdult();
        String a4=mp.getHotel_totalChild();
        String a5= mp.getHotel_childAge();
        String a6=mp.getHotel_Room();
        String a7=mp.getHotel_place();
         ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.preCheckHotel(Constant.skey,getIntent().getStringExtra("key"), mp.getHotel_check_in(),
                mp.getHotel_check_Out(), mp.getHotel_Room(),
                mp.getHotel_noAdult(),mp.getHotel_totalChild(),
                mp.getHotel_childAge(),getIntent().getStringExtra("eMTCommonId"),
                getIntent().getStringExtra("engine"),getIntent().getStringExtra("rateKey"),
                getIntent().getStringExtra("hotelID"),getIntent().getStringExtra("mealType"),
                getIntent().getStringExtra("roomType"),
                getIntent().getStringExtra("roomTypeCode"),getIntent().getStringExtra("rateCode"));
        call.enqueue(new Callback<PreCheckHotel>() {

            @Override
            public void onResponse(Call<PreCheckHotel> call, Response<PreCheckHotel> response) {
                if(response.isSuccessful()) {

                    if (response.body().getMessage().equals("Invalid Request")){

                        noResult.setVisibility(View.VISIBLE);
                        preCheck_list.setVisibility(View.GONE);
                    }else {
                        preCheck_list.setVisibility(View.GONE);
                        noResult.setVisibility(View.VISIBLE);
                      //  PreCheckAdpter list =
                         //       new PreCheckAdpter(response.body().getData(),HotelPreCheck.this);
                      //  preCheck_list.setAdapter(list);
                        noResult.setText(response.body().getData().getRooms().getRoom().get(0).getEMTCommonID());
                    }

                }else{
                    Toast.makeText(HotelPreCheck.this, " no data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PreCheckHotel> call, Throwable t) {
                noResult.setVisibility(View.VISIBLE);
                Toast.makeText(HotelPreCheck.this, "there is some isssue"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }
}