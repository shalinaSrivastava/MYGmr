package com.max.ecomaxgo.maxpe.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import com.max.ecomaxgo.maxpe.R

class Contact : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val CALL_PERMISSION_REQUEST = 9098
    }

    private lateinit var btnLiveChat: RelativeLayout
    private lateinit var llSupportCall: RelativeLayout
    private lateinit var llSupportEmail: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        btnLiveChat=findViewById(R.id.btnLiveChat)
        llSupportCall = findViewById(R.id.llSupportCall)
        llSupportEmail = findViewById(R.id.llSupportEmail)

        btnLiveChat.setOnClickListener(this)
        llSupportEmail.setOnClickListener(this)
        llSupportCall.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v){
            btnLiveChat -> {
                //startActivity(Intent(this, Chat::class.java))
            }

            llSupportCall ->{
                Log.e("check permission"," :: Permission Granted !!")
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:01141411207")
                startActivity(intent)
            }

            llSupportEmail -> {
                val intent = Intent(Intent.ACTION_SEND)
                val recipients = arrayOf("support@ecomaxgo.in")
                intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                intent.putExtra(Intent.EXTRA_SUBJECT, "")
                intent.putExtra(Intent.EXTRA_TEXT, "")
                intent.putExtra(Intent.EXTRA_CC, "android@ecomaxgo.in")
                intent.type = "text/html"
                intent.setPackage("com.google.android.gm")
                startActivity(Intent.createChooser(intent, "Send mail"))
            }
        }
    }
}