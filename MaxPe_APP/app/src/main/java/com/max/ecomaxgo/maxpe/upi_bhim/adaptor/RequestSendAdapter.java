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

public class RequestSendAdapter extends RecyclerView.Adapter<RequestSendAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<BeneVpa> beneVpa;
    Context ctx;
    RequestSendAdapter.RequestOnItemClickListner requestOnItemClickListner;

    public RequestSendAdapter(Context ctx, ArrayList<BeneVpa> beneVpa, RequestSendAdapter.RequestOnItemClickListner requestOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.beneVpa = beneVpa;
        this.requestOnItemClickListner = requestOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public RequestSendAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vpa_list_item, parent, false);
        RequestSendAdapter.MyViewHolder holder = new RequestSendAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RequestSendAdapter.MyViewHolder holder, int position) {
        String name = beneVpa.get(position).getNickname();
        if(name == null || name.equals(""))
            name = beneVpa.get(position).getName();

        holder.name.setText(name);
        holder.vpa.setText(beneVpa.get(position).getVpa());

        holder.all.setOnClickListener(view -> requestOnItemClickListner.getOperatorPosition(beneVpa.get(position)));
    }

    @Override
    public int getItemCount() {
        return beneVpa.size();
    }

    public void updateList(ArrayList<BeneVpa> beneVpa){
        this.beneVpa = beneVpa;
        notifyDataSetChanged();
    }

    public interface RequestOnItemClickListner{
        void getOperatorPosition(BeneVpa beneVpa);
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

