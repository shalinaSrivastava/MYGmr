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
import com.olive.upi.transport.model.PendingReqVo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RequestReceivedAdapter extends RecyclerView.Adapter<RequestReceivedAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<PendingReqVo> pendingReqVos;
    Context ctx;
    RequestOnItemClickListner requestOnItemClickListner;

    public RequestReceivedAdapter(Context ctx, ArrayList<PendingReqVo> pendingReqVos, RequestOnItemClickListner requestOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.pendingReqVos = pendingReqVos;
        this.requestOnItemClickListner = requestOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.request_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.name.setText(pendingReqVos.get(position).getBeneName());
        holder.vpa.setText(pendingReqVos.get(position).getPayeeVpa());
        holder.expiry.setText(pendingReqVos.get(position).getExpdate());

        int amount = Double.valueOf(pendingReqVos.get(position).getAmount()).intValue();
        holder.amt.setText(String.valueOf(amount));
        //holder.status.setImageResource(R.drawable.ic_baseline_error_outline_24);

        holder.all.setOnClickListener(view -> requestOnItemClickListner.getOperatorPosition(pendingReqVos.get(position)));
    }

    @Override
    public int getItemCount() {
        return pendingReqVos.size();
    }

    public void updateList(ArrayList<PendingReqVo> pendingReqVos){
        this.pendingReqVos = pendingReqVos;
        notifyDataSetChanged();
    }

    public interface RequestOnItemClickListner {
        void getOperatorPosition(PendingReqVo pendingReqVo);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView name;
        protected TextView vpa;
        protected TextView expiry;
        protected TextView amt;
        protected LinearLayout all;
        protected ImageView status;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            vpa = itemView.findViewById(R.id.vpa);
            expiry = itemView.findViewById(R.id.expiry);
            amt = itemView.findViewById(R.id.amt);
            all = itemView.findViewById(R.id.all);
            status = itemView.findViewById(R.id.status);
        }
    }
}
