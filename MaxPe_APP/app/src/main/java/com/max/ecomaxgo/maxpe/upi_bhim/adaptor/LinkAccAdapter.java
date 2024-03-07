package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.Account;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LinkAccAdapter extends RecyclerView.Adapter<LinkAccAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    Context ctx;
    AccountOnItemClickListner accountOnItemClickListner;
    ArrayList<Account> accounts;

    public LinkAccAdapter(Context ctx, ArrayList<Account> accounts, AccountOnItemClickListner accountOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.accounts = accounts;
        this.accountOnItemClickListner = accountOnItemClickListner;
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.linkacc_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        holder.name.setText(accounts.get(position).getName());
        holder.acc.setText(accounts.get(position).getMaskedAccnumber());
        holder.ifsc.setText(accounts.get(position).getIfsc());
        holder.type.setText(accounts.get(position).getType());

        MaxSharedPreference sp = new MaxSharedPreference(ctx);
        sp.setBHIM_DB("true");
        sp.setBHIM_ACCOUNTNO(accounts.get(position).getMaskedAccnumber());
        sp.setBHIM_HOLDERNAME(accounts.get(position).getName());
        sp.setBHIM_IFSC(accounts.get(position).getIfsc());
        sp.setBHIM_TYPE(accounts.get(position).getType());
       // sp.setBHIM_bankName(accounts.get(position).getBankName());
        sp.setBHIM_mmid(accounts.get(position).getMmid());
        sp.setBHIM_accRefNumber(accounts.get(position).getAccRefNumber());
        sp.setBHIM_maskedAccnumber(accounts.get(position).getMaskedAccnumber());
        sp.setBHIM_Status(accounts.get(position).getStatus());
        sp.setBHIM_Vpa(accounts.get(position).getVpa());
        sp.setBHIM_dType(accounts.get(position).getdType());
        sp.setBHIM_Balance(accounts.get(position).getBalance());
        sp.setBHIM_BalTime(accounts.get(position).getBalTime());
        sp.setBHIM_Mbeba(accounts.get(position).getMbeba());
        sp.setBHIM_aeba(accounts.get(position).getAeba());

        String vpa = accounts.get(position).getVpa();
        if(vpa == null || vpa.equals(""))
        {
            holder.evpa.setVisibility(View.GONE);
            holder.vpa.setText("");
        }
        else
        {
            holder.evpa.setVisibility(View.VISIBLE);
            holder.vpa.setText(accounts.get(position).getVpa());
        }

        String mbeba = accounts.get(position).getMbeba();
        if(mbeba == null || mbeba.equals("N"))
        {
            holder.pinset.setVisibility(View.GONE);
        }
        else
        {
            holder.pinset.setVisibility(View.VISIBLE);
        }

        holder.start.setOnClickListener(view -> accountOnItemClickListner.getOperatorPosition(position));
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView acc;
        TextView ifsc;
        TextView type;
        TextView vpa;
        LinearLayout evpa;
        LinearLayout pinset;
        CardView start;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            acc = itemView.findViewById(R.id.acc);
            ifsc = itemView.findViewById(R.id.ifsc);
            type = itemView.findViewById(R.id.type);
            vpa = itemView.findViewById(R.id.vpa);
            evpa = itemView.findViewById(R.id.evpa);
            pinset = itemView.findViewById(R.id.pinset);
            start = itemView.findViewById(R.id.start);
        }
    }

    public interface AccountOnItemClickListner{
        void getOperatorPosition(int pos);
    }
}
