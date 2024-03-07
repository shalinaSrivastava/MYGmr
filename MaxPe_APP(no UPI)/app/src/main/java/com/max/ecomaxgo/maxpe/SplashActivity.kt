package com.max.ecomaxgo.maxpe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.model.Basic.WalletHolding
import com.max.ecomaxgo.maxpe.model.PutIdKyc
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    lateinit var data: PutIdKyc
    private lateinit var maxPreference: MaxSharedPreference
    lateinit var userToken: String


    override fun onCreate(savedInstanceState: Bundle?) {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash)

        //pbSplashLoading = findViewById(R.id.pbSplashLoading)
        maxPreference = MaxSharedPreference(this@SplashActivity)

        //Log.e("token", " :: ${maxPreference.UserToken}")
        //System.out.println("-------------------------------"+maxPreference.UserToken)
        userToken = maxPreference.UserToken.toString()
        System.out.println("-------------------------------"+userToken)
        if(userToken.equals("")){
            handleScreenForTime()
        }else{

            Handler().postDelayed({
                // val intentLogin = Intent(this@SplashActivity, MainActivity::class.java)
               // val intentLogin = Intent(this@SplashActivity, HomeActivity::class.java)

                val intentLogin = Intent(this@SplashActivity, DashboadActivity::class.java)
                intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                //intentLogin.putExtra("fromPage",Splash")
                //intentLogin.putExtra("offerUrl","")
                startActivity(intentLogin)
                finish()
            }, 1500)
        }
    }

    private lateinit var walletresponse: WalletHolding
    private fun getwalletbalanceUpdate() {
        val call: Call<WalletHolding> = retrofitconfig.endpoints.wallet(maxPreference.userId!!,maxPreference.UserToken!!)
        call.enqueue(object : Callback<WalletHolding> {
            override fun onFailure(call: Call<WalletHolding>, t: Throwable) {
                Toast.makeText(this@SplashActivity,"Please check your Internet Connection", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<WalletHolding>, response: Response<WalletHolding>) {
                walletresponse = response.body()!!
                if(walletresponse.status.equals("1")){
                    maxPreference.UserAmountLimit = walletresponse.wallet!!.limit
                    maxPreference.UserNetAmount = walletresponse.wallet!!.funds!!.available!!.amount
                    maxPreference.UserKycValue = walletresponse.kyc
                    maxPreference.WalletFundTranserLimit = walletresponse.walletFundTransferLimit!!.remain
                }else{
                    if(walletresponse.message.equals("Invalid Access!", true)){
                        val IntentLogin = Intent(this@SplashActivity, LoginActivity::class.java)
                        IntentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        maxPreference.clear()
                        Toast.makeText(this@SplashActivity,"Your account is open in another device. Please try login again", Toast.LENGTH_SHORT).show()
                        startActivity(IntentLogin)
                        finish()
                    }else{
// Toast.makeText(context,walletresponse.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    /*private fun web_update(): Boolean {
        try {
            val package_name = "com.maxpay.rst.maxappinkotlin"
            val curVersion = applicationContext.packageManager.getPackageInfo(package_name, 0).versionName
            var newVersion = curVersion
            newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=$package_name&hl=en")
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select("div[itemprop=softwareVersion]")
                    .first()
                    .ownText()
            return value(curVersion) < value(newVersion)
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }*/

    private fun value(string: String): Long {
        var string = string
        string = string.trim { it <= ' ' }
        if (string.contains(".")) {
            val index = string.lastIndexOf(".")
            return value(string.substring(0, index)) * 100 + value(string.substring(index + 1))
        } else {
            return java.lang.Long.valueOf(string)
        }
    }
    private fun handleScreenForTime(){
        Handler().postDelayed({
            val intentLogin = Intent(this@SplashActivity, LoginActivity::class.java)
            intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentLogin)
            finish()
        }, 1500)
    }
}