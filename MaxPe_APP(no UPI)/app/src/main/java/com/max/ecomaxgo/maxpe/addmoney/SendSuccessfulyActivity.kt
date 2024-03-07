package com.max.ecomaxgo.maxpe.addmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R

class SendSuccessfulyActivity : AppCompatActivity() {

    private lateinit var ivSuccessful: ImageView
    private lateinit var tvMessageT: TextView
    private lateinit var tvMyNo: TextView
    private lateinit var tvRechargeNo: TextView
    private lateinit var tvRechargeAmount: TextView
    private lateinit var btnDone: Button

    lateinit var amount: String
    lateinit var strMob: String
    lateinit var strAmount: String
    lateinit var strMessage: String
    private lateinit var maxPreference: MaxSharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_successfuly)

        strMob = intent.getStringExtra("recharge_no").toString()
        strMessage = intent.getStringExtra("message").toString()
        amount = intent.getStringExtra("amount").toString()

        maxPreference = MaxSharedPreference(this@SendSuccessfulyActivity)
        //mob_number = maxPreference.UserMobileNum.toString()

        initView()
    }

    private fun initView(){
        ivSuccessful = findViewById(R.id.ivSuccessful)
        tvMessageT = findViewById(R.id.tvMessageT)
        tvMyNo = findViewById(R.id.tvMyNo)
        tvRechargeNo = findViewById(R.id.tvRechargeNo)
        tvRechargeAmount = findViewById(R.id.tvRechargeAmount)
        btnDone = findViewById(R.id.btnDone)


        tvRechargeNo.text = strMob
        tvMessageT.text = strMessage
        tvMyNo.text = maxPreference.UserMobileNum
        tvRechargeAmount.text = amount

        if (strMessage.equals("Success")){
            ivSuccessful.visibility = View.VISIBLE
        }else{
            ivSuccessful.visibility = View.GONE
        }


        btnDone.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}