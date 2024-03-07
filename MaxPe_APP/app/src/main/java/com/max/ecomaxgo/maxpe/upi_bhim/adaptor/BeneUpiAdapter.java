package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.app.AlertDialog;
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
import com.olive.upi.transport.model.BeneVpa;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BeneUpiAdapter extends RecyclerView.Adapter<BeneUpiAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<BeneVpa> beneVpa;
    Context ctx;
    BeneOnItemClickListner beneOnItemClickListner;
    AlertDialog deleteDialog;

    public BeneUpiAdapter(Context ctx, ArrayList<BeneVpa> beneVpa, BeneOnItemClickListner beneOnItemClickListner) {
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.beneVpa = beneVpa;
        this.beneOnItemClickListner = beneOnItemClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.beneupi_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder,int position) {
        String name = beneVpa.get(position).getNickname();
        if(name == null || name.equals(""))
            name = beneVpa.get(position).getName();

        holder.name.setText(name);
        holder.vpa.setText(beneVpa.get(position).getVpa());
        //holder.delete.setOnClickListener(view -> beneOnItemClickListner.getOperatorPosition(beneVpa.get(position).getVpa()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_delete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beneVpa.size();
    }

    public void updateList(ArrayList<BeneVpa> beneVpa){
        this.beneVpa = beneVpa;
        notifyDataSetChanged();
    }

    public interface BeneOnItemClickListner{

        void getOperatorPosition(String vpa);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView vpa;
        protected ImageView delete;
        LinearLayout all;
        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            vpa = (TextView) itemView.findViewById(R.id.vpa);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            all = (LinearLayout) itemView.findViewById(R.id.all);


        }
    }
    private void set_delete(int position) {

        LayoutInflater factory = LayoutInflater.from(ctx);
        final View deleteDialogView = factory.inflate(R.layout.logout_layout, null);

        deleteDialog = new AlertDialog.Builder(ctx).create();
        deleteDialog.setView(deleteDialogView);
       TextView tvCancelRequest = (TextView)deleteDialogView.findViewById(R.id.tvCancelRequest);
        tvCancelRequest.setText("Are you sure to delete this item?");

        deleteDialogView.findViewById(R.id.tvCancelNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });
        deleteDialogView.findViewById(R.id.tvCancelYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
                beneOnItemClickListner.getOperatorPosition(beneVpa.get(position).getVpa());
            }
        });
        deleteDialog.show();

    }
}
