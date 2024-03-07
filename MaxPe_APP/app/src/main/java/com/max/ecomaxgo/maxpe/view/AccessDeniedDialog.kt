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
class AccessDeniedDialog : DialogFragment() {
    internal lateinit var view : View
    private lateinit var maxUserPrefs : MaxSharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.denied_layout, container, false)

        maxUserPrefs = MaxSharedPreference(requireContext())
        val tvLogout: TextView = view.findViewById(R.id.tvLogout)
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvLogout.setOnClickListener {
            maxUserPrefs.clear()
            dismiss()
            val intent= Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            requireActivity().finish()
        }
        return view
    }
}