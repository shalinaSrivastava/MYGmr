package com.max.ecomaxgo.maxpe.share

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

class ShareThanksDialog : DialogFragment() {

    internal lateinit var view : View
    private lateinit var maxUserPrefs : MaxSharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.share_thanks_layout, container, false)

        maxUserPrefs = MaxSharedPreference(requireContext())
        val tvLogoutYes: TextView = view.findViewById(R.id.tvLogoutYes)
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvLogoutYes.setOnClickListener {
            dismiss()
            requireActivity().finish()
        }
        return view
    }
}