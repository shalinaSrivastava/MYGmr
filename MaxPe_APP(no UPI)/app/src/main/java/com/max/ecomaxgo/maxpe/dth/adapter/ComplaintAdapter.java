package com.max.ecomaxgo.maxpe.dth.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dth.model.ComplaintModel;

import java.util.ArrayList;
import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ViewHolder> {

    List<ComplaintModel> userList = new ArrayList<>();

    public ComplaintAdapter(List<ComplaintModel> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_item_complaint, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bindItems(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindItems(ComplaintModel user) {
            TextView datetv = itemView.findViewById(R.id.datetv);
            TextView titletv = itemView.findViewById(R.id.titletv);
            TextView datetvheader = itemView.findViewById(R.id.datetvheader);

            datetv.setText(user.getDate() + " " + user.getTime());
            titletv.setText(user.getId());
            datetvheader.setText(user.getDate() + " " + user.getTime());
        }
    }
}
