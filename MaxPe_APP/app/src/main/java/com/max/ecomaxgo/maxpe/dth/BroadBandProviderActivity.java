package com.max.ecomaxgo.maxpe.dth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.bbps.Biller;
import com.max.ecomaxgo.maxpe.bbps.BillerCustomerParam;
import com.max.ecomaxgo.maxpe.bbps.BillerData;
import com.max.ecomaxgo.maxpe.bbps.FetchBiller;
import com.max.ecomaxgo.maxpe.dth.adapter.EditTextAdapter;
import com.max.ecomaxgo.maxpe.dth.model.GetBilllerApi;
import com.max.ecomaxgo.maxpe.dth.model.Validate;
import com.max.ecomaxgo.maxpe.util.Constant;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class BroadBandProviderActivity extends AppCompatActivity{


    int paramSize;
    RelativeLayout ll;
    ProgressBar progressBar;
    static final String TAG = BroadBandProviderActivity.class.getSimpleName();
    static final String BASE_URL = "https://maxpe.in/api/index.php/";
    static Retrofit retrofit = null;
    private RecyclerView recyclerView;
    private EditTextAdapter customAdapter;
    public List<BillerCustomerParam> editModelArrayList;
    String BillDate;
    String BillNumber;
    String Amount;
    String DueDate;
    String BillPeriod;
    String CustomerName;
    String billerId;
    String billerName;
    String billerIcon;
    GetBilllerApi getBilllerApi;

    private TextView tvBillerName;
    private ImageView ivLogoDth;
    private Button btnNext;
    String paramNameComma;
    String paramNames;
    String paramValues;
    MaxSharedPreference maxSharedPreference;
    String paramX;
    ProgressDialog progressDialog;
    int minLength, maxLength;
    EditText ed;
    TextView tvLabel;
    String fetchRequirement;
    String supportBillValidation;
    private TextInputLayout filledTextField;
    private EditText etAmount;
    List<String> stringList;
    List<String> optionalList;
    List<Integer> minlist;
    List<Integer> maxlist;
    String optional;
    List<String> pn = new ArrayList<>();
    List<String> pv = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_h_provider);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        maxSharedPreference = new MaxSharedPreference(this);
        btnNext = (Button)findViewById(R.id.btnNext);
        ivLogoDth = (ImageView)findViewById(R.id.ivLogoDth);
        tvBillerName = (TextView)findViewById(R.id.tvBillerName);
        filledTextField = (TextInputLayout)findViewById(R.id.filledTextField);
        etAmount = (EditText)findViewById(R.id.etAmount);
        tvLabel = (TextView)findViewById(R.id.tvLabel);
        billerId = getIntent().getStringExtra("billerId");
        billerName = getIntent().getStringExtra("billerName");
        billerIcon = getIntent().getStringExtra("billerLogo");

        System.out.println("billerId----------------------"+billerId);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        Glide.with(this)
                .load(billerIcon)
                .centerCrop()
                .placeholder(R.drawable.max_logo)
                .into(ivLogoDth);
        tvBillerName.setText(billerName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("fetchRequirement+++---------------"+fetchRequirement);
                if (fetchRequirement.equals("true")){
                    fetchBill();
                }else if (fetchRequirement.equals("false")){

                    validationApi(etAmount.getText().toString());
                    //System.out.println("fetchRequirement+++---------------"+fetchRequirement);
                }
            }
        });
        progressBar = findViewById(R.id.rv_progress_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        editModelArrayList  = new ArrayList<>();

        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS).build();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        //Creating an object of our api interface
        getBilllerApi = retrofit.create(GetBilllerApi.class);
        Call<Biller> call = getBilllerApi.biller(Constant.skey, billerId);
        call.enqueue(new Callback<Biller>() {
            @Override
            public void onResponse(Call<Biller> call, Response<Biller> response) {
                System.out.println("podt--------post---------------"+response.message());
                Biller biller = (Biller) response.body();
                if (biller.getStatus().equals("1")){
                    progressBar.setVisibility(View.GONE);
                    System.out.println("podt--------post---------------"+response.message());

                    BillerData billerData = biller.getData();
                    fetchRequirement = billerData.getFetchRequirement();
                    supportBillValidation = billerData.getSupportBillValidation();
                    System.out.println("fetchRequirement---------------"+fetchRequirement);
                    System.out.println("supportBillValidation---------------"+supportBillValidation);

                    if (fetchRequirement.equals("true")){
                        btnNext.setText("Fetch Bill");
                        filledTextField.setVisibility(View.GONE);
                        btnNext.setVisibility(View.VISIBLE);
                    }else {
                        btnNext.setText("Validate");
                        filledTextField.setVisibility(View.VISIBLE);
                        btnNext.setVisibility(View.VISIBLE);
                    }
                    paramSize = billerData.getBillerCustomerParams().size();
                    System.out.println("paramSize------------------------"+paramSize);
                    List <BillerCustomerParam> CustomerInputList = billerData.getBillerCustomerParams();
                    editModelArrayList =  CustomerInputList;
                    System.out.println("CustomerInputList-------------------"+CustomerInputList.toString());

                    customAdapter = new EditTextAdapter(BroadBandProviderActivity.this,editModelArrayList);
                    recyclerView.setAdapter(customAdapter);
                    customAdapter.notifyDataSetChanged();

                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));

                    stringList = new ArrayList<>();
                    optionalList = new ArrayList<>();

                    minlist = new ArrayList<>();
                    maxlist = new ArrayList<>();

                    for (BillerCustomerParam bill: CustomerInputList){
                        System.out.println("paramName--------------------"+bill.getParamName());
                        stringList.add(bill.getParamName());
                        optionalList.add(bill.getOptional());

                        minlist.add(bill.getMinLength());
                        maxlist.add(bill.getMaxLength());


                        //System.out.println("maxLength--------------------"+bill.getMaxLength());
                        //System.out.println("minLength--------------------"+bill.getMinLength());
                        String paramName = bill.getParamName();
                        if (paramName.equals("Amount")){
                            filledTextField.setVisibility(View.INVISIBLE);
                            System.out.println("paramName--------------------"+bill.getParamName());
                        }

                    }
                    //if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        paramNameComma = String.join(",", stringList);
                        System.out.println("countriesComma--------------------"+paramNameComma);
                    //}
                }else if (biller.getStatus().equals("0")) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(BroadBandProviderActivity.this, biller.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Biller> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void fetchBill() {
        progressDialog.show();
        int hasError = 0;
        int isFill = 0;
        List<String> listValue = new ArrayList<>();

        for (int i = 0; i < paramSize; i++) {

            minLength = minlist.get(i);
            maxLength = maxlist.get(i);
            View parentView = recyclerView.getChildAt(i);
            ed = (EditText) parentView.findViewById(R.id.et);
            tvLabel = (TextView) parentView.findViewById(R.id.tvLabel);
            System.out.println("maxLength----+++------------------" + maxLength);
            System.out.println("minLength------+++----------------" + minLength);

            tvLabel.setVisibility(View.GONE);
            System.out.println("Edittext Value : " + ed.getText().toString());
            listValue.add(ed.getText().toString());

            System.out.println("listvalue----------------------" + listValue.toString());
            System.out.println("listvalue----------------------" + stringList.toString());


            if (optionalList.get(i).toString().equals("false")) {
                if (ed.getText().toString().trim().equals("")) {

                    tvLabel.setText("Please enter " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);
                    hasError = 1;

                } else if (!(ed.getText().length() >= minLength && ed.getText().length() <= maxLength)) {
                    ///System.out.println("maxLength----------------------" + "failed");
                    tvLabel.setText("Invalid " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);
                    //Toast.makeText(BroadBandProviderActivity.this, String.valueOf(ed.getText().length()), Toast.LENGTH_LONG).show();
                    hasError = 1;
                }
                isFill = 1;
            } else if (optionalList.get(i).toString().equals("true") && !ed.getText().toString().equals("")) {
                if (!(ed.getText().length() >= minLength && ed.getText().length() <= maxLength)) {
                    //System.out.println("maxLength----------------------" + "failed");
                    tvLabel.setText("Invalid " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);

                    hasError = 1;
                }

                isFill = 1;
            }
        }


//        if (ed.getText().length()<minLength || ed.getText().length()>maxLength) {
//            //progressDialog.dismiss();
//            System.out.println("maxLength----------------------" + "failed");
//            tvLabel.setText("Invalid "+paramNameComma);
//            tvLabel.setVisibility(View.VISIBLE);
//            //Toast.makeText(BroadBandProviderActivity.this, "Invalid ", Toast.LENGTH_LONG).show();
//        } else {
//            System.out.println("maxLength----------------------" + "success");
//            tvLabel.setVisibility(View.GONE);

        if(isFill == 0)
        {
            Toast.makeText(BroadBandProviderActivity.this, "Please fill atleast one field ", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
        else if(hasError == 1) {
            progressDialog.dismiss();
        }
        else {

            for (int i = 0; i < paramSize; i++) {
                if (optionalList.get(i).equals("false")){
                    pn.add(stringList.get(i));
                    pv.add(listValue.get(i));
                }else if (optionalList.get(i).equals("true")) {
                    if (!listValue.get(i).toString().trim().equals("")){
                        pn.add(stringList.get(i));
                        pv.add(listValue.get(i));
                    }
                }
            }


            paramNames = String.join(",", pn);
            paramValues = String.join(",", pv);

            System.out.println("paramNames+++++++++++++++++++++++++"+paramNames);
            System.out.println("paramValues+++++++++++++++++++++++++"+paramValues);
            fetchBillApi(Constant.skey, billerId, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(), paramNameComma, paramValues);
        }
    }

    private void fetchBillApi(String skey, String billerId, String mobNo, String token, String paramName, String paramVal){

        Call<FetchBiller> call = getBilllerApi.fetchBill(skey, billerId, mobNo, token, paramName, paramVal);
        call.enqueue(new Callback<FetchBiller>() {
            @Override
            public void onResponse(Call<FetchBiller> call, Response<FetchBiller> response) {

                FetchBiller fetchBiller = (FetchBiller) response.body();
                System.out.println("fetchResponse------------------------" + fetchBiller);
                if (fetchBiller!=null){
                    if (fetchBiller.getStatus().equals("1")) {
                        progressDialog.dismiss();
                        System.out.println("gfderdsa-----------------------------"+fetchBiller.getStatus());

                        //Toast.makeText(BroadBandProviderActivity.this, fetchBiller.getMessage(), Toast.LENGTH_LONG).show();

                        CustomerName = fetchBiller.getData().getBillDetail().getCustomerName();
                        Amount = fetchBiller.getData().getBillDetail().getAmount();
                        DueDate = fetchBiller.getData().getBillDetail().getDueDate();
                        BillDate = fetchBiller.getData().getBillDetail().getBillDate();
                        BillNumber = fetchBiller.getData().getBillDetail().getBillNumber();
                        BillPeriod = fetchBiller.getData().getBillDetail().getBillPeriod();
                        Intent intent = new Intent(BroadBandProviderActivity.this, PayBroadBandBillActivity.class);
                        intent.putExtra("CustomerName", CustomerName);
                        intent.putExtra("Amount",Amount);
                        intent.putExtra("DueDate",DueDate);
                        intent.putExtra("BillDate",BillDate);
                        intent.putExtra("BillNumber",BillNumber);
                        intent.putExtra("billerId", billerId);
                        intent.putExtra("billerIcon", billerIcon);
                        intent.putExtra("billerName", billerName);
                        //intent.putExtra("billerAcceptsAdhoc", fetchBiller.getData().getBillerAcceptsAdhoc());
                        intent.putExtra("paymentAmountExactness", fetchBiller.getData().getPaymentAmountExactness());
                        intent.putExtra("billToken", fetchBiller.getData().getBillToken());
                        intent.putExtra("paramvalues", pv.get(0));
                        startActivity(intent);
                        finish();

                    } else if (fetchBiller.getStatus().equals("0")) {
                        progressDialog.dismiss();
                        Toast.makeText(BroadBandProviderActivity.this, fetchBiller.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.println("message---------------------------------");

                    }

                }else {

                }

            }

            @Override
            public void onFailure(Call<FetchBiller> call, Throwable t) {
                System.out.println("------------------"+t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    private void validationApi(String amount){
        progressDialog.show();
        int hasError = 0;
        int isFill = 0;
        List<String> listValue = new ArrayList<>();
        for (int i = 0; i < paramSize; i++) {
            minLength = minlist.get(i);
            maxLength = maxlist.get(i);
            View parentView = recyclerView.getChildAt(i);
            ed = (EditText) parentView.findViewById(R.id.et);
            System.out.println("Edittext Value : " + ed.getText().toString());
            listValue.add(ed.getText().toString());

            System.out.println("maxLength----------------------" + maxLength);
            System.out.println("minLength----------------------" + minLength);

            System.out.println("listvalue----------------------" + listValue.toString());


            if (optionalList.get(i).toString().equals("false")) {
                if (ed.getText().toString().trim().equals("")) {

                    tvLabel.setText("Please enter " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);
                    hasError = 1;

                } else if (!(ed.getText().length() >= minLength && ed.getText().length() <= maxLength)) {
                    ///System.out.println("maxLength----------------------" + "failed");
                    tvLabel.setText("Invalid " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);
                    //Toast.makeText(BroadBandProviderActivity.this, String.valueOf(ed.getText().length()), Toast.LENGTH_LONG).show();
                    hasError = 1;
                }
                isFill = 1;
            } else if (optionalList.get(i).toString().equals("true") && !ed.getText().toString().equals("")) {
                if (!(ed.getText().length() >= minLength && ed.getText().length() <= maxLength)) {
                    //System.out.println("maxLength----------------------" + "failed");
                    tvLabel.setText("Invalid " + stringList.get(i));
                    tvLabel.setVisibility(View.VISIBLE);

                    hasError = 1;
                }

                isFill = 1;
            }

            if (ed.getText().length() < minLength || ed.getText().length() > maxLength) {
                progressDialog.dismiss();
                //System.out.println("maxLength----------------------" + "failed");
                //Toast.makeText(BroadBandProviderActivity.this, "Invalid length", Toast.LENGTH_LONG).show();
            } else {
                System.out.println("maxLength----------------------" + "success");

            }
        }

        if(isFill == 0)
        {
            Toast.makeText(BroadBandProviderActivity.this, "Please fill atleast one field ", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
        else if(hasError == 1) {
            progressDialog.dismiss();
        }
        else {
            List<String> pn = new ArrayList<>();
            List<String> pv = new ArrayList<>();
            for (int i = 0; i < paramSize; i++) {
                if (optionalList.get(i).equals("false")) {
                    pn.add(stringList.get(i));
                    pv.add(listValue.get(i));
                } else if (optionalList.get(i).equals("true")) {
                    if (!listValue.get(i).toString().trim().equals("")) {
                        pn.add(stringList.get(i));
                        pv.add(listValue.get(i));
                    }
                }
            }


            paramNames = String.join(",", pn);
            paramValues = String.join(",", pv);

            System.out.println("paramNames+++++++++++++++++++++++++" + paramNames);
            System.out.println("paramValues+++++++++++++++++++++++++" + paramValues);
//            fetchBillApi(Constant.skey, billerId, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(), paramNameComma, paramValues);
//        }
//        paramValues = String.join(",", listValue);
            System.out.println("paramValue--------------------" + paramValues);
            System.out.println("number--------------------" + maxSharedPreference.getUserMobileNum());
            System.out.println("token--------------------" + maxSharedPreference.getUserToken());
            System.out.println("billerId--------------------" + billerId);
            System.out.println("Constant.skey--------------------" + Constant.skey);
            System.out.println("Constantparamname--------------------" + paramNameComma);
            System.out.println("amount---------------------------" + amount);
            Call<Validate> call = getBilllerApi.validate(Constant.skey, billerId, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(), paramNameComma, paramValues, amount);
            call.enqueue(new Callback<Validate>() {
                @Override
                public void onResponse(Call<Validate> call, Response<Validate> response) {
                    System.out.println("---------------------------");
                    Validate validate = (Validate) response.body();
                    if (validate.getStatus().equals("1")) {
                        progressDialog.dismiss();
                        Intent intent = new Intent(BroadBandProviderActivity.this, PayBroadBandBillActivity.class);
                        intent.putExtra("supportbillvalidation", supportBillValidation);
                        intent.putExtra("billerId", validate.getData().getBillerID());
                        intent.putExtra("billToken", validate.getData().getBillToken());
                        intent.putExtra("billerIcon", billerIcon);
                        intent.putExtra("billerName", billerName);
                        intent.putExtra("Amount", amount);
                        intent.putExtra("paramvalues", pv.get(0));
                        startActivity(intent);
                        finish();

                    }

                }

                @Override
                public void onFailure(Call<Validate> call, Throwable t) {
                    progressDialog.dismiss();
                }
            });
        }
    }
}

