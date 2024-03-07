package com.max.ecomaxgo.maxpe.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import com.max.ecomaxgo.maxpe.model.prepaid.TransHistory

class HistoryAdapter(val context: Context, var data:ArrayList<TransHistory>)
: RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.history_item,p0,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val historyDetails = data[p1]

        System.out.println("------------------"+historyDetails.amount)

        if (historyDetails.status.equals("success")){
            p0.imgStatus.setImageResource(R.drawable.check)
            if (historyDetails.account.equals("credit")){
                p0.tvAmount.text = "+" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }else if (historyDetails.account.equals("debit")){
                p0.tvAmount.text = "-" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }
        }else if (historyDetails.status.equals("failed")){
            p0.imgStatus.setImageResource(R.drawable.crossed)
            if (historyDetails.account.equals("credit")){
                p0.tvAmount.text = "-" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }else if (historyDetails.account.equals("debit")){
                p0.tvAmount.text = "+"+ historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }
        }else if (historyDetails.status.equals("pending")){
            p0.imgStatus.setImageResource(R.drawable.warning_sign)
            if (historyDetails.account.equals("credit")){
                p0.tvAmount.text = "+" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }else if (historyDetails.account.equals("debit")){
                p0.tvAmount.text = "-" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }
        }else{
            p0.imgStatus.setImageResource(R.drawable.warning_sign)
            if (historyDetails.account.equals("credit")){
                p0.tvAmount.text = "+" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }else if (historyDetails.account.equals("debit")){
                p0.tvAmount.text = "-" +historyDetails.amount
                p0.tvService.text = historyDetails.services
                p0.tvAccount.text = historyDetails.field
                p0.tvTime.text = historyDetails.dateTime
            }
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val tvTransDate: TextView = itemView.findViewById(R.id.tvTransDate)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val ivStatus: ImageView = itemView.findViewById(R.id.ivStatus)
        val tvService: TextView = itemView.findViewById(R.id.tvService)
        val tvAccount: TextView = itemView.findViewById(R.id.tvAccount)
        val imgStatus: ImageView = itemView.findViewById(R.id.imgStatus)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val llTransHistory: LinearLayout = itemView.findViewById(R.id.llTransHistory)
    }
}