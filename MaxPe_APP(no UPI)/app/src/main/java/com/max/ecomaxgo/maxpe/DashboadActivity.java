package com.max.ecomaxgo.maxpe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
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
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
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
import com.max.ecomaxgo.maxpe.dashboad.fragment.FragmentMenu;
import com.max.ecomaxgo.maxpe.dashboad.fragment.Homefreg;

import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.fragment.ProfileFragment;
import com.max.ecomaxgo.maxpe.util.Constant;


import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboadActivity extends AppCompatActivity {
    TextView userName_tv;
    CircleImageView profileUser;
    MaxSharedPreference sharedPreference;
    BottomNavigationView bottom_nav_view;
    LinearLayout toolbar_lay;
    String homeFragment = "";
    @Override
    public void onBackPressed() {



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

            }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboad);

        sharedPreference = new MaxSharedPreference(this);

        Fragment fragment = new Homefreg();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        initView();



    }
    private void initView() {

        userName_tv = (TextView)findViewById(R.id.userName_tv);
        profileUser= (CircleImageView) findViewById(R.id.profileUser);
        bottom_nav_view = (BottomNavigationView)findViewById(R.id.bottom_nav_view);
        toolbar_lay = (LinearLayout)findViewById(R.id.toolbar_lay);
        toolbar_lay.setVisibility(View.VISIBLE);
        homeFragment ="VISIBLE";



        if (sharedPreference.getMaxUserName().equals("")){
            userName_tv.setText(sharedPreference.getUserMobileNum());
        }else{
            String fName = sharedPreference.getUserFName();
            userName_tv.setText("Hi "+fName);
        }
     //   getLiveWalletCard();
        String profileImage = sharedPreference.getUserProfileImg();
        Glide.with(this)
                .load(profileImage)
                .centerCrop()
                .placeholder(R.drawable.default_maxpe_profile)
                .into(profileUser);

        bottom_nav_view.setSelectedItemId(R.id.homeFragment);
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
                        Fragment fragment_Menu = new FragmentMenu();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment_Menu, fragment_Menu.getClass().getSimpleName()).addToBackStack(null).commit();

                        break;
                    case R.id.homeFragment:
                        toolbar_lay.setVisibility(View.VISIBLE);
                        homeFragment ="VISIBLE";
                        Fragment fragment_home = new Homefreg();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_ContainerView, fragment_home,
                                fragment_home.getClass().getSimpleName()).addToBackStack(null).commit();
                        break;

                }
                return true;
            }
        });


    }

}