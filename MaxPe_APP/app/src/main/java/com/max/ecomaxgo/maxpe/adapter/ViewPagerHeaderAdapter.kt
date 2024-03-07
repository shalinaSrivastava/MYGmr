package com.max.ecomaxgo.maxpe.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.R

class ViewPagerHeaderAdapter (private val postList: Array<Int>, private val context: Context) : PagerAdapter() {

    fun setOnItemClickListener(clickListener: ClickListener) {
        ViewPagerHeaderAdapter.clickListener = clickListener
    }

    override fun getCount(): Int {
        return postList.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view_pager_header, container, false)

        val mealThumb = view.findViewById<ImageView>(R.id.mealThumb)
        val mealName = view.findViewById<TextView>(R.id.mealName)

        val strMealThumb = postList[position]
        Glide.with(context).load(strMealThumb).placeholder(R.drawable.shadow_bottom_to_top).into(mealThumb)

//        val strMealName = meals[position].strMeal
//        mealName.text = strMealName

//        try {
//            view.setOnClickListener { v -> clickListener!!.onClick(v, position) }
//        }catch (ex :Exception){
//            Log.e("TAG", "Something went wrong")
//        }


        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    interface ClickListener {
        fun onClick(v: View, position: Int)
    }

    companion object {
        private var clickListener: ClickListener? = null
    }
}