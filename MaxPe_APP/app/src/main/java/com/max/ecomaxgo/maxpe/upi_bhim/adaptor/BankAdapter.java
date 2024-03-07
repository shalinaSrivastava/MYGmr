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
import com.olive.upi.transport.model.Bank;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<Bank> banks;
    Context ctx;
    BankOnItemClickListner bankOnItemClickListner;

    public BankAdapter(Context ctx, List<Bank> banks,BankOnItemClickListner bankOnItemClickListner){
        inflater = LayoutInflater.from(ctx);
        this.banks = banks;
        this.ctx = ctx;
        this.bankOnItemClickListner = bankOnItemClickListner;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bank_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(banks.get(position).getName());
        holder.iin.setText(banks.get(position).getIin());

        Glide.with(ctx)
            .load(banks.get(position).getLogo())
            .centerInside()
            .placeholder(R.drawable.ic_baseline_account_balance_24)
            .into(holder.image);



        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankOnItemClickListner.getOperatorPosition(banks.get(position));
            }
        });
    }

    public void updateList(List<Bank> list){
        this.banks = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.banks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView iin;
        protected ImageView image;
        LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.bankName);
            iin = (TextView) itemView.findViewById(R.id.bankiin);
            image = (ImageView) itemView.findViewById(R.id.bankLogo);
            ll = (LinearLayout) itemView.findViewById(R.id.all);
        }
    }

    public interface BankOnItemClickListner{
        void getOperatorPosition(Bank bank);
    }


}
