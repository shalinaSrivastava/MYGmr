package com.max.ecomaxgo.maxpe.dth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.dth.adapter.BbpsGetOperatorAdapter
import com.max.ecomaxgo.maxpe.dth.model.Bbps
import com.max.ecomaxgo.maxpe.dth.model.Operator
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class DthMainActivity : AppCompatActivity() {

    private lateinit var ivImage: ImageView
    lateinit var bbpsModel: Bbps
    val operaterDetails = ArrayList<Operator>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var bbpsAdapter: BbpsGetOperatorAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var progressDth: ProgressBar
    lateinit var category: String
    private lateinit var tvTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dth_main)

        category = intent.getStringExtra("category").toString()
        initView();

        getOperator()
    }


    private fun initView(){
        ivImage = findViewById(R.id.ivImage)
        recyclerView = findViewById(R.id.recyclerView)
        progressDth = findViewById(R.id.progressDth)
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.text = category


        gridLayoutManager = GridLayoutManager(this, 1)
        //val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        ivImage.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

    //get operator function created---------------------------
    private fun getOperator(){
        val call: Call<Bbps> =
            retrofitconfig.endpoints.getDthOperator(Constant.skey, category)
        call.enqueue(object : Callback<Bbps> {
            override fun onResponse(call: Call<Bbps>, response: Response<Bbps>) {
                bbpsModel=response.body()!!
                Log.e("bbps response ", " :: ${response.body()}")
                if (bbpsModel.status.equals("1")){
                    progressDth.visibility = View.GONE
                    bbpsModel.data!!.operator?.let { operaterDetails.addAll(it) }
                    bbpsAdapter = BbpsGetOperatorAdapter(this@DthMainActivity,operaterDetails)
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