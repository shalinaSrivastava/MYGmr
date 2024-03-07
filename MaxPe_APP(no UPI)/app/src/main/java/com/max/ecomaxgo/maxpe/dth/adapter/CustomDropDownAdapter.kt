package com.max.ecomaxgo.maxpe.dth.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.model.prepaid.Service

class CustomDropDownAdapter (val context: Context, var dataSource: List<Service>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        //vh.label.text = dataSource.get(position).operation
        vh.idType.text = dataSource.get(position).operation

        return view
    }

    override fun getItem(position: Int): Any? {
        return dataSource[position];
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    private class ItemHolder(row: View?) {
        val label: TextView
        //val radioGroup: RadioGroup
        val idType: RadioButton

        init {
            label = row?.findViewById(R.id.text) as TextView
            //radioGroup = row?.findViewById(R.id.radioGroup) as RadioGroup
            idType = row?.findViewById(R.id.idType) as RadioButton
        }
    }

}