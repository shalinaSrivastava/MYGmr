package com.max.ecomaxgo.maxpe.upi_bhim.option;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import com.budiyev.android.codescanner.AutoFocusMode;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.gson.Gson;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.CreateUpiActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.SendUPIActivity;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.ErrorDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.olive.upi.OliveUpiManager;
import com.olive.upi.transport.OliveUpiEventListener;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.api.UpiService;

import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ScanQRActivity extends AppCompatActivity implements OliveUpiEventListener {
    LoadingDialog ld;
    ErrorDialog error;
    CodeScannerView scannerView;
    private CodeScanner codeScanner;
    TextView temp;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, DashboadActivity.class);
        startActivity(intent);
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qractivity);
        ld = new LoadingDialog(ScanQRActivity.this);
        error = new ErrorDialog(ScanQRActivity.this);

        scannerView = findViewById(R.id.scanner_view);
        temp = findViewById(R.id.temp);
        if (ContextCompat.checkSelfPermission(ScanQRActivity.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(ScanQRActivity.this, new String[] {Manifest.permission.CAMERA}, 123);
        } else {
            startScanning();
        }

    }

    private void startScanning() {

        codeScanner = new CodeScanner(this, scannerView);

        codeScanner.setCamera(CodeScanner.CAMERA_BACK);
        codeScanner.setFormats(CodeScanner.ALL_FORMATS);
        codeScanner.setAutoFocusMode(AutoFocusMode.SAFE);
        codeScanner.setScanMode(ScanMode.SINGLE);
        codeScanner.setAutoFocusEnabled(true);
        codeScanner.setFlashEnabled(false);
        codeScanner.getCamera();
        codeScanner.isPreviewActive();
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull @NotNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        process(result.getText());
                    }
                });
            }
        });

    }

    @Override
    public void onSuccessResponse(int reqType, Object data) {
        Log.d("Main", "onSuccessResponse: reqType " + reqType + " data " + new Gson().toJson(data));

        if(ld.isShowing())
            ld.dismiss();
        if (reqType == UpiService.REQUEST_VERIFY_INTENT_SIGN) {
            Result<String> rs = (Result<String>) data;
            if (rs.getCode().equals("00")) {
                startProcess();
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24, rs.getResult()).show();
            }
        }
    }

    String scanned = "";
    String sign;
    String Scheme;
    String Host;
    String Query;
    private void process(String scan){
        try {
            scanned = scan;
            sign = new String(Base64.decode(scanned,Base64.NO_WRAP));
            String temp = sign.replace(" ","_");

            URI uri = new URI(temp);
            Scheme = uri.getScheme();
            Host = uri.getHost();
            Query = uri.getQuery();

            if(Scheme == null || !Scheme.equals("upi") || Host == null || !Host.equals("pay") || Query == null)
            {
                error.set(R.drawable.ic_baseline_check_circle_outline_24, "Unsupported QR").show();
                codeScanner.startPreview();
                return;
            }
            ld.show();
            ld.setCancelable(false);
            OliveUpiManager.getInstance(ScanQRActivity.this).verifySignedQR(sign);
        }
        catch (Exception e){
            error.set(R.drawable.ic_baseline_check_circle_outline_24, "Error QR").show();
            codeScanner.startPreview();
            return;
        }
    }

    private void startProcess() {
        System.out.println(Query);
        Query = Query.replace("_"," ");

        String s[] = Query.split("&");
        Map<String, String> map = new HashMap<String, String>();

        for (String i : s) {
            String t[] = i.split("=");
            map.put(t[0], t[1]);

        }
        Intent intent = new Intent(ScanQRActivity.this, SendUPIActivity.class);
        intent.putExtra("name", map.get("pn"));
        intent.putExtra("vpa",map.get("pa"));
        intent.putExtra("for","scan");
        startActivity(intent);
    }


    @Override
    public void onFailureResponse(int reqType, Object data) {
        Log.d("MAIN", "onFailureResponse: reqType "+reqType+" data "+new Gson().toJson(data));

        try{
            if(data != null) {
                Result<Void> rs = (Result<Void>) data;
                error.set(R.drawable.ic_baseline_error_outline_24,rs.getResult()).show();
            } else {
                error.set(R.drawable.ic_baseline_error_outline_24,"Empty").show();
            }
        }
        catch (Exception ex){
            error.set(R.drawable.ic_baseline_error_outline_24,"Error:"+data).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
        OliveUpiManager.getInstance(ScanQRActivity.this).setListener(this);
    }

    @Override
    protected void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}