package com.max.ecomaxgo.maxpe.dashboad.lostfound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.adpter.LFcategoryAdpter;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFCategory;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LFCategoryActivity extends AppCompatActivity {
    RecyclerView categoryList;
    ProgressBar progress;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_lf);

        categoryList = findViewById(R.id.categoryList);
        progress= findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);
        lostAndFoundcategory();
        findViewById(R.id._back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void lostAndFoundcategory() {

        MaxSharedPreference sp = new MaxSharedPreference(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getCategory(Constant.skey, sp.getUserMobileNum(), sp.getUserToken());
        call.enqueue(new Callback<LFCategory>() {
            @Override
            public void onResponse(Call<LFCategory> call, Response<LFCategory> response) {
                progress.setVisibility(View.GONE);
                if (response.body() != null) {

                   LFcategoryAdpter category = new LFcategoryAdpter(LFCategoryActivity.this,response.body().getData(),getIntent().getStringExtra("title"));
                    categoryList.setLayoutManager(new GridLayoutManager(LFCategoryActivity.this, 2));
                    categoryList.setAdapter(category);

                } else {

                    Toast.makeText(LFCategoryActivity.this, "Not" + response.code(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LFCategory> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(LFCategoryActivity.this, "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }

}