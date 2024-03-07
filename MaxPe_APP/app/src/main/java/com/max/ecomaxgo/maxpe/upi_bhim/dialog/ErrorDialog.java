package com.max.ecomaxgo.maxpe.upi_bhim.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.max.ecomaxgo.maxpe.R;


public class ErrorDialog extends Dialog {
    String error;
    int draw;
    TextView msg;
    ImageView img;

    public ErrorDialog(@NonNull Context context) {
        super(context);
    }

    public ErrorDialog set(int draw,String error)
    {
        this.error = error;
        this.draw = draw;
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
        setContentView(R.layout.dialog_error);

        msg = findViewById(R.id.msg);
        img = findViewById(R.id.img);
        img.setImageResource(draw);
        msg.setText(error);

    }
}
