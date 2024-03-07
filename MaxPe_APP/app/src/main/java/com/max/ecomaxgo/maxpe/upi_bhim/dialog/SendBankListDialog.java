package com.max.ecomaxgo.maxpe.upi_bhim.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.adaptor.SendBankListAdapter;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.api.Result;
import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;

import java.util.ArrayList;

public class SendBankListDialog extends Dialog {

    SendBankListAdapter sendBankListAdapter;
    ActOnItemClickListner actOnItemClickListner;
    RecyclerView recyclerView;
    EditText filter;
    Result<ArrayList<Account>> account;
    ArrayList<Bank> banks;
    Context context;

    public SendBankListDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public SendBankListDialog set(ActOnItemClickListner actOnItemClickListner){
        this.actOnItemClickListner = actOnItemClickListner;
        return this;
    }

    public interface ActOnItemClickListner{
        void act(Bank bank);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_banklist);
        recyclerView =  findViewById(R.id.bankListRecycler);
        filter = findViewById(R.id.filter);

        banks = Upi.getBanks();
        listSetup();
    }

    private void listSetup() {
        sendBankListAdapter = new SendBankListAdapter(context, banks, new SendBankListAdapter.BankOnItemClickListner() {
            @Override
            public void getOperatorPosition(Bank bank) {
                select(bank);
            }
        });

        recyclerView.setAdapter(sendBankListAdapter);
        sendBankListAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false));

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void select(Bank bank) {
        actOnItemClickListner.act(bank);
    }

    void filter(String text){
        ArrayList<Bank> temp = new ArrayList();
        for(Bank d: banks){
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        sendBankListAdapter.updateList(temp);
    }
}
