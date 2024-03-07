package com.max.ecomaxgo.maxpe.dth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.dth.model.Details

class DthProviderActivity : AppCompatActivity() {

    lateinit var details: Details
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dth_provider)




    }

//    private fun inserOperatorDetails(){
//        val call: Call<Bbps> = retrofitconfig.endpoints.insertUser("OTOE00007XXA63", Constant.FlightSkey)
//        call.enqueue(object : Callback<Bbps>{
//            override fun onResponse(call: Call<Bbps>, response: Response<Bbps>) {
//                bbps = response.body()!!
//                if (bbps.status.equals("1")){
//                    details = bbps.details!!
//                }
//
//            }
//
//            override fun onFailure(call: Call<Bbps>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//
//
//
//    }
}