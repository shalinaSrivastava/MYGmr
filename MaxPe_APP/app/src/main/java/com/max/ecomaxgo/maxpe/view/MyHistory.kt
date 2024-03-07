package com.max.ecomaxgo.maxpe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.HistoryAdapter
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import com.max.ecomaxgo.maxpe.model.prepaid.History
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.model.prepaid.TransHistory
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MyHistory : AppCompatActivity() {

    private lateinit var rvHistory: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var maxPreference : MaxSharedPreference
    lateinit var mob_number: String
    lateinit var userToken: String

    lateinit var history: History
    val historyDetails = ArrayList<TransHistory>()
    private lateinit var historyAdapter: HistoryAdapter

    private lateinit var imgBackHistory: ImageView
    private lateinit var progressHistory: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_history)

        maxPreference =
            MaxSharedPreference(this@MyHistory)

        mob_number = maxPreference.UserMobileNum.toString()
        userToken = maxPreference.UserToken.toString()

        System.out.println("mob_number-------------------+++"+mob_number)

        System.out.println("userToken-------------------+++"+userToken)
        initView()
        layoutManager = LinearLayoutManager(this@MyHistory)
        rvHistory.layoutManager = layoutManager
        rvHistory.itemAnimator = DefaultItemAnimator()
        rvHistory.hasFixedSize()

    }

    private fun initView(){
        rvHistory = findViewById(R.id.rvHistory)
        imgBackHistory = findViewById(R.id.imgBackHistory)
        progressHistory = findViewById(R.id.progressHistory)

        imgBackHistory.setOnClickListener(View.OnClickListener {
            finish()
        })

        val call: Call<History> =
            retrofitconfig.endpoints.getHistory(Constant.skey, mob_number, userToken)
        call.enqueue(object : Callback<History>{
            override fun onResponse(call: Call<History>, response: Response<History>) {
                history = response.body()!!
                if (history.status.equals("1")){
                    historyDetails.addAll(history.data!!)
                    historyAdapter = HistoryAdapter(this@MyHistory, historyDetails)
                    rvHistory.adapter = historyAdapter
                    progressHistory.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<History>, t: Throwable) {

            }
        })
    }

}