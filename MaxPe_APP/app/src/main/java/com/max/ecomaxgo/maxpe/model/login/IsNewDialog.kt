package com.max.ecomaxgo.maxpe.model.login

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

//class IsNewDialog : DialogFragment() {
//    internal lateinit var view: View
//    private lateinit var maxUserPrefs: MaxSharedPreference
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        view = inflater.inflate(R.layout.popup_layout, container, false)
//
//        maxUserPrefs = MaxSharedPreference(requireContext()!!)
//        val tvSkip: TextView = view.findViewById(R.id.tvSkip)
//        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        tvSkip.setOnClickListener {
//            dismiss()
//        }
//        return view
//    }
//}