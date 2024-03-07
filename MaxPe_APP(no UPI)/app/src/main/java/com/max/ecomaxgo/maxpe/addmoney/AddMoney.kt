package com.max.ecomaxgo.maxpe.addmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddMoney : AppCompatActivity() {

    private lateinit var edtAddAmount: EditText
    private lateinit var maxPreference: MaxSharedPreference
    lateinit var addAmount: Login
    lateinit var btnProceedAddMoney: Button
    private lateinit var imgBackAddMoney: ImageView
    private lateinit var tvBalanceShow: TextView
    private lateinit var progressAddMoney: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money)
        initView()

        maxPreference = MaxSharedPreference(this@AddMoney)

        val amount = maxPreference.AddMoneyAmountToWallet
        tvBalanceShow.text = "Available Balance ₹ " + amount

    }


    private fun initView(){
        edtAddAmount = findViewById(R.id.edtAddAmount)
        btnProceedAddMoney = findViewById(R.id.btnProceedAddMoney)
        imgBackAddMoney = findViewById(R.id.imgBackAddMoney)
        tvBalanceShow = findViewById(R.id.tvBalanceShow)
        progressAddMoney = findViewById(R.id.progressAddMoney)

        imgBackAddMoney.setOnClickListener(View.OnClickListener { finish() })

        btnProceedAddMoney.setOnClickListener(View.OnClickListener {

            addMoneyApi()
        })

    }

    private fun addMoneyApi(){
        progressAddMoney.visibility = View.VISIBLE
        val call: Call<Login> =
            retrofitconfig.endpoints.addMoney(Constant.skey, maxPreference.UserMobileNum.toString(), maxPreference.UserToken.toString(), edtAddAmount.text.toString())
        call.enqueue(object : Callback<Login>{
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                addAmount=response.body()!!
                Log.e("login response ", " :: ${response.body()}")

                if (addAmount.status.equals("1")){
                    Toast.makeText(this@AddMoney, addAmount.message, Toast.LENGTH_LONG).show()
                    progressAddMoney.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                TODO("Not yet implemented")
                progressAddMoney.visibility = View.VISIBLE
            }
        })
    }
}