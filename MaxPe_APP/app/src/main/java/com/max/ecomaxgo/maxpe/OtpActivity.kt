package com.max.ecomaxgo.maxpe

import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.dashboad.modle.CardNumber
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiClient
import com.max.ecomaxgo.maxpe.dashboad.utils.ApiInterface
import com.max.ecomaxgo.maxpe.model.login.Login
import com.max.ecomaxgo.maxpe.receiver.MySMSBroadcastReceiver
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern


class OtpActivity : AppCompatActivity() {

    private lateinit var fabNext: Button
    private lateinit var tvTimer: TextView
    private lateinit var tvResendOtp: TextView
    lateinit var data: Login
    private lateinit var maxPreference: MaxSharedPreference
    private var otpTextView: OtpTextView? = null
    lateinit var strMob: String
    lateinit var strOtpr: String
    lateinit var strOtp: String

    private var countDownTimer: CountDownTimer? = null
    private lateinit var tvNumber: TextView

    private val REQ_USER_CONSENT = 200
    var mySMSBroadcastReceiver: MySMSBroadcastReceiver? = null
    lateinit var rfcode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        getRfcode()
        initViews()
        maxPreference = MaxSharedPreference(this@OtpActivity)

        strMob = intent.getStringExtra("mob_no").toString()
        //strOtpr = maxPreference.OtpNo.toString()
        strOtpr = intent.getStringExtra("otpr_no").toString()
//        mob_no = intent.getStringExtra("mob_no")
//        otpr_no = intent.getStringExtra("otpr_no")

        System.out.println("strUser----------------------"+strMob)
        System.out.println("strOtpr----------------------"+strOtpr)
        //tvNumber.text = "Send to number "+"+91 "+ strMob
        tvNumber.text = "+91 "+ strMob


