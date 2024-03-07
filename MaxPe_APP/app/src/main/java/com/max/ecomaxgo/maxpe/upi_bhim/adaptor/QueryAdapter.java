package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

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
import com.olive.upi.transport.model.TranHistory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.MyViewHolder> {

    ArrayList<TranHistory> query;
    LayoutInflater inflater;
    Context ctx;
    QueryOnItemClickListner queryOnItemClickListner;
    String mvpa;

    public QueryAdapter(Context ctx,String mvpa, ArrayList<TranHistory> query, QueryOnItemClickListner queryOnItemClickListner) {
        this.query = query;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.queryOnItemClickListner = queryOnItemClickListner;
        this.mvpa = mvpa;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.query_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return query.size();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        String type = query.get(position).getType();
        int amount = Double.valueOf(query.get(position).getAmount()).intValue();
        holder.amt.setText(String.valueOf(amount));
        if(type.equals("PAY"))
        {
            if(mvpa.equals(query.get(position).getCreditVpa()))
            {
                holder.act.setText("Received from");
                holder.vpa.setText(query.get(position).getDebitVpa());
                holder.name.setText(query.get(position).getRemitterName());
            }
            else{
                holder.act.setText("Pay to");
                holder.vpa.setText(query.get(position).getCreditVpa());
                holder.name.setText(query.get(position).getBeneficiaryName());
            }
        }
        else if(type.equals("COLLECT"))
        {
            if(mvpa.equals(query.get(position).getCreditVpa()))
            {
                holder.act.setText("Request to");
                holder.vpa.setText(query.get(position).getDebitVpa());
                holder.name.setText(query.get(position).getRemitterName());
            }
            else{
                holder.act.setText("Request from");
                holder.vpa.setText(query.get(position).getCreditVpa());
                holder.name.setText(query.get(position).getBeneficiaryName());
            }
        }

        String status = query.get(position).getStatus();
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

        holder.date.setText(query.get(position).getDateTime());
        holder.txn.setText(query.get(position).getTranid());
        holder.qryid.setText(query.get(position).getQueryid());
        holder.qrydate.setText(query.get(position).getQuerydate());
        holder.qry.setText(query.get(position).getQuery());
        holder.qrystatus.setText(query.get(position).getQueryStatus());
        holder.qrycmt.setText(query.get(position).getQueryCloserComment());

    }

    public interface QueryOnItemClickListner{
        void getOperatorPosition(int pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView status;

        TextView act;
        TextView vpa;
        TextView date;
        TextView txn;
        TextView name;
        TextView amt;

        TextView qryid;
        TextView qrydate;
        TextView qrystatus;
        TextView qry;
        TextView qrycmt;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            status = itemView.findViewById(R.id.status);
            act = itemView.findViewById(R.id.act);
            vpa = itemView.findViewById(R.id.vpa);
            date = itemView.findViewById(R.id.txndate);
            txn = itemView.findViewById(R.id.txnid);
            name = itemView.findViewById(R.id.name);
            amt = itemView.findViewById(R.id.amt);


            qryid = itemView.findViewById(R.id.qryid);
            qrydate = itemView.findViewById(R.id.qrydate);
            qrystatus = itemView.findViewById(R.id.qrystatus);
            qry = itemView.findViewById(R.id.qry);
            qrycmt = itemView.findViewById(R.id.qrycmt);
        }
    }
}
