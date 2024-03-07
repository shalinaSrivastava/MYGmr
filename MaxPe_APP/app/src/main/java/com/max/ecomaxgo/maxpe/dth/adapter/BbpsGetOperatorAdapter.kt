package com.max.ecomaxgo.maxpe.dth.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.dth.BbpsBillerActivity
import com.max.ecomaxgo.maxpe.dth.BroadBandProviderActivity
import com.max.ecomaxgo.maxpe.dth.model.Operator
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import java.util.ArrayList

class BbpsGetOperatorAdapter (val context: Context, var data: ArrayList<Operator>): RecyclerView.Adapter<BbpsGetOperatorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.mob_operater_name,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, position: Int){
        val operaterModel = data[position]
        Glide.with(context)
            .load(operaterModel.operatorLogo)
            .centerCrop()
            .placeholder(R.drawable.max_logo)
            .into(p0.ivOperaterImage)

        p0.tvOperaterName.text = operaterModel.billerName

        p0.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, BroadBandProviderActivity::class.java)
            intent.putExtra("billerId", operaterModel.billerId)
            intent.putExtra("billerName", operaterModel.billerName)
            intent.putExtra("billerLogo", operaterModel.operatorLogo)
            System.out.println("-----------------------------"+operaterModel.billerName)
            context.startActivity(intent)
        })


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivOperaterImage: ImageView = itemView.findViewById(R.id.ivOperaterImage)
        val tvOperaterName: TextView = itemView.findViewById(R.id.tvOperaterName);
    }
}