        //Terms & Condition clickable code here....
        //setTimer()
        timerDialog()
        startUserConsent()

    }
    private fun initViews() {
        fabNext = findViewById(R.id.fabNext)
        otpTextView = findViewById(R.id.otp_view)
        tvTimer = findViewById(R.id.tvTimer)
        tvResendOtp = findViewById(R.id.tvResendOtp)
        tvNumber = findViewById(R.id.tvNumber)


        otpTextView?.requestFocusOTP()

        otpTextView?.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                strOtp = otp
                //Toast.makeText(this@OtpActivity, "The OTP is $strOtp", Toast.LENGTH_SHORT).show()
            }


        }

        fabNext.setOnClickListener(View.OnClickListener {
            if (!TextUtils.isEmpty(strOtp)) {
                if (strOtp.length < 6) {
                    Toast.makeText(this@OtpActivity, "Please enter valid otp", Toast.LENGTH_SHORT).show()
                } else {
                    veriFiedOTP(Constant.skey, strMob, strOtpr, strOtp)
                }
            }
            //Toast.makeText(this@OtpActivity, "The OTP is $strOtp", Toast.LENGTH_SHORT).show()
        })

        tvResendOtp.setOnClickListener(View.OnClickListener {
            tvResendOtp.visibility = View.GONE
            tvTimer.visibility = View.VISIBLE
            resendOTP(Constant.skey, strMob, strOtpr)
            timerDialog()
        })
    }
    //finction create ---------------------------otp read-----------------------
    private fun startUserConsent(){
        val client = SmsRetriever.getClient(this)
        client.startSmsUserConsent(null)
        // Toast.makeText(this@OtpActivity, "The OTP is 1", Toast.LENGTH_SHORT).show()

    }
    /*if (requestCode == REQ_USER_CONSENT) {
            if ((resultCode == RESULT_OK) && (data != null)) {

                String message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);


                getOtpFromMessage(message);
            }
        }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_USER_CONSENT){
            if (resultCode == RESULT_OK && data != null){
                val message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
                getOtpFromMessage(message)
            }
        }
    }

    //set otp funcrion create in edittext
    private fun getOtpFromMessage(message: String?) {
        val otpPatter = Pattern.compile("(|^)\\d{6}")
        val matcher = otpPatter.matcher(message)
        if (matcher.find()){

            otpTextView!!.setOTP(matcher.group(0))
            veriFiedOTP(Constant.skey, strMob, strOtpr, strOtp)


        }
    }

    //fun create in
    private fun registerBroadCastReceiver(){
        mySMSBroadcastReceiver = MySMSBroadcastReceiver()
        mySMSBroadcastReceiver!!.smsBroadCastSmsReceiverListener = object : MySMSBroadcastReceiver.SmsBroadCastSmsReceiverListener{
            override fun onSuccess(intent: Intent?) {
                // Toast.makeText(this@OtpActivity, "The OTP is 9", Toast.LENGTH_SHORT).show()

                startActivityForResult(intent, REQ_USER_CONSENT)
            }

            override fun onFailure() {
            }
        }
        val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        registerReceiver(mySMSBroadcastReceiver, intentFilter)
    }
    //register broadcastreceiver on start
    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }

    //unregister broadcastreceiver on stop
    override fun onStop() {
        super.onStop()
        unregisterReceiver(mySMSBroadcastReceiver)
    }

    //-----------------------------------end autoreadotp function-----------------------------
    override fun onResume() {
        super.onResume()
//        strOtpr = maxPreference.UserOtprno!!
//        System.out.println("strOtprno2222------------------------"+strOtpr)
    }

    override fun onRestart() {
        super.onRestart()
        //strOtpr = maxPreference.UserOtprno!!
        //System.out.println("strOtprno2222------------------------"+strOtpr)
    }

    private fun veriFiedOTP(sKey: String, mobNumber: String, otprno: String, otp: String){

        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Verifying OTP....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")
        // Toast.makeText(this@OtpActivity, "The OTP is 2", Toast.LENGTH_SHORT).show()
        val call: Call<Login> =
            retrofitconfig.endpoints.otpVerify(sKey, mobNumber, otprno, otp)
        call.enqueue(object : Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {
                Toast.makeText(
                    this@OtpActivity,
                    "Please check your Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
                loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                data=response.body()!!
                Log.e("login response ", " :: ${response.body()}")
                if (data.status.equals("1"))
                {
                    maxPreference.UserToken = data.data?.token
                    maxPreference.userAmount = data.data?.wallet?.amount
                    maxPreference.UserMobileNum = data.data?.number
                    maxPreference.UserProfileImg = data.data?.image
                    maxPreference.UserIsNew = data.data?.isNew
                    maxPreference.UserFName = data.data?.name?.first
                    maxPreference.UserLName = data.data?.name?.last
                    //   Toast.makeText(this@OtpActivity, "The OTP is 4", Toast.LENGTH_SHORT).show()

                    //val intentOtp = Intent(this@OtpActivity, HomeActivity::class.java)
                    //getLiveWalletCard(loadingDialog)
                    val intentOtp = Intent(this@OtpActivity, DashboadActivity::class.java)

                    startActivity(intentOtp)
                    loadingDialog.dismiss()
                    println("-------------------------------------")
                    finish()
                }else if (data.status.equals("0")){
                    ///   Toast.makeText(this@OtpActivity, "The OTP is 3", Toast.LENGTH_SHORT).show()

                    Toast.makeText(this@OtpActivity, data.message, Toast.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    private fun resendOTP(sKey: String, mobNumber: String, otprno: String) {
        tvTimer.visibility = View.VISIBLE
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Sending OTP....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")


        val call:Call<Login> =
            retrofitconfig.endpoints.reSendOTP(sKey, mobNumber, otprno)
        call.enqueue(object : Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {
                Toast.makeText(
                    this@OtpActivity,
                    "Please check your Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
                loadingDialog.dismiss()
            }

            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                data=response.body()!!
                Log.e("login response ", " :: ${response.body()}")
                if (data.status.equals("1"))
                {
                    maxPreference.UserOtprno = data.data?.otprno
                    loadingDialog.dismiss()
                    Toast.makeText(this@OtpActivity, data.message, Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun getRfcode() {
        val mReferrerClient: InstallReferrerClient

        mReferrerClient = InstallReferrerClient.newBuilder(this).build()

        mReferrerClient.startConnection(object : InstallReferrerStateListener {
            override fun onInstallReferrerSetupFinished(responseCode: Int) {
                when (responseCode) {
                    InstallReferrerClient.InstallReferrerResponse.OK -> {
                        // Connection established
                        try {
                            val response = mReferrerClient.installReferrer
                            if (!response.installReferrer.contains("utm_source"))

                                rfcode= response.installReferrer.toString()
                            else
                                rfcode=""
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                        mReferrerClient.endConnection()
                    }
                    InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED -> {
                    }
                    InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE -> {
                    }
                }
            }

            override fun onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })
    }
    private fun setTimer(){

        var seconds = 30
        var minutes = 1

        //Declare the timer
        val timerOtp = Timer()
        timerOtp.scheduleAtFixedRate(object : TimerTask() {

            override fun run() {
                runOnUiThread {
                    tvTimer.text = "Resend $minutes:$seconds"
                    seconds -= 1
                    if(minutes == 0 && seconds == 0){
                        tvResendOtp.visibility = View.VISIBLE
                        tvTimer.visibility = View.GONE
                        seconds = 30
                        minutes = 1
                    }

                    if(seconds == 0 && minutes != 0) {
                        tvTimer.text = "Resend $minutes:$seconds"

                        seconds=60
                        minutes -= 1

                    }
                }
            }
        }, 0, 1000)
    }

    fun timerDialog() {
        if (countDownTimer == null) {
            startTimer(60000)

            //setProgressBarValues();
        } else {
            //Else stop timer and change text
            stopCountdown()
        }
    }
    private fun stopCountdown() {
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
            countDownTimer = null
            tvResendOtp.visibility = View.VISIBLE
        }
    }
    private fun hmsTimeFormatter(milliSeconds: Long): String? {
        return java.lang.String.format(
            "%d:%d",
            TimeUnit.MILLISECONDS.toMinutes(milliSeconds),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds))
        )
    }
    private fun startTimer(noOfMinutes: Int) {
        countDownTimer = object : CountDownTimer(noOfMinutes.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTimer.setText(hmsTimeFormatter(millisUntilFinished))
                tvResendOtp.visibility = View.GONE
                //tvReSendOTP.setVisibility(View.GONE)
            }

            override fun onFinish() {
                countDownTimer = null
                tvResendOtp.visibility = View.VISIBLE
                tvTimer.visibility = View.GONE
            }
        }.start()
    }
    private fun getLiveWalletCard(loadingDialog: LoadingDialog) {
        val maxSharedPreference = MaxSharedPreference(this@OtpActivity)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call: Call<*> = apiService.getWalletCard(
            Constant.skey,
            maxSharedPreference.UserMobileNum,
            maxSharedPreference.UserToken
        )
        call.enqueue(object : Callback<CardNumber?> {
            override fun onResponse(call: Call<CardNumber?>, response: Response<CardNumber?>) {
                if (response.isSuccessful) {
                    val dataCard = response.body()
                    val cardNo = dataCard!!.data.card[0].number
                    val card = cardNo.substring(0, 4)
                    val card2 = cardNo.substring(4, 8)
                    val card3 = cardNo.substring(8, 12)
                    val card4 = cardNo.substring(12, 16)
                    maxSharedPreference.WALLETCARD=card+"  "+card2+"  "+card3+"  "+card4

                    val intentOtp = Intent(this@OtpActivity, DashboadActivity::class.java)

                    startActivity(intentOtp)
                    loadingDialog.dismiss()
                    println("-------------------------------------")
                    finish()

                }
            }

            override fun onFailure(call: Call<CardNumber?>, t: Throwable) {
                Toast.makeText(this@OtpActivity, "", Toast.LENGTH_SHORT)
                loadingDialog.dismiss()
            }
        } as Nothing)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@OtpActivity, LoginActivity::class.java)
        startActivity(intent)

    }

}