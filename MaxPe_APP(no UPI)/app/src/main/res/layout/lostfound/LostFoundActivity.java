package com.max.ecomaxgo.maxpe.dashboad.lostfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.max.ecomaxgo.maxpe.R;

public class LostFoundActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView _back_lf;
    TextView _lost_tv,_found_tv,_myPost_tv;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);
        _back_lf = (ImageView)findViewById(R.id._back_lf);
        _lost_tv= (TextView) findViewById(R.id._lost_tv);
        _found_tv= (TextView)findViewById(R.id._found_tv);
        _myPost_tv= (TextView)findViewById(R.id._myPost_tv);

        _back_lf.setOnClickListener(this);
        _lost_tv.setOnClickListener(this);
        _found_tv.setOnClickListener(this);
        _myPost_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id._back_lf:
                finish();
                break;

            case R.id._lost_tv:
                 callActivity("Lost");
                break;
            case R.id._found_tv:
                callActivity("Found");
                break;
            case R.id._myPost_tv:
                Intent intent = new Intent(this, LostActivity.class);
                intent.putExtra("title","My Post");
                startActivity(intent);
                break;
        }

    }

    private void callActivity(String title) {

        Intent intent = new Intent(this, LFCategoryActivity.class);
        intent.putExtra("title",title);
        startActivity(intent);

    }
}