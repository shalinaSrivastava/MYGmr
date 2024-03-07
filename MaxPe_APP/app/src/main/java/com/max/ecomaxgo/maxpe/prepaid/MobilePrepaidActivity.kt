package com.max.ecomaxgo.maxpe.prepaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.OperatorValueSetListener
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.prepaid.Datum
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidMode
import com.max.ecomaxgo.maxpe.model.prepaid.Service
import com.max.ecomaxgo.maxpe.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
import java.util.ArrayList

class MobilePrepaidActivity : AppCompatActivity() {

    lateinit var recyclerOperater: RecyclerView
    lateinit var prepaidMode: PrepaidMode
    val operaterDetails = ArrayList<Datum>()
    private lateinit var gridLayoutManager: GridLayoutManager
    lateinit var edit_mobileno: TextInputEditText
    lateinit var edit_amount: TextInputEditText
    lateinit var textRecharge: TextView
    private lateinit var rechargeAdapter: PrepaidRechargeAdapter
    private var operatorValueSetListener : OperatorValueSetListener?= null

    lateinit var imgBackRecharge: ImageView

    fun setOperatorListener(operatorValueSetListener : OperatorValueSetListener){
        this.operatorValueSetListener = operatorValueSetListener
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_prepaid)

        initView()
        getRechargeOperaterName()

    }


    private fun initView(){

        recyclerOperater = findViewById(R.id.recyclerOperater)
        edit_mobileno = findViewById(R.id.edit_mobileno)
        edit_amount = findViewById(R.id.edit_amount)
        textRecharge = findViewById(R.id.tvRechargePay)
        imgBackRecharge = findViewById(R.id.imgBackRecharge)

        gridLayoutManager = GridLayoutManager(this, 2)
        //val layoutManager = LinearLayoutManager(applicationContext)
        recyclerOperater.layoutManager = gridLayoutManager
        recyclerOperater.itemAnimator = DefaultItemAnimator()


        imgBackRecharge.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun getRechargeOperaterName(){
        val call: Call<PrepaidMode> =
            retrofitconfig.endpoints.mobilePrepaid(Constant.skey)
        call.enqueue(object : Callback<PrepaidMode> {
            override fun onFailure(call: Call<PrepaidMode>, t: Throwable) {
                Toast.makeText(
                    this@MobilePrepaidActivity,
                    "Please check your Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
                //loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<PrepaidMode>, response: Response<PrepaidMode>) {
                prepaidMode = response.body()!!
                operaterDetails.addAll(prepaidMode.data!!)
               if (prepaidMode.status.equals("1")){
                    System.out.println("------------------------------"+prepaidMode.message)
                    rechargeAdapter = PrepaidRechargeAdapter(
                        this@MobilePrepaidActivity,
                        operaterDetails, object: PrepaidRechargeAdapter.OperatorItemClickListener{
                            override fun getOperatorPosition(pos: Int) {
                                val intentPrepaid = Intent(this@MobilePrepaidActivity, MobilePrepaidTwo::class.java)
                                intentPrepaid.putExtra("operator_logo", operaterDetails[pos].operatorLogo)
                                intentPrepaid.putExtra("operator_name", operaterDetails[pos].operatorName)
                                intentPrepaid.putExtra("service_name", operaterDetails[pos].serviceType)
                                val args = Bundle()
                                args.putSerializable("listData", operaterDetails[pos].service as Serializable)
                                intentPrepaid.putExtra("serviceList", args)
                                startActivity(intentPrepaid)
                            }

                        }
                    )
                    recyclerOperater.adapter = rechargeAdapter

                }
            }
        })
    }

}

//if (prepaidMode!!.status.equals("1")){
//    System.out.println("------------------------------"+prepaidMode.message)
//    operaterDetails.addAll(prepaidMode.data!!)
//    System.out.println("--------------------"+operaterDetails.toString())
//    rechargeAdapter = PrepaidRechargeAdapter(
//        this@MobilePrepaidActivity,
//        operaterDetails, object: PrepaidRechargeAdapter.OperatorItemClickListener{
//            override fun getOperatorPosition(pos: Int) {
//                val intentPrepaid = Intent(this@MobilePrepaidActivity, MobilePrepaidTwo::class.java)
//                intentPrepaid.putExtra("operator_logo", operaterDetails[pos].operatorLogo)
//                intentPrepaid.putExtra("operator_name", operaterDetails[pos].operatorName)
//                intentPrepaid.putExtra("service_name", operaterDetails[pos].serviceType)
//                intentPrepaid.putExtra("operator_id", "5")
//                startActivity(intentPrepaid)
//
//                //Toast.makeText(this@MobilePrepaidActivity, "hi${operaterDetails[pos].operatorLogo}", Toast.LENGTH_LONG).show()
//            }
//
//        }
//    )
//    recyclerOperater.adapter = rechargeAdapter
//

