package com.max.ecomaxgo.maxpe.dth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dth.adapter.ComplaintAdapter;
import com.max.ecomaxgo.maxpe.dth.model.ComplaintModel;

import java.util.ArrayList;

public class ComplaintListActivity extends AppCompatActivity {

    ImageView backiv;
    TextView registernewtv;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ArrayList<ComplaintModel> complaintModels = new ArrayList<ComplaintModel>();

        backiv = findViewById(R.id.backiv);
        backiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        complaintModels.add(new ComplaintModel("02-02-2021", "Complaint ID : LH567678678", "08:33:30"));
        complaintModels.add(new ComplaintModel("02-02-2021", "Complaint ID : LH567678678", "08:33:30"));
        complaintModels.add(new ComplaintModel("02-02-2021", "Complaint ID : LH567678678", "08:33:30"));
        complaintModels.add(new ComplaintModel("02-02-2021", "Complaint ID : LH567678678", "08:33:30"));


        registernewtv = findViewById(R.id.registernewtv);
        registernewtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplaintListActivity.this, RegisteredComplaintActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ComplaintListActivity.this);
        recyclerView.setLayoutManager(layoutManager);


        ComplaintAdapter adapter = new ComplaintAdapter(complaintModels);
        recyclerView.setAdapter(adapter);

    }

}