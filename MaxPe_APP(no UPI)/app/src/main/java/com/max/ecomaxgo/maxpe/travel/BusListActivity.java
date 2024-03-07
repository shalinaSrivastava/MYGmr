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
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusListActivity extends AppCompatActivity {
     RecyclerView busList;
     ImageView _back;
     TextView _title,_date,bus_noResult;
     ProgressBar loader;
    MaxSharedPreference mp;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        mp= new MaxSharedPreference(this);
        initView();
       // availableBus();
    }

    private void initView() {
        busList=findViewById(R.id.busList);
        _back=findViewById(R.id._back);
        _title=findViewById(R.id._title);
        _date=findViewById(R.id._date);
        bus_noResult= findViewById(R.id.bus_noResult);

        loader=findViewById(R.id.loader);
        loader.setVisibility(View.VISIBLE);
        bus_noResult.setVisibility(View.GONE);
        _back.setOnClickListener(view->finish());
        _title.setText(mp.getBus_Sourcekey()+" to "+mp.getBus_DestinationKey());
        _date.setText(mp.getBus_Date());
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        busList.setLayoutManager(llm);
        availableBus();
    }
    private void availableBus() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.busAvailableTrips(Constant.skey,mp.getBus_SourceId(),
                mp.getBus_DestinationId(),mp.getBus_Date());

        call.enqueue(new Callback<BusAvailableTrips>() {

            @Override
            public void onResponse(Call<BusAvailableTrips> call, Response<BusAvailableTrips> response) {

                loader.setVisibility(View.GONE);
                if(response.isSuccessful()) {

                        if (response.body().getMessage().equals("Success")) {

                            if (response.body().equals(null)) {
                                bus_noResult.setVisibility(View.VISIBLE);
                            } else {
                                bus_noResult.setVisibility(View.GONE);
                                BusListAdpter list = new BusListAdpter(response.body().getData().getAvailableTrips(), BusListActivity.this);
                                busList.setAdapter(list);
                            }


                        } else {
                            bus_noResult.setVisibility(View.VISIBLE);


                    }
                }else{
                    bus_noResult.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onFailure(Call<BusAvailableTrips> call, Throwable t) {
                loader.setVisibility(View.GONE);
                bus_noResult.setVisibility(View.VISIBLE);
            }
        });
    }


}