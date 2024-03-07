package com.max.ecomaxgo.maxpe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.dashboad.fragment.Homefreg;

import com.max.ecomaxgo.maxpe.fragment.ProfileFragment;


import de.hdodenhof.circleimageview.CircleImageView;

public class DashboadActivity extends AppCompatActivity implements View.OnClickListener {
    TextView _mRank, _mChain, _mMilestone, _mMonthly, _mPolicies, _mLogout,userName_tv,_mName,_mProfile;
    CircleImageView profileUser,_mProfileImg;
    DrawerLayout drawer;
    MaxSharedPreference sharedPreference;
    BottomNavigationView bottom_nav_view;
    LinearLayout toolbar_lay;
    String homeFragment = "";

    @Override
    public void onBackPressed() {


        if(drawer.isDrawerOpen(GravityCompat.START)){
            getFragmentManager().popBackStack();
            drawer.closeDrawer(GravityCompat.START);
        }else {
            if(homeFragment.equals("VISIBLE")){
                getFragmentManager().popBackStack();
                homeFragment ="";
                finish();
            }
            else  if(homeFragment.equals("GONE")){
                toolbar_lay.setVisibility(View.VISIBLE);

                homeFragment ="";
                Fragment fragment = new Homefreg();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

            }else {
                getFragmentManager().popBackStack();
                finish();
            }

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboad);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        sharedPreference = new MaxSharedPreference(this);
      // checkForUpdate();
        //showUpdateDialog();
        Fragment fragment = new Homefreg();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        initView();



    }
    private void initView() {
        _mRank = (TextView) findViewById(R.id._mRank);
        _mChain = (TextView) findViewById(R.id._mChain);
        _mMilestone = (TextView) findViewById(R.id._mMilestone);
        _mMonthly = (TextView) findViewById(R.id._mMonthly);
        _mPolicies = (TextView) findViewById(R.id._mPolicies);
        _mLogout = (TextView) findViewById(R.id._mLogout);
        _mName= (TextView) findViewById(R.id._mName);
        _mProfile= (TextView) findViewById(R.id._mProfile);
        drawer = findViewById(R.id._drawer);
        userName_tv = (TextView)findViewById(R.id.userName_tv);
        profileUser= (CircleImageView) findViewById(R.id.profileUser);
        _mProfileImg = (CircleImageView)findViewById(R.id._mProfileImg);
        bottom_nav_view = (BottomNavigationView)findViewById(R.id.bottom_nav_view);
        toolbar_lay = (LinearLayout)findViewById(R.id.toolbar_lay);

        toolbar_lay.setVisibility(View.VISIBLE);
        homeFragment ="VISIBLE";
        _mRank.setOnClickListener(this);
        _mChain.setOnClickListener(this);
        _mMilestone.setOnClickListener(this);
        _mMonthly.setOnClickListener(this);
        _mPolicies.setOnClickListener(this);
        _mLogout.setOnClickListener(this);
        _mProfile.setOnClickListener(this);

        if (sharedPreference.getMaxUserName().equals("")){
            userName_tv.setText(sharedPreference.getUserMobileNum());
            _mName.setText(sharedPreference.getUserMobileNum());
        }else{
            String fName = sharedPreference.getUserFName();
            userName_tv.setText("Hi "+fName);
            _mName.setText("Hi "+fName);
        }

        String profileImage = sharedPreference.getUserProfileImg();
        //System.out.println("profileImage----------------------------"+profileImage)
        Glide.with(this)
                .load(profileImage)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(profileUser);

        Glide.with(this)
                .load(profileImage)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(_mProfileImg);
        findViewById(R.id._menu_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        bottom_nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profileFragment:
                        toolbar_lay.setVisibility(View.GONE);
                        homeFragment ="GONE";
                        Fragment fragment_prfile = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment_prfile, fragment_prfile.getClass().getSimpleName()).addToBackStack(null).commit();
                        break;
                    case R.id.transactionsFragment:
                        toolbar_lay.setVisibility(View.GONE);
                        homeFragment ="GONE";
                        Fragment fragment_trasaction = new TransactionsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment_trasaction, fragment_trasaction.getClass().getSimpleName()).addToBackStack(null).commit();

                        break;
                    case R.id.homeFragment:
                        toolbar_lay.setVisibility(View.VISIBLE);
                        homeFragment ="VISIBLE";
                        Fragment fragment_home = new Homefreg();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment_home, fragment_home.getClass().getSimpleName()).addToBackStack(null).commit();
                        break;

                }
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id._mRank:
                callIntent("My Rank");
                break;
            case R.id._mChain:
                callIntent("My Chain");
                break;
            case R.id._mMilestone:
                callIntent("My Milestone");
                break;
            case R.id._mMonthly:
                callIntent("Monthly Contest");
                break;
            case R.id._mPolicies:
                break;
            case R.id._mLogout:
                set_logOut();
                break;
            case R.id._mProfile:
                callIntent("Profile");
                break;
        }
    }
    private void callIntent(String TITLE) {
        drawer.closeDrawer(GravityCompat.START);
        Intent intent = new Intent(DashboadActivity.this, MenuContainerActivity.class);
        intent.putExtra("title", TITLE);
        startActivity(intent);
    }
    private void set_logOut() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);

        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        tvCancelRequest.setText("Are you sure to exit?");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
                sharedPreference.clear();
                Intent intent= new Intent(DashboadActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        deleteDialog.show();

    }


}