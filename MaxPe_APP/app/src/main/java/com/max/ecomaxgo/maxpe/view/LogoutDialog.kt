package com.max.ecomaxgo.maxpe.view

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.LoginActivity
import com.max.ecomaxgo.maxpe.R

class LogoutDialog : DialogFragment() {

    internal lateinit var view : View
    private lateinit var maxUserPrefs : MaxSharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.logout_layout, container, false)
        maxUserPrefs = MaxSharedPreference(context!!)
        val tvCancelNo: TextView = view.findViewById(R.id.tvCancelNo)
        val tvCancelYes: TextView = view.findViewById(R.id.tvCancelYes)
        val tvCancelRequest: TextView = view.findViewById(R.id.tvCancelRequest)
        tvCancelRequest.setText("Are you sure to exit?")
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        tvCancelNo.setOnClickListener {
            dismiss()
        }

        tvCancelYes.setOnClickListener {
            maxUserPrefs.clear()
            dismiss()
            val intent= Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            activity!!.finish()
        }
        return view
    }
}