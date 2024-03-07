package com.max.ecomaxgo.maxpe.upi_bhim;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.DashboadActivity;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.LinkAccAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.dialog.LoadingDialog;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;

import java.util.ArrayList;
public class BankActivity extends AppCompatActivity {
    ImageView banklogo;
    TextView bankname;
    ArrayList<Account> accounts;
    Bank bank;
    LoadingDialog ld;
    RecyclerView linkacc;
    LinkAccAdapter linkAccAdapter;
    MaxSharedPreference sp;
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
        setContentView(R.layout.activity_bank);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ld = new LoadingDialog(BankActivity.this);

        banklogo = findViewById(R.id.bankLogo);
        bankname = findViewById(R.id.bankName);
        linkacc = findViewById(R.id.linkacc);
        sp = new MaxSharedPreference(this);

        accounts = Upi.getAccounts();
        bank = Upi.getSelectedBank();
        Glide.with(getApplicationContext())
                .load(bank.getLogo())
                .centerInside()
                .placeholder(R.drawable.ic_baseline_account_balance_24)
                .into(banklogo);

        sp.setSaveQRBitmapPathBankLogo(bank.getLogo());
        sp.setBHIM_bankName(bank.getName());
        bankname.setText(bank.getName());

        accountSetup();
    }

    private void accountSetup() {
        linkAccAdapter = new LinkAccAdapter(BankActivity.this, Upi.getAccounts(), pos -> start(pos));
        linkacc.setAdapter(linkAccAdapter);
        linkAccAdapter.notifyDataSetChanged();
        linkacc.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    private void start(int pos) {
        if (sp.getDEREGISTER().equals( "true")){
            accounts.get(0).setVpa("");
        }
        if(accounts.get(0).getVpa() == null||accounts.get(0).getVpa().equals(""))
        {
            Intent intent = new Intent(this,AccountLinkActivity.class);
            intent.putExtra("position",pos);
            startActivity(intent);
        }
        else {


            Upi.setCustomerBankAccounts(accounts.get(0),bank);
            Intent intent = new Intent(this, DashboadActivity.class);
            startActivity(intent);
        }
    }

}