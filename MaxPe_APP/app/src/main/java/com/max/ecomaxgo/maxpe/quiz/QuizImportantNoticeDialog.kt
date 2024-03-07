package com.max.ecomaxgo.maxpe.quiz

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R

class QuizImportantNoticeDialog : DialogFragment() {

    internal lateinit var view: View
    private lateinit var maxUserPrefs: MaxSharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.quiz_important_notice_layout, container, false)

        maxUserPrefs = MaxSharedPreference(context!!)
        val tvQuizOk: TextView = view.findViewById(R.id.tvQuizOk)
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        tvQuizOk.setOnClickListener {
            dismiss()
        }
        return view
    }
}