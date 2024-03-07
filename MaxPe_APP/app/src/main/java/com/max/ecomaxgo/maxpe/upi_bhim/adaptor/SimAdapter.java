package com.max.ecomaxgo.maxpe.upi_bhim.adaptor;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.ApiUPI;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIChecksum;
import com.max.ecomaxgo.maxpe.upi_bhim.upi_model.UPIInterface;
import com.max.ecomaxgo.maxpe.util.Constant;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SimAdapter extends RecyclerView.Adapter<SimAdapter.MyViewHolder>{
    Context ctx;
    public SimAdapter(Context ctx,List<SubscriptionInfo> subscription, SimOnItemClickListner simOnItemClickListner) {
        this.ctx=ctx;
        inflater = LayoutInflater.from(ctx);
        this.subscription = subscription;
        this.simOnItemClickListner = simOnItemClickListner;
    }
    private LayoutInflater inflater;
    List<SubscriptionInfo> subscription;
    SimOnItemClickListner simOnItemClickListner;

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sim_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

//        String num = subscription.get(position).getNumber();
//        holder.number.setText((num.length() == 10?num:num.substring(num.length()-10,num.length())));
        holder.operator.setText(subscription.get(position).getCarrierName());
        holder.slot.setText(""+(position+1));
        holder.numcon.setOnClickListener(v -> simOnItemClickListner.getOperatorPosition(position));

    }

    @Override
    public int getItemCount() {
        return this.subscription.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView slot;
        protected TextView operator;
        protected LinearLayout numcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            slot = (TextView) itemView.findViewById(R.id.slot);
            operator = (TextView) itemView.findViewById(R.id.operator);
            numcon = (LinearLayout) itemView.findViewById(R.id.numcon);
        }
    }

    public interface SimOnItemClickListner{

        void getOperatorPosition(int pos);


    }

}
