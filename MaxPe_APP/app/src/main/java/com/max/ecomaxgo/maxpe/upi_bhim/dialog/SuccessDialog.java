package com.max.ecomaxgo.maxpe.upi_bhim.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.max.ecomaxgo.maxpe.R;


public class SuccessDialog extends Dialog {
    String error;
    int draw;
    TextView msg;
    ImageView img;
    Button ok;
    OkOnItemClickListner okOnItemClickListner;

    public SuccessDialog(@NonNull Context context) {
        super(context);
    }

    public SuccessDialog set(int draw, String error,OkOnItemClickListner okOnItemClickListner)
    {
        this.error = error;
        this.draw = draw;
        this.okOnItemClickListner = okOnItemClickListner;
        if(msg != null)
        {
            img.setImageResource(draw);
            msg.setText(error);
        }
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_success);

        msg = findViewById(R.id.msg);
        img = findViewById(R.id.img);
        ok = findViewById(R.id.ok);
        img.setImageResource(draw);
        msg.setText(error);

        ok.setOnClickListener(view -> okOnItemClickListner.act());
    }

    public interface OkOnItemClickListner{
        void act();
    }
}
