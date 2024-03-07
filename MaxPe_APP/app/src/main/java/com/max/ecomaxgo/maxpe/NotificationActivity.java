package com.max.ecomaxgo.maxpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class NotificationActivity extends AppCompatActivity {
   ImageView _Nback;
   RecyclerView _Notific_list;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        _Nback=findViewById(R.id._Nback);
        _Notific_list=findViewById(R.id._Notific_list);
        _Nback.setOnClickListener(view->finish());
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        _Notific_list.setLayoutManager(llm);
    }
}