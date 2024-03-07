package com.max.ecomaxgo.maxpe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.max.ecomaxgo.maxpe.LocalStorage.MaxSharedPreference
import com.max.ecomaxgo.maxpe.R
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import com.max.ecomaxgo.maxpe.share.ShareIdea
import com.max.ecomaxgo.maxpe.share.ShareThanksDialog
import com.max.ecomaxgo.maxpe.util.Constant
import com.max.ecomaxgo.maxpe.view.DialogFragment.LoadingDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShareIdeaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var share: EditText
    private lateinit var linear: LinearLayout
    private lateinit var btnShareIdeaSubmit: Button
    private lateinit var maxPreference: MaxSharedPreference
    private lateinit var imgBackShareIdea: ImageView

    private lateinit var data: ShareIdea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_idea)

        imgBackShareIdea = findViewById(R.id.imgBackShareIdea)
        btnShareIdeaSubmit = findViewById(R.id.btnShareIdeaSubmit)
        maxPreference =
            MaxSharedPreference(this@ShareIdeaActivity)
        share=findViewById(R.id.sharemessage)
        linear=findViewById(R.id.linear)

        imgBackShareIdea.setOnClickListener { finish() }
        btnShareIdeaSubmit.setOnClickListener(this)
    }



    private fun shareMessage() {
        val loadingDialog = LoadingDialog()
        val bundlePassText = Bundle()
        loadingDialog.isCancelable = false
        bundlePassText.putString("showText", "Loading....")
        loadingDialog.arguments = bundlePassText
        loadingDialog.show(supportFragmentManager, "Loading Dialog")

        val call: Call<ShareIdea> = retrofitconfig.endpoints.shareanides(maxPreference.UserMobileNum!!, maxPreference.UserToken!!, share.text.toString(), Constant.skey)
        call.enqueue(object : Callback<ShareIdea> {
            override fun onFailure(call: Call<ShareIdea>, t: Throwable) {
                Toast.makeText(this@ShareIdeaActivity,"Please check your Internet Connection", Toast.LENGTH_SHORT).show()
                loadingDialog.dismiss()
            }
            override fun onResponse(call: Call<ShareIdea>, response: Response<ShareIdea>) {
                data=response.body()!!

                if(data.status.equals("1")){
                    val shareThanksDialog = ShareThanksDialog()
                    shareThanksDialog.show(supportFragmentManager, "Share your Idea")
                }
                loadingDialog.dismiss()
            }

        })
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(share.text.toString())){
            Toast.makeText(this@ShareIdeaActivity,"Please share your idea with him",Toast.LENGTH_SHORT).show()
        }else{
            shareMessage()
        }
    }
}