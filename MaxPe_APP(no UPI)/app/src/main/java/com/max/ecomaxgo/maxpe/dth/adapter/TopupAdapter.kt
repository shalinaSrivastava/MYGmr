package com.max.ecomaxgo.maxpe.dth.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.model.prepaid.Service

class TopupAdapter(val context: Context, var data:ArrayList<Service>, operatorItemClickListener: OperatorItemClickListener)
    : RecyclerView.Adapter<TopupAdapter.ViewHolder>() {

    var operatorItemClickListener: OperatorItemClickListener?=null

    init {
        this.operatorItemClickListener = operatorItemClickListener
    }

    var  selectedRBPosition = -1
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.custom_spinner_item, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val topup = data[p1]
        p0.idType.isChecked = selectedRBPosition ==p1
        p0.idType.text = topup.operation

        p0.itemView.setOnClickListener(View.OnClickListener {
            //operatorItemClickListener!!.getOperatorPosition(p1)
        })

        p0.idType.setOnClickListener(View.OnClickListener {
            operatorItemClickListener!!.getOperatorPosition(p1)
           //mSelectedItem=getAdapterPosition()
                //notifyDataSetChanged();
            selectedRBPosition  = p0.adapterPosition
            notifyItemRangeChanged(0, data.size)


        })


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idType: RadioButton = itemView.findViewById(R.id.idType)

    }

    interface OperatorItemClickListener {
        fun getOperatorPosition(pos:Int)
    }
}