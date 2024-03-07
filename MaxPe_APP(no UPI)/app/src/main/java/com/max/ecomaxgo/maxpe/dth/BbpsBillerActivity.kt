package com.max.ecomaxgo.maxpe.dth

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BbpsBillerActivity : AppCompatActivity() {

    private lateinit var imgBackRecharge: ImageView
    private lateinit var ivLogoDth: ImageView
    private lateinit var tvBillerName: TextView
    private lateinit var linear: LinearLayout
    //lateinit var biller: Biller
    private lateinit var edit_field: TextInputEditText

    lateinit var billerId: String
    lateinit var billerName: String
    lateinit var billerLogo: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbps_biller)
        billerId = intent.getStringExtra("billerId")!!
        billerName = intent.getStringExtra("billerName")!!
        billerLogo = intent.getStringExtra("billerLogo")!!

        initView()

    }

    private fun initView(){
        imgBackRecharge = findViewById(R.id.imgBackRecharge)
        ivLogoDth = findViewById(R.id.ivLogoDth)
        tvBillerName = findViewById(R.id.tvBillerName)
        edit_field = findViewById(R.id.edit_field)
        linear = findViewById(R.id.linear)


        imgBackRecharge.setOnClickListener(View.OnClickListener { finish() })
        tvBillerName.text = billerName
        Glide.with(this)
            .load(billerLogo)
            .centerCrop()
            .placeholder(R.drawable.max_logo)
            .into(ivLogoDth)
    }

//    private fun getBillerApi(){
//        val call: Call<Biller> =
//            retrofitconfig.endpoints.getBiller(Constant.skey, "DTH", billerId)
//        call.enqueue(object : Callback<Biller> {
//            override fun onFailure(call: Call<Biller>, t: Throwable) {
//
//            }
//
//            override fun onResponse(call: Call<Biller>, response: Response<Biller>) {
//                biller = response.body()!!
//                if (biller.status.equals("1")){
//                    val billerList: List<BillerCustomerParam>? = biller.data?.billerCustomerParams
//
//                    System.out.println("billerList--------------------------"+billerList?.size)
//                    var paramSize = biller.data?.billerCustomerParams
//                    System.out.println("paramSize--------------------------"+paramSize?.size)
//
//                    var itemNumber: Int? = paramSize?.size
//
//                        for (item in 1..5) {
//                            edit_field.id = item
//                            linear.addView(edit_field)
//                            System.out.println("-----------------------------------"+item)
//                        }
//                    }
//
//
//                }
//
//
//        })
//    }
}