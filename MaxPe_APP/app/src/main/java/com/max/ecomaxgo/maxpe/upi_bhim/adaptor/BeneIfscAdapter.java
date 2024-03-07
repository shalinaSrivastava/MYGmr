package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.BeneIfsc;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BeneIfscAdapter extends RecyclerView.Adapter<BeneIfscAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<BeneIfsc> beneIfsc;
    Context ctx;
    BeneOnItemClickListner beneOnItemClickListner;

    public BeneIfscAdapter(Context ctx, ArrayList<BeneIfsc> beneIfsc, BeneOnItemClickListner beneOnItemClickListner) {
        this.beneIfsc = beneIfsc;
        this.ctx = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.beneOnItemClickListner = beneOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.beneifsc_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.name.setText(beneIfsc.get(position).getName());

        String s = beneIfsc.get(position).getAccount();
        s = "XXXXXXXXX"+ s.substring(s.length()-4,s.length());

        holder.vpa.setText(s+" - "+beneIfsc.get(position).getIfsc().toUpperCase());
        holder.delete.setOnClickListener(view -> beneOnItemClickListner.getOperatorPosition(beneIfsc.get(position).getVpa()));
    }

    @Override
    public int getItemCount() {
        return beneIfsc.size();
    }
    public void updateList(ArrayList<BeneIfsc> beneIfsc){
        this.beneIfsc = beneIfsc;
        notifyDataSetChanged();
    }


    public interface BeneOnItemClickListner{
        void getOperatorPosition(String vpa);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView name;
        protected TextView vpa;
        protected ImageView delete;
        LinearLayout all;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            vpa = (TextView) itemView.findViewById(R.id.vpa);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            all = (LinearLayout) itemView.findViewById(R.id.all);
        }
    }

}
