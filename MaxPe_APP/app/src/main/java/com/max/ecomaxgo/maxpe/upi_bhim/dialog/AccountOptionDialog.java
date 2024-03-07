package com.max.ecomaxgo.maxpe.upi_bhim.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.Account;

public class AccountOptionDialog extends Dialog {

    TextView acc;
    TextView vpa;
    LinearLayout avpa;

    LinearLayout lsvpa;
    LinearLayout lcvpa;
    LinearLayout lset;
    LinearLayout lchange;
    LinearLayout lreset;
    LinearLayout ldelete;
    ActOnItemClickListner actOnItemClickListner;
    int position;

    CardView all;

    public AccountOptionDialog(@NonNull Context context) {
        super(context);
        this.position = -1;
    }

    public AccountOptionDialog set(int position, ActOnItemClickListner actOnItemClickListner){
        this.actOnItemClickListner = actOnItemClickListner;
        this.position = position;
        if(all != null)
            action();
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_account_option);

        all = findViewById(R.id.all);
        acc = findViewById(R.id.acc);
        vpa = findViewById(R.id.vpa);
        avpa = findViewById(R.id.avpa);

        lsvpa = findViewById(R.id.lsvpa);
        lcvpa = findViewById(R.id.lcvpa);
        lset = findViewById(R.id.lset);
        lchange = findViewById(R.id.lchange);
        lreset = findViewById(R.id.lreset);
        ldelete = findViewById(R.id.ldelete);

        lsvpa.setOnClickListener(view -> actOnItemClickListner.act("setvpa"));
        lcvpa.setOnClickListener(view -> actOnItemClickListner.act("chgvpa"));
        lset.setOnClickListener(view -> actOnItemClickListner.act("set"));
        lchange.setOnClickListener(view -> actOnItemClickListner.act("change"));
        lreset.setOnClickListener(view -> actOnItemClickListner.act("reset"));
        ldelete.setOnClickListener(view -> actOnItemClickListner.act("delete"));
        action();
    }

    void action()
    {
        if(position != -1){
            all.setVisibility(View.VISIBLE);
            Account account = Upi.getCustomerBankAccounts().get(position).getAccounts().get(0);
            System.out.println(position+")"+account.getVpa()+")"+account.getMbeba());
            acc.setText(account.getMaskedAccnumber());
            if(account.getVpa() == null || account.getVpa().equals(""))
            {
                vpa.setText("");
                avpa.setVisibility(View.GONE);
                lcvpa.setVisibility(View.GONE);
                lsvpa.setVisibility(View.VISIBLE);
            }
            else
            {
                vpa.setText(account.getVpa());
                avpa.setVisibility(View.VISIBLE);
                lcvpa.setVisibility(View.VISIBLE);
                lsvpa.setVisibility(View.GONE);
            }

            if(account.getMbeba().equals("Y"))
            {
                lset.setVisibility(View.GONE);
                lchange.setVisibility(View.VISIBLE);
                lreset.setVisibility(View.VISIBLE);
            }
            else
            {
                if(vpa.getText().equals(""))
                    lset.setVisibility(View.GONE);
                else
                    lset.setVisibility(View.VISIBLE);
                lchange.setVisibility(View.GONE);
                lreset.setVisibility(View.GONE);
            }

        }else
        {
            all.setVisibility(View.GONE);
        }
    }

    public interface ActOnItemClickListner{
        void act(String action);
    }
}
