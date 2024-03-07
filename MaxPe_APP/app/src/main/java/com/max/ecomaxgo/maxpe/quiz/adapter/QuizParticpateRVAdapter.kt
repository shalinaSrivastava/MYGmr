package com.max.ecomaxgo.maxpe.quiz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.quiz.model.Participant
import de.hdodenhof.circleimageview.CircleImageView
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class QuizParticpateRVAdapter(val context: Context, var data:ArrayList<Participant>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return ViewHolder(layoutInflater.inflate(R.layout.quiz_participate_layout, p0, false))

    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val quizPart = data[p1]

        val quizVH = p0 as ViewHolder

        if(quizPart.image.isNullOrEmpty()){
            quizVH.imgUserProfileQuiz.setBackgroundResource(R.drawable.personicon)
        }else{
            Glide.with(context)
                .load(quizPart.image)
                .centerCrop()
                .placeholder(R.drawable.personicon)
                .into(quizVH.imgUserProfileQuiz)
        }

        quizVH.tvUsernameQuiz.text = quizPart.fname
        quizVH.tvQuizWinnerCredit.text = "₹ ${quizPart.credited}"
        //quizVH.tvAttemptDate.text = changeStringFormat(quizPart.attemptDate!!)

    }

    fun changeStringFormat(attemptDate:String):String{

        val df: DateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm:ss a", Locale.getDefault())
        val convertedDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val startDate: Date
        var newDate:String ?= null
        try {
            startDate = convertedDateFormat.parse(attemptDate)
            newDate = df.format(startDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return newDate!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgUserProfileQuiz: ImageView = itemView.findViewById(R.id.imgUserProfileQuiz)
        val tvUsernameQuiz: TextView = itemView.findViewById(R.id.tvUsernameQuiz)
        val tvQuizWinnerCredit: TextView = itemView.findViewById(R.id.tvAmount)
        //val tvAttemptDate: TextView = itemView.findViewById(R.id.tvAttemptDate)
    }

    class WinnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgUserProfileQuizWin: ImageView = itemView.findViewById(R.id.imgUserProfileQuizWin)
//        val tvUsernameQuizWin: TextView = itemView.findViewById(R.id.tvUsernameQuizWin)
//        val tvWinAmount: TextView = itemView.findViewById(R.id.tvWinAmount)
    }
}