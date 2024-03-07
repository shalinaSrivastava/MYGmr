package com.max.ecomaxgo.maxpe.prepaid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.adapter.HistoryAdapter
import com.max.ecomaxgo.maxpe.adapter.PrepaidRechargeAdapter
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.dth.adapter.CustomDropDownAdapter
import com.max.ecomaxgo.maxpe.dth.adapter.TopupAdapter
import com.max.ecomaxgo.maxpe.model.prepaid.PrepaidDetailsData
import com.max.ecomaxgo.maxpe.model.prepaid.Service
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePrepaidTwo : AppCompatActivity(), View.OnClickListener {

    lateinit var strOperatorLogo: String
    lateinit var strOperatorName: String
    lateinit var strServiceName: String
    lateinit var ivPrepaidLogo: ImageView
    lateinit var tvOperatorName: TextView
    lateinit var tvServiceName: TextView
    lateinit var btnSubmit: Button
    lateinit var edit_mobileno: TextInputEditText
    lateinit var edit_amount: TextInputEditText
    private lateinit var idtypeService: ArrayList<Service>
    private lateinit var spinner: Spinner
    lateinit var serviceId: Service
    lateinit var operaterId: String
    lateinit var progress: ProgressBar
    lateinit var mob_number: String
    private lateinit var imgBackRecharge: ImageView
    lateinit var prepaidMode: PrepaidDetailsData
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var rgTopup: RadioGroup
    private lateinit var tvServiceType: TextView
    private lateinit var rbTopup: RadioButton
    private lateinit var rbSpecial: RadioButton
    private lateinit var frameLayout: FrameLayout

    private lateinit var recyclerTop: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var historyAdapter: TopupAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_prepaid_two)

        maxPreference = MaxSharedPreference(this@MobilePrepaidTwo)
        val tokenVal = maxPreference.UserToken
        System.out.println("----------------------------" + tokenVal)
        mob_number = maxPreference.UserMobileNum.toString()
        strOperatorLogo = intent.getStringExtra("operator_logo").toString()
        strOperatorName = intent.getStringExtra("operator_name").toString()
        strServiceName = intent.getStringExtra("service_name").toString()

        initView()

        val args = intent.getBundleExtra("serviceList")
        idtypeService = args?.getSerializable("listData") as ArrayList<Service>
        System.out.println("----------------------"+idtypeService.size)

        for (service in idtypeService) {

            if (service.operation.equals("Topup")){
                recyclerTop.visibility = View.GONE
                //frameLayout.visibility = View.GONE
                tvServiceType.visibility = View.GONE
                operaterId = service.operatorId.toString()
                System.out.println("++++++++++++++++++"+operaterId)
            }else if (service.operation.equals("Special")){
                recyclerTop.visibility = View.VISIBLE
                //frameLayout.visibility = View.VISIBLE
                tvServiceType.visibility = View.VISIBLE

            }

        }

        Log.e("kyc listsize ", " :: ${idtypeService.size}")

        gridLayoutManager = GridLayoutManager(this, 2)
        recyclerTop.layoutManager = gridLayoutManager
        recyclerTop.itemAnimator = DefaultItemAnimator()

        historyAdapter = TopupAdapter(this@MobilePrepaidTwo, idtypeService, object: TopupAdapter.OperatorItemClickListener{
            override fun getOperatorPosition(pos: Int) {
                operaterId = idtypeService[pos].operatorId!!
                System.out.println("operaterId------------------------"+operaterId)
                //Toast.makeText(this@MobilePrepaidTwo, idtypeService[pos].operatorId, Toast.LENGTH_LONG).show()
            }

        }
        )
        recyclerTop.adapter = historyAdapter

//        val customDropDownAdapter = CustomDropDownAdapter(this, idtypeService)
//        spinner.adapter = customDropDownAdapter

