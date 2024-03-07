package com.max.ecomaxgo.maxpe.dashboad.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.max.ecomaxgo.maxpe.R;
import com.max.ecomaxgo.maxpe.dashboad.modle.AdsBanner;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {


     List<AdsBanner.Datum> list;
    Context context;
    CardView cardQuiz;
    public SliderAdapter(Context context, List<AdsBanner.Datum> list) {
        this.list = list;
        this.context = context;
        this.cardQuiz = cardQuiz;
    }

    // We are inflating the slider_layout
    // inside on Create View Holder method.
    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_ads, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {


        // Glide is use to load image
        String hotelPic = list.get(position).getImage();
        Glide.with(context)
                .load(hotelPic)
                .centerCrop()
                .placeholder(R.drawable.log)
                .into(viewHolder.ads_banner);
    }
    @Override
    public int getCount() {
        return list.size();
    }
    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        View itemView;
        ImageView ads_banner;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            ads_banner = itemView.findViewById(R.id.ads_banner);
            this.itemView = itemView;
        }
    }
}
