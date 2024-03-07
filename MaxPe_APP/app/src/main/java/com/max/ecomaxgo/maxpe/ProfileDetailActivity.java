package com.max.ecomaxgo.maxpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileDetailActivity extends AppCompatActivity {
    MaxSharedPreference sp;
    TextView _Pname, _Pgender, _Pmobile, _PmailId;
    CircleImageView imgUserProfile;
    ImageView _pback,editProfile;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        sp = new MaxSharedPreference(this);

        _Pname = findViewById(R.id._Pname);
        _Pgender = findViewById(R.id._Pgender);
        _Pmobile = findViewById(R.id._Pmobile);
        _PmailId = findViewById(R.id._PmailId);
        imgUserProfile = findViewById(R.id.imgUserProfile);
        _pback = findViewById(R.id._pback);
        editProfile= findViewById(R.id.editProfile);
        _Pname.setText(sp.getUserFName());
        _Pgender.setText(sp.getGenderValue());
        _Pmobile.setText(sp.getUserMobileNum());
        _PmailId.setText(sp.getUserEmail());


        Glide.with(this)
                .load(sp.getSaveQRBitmapPathBankLogo())
                .centerInside()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(imgUserProfile);

        editProfile.setOnClickListener(view -> changeProfile());
    }

    private void changeProfile() {
        startActivity(new Intent(ProfileDetailActivity.this,ProfileChangedActivity.class));
    }
}