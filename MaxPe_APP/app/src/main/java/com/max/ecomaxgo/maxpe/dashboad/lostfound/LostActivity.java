package com.max.ecomaxgo.maxpe.dashboad.lostfound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.adpter.LostAdpter;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.adpter.PostAdpter;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.MyPost;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFAds;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LostActivity extends AppCompatActivity {
    TextView _losttitleTv;
    LinearLayout noDataLost;
    ImageView _lostback;
    RecyclerView _lostList;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        _losttitleTv=findViewById(R.id._losttitleTv);
         _lostback=findViewById(R.id._lostback);
        _lostList=findViewById(R.id._lostList);
        noDataLost=findViewById(R.id.noDataLost);
        noDataLost.setVisibility(View.GONE);
        progress=findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);
        _lostback.setOnClickListener(view->finish());
        _losttitleTv.setText(getIntent().getStringExtra("title"));
        if (getIntent().getStringExtra("title").equals("Lost")){
            getlostList();
        }else if (getIntent().getStringExtra("title").equals("My Post")){
            getMyPostList();
        }


    }
    private void getlostList() {
        MaxSharedPreference sp = new MaxSharedPreference(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getAds(Constant.skey, sp.getUserMobileNum(), sp.getUserToken());
        call.enqueue(new Callback<LFAds>() {
            @Override
            public void onResponse(Call<LFAds> call, Response<LFAds> response) {
                progress.setVisibility(View.GONE);
                if (response.body() != null) {

                     for (int i=0;i<=response.body().getData().size();i++){

                     //   if (getIntent().getStringExtra("category").equals(response.body().getData().)){
                             LostAdpter category = new LostAdpter(LostActivity.this,response.body().getData());
                             _lostList.setLayoutManager(new LinearLayoutManager(LostActivity.this));
                             _lostList.setAdapter(category);
                             noDataLost.setVisibility(View.GONE);
                         /*}else {
                             noDataLost.setVisibility(View.VISIBLE);
                             _lostList.setVisibility(View.GONE);
                        }*/
                    }



                } else {

                    Toast.makeText(LostActivity.this, "Not" + response.code(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LFAds> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(LostActivity.this, "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getMyPostList() {
        MaxSharedPreference sp = new MaxSharedPreference(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getMyAds(Constant.skey, sp.getUserMobileNum(), sp.getUserToken());
        call.enqueue(new Callback<MyPost>() {
            @Override
            public void onResponse(Call<MyPost> call, Response<MyPost> response) {
                progress.setVisibility(View.GONE);
                if (response.body() != null) {


                        PostAdpter post = new PostAdpter(LostActivity.this,response.body().getData());
                        _lostList.setLayoutManager(new LinearLayoutManager(LostActivity.this));
                        _lostList.setAdapter(post);
                        noDataLost.setVisibility(View.GONE);


                } else {

                    Toast.makeText(LostActivity.this, "Not" + response.code(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<MyPost> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(LostActivity.this, "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }
}