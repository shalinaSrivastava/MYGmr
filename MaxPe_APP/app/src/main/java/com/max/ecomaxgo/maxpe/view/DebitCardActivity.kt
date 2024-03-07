package com.max.ecomaxgo.maxpe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.Profile
import com.max.ecomaxgo.maxpe.model.login.Card
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.prepaid.MobilePrepaidTwo
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class DebitCardActivity : AppCompatActivity() {

    private lateinit var tvCardNumber: TextView
    private lateinit var tvCardExpiry: TextView
    private lateinit var tvCardStatus: TextView
    lateinit var maxPreference: MaxSharedPreference
    private lateinit var updateCard : Card


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debit_card)

        tvCardNumber = findViewById(R.id.tvCardNumber)
        tvCardStatus = findViewById(R.id.tvCardStatus)
        tvCardExpiry = findViewById(R.id.tvCardExpiry)

        maxPreference = MaxSharedPreference(this@DebitCardActivity)
        val call: Call<Card> =
            retrofitconfig.endpoints.getCard(Constant.skey, maxPreference.UserMobileNum!!, maxPreference.UserToken!!)
        call.enqueue(object : Callback<Card> {
            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(
                    this@DebitCardActivity,
                    "Please check your Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
                //loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                updateCard = response.body()!!
                if (updateCard.status.equals("1")){
                    System.out.println("------------------------------"+updateCard.message)

                    tvCardNumber.text = updateCard.data?.cardNumber
                    tvCardExpiry.text = updateCard.data?.cardExpiry
                    tvCardStatus.text = updateCard.data?.cardStatus


                }
            }
        })
    }
}