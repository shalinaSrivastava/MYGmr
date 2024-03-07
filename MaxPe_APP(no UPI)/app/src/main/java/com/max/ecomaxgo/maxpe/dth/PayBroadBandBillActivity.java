package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dth.model.BillPay;
import com.max.ecomaxgo.maxpe.dth.model.BillPaymentVal;
import com.max.ecomaxgo.maxpe.dth.model.DetailBillPay;
import com.max.ecomaxgo.maxpe.dth.model.DetailBillPaymentVal;
import com.max.ecomaxgo.maxpe.dth.model.GetBilllerApi;
import com.max.ecomaxgo.maxpe.util.Constant;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PayBroadBandBillActivity extends AppCompatActivity {

    static final String TAG = BroadBandProviderActivity.class.getSimpleName();
    static final String BASE_URL = "https://maxpe.in/api/index.php/";
    static Retrofit retrofit = null;

    MaxSharedPreference maxSharedPreference;
    String CustomerName;
    String Amount;
    String DueDate;
    String BillDate;
    String BillNumber;
    String billerId;
    String paymentAmountExactness;
    String billToken;

    String billerName;
    String billerIcon;
    GetBilllerApi billPayApi;
    private Button btnNext;
    private TextView tvBillerName, tvBillerNumber, tvCustomerName, tvbillDate, tvBillDue, tvBillNumber;
    private EditText et;
    private ImageView ivLogoDth;
    ProgressDialog progressDialog;
    private TextView tvMessage;
    private CheckBox checkbox;
    String supportbillvalidation;
    LinearLayout linearOne, linearTwo;
    String paramvalues;
    private LinearLayout linearThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_broad_band_bill);

        maxSharedPreference = new MaxSharedPreference(this);
        CustomerName = getIntent().getStringExtra("CustomerName");
        Amount = getIntent().getStringExtra("Amount");
        DueDate = getIntent().getStringExtra("DueDate");
        BillDate = getIntent().getStringExtra("BillDate");
        billerId = getIntent().getStringExtra("billerId");
        BillNumber = getIntent().getStringExtra("BillNumber");
        paramvalues = getIntent().getStringExtra("paramvalues");
