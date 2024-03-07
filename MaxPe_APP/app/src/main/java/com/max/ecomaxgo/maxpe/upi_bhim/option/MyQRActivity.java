package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MyQRActivity extends AppCompatActivity{

    ImageView qr;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    TextView name;
    TextView upi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qractivity);

        qr = findViewById(R.id.qr);
        name = findViewById(R.id.name);
        upi = findViewById(R.id.upi);

        name.setText(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getName());
        upi.setText(Upi.getCustomerBankAccounts().get(0).getAccounts().get(0).getVpa());

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;

        int dimen = width < height ? width : height;
        dimen = dimen * 3 / 4;

        qrgEncoder = new QRGEncoder(Upi.getSign(), null, QRGContents.Type.TEXT, dimen);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            qr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            System.out.println("Tag" + e.toString());
        }

//        QRGSaver qrgSaver = new QRGSaver();
//        qrgSaver.save(savePath, edtValue.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);
    }

}