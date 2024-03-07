package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.CustomerBankAccounts;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    Context ctx;
    AccountOnItemClickListner accountOnItemClickListner;
    ArrayList<CustomerBankAccounts> customerBankAccounts;

    public AccountAdapter(Context ctx, ArrayList<CustomerBankAccounts> customerBankAccounts, AccountOnItemClickListner accountOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.customerBankAccounts = customerBankAccounts;
        this.accountOnItemClickListner = accountOnItemClickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.account_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if(customerBankAccounts.get(position).getAccounts().get(0).getBalance() == null ||
            customerBankAccounts.get(position).getAccounts().get(0).getBalance().equals(""))
        {
            holder.balance.setVisibility(View.INVISIBLE);
            holder.amt.setText("");
        }
        else
        {
            holder.balance.setVisibility(View.VISIBLE);
            holder.amt.setText(customerBankAccounts.get(position).getAccounts().get(0).getBalance());
        }
        holder.option.setOnClickListener(view -> accountOnItemClickListner.getOperatorPosition(position,"option"));
        holder.check.setOnClickListener(view -> accountOnItemClickListner.getOperatorPosition(position,"amt"));
    }

    public void updateList(ArrayList<CustomerBankAccounts> customerBankAccounts){
        this.customerBankAccounts = customerBankAccounts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return customerBankAccounts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {


        TextView amt;
        LinearLayout check;
        LinearLayout balance;
        ImageView option;

        public MyViewHolder(View itemView) {
            super(itemView);
            amt = itemView.findViewById(R.id.amt);
            check = itemView.findViewById(R.id.check);
            balance = itemView.findViewById(R.id.balance);
            option = itemView.findViewById(R.id.option);
        }
    }

    public interface AccountOnItemClickListner{
        void getOperatorPosition(int pos,String type);
    }

}
