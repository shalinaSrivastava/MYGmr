package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.max.ecomaxgo.maxpe.R;

public class RegisteredComplaintActivity extends AppCompatActivity {

    ImageView backiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_complaint);

        backiv = findViewById(R.id.backiv);
        backiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}