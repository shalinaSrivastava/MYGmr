package com.max.ecomaxgo.maxpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.max.ecomaxgo.maxpe.dashboad.fragment.FragmentChain;
import com.max.ecomaxgo.maxpe.dashboad.fragment.FragmentMilestone;
import com.max.ecomaxgo.maxpe.dashboad.fragment.FragmentMonthlyContest;
import com.max.ecomaxgo.maxpe.dashboad.fragment.FragmentRank;
import com.max.ecomaxgo.maxpe.fragment.ProfileFragment;

public class MenuContainerActivity extends AppCompatActivity {
    LinearLayout _mtoolbar_lay;
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_container);

        TextView _titleTv =(TextView) findViewById(R.id._titleTv);
         _mtoolbar_lay=findViewById(R.id._mtoolbar_lay);
        _titleTv.setText(getIntent().getStringExtra("title"));


        Fragment  fragment=null;
        String title=getIntent().getStringExtra("title");
        if (title.equals("My Rank")){
            fragment = new FragmentRank();
        }else if (title.equals("My Chain")){
            fragment = new FragmentChain();
        }else if (title.equals("My Milestone")){
            fragment = new FragmentMilestone();
        }else if (title.equals("Monthly Contest")){
            fragment = new FragmentMonthlyContest();
        }else if(title.equals("Profile")){
            fragment = new ProfileFragment();
        }else if(title.equals("Transactions")){
            _mtoolbar_lay.setVisibility(View.GONE);
            fragment = new TransactionsFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();



        findViewById(R.id._back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}