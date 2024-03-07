package com.max.ecomaxgo.maxpe.travel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.travel.hotelModel.SearchHotel;

public class TravelCardActivity extends AppCompatActivity {
    CardView cardBus,cardHotel,cardFlight;
    ImageView ivImage;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_card);
        cardBus = findViewById(R.id.cardBus);
        cardHotel = findViewById(R.id.cardHotel);
        cardFlight = findViewById(R.id.cardFlight);
        ivImage= findViewById(R.id.ivImage);
        cardBus.setOnClickListener(view->startActivity(new Intent(this, BusActivity.class)));
        cardHotel.setOnClickListener(view->startActivity(new Intent(this, HotelSearchActivity.class)));
        cardFlight.setOnClickListener(view->setComingSoon());
        ivImage.setOnClickListener(view->finish());
    }

    private void setComingSoon() {

        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        TextView tvCancelNo = (TextView)deleteDialogView.findViewById(R.id.tvCancelNo);
        tvCancelRequest.setText("Coming soon");
        tvCancelNo.setVisibility(View.GONE);
        TextView tvCancelYes= (TextView)deleteDialogView.findViewById(R.id.tvCancelYes);
        tvCancelYes.setText("OK");

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
            }
        });
        deleteDialog.show();
    }
}