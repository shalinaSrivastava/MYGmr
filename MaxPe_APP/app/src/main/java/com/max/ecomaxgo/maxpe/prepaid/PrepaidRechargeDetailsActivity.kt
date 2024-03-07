package com.max.ecomaxgo.maxpe.prepaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidDetailsData
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PrepaidRechargeDetailsActivity : AppCompatActivity() {

    lateinit var strMob: String
    lateinit var strAmount: String
    lateinit var strMessage: String
    lateinit var strOperatorLogo: String;
    lateinit var strOperaterName: String
    lateinit var strServiceName: String

    lateinit var tvRechargeAmount: TextView
    lateinit var tvMessageT: TextView
    lateinit var ivLogo: ImageView
    lateinit var op_name: TextView
    lateinit var service_name: TextView
    lateinit var tvRechargeNo: TextView
    lateinit var tvMyNo: TextView

    lateinit var prepaidMode: PrepaidDetailsData
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var btnDone: Button
    private lateinit var ivSuccessful: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepaid_recharge_details)

        strMob = intent.getStringExtra("mob_no").toString()
        strAmount = intent.getStringExtra("amount").toString()
        strMessage = intent.getStringExtra("message").toString()
        strOperatorLogo = intent.getStringExtra("operater_logo").toString()
        strOperaterName = intent.getStringExtra("operater_name").toString();
        strServiceName = intent.getStringExtra("service_name").toString()

        if (strMessage.equals("SUCCESS")){
            ivSuccessful.setImageResource(R.drawable.check01)
        }else if (strMessage.equals("FAILED")){
            ivSuccessful.setImageResource(R.drawable.fail)

        }else if (strMessage.equals("PENDING")){
            ivSuccessful.setImageResource(R.drawable.pending)
        }

        maxPreference = MaxSharedPreference(this@PrepaidRechargeDetailsActivity)

        initView()

    }

    private fun initView(){
        tvRechargeAmount = findViewById(R.id.tvRechargeAmount)
        tvMessageT = findViewById(R.id.tvMessageT)
        ivLogo = findViewById(R.id.ivLogo)
        op_name = findViewById(R.id.op_name)
        service_name = findViewById(R.id.service_name)
        tvRechargeNo = findViewById(R.id.op_name2)
        btnDone = findViewById(R.id.btnDone)
        ivSuccessful = findViewById(R.id.ivSuccessful)
        tvMyNo = findViewById(R.id.op_name2)

        Glide.with(this)
            .load(strOperatorLogo)
            .centerCrop()
            .placeholder(R.drawable.max_logo)
            .into(ivLogo)
        op_name.text = strOperaterName
        service_name.text = strServiceName
        tvRechargeAmount.text = strAmount
        tvRechargeNo.text = strMob
        tvMessageT.text = strMessage
        tvMyNo.text = maxPreference.UserMobileNum

        if (strMessage.equals("SUCCESS")){
            ivSuccessful.visibility = View.VISIBLE
        }

        btnDone.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}