package com.max.ecomaxgo.maxpe.dashboad.lostfound.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.FoundActivity;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.LostActivity;
import com.max.ecomaxgo.maxpe.dashboad.lostfound.modle.LFCategory;

import java.util.List;

public class LFcategoryAdpter extends RecyclerView.Adapter<LFcategoryAdpter.RecyclerViewHolder> {

        List<LFCategory.Datum>list;
        String title;
        Context context;
        public LFcategoryAdpter(Context context,List<LFCategory.Datum> list, String title){
         this.list=list;
         this.title=title;
         this.context=context;
        }

    @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate Layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_category_lf, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder._adpt_lfCategory.setText(list.get(position).getCategory());
            holder._adpt_lfCategory.setOnClickListener(view->category(list.get(position).getCategory()));
        }

    private void category(String Category) {
            if (title.equals("Found")){
                Intent intent = new Intent(context, FoundActivity.class);
                intent.putExtra("category",Category);
                context.startActivity(intent);

            }else  if (title.equals("Lost")){
                Intent intent = new Intent(context, LostActivity.class);
                intent.putExtra("title","Lost");
                context.startActivity(intent);
            }
    }

    @Override
        public int getItemCount() {
            // this method returns the size of recyclerview
            return list.size();
        }

        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our views.
            private TextView _adpt_lfCategory;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our views with their ids.
                _adpt_lfCategory = itemView.findViewById(R.id._adpt_lfCategory);

            }
        }
    }
