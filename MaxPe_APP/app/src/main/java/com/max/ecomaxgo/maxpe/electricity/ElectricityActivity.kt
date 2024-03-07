package com.max.ecomaxgo.maxpe.electricity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.dth.BroadBandProviderActivity
import com.max.ecomaxgo.maxpe.dth.adapter.BbpsGetOperatorAdapter
import com.max.ecomaxgo.maxpe.dth.model.Bbps
import com.max.ecomaxgo.maxpe.dth.model.Operator
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class ElectricityActivity : AppCompatActivity() {

    private lateinit var imgBackRecharge: ImageView
    lateinit var bbpsModel: Bbps
    val operaterDetails = ArrayList<Operator>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var bbpsAdapter: BbpsGetOperatorAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var progressDth: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electricity)

        initView();

        getOperator()
    }


    private fun initView(){
        imgBackRecharge = findViewById(R.id.imgBackRecharge)
        recyclerView = findViewById(R.id.recyclerView)
        progressDth = findViewById(R.id.progressDth)


        gridLayoutManager = GridLayoutManager(this, 2)
        //val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        imgBackRecharge.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

    //get operator function created---------------------------
    private fun getOperator(){
        val call: Call<Bbps> =
            retrofitconfig.endpoints.getDthOperator(Constant.skey, "ELC")
        call.enqueue(object : Callback<Bbps> {
            override fun onResponse(call: Call<Bbps>, response: Response<Bbps>) {
                bbpsModel=response.body()!!
                Log.e("bbps response ", " :: ${response.body()}")
                if (bbpsModel.status.equals("1")){
                    progressDth.visibility = View.GONE
                    bbpsModel.data!!.operator?.let { operaterDetails.addAll(it) }
                    bbpsAdapter = BbpsGetOperatorAdapter(this@ElectricityActivity, operaterDetails)
                    recyclerView.adapter = bbpsAdapter

                }
            }

            override fun onFailure(call: Call<Bbps>, t: Throwable) {
                if (bbpsModel.status.equals("0")){
                    progressDth.visibility = View.GONE
                }
            }
        })
    }
}