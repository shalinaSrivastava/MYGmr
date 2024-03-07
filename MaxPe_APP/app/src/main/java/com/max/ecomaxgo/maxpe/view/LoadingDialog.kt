package com.max.ecomaxgo.maxpe.view.DialogFragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.max.ecomaxgo.maxpe.R

class LoadingDialog : DialogFragment() {

    internal lateinit var view : View
    private lateinit var tvLoadingText:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        view = inflater.inflate(R.layout.fragment_loading_dialog, container, false)
        tvLoadingText = view.findViewById(R.id.tvLoadingText)

        tvLoadingText.text = requireArguments().getString("showText")
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return view
    }
}