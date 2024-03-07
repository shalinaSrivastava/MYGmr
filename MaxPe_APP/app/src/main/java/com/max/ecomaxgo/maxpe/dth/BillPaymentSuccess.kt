package com.max.ecomaxgo.maxpe.dth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.max.ecomaxgo.maxpe.R
import org.w3c.dom.Text

class BillPaymentSuccess : AppCompatActivity() {

    private lateinit var billerName: TextView
    private lateinit var transactionid: TextView
    private lateinit var tvBillerID: TextView
    private lateinit var tvAmount: TextView
    private lateinit var tvreferenceno: TextView

    lateinit var transactionId: String
    lateinit var billerId: String
    lateinit var billerNam: String
    lateinit var amount: String
    lateinit var PaymentRefNo: String
    lateinit var payment: String
    lateinit var paramvalue: String
    lateinit var category: String
    lateinit var logo: String
    private lateinit var btnDone: Button

    lateinit var tvTransactionValues: TextView
    lateinit var tvbbpsTransValue: TextView
    lateinit var tvRechargeAmount: TextView
    lateinit var op_name: TextView
    lateinit var op_name2: TextView
    lateinit var service_name: TextView
    lateinit var tvPrice: TextView
    lateinit var ivSuccessful: ImageView
    lateinit var tvMessageT: TextView
    lateinit var ivLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_payment_success)

        transactionId = intent.getStringExtra("transactionId").toString()
        billerId = intent.getStringExtra("billerId").toString()
        billerNam = intent.getStringExtra("billerName").toString()
        amount = intent.getStringExtra("amount").toString()
        PaymentRefNo = intent.getStringExtra("PaymentRefNo").toString()
        payment = intent.getStringExtra("payment").toString()
        paramvalue = intent.getStringExtra("paramvalue").toString()
        category = intent.getStringExtra("category").toString()
        logo = intent.getStringExtra("logo").toString()

        System.out.println("payment------------------------"+payment)
        initView()


    }

    private fun initView(){
        tvTransactionValues = findViewById(R.id.tvTransactionValues)
        tvbbpsTransValue = findViewById(R.id.tvbbpsTransValue)
        tvRechargeAmount = findViewById(R.id.tvRechargeAmount)
        op_name = findViewById(R.id.op_name)
        op_name2 = findViewById(R.id.op_name2)
        service_name = findViewById(R.id.service_name)
        tvPrice = findViewById(R.id.tvPrice)
        ivSuccessful = findViewById(R.id.ivSuccessful)
        tvMessageT = findViewById(R.id.tvMessageT)
        ivLogo = findViewById(R.id.ivLogo)

        btnDone = findViewById(R.id.btnDone)

        tvTransactionValues.text = transactionId
        tvbbpsTransValue.text = PaymentRefNo
        tvRechargeAmount.text = amount
        op_name.text = billerNam
        op_name2.text = paramvalue
        service_name.text = category
        tvPrice.text = amount

        if (payment.equals("success")){
            ivSuccessful.setImageResource(R.drawable.flower)
            tvMessageT.text = "Successful"
        }else{
            ivSuccessful.setImageResource(R.drawable.crossed)
            tvMessageT.text = "Failed"
        }

        Glide.with(this)
            .load(logo)
            .centerCrop()
            .placeholder(R.drawable.default_maxpe_profile)
            .into(ivLogo)
        btnDone.setOnClickListener(View.OnClickListener { finish() })
    }
}