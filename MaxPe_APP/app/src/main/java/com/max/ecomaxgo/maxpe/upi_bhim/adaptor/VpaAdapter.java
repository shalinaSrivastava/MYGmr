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
import com.olive.upi.transport.model.BeneVpa;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VpaAdapter extends RecyclerView.Adapter<VpaAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    Context ctx;
    VpaOnItemClickListner vpaOnItemClickListner;
    ArrayList<BeneVpa> beneVpa;
    String name;

    public VpaAdapter(Context ctx, ArrayList<BeneVpa> beneVpa, VpaOnItemClickListner vpaOnItemClickListner) {
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.beneVpa = beneVpa;
        this.vpaOnItemClickListner = vpaOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vpa_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        name = beneVpa.get(position).getNickname();
        if(name == null || name.equals(""))
            name = beneVpa.get(position).getName();

        holder.name.setText(name);
        holder.vpa.setText(beneVpa.get(position).getVpa());
        holder.all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vpaOnItemClickListner.getOperatorPosition(beneVpa.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return beneVpa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView vpa;
        protected LinearLayout all;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            vpa = (TextView) itemView.findViewById(R.id.vpa);
            all = (LinearLayout) itemView.findViewById(R.id.all);
        }
    }

    public interface VpaOnItemClickListner{
        void getOperatorPosition(BeneVpa beneVpa);
    }
}