//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>,
//                view: View,
//                position: Int,
//                id: Long
//            ) {
//                val selectedItem = parent.getItemAtPosition(position).toString()
//                serviceId = (parent.getItemAtPosition(position) as Service?)!!
//                System.out.println("id---------------------"+serviceId.operatorId)
//                operaterId = serviceId.operatorId.toString()
//                if (selectedItem == "Add new category") {
//                    // do your stuff
//                }
//            } // to close the onItemSelected
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//
//            }
//        }
    }


    private fun initView(){
        ivPrepaidLogo = findViewById(R.id.ivPrepaidLogo)
        tvOperatorName = findViewById(R.id.tvOperatorName)
        tvServiceName = findViewById(R.id.tvServiceName)
        btnSubmit = findViewById(R.id.btnSubmit)
        edit_mobileno = findViewById(R.id.edit_mobileno)
        edit_amount = findViewById(R.id.edit_amount)
        spinner = findViewById(R.id.spinner)
        progress = findViewById(R.id.progress)
        imgBackRecharge = findViewById(R.id.imgBackRecharge)
        rgTopup = findViewById(R.id.rgTopup)
        tvServiceType = findViewById(R.id.tvServiceType)
        rbTopup = findViewById(R.id.rbTopup)
        rbSpecial = findViewById(R.id.rbSpecial)
        frameLayout = findViewById(R.id.frameLayout)
        recyclerTop = findViewById(R.id.recyclerTop)

        btnSubmit.setOnClickListener(this)

        Glide.with(this)
            .load(strOperatorLogo)
            .centerCrop()
            .placeholder(R.drawable.max_logo)
            .into(ivPrepaidLogo)
        tvOperatorName.text = strOperatorName
        tvServiceName.text = strServiceName

        imgBackRecharge.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

    private fun submitPrepaidDetails(mob_no: String, amount: String){
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Progress....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")

        val call: Call<PrepaidDetailsData> =
            retrofitconfig.endpoints.prepaidDetails(Constant.skey, mob_number, maxPreference.UserToken!!, amount, mob_no, operaterId, "wallet")
        call.enqueue(object : Callback<PrepaidDetailsData> {
            override fun onFailure(call: Call<PrepaidDetailsData>, t: Throwable) {
                Toast.makeText(
                    this@MobilePrepaidTwo,
                    "Please check your Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
                loadingDialog.dismiss()
                //loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<PrepaidDetailsData>, response: Response<PrepaidDetailsData>) {
                prepaidMode = response.body()!!
                if (prepaidMode.status.equals("1")){
                    loadingDialog.dismiss()
                    System.out.println("-----+++++--------"+prepaidMode.message)
                    val intentDetails = Intent(this@MobilePrepaidTwo, PrepaidRechargeDetailsActivity::class.java)
                    intentDetails.putExtra("mob_no", prepaidMode.data?.recharge_number)
                    intentDetails.putExtra("amount", prepaidMode.data?.amount)
                    intentDetails.putExtra("message", prepaidMode.data?.recharge)
                    intentDetails.putExtra("operater_logo", prepaidMode.data?.operatorDetail?.operatorLogo)
                    intentDetails.putExtra("operater_name", prepaidMode.data?.operatorDetail?.operatorName)
                    intentDetails.putExtra("service_name", prepaidMode.data?.operatorDetail?.serviceType)
                    //maxPreference.AddMoneyAmountToWallet = prepaidMode.data.amount.
                    startActivity(intentDetails)
                    finish()

                }else if (prepaidMode.status.equals("0")){
                    loadingDialog.dismiss()
                    val intentDetails = Intent(this@MobilePrepaidTwo, PrepaidRechargeDetailsActivity::class.java)
                    intentDetails.putExtra("mob_no", prepaidMode.data?.recharge_number)
                    intentDetails.putExtra("amount", prepaidMode.data?.amount)
                    intentDetails.putExtra("message", prepaidMode.data?.recharge)
                    intentDetails.putExtra("operater_logo", prepaidMode.data?.operatorDetail?.operatorLogo)
                    intentDetails.putExtra("operater_name", prepaidMode.data?.operatorDetail?.operatorName)
                    intentDetails.putExtra("service_name", prepaidMode.data?.operatorDetail?.serviceType)
                    //maxPreference.AddMoneyAmountToWallet = prepaidMode.data.amount.
                    startActivity(intentDetails)
                    finish()
                    Toast.makeText(this@MobilePrepaidTwo, prepaidMode.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onClick(v: View?) {
        if (v == btnSubmit) {
            if (edit_mobileno.text.toString().equals("")) {
                Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT)
                    .show()
                edit_mobileno.requestFocus()
            } else if (edit_amount.text.toString().equals("")){
                Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT)
                    .show()
                edit_mobileno.requestFocus()
            }else if ((edit_amount.text.toString().toDouble()).toInt() <= 9){
                Toast.makeText(this, "Please enter amount maximum 10", Toast.LENGTH_SHORT)
                    .show()
            }
            else{
                submitPrepaidDetails(edit_mobileno.text.toString(), edit_amount.text.toString())
            }
        }
    }
}