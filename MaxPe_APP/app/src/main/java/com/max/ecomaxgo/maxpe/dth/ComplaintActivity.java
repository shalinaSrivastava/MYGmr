package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dth.model.ComplaintReg;
import com.max.ecomaxgo.maxpe.dth.model.DetailComplaint;
import com.max.ecomaxgo.maxpe.dth.model.GetBilllerApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComplaintActivity extends AppCompatActivity {

    ImageView backiv;
    Button submitbtn;
    String paymentRefNumber = "VALIDATEEEEEEEEEE637576801913698706";
    EditText description;
    EditText deposition;

    static final String TAG = BroadBandProviderActivity.class.getSimpleName();
    static final String BASE_URL = "https://maxpe.in/api/index.php/UAT/Euronet/newapi/";
    static Retrofit retrofit = null;

    GetBilllerApi getBilllerApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        description = findViewById(R.id.et2);
        deposition = findViewById(R.id.et3);

        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(2000, TimeUnit.SECONDS)
                    .readTimeout(2000, TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        backiv = findViewById(R.id.backiv);
        backiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void btn_submit(View view) {
        getBilllerApi = retrofit.create(GetBilllerApi.class);
        Call<ComplaintReg> call = getBilllerApi.complaintReg(paymentRefNumber, description.getText(), deposition.getText(), "d2k4m5n7q8r9b3k4m6p7q8s2j3m5n6p8r9s2k4m5n7q8r");
        call.enqueue(new Callback<ComplaintReg>() {
            @Override
            public void onResponse(Call<ComplaintReg> call, Response<ComplaintReg> response) {
                ComplaintReg complaintReg = response.body();
                DetailComplaint detailComplaint = complaintReg.getDetailComplaint();

                String ComplaintStatus = detailComplaint.getComplaintStatus();
                Toast.makeText(ComplaintActivity.this, "ComplaintStatus:  " + ComplaintStatus, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ComplaintActivity.this, ComplaintListActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ComplaintReg> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

}