//        billerAcceptsAdhoc = getIntent().getStringExtra("billerAcceptsAdhoc");
        paymentAmountExactness = getIntent().getStringExtra("paymentAmountExactness");
        billToken = getIntent().getStringExtra("billToken");

        billerName = getIntent().getStringExtra("billerName");
        billerIcon = getIntent().getStringExtra("billerIcon");
        supportbillvalidation = getIntent().getStringExtra("supportbillvalidation");

        System.out.println("skey-------------------"+Constant.skey);
        System.out.println("number-------------------"+maxSharedPreference.getUserMobileNum());
        System.out.println("token-------------------"+maxSharedPreference.getUserToken().toString());
        System.out.println("billerId-------------------"+billerId);
        System.out.println("billtoken-------------------"+billToken);
        System.out.println("paymentAmountExactness-------------------"+paymentAmountExactness);
        System.out.println("supportbillvalidation-------------------"+supportbillvalidation);

        initView();

        if (supportbillvalidation!=null){
            if (supportbillvalidation.equals("true")){
                et.setEnabled(false);
                linearOne.setVisibility(View.GONE);
                linearTwo.setVisibility(View.GONE);
                tvBillDue.setVisibility(View.GONE);
                linearThree.setVisibility(View.GONE);
            }
        }else {

        }

        if (paymentAmountExactness!=null){
            if (paymentAmountExactness.equals("EXACT")){
                et.setEnabled(false);
            }else if (paymentAmountExactness.equals("EXACT_UP")){
                et.setEnabled(true);
            }else if (paymentAmountExactness.equals("EXACT_DOWN")){
                et.setEnabled(true);
            }else {
                et.setEnabled(false);
            }
        }else {
            
        }

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

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

    }

    private void initView(){
        tvBillerName = (TextView) findViewById(R.id.tvBillerName);
        tvBillerNumber = (TextView) findViewById(R.id.tvBillerNumber);
        et = (EditText) findViewById(R.id.et);
        tvCustomerName = (TextView) findViewById(R.id.tvCustomerName);
        ivLogoDth = (ImageView)findViewById(R.id.ivLogoDth);
        tvbillDate = (TextView)findViewById(R.id.tvBillDate);
        tvBillDue = (TextView)findViewById(R.id.tvBillDue);
        btnNext = (Button)findViewById(R.id.btnNext);
        tvMessage = (TextView)findViewById(R.id.tvMessage);
        checkbox = (CheckBox)findViewById(R.id.checkbox);
        linearOne = (LinearLayout)findViewById(R.id.linearOne);
        linearTwo = (LinearLayout)findViewById(R.id.linearTwo);
        tvBillNumber = (TextView)findViewById(R.id.tvBillNumber);
        linearThree = (LinearLayout)findViewById(R.id.linearThree);

        tvMessage.setText("MaxPe Wallet/ Cashback\n" +
                "Total Balance "+ maxSharedPreference.getAddMoneyAmountToWallet());

        Glide.with(this)
                .load(billerIcon)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(ivLogoDth);
        tvCustomerName.setText(" " +CustomerName);
        tvbillDate.setText(" " +BillDate);
        tvBillerName.setText(billerName);
        et.setText(Amount);
        tvBillDue.setText("Bill Due : "+DueDate);
        tvBillerNumber.setText(paramvalues);
        tvBillNumber.setText(BillNumber);

        String amount = maxSharedPreference.getAddMoneyAmountToWallet();
        float floatAmount = Float.valueOf(amount);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btnPay(et.getText().toString());
                if (checkbox.isChecked()){
                    System.out.println("checked-------------------------");
                    if (floatAmount < 1){
                        Toast.makeText(PayBroadBandBillActivity.this, "Insufficiant balance", Toast.LENGTH_LONG).show();
                    }else {
                        btnPay(et.getText().toString());
                    }
                }else {
                    Toast.makeText(PayBroadBandBillActivity.this, "Please select payment mode", Toast.LENGTH_LONG).show();


                }

                //Toast.makeText(PayBroadBandBillActivity.this, "UnderProcessing", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void btnPay(String paisaAmount) {
        progressDialog.show();
        billPayApi = retrofit.create(GetBilllerApi.class);
        Call<BillPay> call = billPayApi.billPay(Constant.skey, maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(), billerId, paisaAmount, billToken, "wallet");
        call.enqueue(new Callback<BillPay>() {
            @Override
            public void onResponse(Call<BillPay> call, Response<BillPay> response) {
                //Log.d(TAG, "onResponse: response : " + response.body());
                BillPay billPay = (BillPay)response.body();
                if (billPay.getStatus().equals("1")){
                    progressDialog.dismiss();
                    //Toast.makeText(PayBroadBandBillActivity.this, billPay.getMessage(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PayBroadBandBillActivity.this, BillPaymentSuccess.class);
                    intent.putExtra("transactionId", billPay.getData().getTransactionId());
                    intent.putExtra("billerId", billPay.getData().getBillerId());
                    intent.putExtra("billerName", billPay.getData().getBillerName());
                    intent.putExtra("amount", billPay.getData().getAmount());
                    intent.putExtra("PaymentRefNo", billPay.getData().getPaymentRefNo());
                    intent.putExtra("payment", billPay.getData().getPayment());
                    intent.putExtra("paramvalue", billPay.getData().getParamValue());
                    intent.putExtra("category", billPay.getData().getCategory());
                    intent.putExtra("logo", billPay.getData().getLogo());
                    //intent.putExtra("status", billPay.getData().)
                    startActivity(intent);
                    finish();
                }else if (billPay.getStatus().equals("0")){
                    progressDialog.dismiss();
//                    Intent intent = new Intent(PayBroadBandBillActivity.this, BillPaymentSuccess.class);
//                    intent.putExtra("transactionId", billPay.getData().getTransactionId());
//                    intent.putExtra("billerId", billPay.getData().getBillerId());
//                    intent.putExtra("billerName", billPay.getData().getBillerName());
//                    intent.putExtra("amount", billPay.getData().getAmount());
//                    intent.putExtra("PaymentRefNo", billPay.getData().getPaymentRefNo());
//                    intent.putExtra("payment", billPay.getData().getPayment());
//                    startActivity(intent);
//                    finish();
                    Toast.makeText(PayBroadBandBillActivity.this, billPay.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<BillPay> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                progressDialog.dismiss();
                Toast.makeText(PayBroadBandBillActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}