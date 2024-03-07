package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.BeneIfsc;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SendIfscAdapter extends RecyclerView.Adapter<SendIfscAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<BeneIfsc> beneIfsc;
    Context ctx;
    SendOnItemClickListner sendOnItemClickListner;

    public SendIfscAdapter(Context ctx, ArrayList<BeneIfsc> beneIfsc, SendOnItemClickListner sendOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.beneIfsc = beneIfsc;
        this.sendOnItemClickListner = sendOnItemClickListner;
    }

    public void updateList(ArrayList<BeneIfsc> beneIfsc){
        this.beneIfsc = beneIfsc;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ifsc_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.name.setText(beneIfsc.get(position).getName());

        String s = beneIfsc.get(position).getAccount();
        s = "XXXXXXXXX"+ s.substring(s.length()-4,s.length());

        holder.vpa.setText(s+" - "+beneIfsc.get(position).getIfsc().toUpperCase());
        holder.all.setOnClickListener(view -> sendOnItemClickListner.getOperatorPosition(beneIfsc.get(position)));
    }

    @Override
    public int getItemCount() {
        return beneIfsc.size();
    }

    public interface SendOnItemClickListner{
        void getOperatorPosition(BeneIfsc beneIfsc);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView vpa;
        LinearLayout all;
        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            vpa = (TextView) itemView.findViewById(R.id.vpa);
            all = (LinearLayout) itemView.findViewById(R.id.all);
        }
    }
}
