package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.olive.upi.transport.model.Collectbeneblock;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BlockAdapter extends RecyclerView.Adapter<BlockAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    Context ctx;
    BlockOnItemClickListner blockOnItemClickListner;
    ArrayList<Collectbeneblock> collectbeneblocks;

    public BlockAdapter(Context ctx, ArrayList<Collectbeneblock> collectbeneblocks, BlockOnItemClickListner blockOnItemClickListner){
        inflater = LayoutInflater.from(ctx);
        this.collectbeneblocks = collectbeneblocks;
        this.ctx = ctx;
        this.blockOnItemClickListner = blockOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.block_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.vpa.setText(collectbeneblocks.get(position).getVpa());
        holder.unblock.setOnClickListener(view -> blockOnItemClickListner.getOperatorPosition(collectbeneblocks.get(position).getVpa()));
    }

    @Override
    public int getItemCount() {
        return collectbeneblocks.size();
    }

    public void updateList(ArrayList<Collectbeneblock> collectbeneblocks){
        this.collectbeneblocks = collectbeneblocks;
        notifyDataSetChanged();
    }

    public interface BlockOnItemClickListner{
        void getOperatorPosition(String vpa);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView vpa;
        ImageView unblock;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            vpa = itemView.findViewById(R.id.vpa);
            unblock = itemView.findViewById(R.id.unblock);
        }


    }
}
