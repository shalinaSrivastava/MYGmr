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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.CityNameAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.DestinationNameAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_adpter.SourceNameAdpter;
import com.max.ecomaxgo.maxpe.travel.bus_model.CityList;
import com.max.ecomaxgo.maxpe.travel.bus_model.DestinationCity;
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


public class BusActivity extends AppCompatActivity {

    TextView source,destination,busSearch,date_tv,todayDate,tomorrowDate;
    final Calendar calendar= Calendar.getInstance();
    ProgressBar bLoader;
    SourceNameAdpter sourceAdpter;
    ImageView flip;
    MaxSharedPreference mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
         mp = new MaxSharedPreference(BusActivity.this);
        initView();

    }
    private void initView() {
        source =findViewById(R.id.source);
        destination =findViewById(R.id.destination);
        busSearch=findViewById(R.id.busSearch);
        date_tv=findViewById(R.id.selectDate);
        todayDate=findViewById(R.id.todayDate);
        tomorrowDate=findViewById(R.id.tomorrowDate);
        flip = findViewById(R.id.flip);
        busSearch.setOnClickListener(view->searchBusList());
         source.setOnClickListener(view-> placeName("source"));
        todayDate.setOnClickListener(view->today());
        destination.setOnClickListener(view->setDestination());
        flip.setOnClickListener(view->flipPlace());
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        date_tv.setOnClickListener(view-> new DatePickerDialog(this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show());
        tomorrowDate.setOnClickListener(view->getTomorrowDate());
    }

    private void flipPlace() {
        Animation rotate = AnimationUtils.loadAnimation(BusActivity.this, R.anim.rotate);
        flip.startAnimation(rotate);
        String sourceText = source.getText().toString();
        String destinationText = destination.getText().toString();

        String busDestinationId =mp.getBus_DestinationId();
        String busSourceId =mp.getBus_SourceId();
        mp.setBus_DestinationId(busSourceId);
        mp.setBus_DestinationKey(sourceText);
        mp.setBus_Sourcekey(destinationText);
        mp.setBus_SourceId(busDestinationId);
        source.setText(destinationText);
        destination.setText(sourceText);
    }

    private void searchBusList() {
     if (source.getText().toString().isEmpty()){
            source.setError(getResources().getString(R.string.error));
        }else if (destination.getText().toString().isEmpty()){
            destination.setError(getResources().getString(R.string.error));
        }else if (date_tv.getText().toString().isEmpty()){
            date_tv.setError(getResources().getString(R.string.error));
        }
        else  {
            String date= date_tv.getText().toString();
            searchIntent(date);
        }
    }
    private void setDestination() {
        if (source.getText().toString().isEmpty()){
            source.setError(getResources().getString(R.string.error));
        }
        else  {

            placeName("destination");

        }
    }
    private void getTomorrowDate() {

        if (source.getText().toString().isEmpty()){
            source.setError(getResources().getString(R.string.error));
        }else if (destination.getText().toString().isEmpty()){
            destination.setError(getResources().getString(R.string.error));
        }
        else  {
               Calendar calendar = Calendar.getInstance();
               calendar.add(Calendar.DAY_OF_YEAR, 1);
               Date tomorrow = calendar.getTime();
               DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
               String tomorrowDate = dateFormat.format(tomorrow);
               date_tv.setText(tomorrowDate);
               searchIntent(tomorrowDate);
        }
    }

    private void today() {
     if (source.getText().toString().isEmpty()){
            source.setError(getResources().getString(R.string.error));
        }else if (destination.getText().toString().isEmpty()){
            destination.setError(getResources().getString(R.string.error));
        }
        else  {
            String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            date_tv.setText(currentDate);
            searchIntent(currentDate);
        }
    }
    private void searchIntent(String date) {


        mp.setBus_Date(date);
        Intent intent = new Intent(this,BusListActivity.class);
       startActivity(intent);

    }

    private void statelist(String placeType, RecyclerView cityList, ProgressBar bLoader, AlertDialog deleteDialog) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.listCity(Constant.skey);
        call.enqueue(new Callback<CityList>(){
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {
                bLoader.setVisibility(View.GONE);
                if(response.isSuccessful()) {

                    if (placeType.equals("source")){
                        CityNameAdpter     cityNameAdpter = new CityNameAdpter(BusActivity.this,response.body().getData(),
                                deleteDialog,source,placeType);
                        cityList.setAdapter(cityNameAdpter);

                    }else if (placeType.equals("destination")){
                        CityNameAdpter   cityNameAdpter = new CityNameAdpter(BusActivity.this,response.body().getData(),
                                deleteDialog,destination,placeType);
                        cityList.setAdapter(cityNameAdpter);
                    }


                }else{
                    Toast.makeText(BusActivity.this, " No Data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CityList> call, Throwable t) {
                bLoader.setVisibility(View.GONE);
                Toast.makeText(BusActivity.this, " onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sourceList(String sourceName , RecyclerView sourceList, AlertDialog deleteDialog) {

       ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.sourceCity(Constant.skey,sourceName);
        call.enqueue(new Callback<SourceCity>() {
            @Override
            public void onResponse(Call<SourceCity> call, Response<SourceCity> response) {
                bLoader.setVisibility(View.GONE);
                if(response.isSuccessful()) {
                    sourceAdpter = new SourceNameAdpter(BusActivity.this,response.body().getData(),deleteDialog,source);
                    sourceList.setAdapter(sourceAdpter);

                }else{
                    Toast.makeText(BusActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<SourceCity> call, Throwable t) {
                bLoader.setVisibility(View.GONE);
                Toast.makeText(BusActivity.this, " onFailure", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void destinationList(String destinationName,RecyclerView sourceList, AlertDialog deleteDialog) {

         String id=mp.getBus_SourceId();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.destinationCity(Constant.skey,mp.getBus_SourceId(),destinationName);
        call.enqueue(new Callback<DestinationCity>() {

            @Override
            public void onResponse(Call<DestinationCity> call, Response<DestinationCity> response) {
                bLoader.setVisibility(View.GONE);
                if(response.isSuccessful()) {
                    if (response.body().getMessage().equals("Invalid Request")){
                        Toast.makeText(BusActivity.this, " There is something wrong", Toast.LENGTH_SHORT).show();

                    }else {
                        DestinationNameAdpter   destinationAdpter =
                                new DestinationNameAdpter(BusActivity.this,response.body().getData(),
                                        deleteDialog,destination);
                        sourceList.setAdapter(destinationAdpter);
                    }


                }else{
                    Toast.makeText(BusActivity.this, " There is something wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<DestinationCity> call, Throwable t) {
                bLoader.setVisibility(View.GONE);
                Toast.makeText(BusActivity.this, " There is something wrong ", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void placeName(String placeType) {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.city_name_layout, null);
        AlertDialog deleteDialog = new AlertDialog.Builder(this,android.R.style.Theme_Material_Light_NoActionBar_Fullscreen).
                create();
         RecyclerView cityList =deleteDialogView.findViewById(R.id.cityList);
         bLoader =deleteDialogView.findViewById(R.id.bLoader);
        bLoader.setVisibility(View.VISIBLE);
        LinearLayoutManager llm = new LinearLayoutManager(BusActivity.this,LinearLayoutManager.VERTICAL,false);
        cityList.setLayoutManager(llm);

        deleteDialog.setView(deleteDialogView);
        EditText _search_et_citylay = (EditText)deleteDialogView.findViewById(R.id._search_et_citylay);
        _search_et_citylay.setText("");
       // cityList.setAdapter(cityNameAdpter);
        if (placeType.equals("source")){
            bLoader.setVisibility(View.VISIBLE);
            statelist(placeType,cityList,bLoader,deleteDialog);

        }else if (placeType.equals("destination")){
            bLoader.setVisibility(View.VISIBLE);
            statelist(placeType,cityList,bLoader, deleteDialog);
        }
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
                if (placeType.equals("source")) {
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


                } else if (placeType.equals("destination")) {


                    if ( _search_et_citylay.getText().toString().isEmpty()){
                        textSearchHandler.removeCallbacksAndMessages(null);
                        bLoader.setVisibility(View.GONE);
                    }else {
                        textSearchHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                bLoader.setVisibility(View.VISIBLE);
                                String destinationName = _search_et_citylay.getText().toString();
                                destinationList(destinationName, cityList, deleteDialog);

                            }
                        }, 10);
                    }
                }


            }
        });

        deleteDialogView.findViewById(R.id._cancel_citylay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _search_et_citylay.setText(null);
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
    private void updateLabel(){
        //06-01-2022
        String myFormat="dd-MM-yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        date_tv.setText(dateFormat.format(calendar.getTime()));
    }


}