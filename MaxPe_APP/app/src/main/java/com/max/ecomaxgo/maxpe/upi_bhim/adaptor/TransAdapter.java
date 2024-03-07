package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.Upi;
import com.olive.upi.transport.model.CustomerVpa;
import com.olive.upi.transport.model.TranHistory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    Context ctx;
    ArrayList<TranHistory> tranHistory;
    TransOnItemClickListner transOnItemClickListner;
    String mvpa;
    String ovpa;

    public TransAdapter(Context ctx,String mvpa,ArrayList<TranHistory> tranHistory,TransOnItemClickListner transOnItemClickListner)
    {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.tranHistory = tranHistory;
        this.transOnItemClickListner = transOnItemClickListner;
        this.mvpa = mvpa;
        this.ovpa = mvpa;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.trans_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        if(Upi.getCustomerVpa() != null) {

            for (CustomerVpa vpa : Upi.getCustomerVpa()) {
                if(vpa.getVpa().equals(tranHistory.get(position).getCreditVpa())) {
                    ovpa = vpa.getVpa();
                    break;
                }
            }
        }

        String type = tranHistory.get(position).getType();
        int amount = Double.valueOf(tranHistory.get(position).getAmount()).intValue();
        holder.amt.setText(String.valueOf(amount));
        if(type.equals("PAY"))
        {
            if(ovpa.equals(tranHistory.get(position).getCreditVpa()))
            {
                holder.act.setText("Received from");
                holder.actimg.setRotation(90);
                holder.vpa.setText(tranHistory.get(position).getDebitVpa());
                holder.name.setText(tranHistory.get(position).getRemitterName());
            }
            else{
                holder.act.setText("Pay to");
                holder.actimg.setRotation(270);
                holder.vpa.setText(tranHistory.get(position).getCreditVpa());
                holder.name.setText(tranHistory.get(position).getBeneficiaryName());
            }
        }
        else if(type.equals("COLLECT"))
        {
            if(ovpa.equals(tranHistory.get(position).getCreditVpa()))
            {
                holder.act.setText("Request to");
                holder.actimg.setRotation(270);
                holder.vpa.setText(tranHistory.get(position).getDebitVpa());
                holder.name.setText(tranHistory.get(position).getRemitterName());
            }
            else{
                holder.act.setText("Request from");
                holder.actimg.setRotation(90);
                holder.vpa.setText(tranHistory.get(position).getCreditVpa());
                holder.name.setText(tranHistory.get(position).getBeneficiaryName());
            }
        }

        String status = tranHistory.get(position).getStatus();
        if(status.equals("P"))
        {
            holder.status.setImageResource(R.drawable.ic_baseline_error_24);
            holder.status.setColorFilter(ContextCompat.getColor(ctx,
                    R.color.orange));
        }
        else if(status.equals("C"))
        {
            holder.status.setImageResource(R.drawable.ic_baseline_check_circle_24);
            holder.status.setColorFilter(ContextCompat.getColor(ctx,
                    R.color.purple_200));
        }
        else if(status.equals("R"))
        {
            holder.status.setImageResource(R.drawable.ic_baseline_cancel_24);
            holder.status.setColorFilter(ContextCompat.getColor(ctx,
                    R.color.red));
        }

        holder.date.setText(tranHistory.get(position).getDateTime());
        holder.txn.setText(tranHistory.get(position).getTranid());
        holder.query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transOnItemClickListner.getOperatorPosition(tranHistory.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return tranHistory.size();
    }

    public interface TransOnItemClickListner{
        void getOperatorPosition(TranHistory tranHistory);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView actimg;
        ImageView status;

        TextView act;
        TextView vpa;
        TextView date;
        TextView txn;
        TextView name;
        TextView query;
        TextView amt;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            actimg = itemView.findViewById(R.id.actimg);
            status = itemView.findViewById(R.id.status);
            act = itemView.findViewById(R.id.act);
            vpa = itemView.findViewById(R.id.vpa);
            date = itemView.findViewById(R.id.txndate);
            txn = itemView.findViewById(R.id.txnid);
            name = itemView.findViewById(R.id.name);
            query = itemView.findViewById(R.id.query);
            amt = itemView.findViewById(R.id.amt);
        }
    }
}
