package com.max.ecomaxgo.maxpe.dashboad.lostfound;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.adpter.ChainAdpter;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFPostAds;
import com.max.ecomaxgo.maxpe.dashboad.modle.ChainListRefer;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient;
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface;
import com.max.ecomaxgo.maxpe.dashboad.utils.ImageUtil;
import com.max.ecomaxgo.maxpe.upi_bhim.BhimDashBoardActivity;
import com.max.ecomaxgo.maxpe.util.Constant;
import com.olive.upi.OliveUpiManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoundActivity extends AppCompatActivity {
    TextView _Fsubmit,_fCategory,_fDate;
    ImageView _fImgAdd,_fCamera,_fback,_Fphoto;
    EditText _fItem,_fLocation,_fContactNo,_fDescription,_fName;
    public static final int RequestPermissionCode = 3;
    String base64String="";
    LinearLayout _fPost,_fdetail;
    TextView _Fdescrip,_Fnumber,_Fname,_Fdate,_Flocation,_Fitem,_Fcategory;
    Bitmap photo_bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

            initSet();

        _Fsubmit.setOnClickListener(view->submit());
        _fImgAdd.setOnClickListener(view->EnableRuntimePermission());
        _fback.setOnClickListener(view->finish());
        _fCategory.setText(getIntent().getStringExtra("category"));



    }



    private void initSet() {
        _Fsubmit = findViewById(R.id._Fsubmit);
        _fItem= findViewById(R.id._fItem);
        _fLocation= findViewById(R.id._fLocation);
        _fDate= findViewById(R.id._fDate);
        _fContactNo= findViewById(R.id._fContactNo);
        _fDescription= findViewById(R.id._fDescription);
        _fName= findViewById(R.id._fName);
        _fImgAdd= findViewById(R.id._fImgAdd);
        _fCamera= findViewById(R.id._fCamera);
        _fback= findViewById(R.id._fback);
        _fCategory= findViewById(R.id._fCategory);
        _fPost= findViewById(R.id._fPost);
        _fdetail= findViewById(R.id._fdetail);

        _Fdescrip= findViewById(R.id._Fdescrip);
        _Fnumber= findViewById(R.id._Fnumber);
        _Fname= findViewById(R.id._Fname);
        _Fdate= findViewById(R.id._Fdate);
        _Flocation= findViewById(R.id._Flocation);
        _Fitem= findViewById(R.id._Fitem);
        _Fphoto= findViewById(R.id._Fphoto);
        _Fcategory= findViewById(R.id._Fcategory);

        _fPost.setVisibility(View.GONE);
        _fdetail.setVisibility(View.VISIBLE);
    }
    private void submit() {
        String  category="",title="",description="",city="",lostFoundDate="2021-09-09 11:23:59",categoryStatus="found",contactPersonName="",contactPersonMobile="",pic="";
        category="";


        if (_fItem.getText().toString().isEmpty()) {
            _fItem.setError(getResources().getString(R.string.error));
        } else if (_fDescription.getText().toString().isEmpty()) {
            _fDescription.setError(getResources().getString(R.string.error));

        } else if (_fLocation.getText().toString().isEmpty()) {
            _fLocation.setError(getResources().getString(R.string.error));

        }else if (_fDescription.getText().toString().isEmpty()) {
            _fDescription.setError(getResources().getString(R.string.error));

        }/*else if (_fDate.getText().toString().isEmpty()) {
            _fDate.setError(getResources().getString(R.string.error));

        }*/else if (_fName.getText().toString().isEmpty()) {
            _fName.setError(getResources().getString(R.string.error));

        }else if (_fContactNo.getText().toString().isEmpty()) {
            _fContactNo.setError(getResources().getString(R.string.error));

        }else if (base64String.equals("")){
           Toast.makeText(this,"Please Select Photo",Toast.LENGTH_SHORT).show();
        }else if (_fCategory.getText().toString().isEmpty()){
            _fCategory.setError(getResources().getString(R.string.error));
        }
        else  {
            title=_fItem.getText().toString();
            description=_fDescription.getText().toString();
            city=_fLocation.getText().toString();
           // lostFoundDate=_fDate.getText().toString();
            contactPersonName=_fName.getText().toString();
            contactPersonMobile=_fContactNo.getText().toString();
            category =_fCategory.getText().toString();
        //  postAds("Mobile","Found mobile","Mi10 found","Delhi","2021-09-09 11:23:59","Pending","Shanu","2222222222","");
             postAds(category,title,description,city,lostFoundDate,categoryStatus,contactPersonName,contactPersonMobile,pic);
        }

    }
    private void postAds(String category,String title,String description,String city,String lostFoundDate,String categoryStatus,String contactPersonName,String contactPersonMobile,String pic) {


            MaxSharedPreference maxSharedPreference = new MaxSharedPreference(this);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call call = apiService.getPostAds(Constant.skey,maxSharedPreference.getUserMobileNum(), maxSharedPreference.getUserToken(),category,title,description,city,lostFoundDate,categoryStatus,contactPersonName,contactPersonMobile,pic);

            call.enqueue(new Callback<LFPostAds>() {

                @Override
                public void onResponse(Call<LFPostAds> call, Response<LFPostAds> response) {

                    if(response.isSuccessful()) {
                        //     String msg="";
                        submitAlert("It has been successfully submitted");

                        _Fdescrip.setText(description);
                        _Fnumber.setText(contactPersonMobile);
                        _Fname.setText(contactPersonName);
                        _Fdate.setText(lostFoundDate);
                        _Flocation.setText(city);
                        _Fitem.setText(title);
                        _Fphoto.setImageBitmap(photo_bitmap);
                        _Fcategory.setText(category);

                    }else{

                        submitAlert("It has simply not been submitted.");

                        Toast.makeText(FoundActivity.this, " no data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LFPostAds> call, Throwable t) {
                    Toast.makeText(FoundActivity.this, "there is some isssue"+t, Toast.LENGTH_SHORT).show();

                }
            });

        }

    private void chooseImage() {
       //final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        final CharSequence[] options = { "Take Photo","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(FoundActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
                    startActivityForResult(intent, 1);
                    dialog.dismiss();
                }
               /* else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                    dialog.dismiss();
                }*/
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                try {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    _fCamera.setImageBitmap(bitmap);
                     base64String = ImageUtil.convert(bitmap);
                    photo_bitmap =bitmap;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                if (selectedImage != null) {
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        _fCamera.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                        photo_bitmap =BitmapFactory.decodeFile(picturePath);
                       /* Bitmap bp=BitmapFactory.decodeFile(picturePath);
                      base64String = ImageUtil.convert(bp);*/
                    }
                }
            }
        }
    }

    public void EnableRuntimePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(FoundActivity.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(FoundActivity.this,"CAMERA permission allows us to Access CAMERA app",     Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(FoundActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
            chooseImage();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] result) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(FoundActivity.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void submitAlert(String msg) {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);
        final android.app.AlertDialog deleteDialog = new android.app.AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        TextView tvCancelNo = deleteDialogView.findViewById(R.id.tvCancelNo);
        TextView tvCancelYes = deleteDialogView.findViewById(R.id.tvCancelYes);
        tvCancelYes.setText("OK");
        tvCancelRequest.setText(msg);

        tvCancelNo.setVisibility(View.GONE);
        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* startActivity(new Intent(FoundActivity.this,LFPostActivity.class));
                 finish();*/
                if (msg.equals("It has simply not been submitted.")){
                    _fPost.setVisibility(View.GONE);
                    _fdetail.setVisibility(View.VISIBLE);
                }else {
                    _fPost.setVisibility(View.VISIBLE);
                    _fdetail.setVisibility(View.GONE);
                }

                deleteDialog.dismiss();
            }
        });
        deleteDialog.show();

    }
}