package com.max.ecomaxgo.maxpe.addmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.max.ecomaxgo.maxpe.R

class AddMoneyActivity : AppCompatActivity() {

    private lateinit var cardContact: CardView
    private lateinit var ivImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money2)
        initView()
    }


    private fun initView(){
        cardContact = findViewById(R.id.cardContact)
        ivImage = findViewById(R.id.ivImage)

        ivImage.setOnClickListener(View.OnClickListener {
            finish()
        })
        cardContact.setOnClickListener(View.OnClickListener {
            val intentSendMoney = Intent(this@AddMoneyActivity, SendMoneyPage::class.java)
            startActivity(intentSendMoney)
        })
    }
}