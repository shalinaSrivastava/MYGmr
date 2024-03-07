package com.max.ecomaxgo.maxpe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.model.prepaid.Service
import com.max.ecomaxgo.maxpe.prepaid.MobilePrepaidActivity
import java.util.ArrayList

class PrepaidRechargeAdapter (val context: Context, var data: ArrayList<Datum>, operatorItemClickListener: OperatorItemClickListener): RecyclerView.Adapter<PrepaidRechargeAdapter.ViewHolder>() {

    var operatorItemClickListener: OperatorItemClickListener?=null

    init {
        this.operatorItemClickListener = operatorItemClickListener
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.postpaid_operater_name,p0,false)
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

        p0.tvOperaterName.text = operaterModel.operatorName

        p0.itemView.setOnClickListener(View.OnClickListener {
            operatorItemClickListener!!.getOperatorPosition(position)
        })

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivOperaterImage: ImageView = itemView.findViewById(R.id.ivOperaterImage)
        val tvOperaterName: TextView = itemView.findViewById(R.id.tvOperaterName);
    }

    interface OperatorItemClickListener {
        fun getOperatorPosition(pos:Int)
    }
}
