package com.max.ecomaxgo.maxpe

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.auth.api.phone.SmsRetriever.SMS_RETRIEVED_ACTION
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import com.max.ecomaxgo.maxpe.view.PrivacyPolicyPage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var fabSubmit: Button
    lateinit var data: Login
    lateinit var editNumber: EditText
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var tvPolicy: TextView
    private lateinit var tvTerm: TextView
    lateinit var deviceId: String
    lateinit var device: String
    lateinit var versionAPI: String
    var myIMEI: String? = null
    private val REQUEST_CODE = 101


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
        maxPreference = MaxSharedPreference(this@LoginActivity)

        IMEI()
        device = Build.MODEL

        System.out.println("-------------"+device)

        versionAPI = Build.VERSION.SDK_INT.toString()
        System.out.println("-------------"+versionAPI)
        val versionRelease = Build.VERSION.RELEASE
        System.out.println("-------------"+versionRelease)


    }

    private fun IMEI() {
        //var myIMEI: String? = null

        try {
            val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            val IMEI = tm.getImei().toString()
            if (IMEI != null) {
                myIMEI = IMEI
                //show_IMEI.setText(myIMEI)
                //show_IMEI.setOnClickListener {

                //Toast.makeText(this, myIMEI, Toast.LENGTH_SHORT).show()

            }



        } catch (ex: Exception) {
            //Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show()

        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.READ_PHONE_STATE
                )
            ) {

            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_PHONE_STATE),
                    2
                )

            }
        }



    }

    private fun initView(){
        fabSubmit = findViewById(R.id.fabSubmit)
        editNumber = findViewById(R.id.edtmobileno);
        fabSubmit.setOnClickListener(this)
        tvPolicy = findViewById(R.id.tvPrivacy)
        tvTerm = findViewById(R.id.tvTerms)

        editNumber.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_GO) {

                // Do something of your interest.
                // We in this examples created the following Toasts
                if (editNumber.text.toString().equals("") || editNumber.text.toString().length<10) {
                    Toast.makeText(this,"Please enter mobile number",Toast.LENGTH_SHORT).show()
                    editNumber.requestFocus()
                }else {
                    loginUser(Constant.skey, editNumber.text.toString())
                }
                return@OnEditorActionListener true
            }
            false
        })



        tvTerm.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, WebViewactivity::class.java)
            intent.putExtra("url","https://maxpe.in/term.html")
            intent.putExtra("title","Terms & Condition")
            startActivity(intent)
        })
        tvPolicy.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginActivity, PrivacyPolicyPage::class.java))
        })
    }
    //login function call
    private fun loginUser(sKey: String, mobNumber: String) {
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Sending OTP....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")


        val call:Call<Login> = retrofitconfig.endpoints.login(sKey, mobNumber,myIMEI.toString(), "android", versionAPI, device)
        call.enqueue(object : Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {
                Toast.makeText(this@LoginActivity,"Please check your Internet Connection",Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
            }
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                data=response.body()!!
                Log.e("login response ", " :: ${response.body()}")
                if (data.status.equals("1"))
                {
                    maxPreference.OtpNo = data.data?.otprno
                    val intentOtp = Intent(this@LoginActivity, OtpActivity::class.java)
                    intentOtp.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intentOtp.putExtra("mob_no", data.data?.number)
                    intentOtp.putExtra("otpr_no", data.data?.otprno)
                    startActivity(intentOtp)
                    loadingDialog.dismiss()
                    System.out.println("----------------------"+data.data?.number)
                    println("-------------------------+++++------------")
                    finish()
                }
            }
        })
    }
    override fun onClick(v: View?) {
        if (v==fabSubmit){
            if (editNumber.text.toString().equals("") || editNumber.text.toString().length<10) {
                Toast.makeText(this,"Please enter mobile number",Toast.LENGTH_SHORT).show()
                editNumber.requestFocus()
            }else {
                loginUser(Constant.skey, editNumber.text.toString())
            }
        }
    }
}