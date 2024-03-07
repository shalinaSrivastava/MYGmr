package com.max.ecomaxgo.maxpe.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.travel.bus_model.BusAvailableTrips;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookSeatActivity extends AppCompatActivity {
    TextView _gMrs,_gMr,_gMiss,_userLastName,
    _userAge,_userName,_idProofType,_bProcced,_btitle,_userContact;
    ImageView _bback;
    String gender="";
    MaxSharedPreference mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_seat);
        mp= new MaxSharedPreference(this);
        _gMrs = findViewById(R.id._gMrs);
        _gMr = findViewById(R.id._gMr);
        _gMiss = findViewById(R.id._gMiss);
        _userLastName = findViewById(R.id._userLastName);
        _userAge = findViewById(R.id._userAge);
        _userName = findViewById(R.id._userName);
        _idProofType = findViewById(R.id._idProofType);
        _bProcced = findViewById(R.id._bProcced);
        _bback = findViewById(R.id._bback);
        _btitle = findViewById(R.id._btitle);
        _userContact=findViewById(R.id._userContact);
        _idProofType.setOnClickListener(view -> idProof());
        _bProcced.setOnClickListener(view -> bookSeat());
        _gMrs.setOnClickListener(view -> setMrs());
        _gMr.setOnClickListener(view -> setMr());
        _gMiss.setOnClickListener(view -> setMiss());

        _bback.setOnClickListener(view->finish());
        _btitle.setText(mp.getBus_Sourcekey()+" To "+mp.getBus_DestinationKey());

    }

    private void setMrs() {
        _gMrs.setBackgroundColor(getResources().getColor(R.color.blue));
        _gMrs.setTextColor(getResources().getColor(R.color.white));
        _gMr.setBackgroundColor(getResources().getColor(R.color.white));
        _gMr.setTextColor(getResources().getColor(R.color.blue));
        _gMiss.setTextColor(getResources().getColor(R.color.blue));
        _gMiss.setBackgroundColor(getResources().getColor(R.color.white));
        gender="Mrs";
    }
    private void setMr() {
        _gMr.setBackgroundColor(getResources().getColor(R.color.blue));
        _gMr.setTextColor(getResources().getColor(R.color.white));
        _gMrs.setBackgroundColor(getResources().getColor(R.color.white));
        _gMrs.setTextColor(getResources().getColor(R.color.blue));
        _gMiss.setTextColor(getResources().getColor(R.color.blue));
        _gMiss.setBackgroundColor(getResources().getColor(R.color.white));
        gender="Mr";
    }
    private void setMiss() {
        _gMiss.setBackgroundColor(getResources().getColor(R.color.blue));
        _gMiss.setTextColor(getResources().getColor(R.color.white));
        _gMr.setBackgroundColor(getResources().getColor(R.color.white));
        _gMr.setTextColor(getResources().getColor(R.color.blue));
        _gMrs.setTextColor(getResources().getColor(R.color.blue));
        _gMrs.setBackgroundColor(getResources().getColor(R.color.white));
        gender="Miss";
    }

    private void idProof() {

            LayoutInflater factory = LayoutInflater.from(this);
            final View dialogView = factory.inflate(R.layout.dialog_idproof_layout, null);
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
            ImageView imageView = dialogView.findViewById(R.id.idType_back);
            ListView idProofType_lv = dialogView.findViewById(R.id.idProofType_lv);
            ArrayList<String> idList = new ArrayList<>();
            idList.add("Aadhaar Card");
            idList.add("PAN Card");
            idList.add("Driving License");
            idList.add("Election Commission ID Card");
            ArrayAdapter<String> idProofAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, idList);
        imageView.setOnClickListener(view->alertDialog.dismiss());
             idProofType_lv.setAdapter(idProofAdapter);
        idProofType_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _idProofType.setText(idList.get(position));
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

        }
    private void proccedDone() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View dialogView = factory.inflate(R.layout.dialog_procced_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(dialogView);
        deleteDialog.show();

    }

    private void bookSeat() {
        if (_userLastName.getText().toString().isEmpty()){
            _userLastName.setError(getResources().getString(R.string.error));
        }else if (_userLastName.getText().toString().isEmpty()){
            _userLastName.setError(getResources().getString(R.string.error));
        }else if (_idProofType.getText().toString().isEmpty()){
            _idProofType.setError(getResources().getString(R.string.error));
        }else if (_userContact.getText().toString().isEmpty()){
            _userContact.setError(getResources().getString(R.string.error));
        }else if (_userAge.getText().toString().isEmpty()){
            _userAge.setError(getResources().getString(R.string.error));
        }else if (gender.equals("")){
            _gMr.setError(getResources().getString(R.string.error));
            _gMrs.setError(getResources().getString(R.string.error));
            _gMiss.setError(getResources().getString(R.string.error));
        }
        else  {
           submite();
        }

    }

    private void submite() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.blockBusSeat(Constant.skey,mp.getBus_SourceId(),
                mp.getBus_Sourcekey(),mp.getBus_DestinationId(),mp.getBus_DestinationKey(),mp.getBus_Date(),mp.getBus_tripId(),
                mp.getBus_routeId(),mp.getBus_engineId(),_userContact.getText().toString(), mp.getUserEmail(), _idProofType.getText().toString(),
                "","",mp.getBus_type(),"","",
                "","","","","",
                "","","","","",
                "","","","","",
                "",_userName.getText().toString(),_userLastName.getText().toString(),"","",
                "",_userAge.getText().toString(),gender);

        call.enqueue(new Callback<BusAvailableTrips>() {

            @Override
            public void onResponse(Call<BusAvailableTrips> call, Response<BusAvailableTrips> response) {

                // loader.setVisibility(View.GONE);
                if(response.isSuccessful()) {

                }else{
                    Toast.makeText(BookSeatActivity.this, " No Data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<BusAvailableTrips> call, Throwable t) {
                //   loader.setVisibility(View.GONE);
                Toast.makeText(BookSeatActivity.this, " onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}