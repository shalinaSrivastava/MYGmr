package com.max.ecomaxgo.maxpe.dth.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;

import java.util.ArrayList;
import java.util.List;

public class SentListAdapter extends RecyclerView.Adapter<SentListAdapter.ViewHolder>{

    List<String> userList = new ArrayList<>();

    public SentListAdapter(ArrayList<String> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_sent_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItems(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.toArray().length;
    }


    //the class is hodling the list view
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
        public void bindItems (String user) {
            CardView cardView = null;
            cardView.findViewById(R.id.cardView);
        }
    }
}
