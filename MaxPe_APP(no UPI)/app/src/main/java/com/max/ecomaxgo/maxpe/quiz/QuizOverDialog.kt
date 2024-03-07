package com.max.ecomaxgo.maxpe.quiz

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.quiz.model.QuizCancelListener

class QuizOverDialog : DialogFragment() {
    internal lateinit var view : View
    private lateinit var maxUserPrefs : MaxSharedPreference
    private lateinit var imgCloseQuizDialogOver: ImageView
    private var  mActivity: Activity?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }

    private var quizCancelListener: QuizCancelListener?= null

    fun setQuizCancelListener(quizCancelListener:QuizCancelListener){
        this.quizCancelListener = quizCancelListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.quiz_over_dialog_layout, container, false)
        initViews()

        maxUserPrefs = MaxSharedPreference(context!!)
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        imgCloseQuizDialogOver.setOnClickListener {
            dismissAllowingStateLoss()
            quizCancelListener?.quizClose(true) }

        return view
    }

    private fun initViews(){
        imgCloseQuizDialogOver = view.findViewById(R.id.imgCloseQuizDialogOver)
    }
}