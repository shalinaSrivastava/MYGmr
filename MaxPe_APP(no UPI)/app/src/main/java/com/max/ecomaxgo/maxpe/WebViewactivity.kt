package com.max.ecomaxgo.maxpe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class WebViewactivity : AppCompatActivity() {

    private lateinit var webViewTerms: WebView
    private lateinit var imgBackTermsCondition: ImageView
    private lateinit var pbLoadingTerms: ProgressBar
    private var url:String ?= null
    private lateinit var tvWebViewTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_viewactivity)

        initViews()

        url = intent.getStringExtra("url")
        tvWebViewTitle.text = intent.getStringExtra("title")
        startWebView(url!!)

        imgBackTermsCondition.setOnClickListener { finish() }
    }

    private fun initViews(){
        imgBackTermsCondition = findViewById(R.id.imgBackTermsCondition)
        webViewTerms = findViewById(R.id.webViewTerms)
        pbLoadingTerms = findViewById(R.id.pbLoadingTerms)
        tvWebViewTitle = findViewById(R.id.tvWebViewTitle)
    }

    private fun startWebView(url: String) {

        val settings = webViewTerms.settings
        webViewTerms.settings.defaultTextEncodingName = "utf-8"

        settings.javaScriptEnabled = true

        webViewTerms.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                pbLoadingTerms.visibility = View.GONE
            }

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                Toast.makeText(this@WebViewactivity, "Error:$description", Toast.LENGTH_SHORT).show()

            }
        }
        webViewTerms.loadUrl(url)

    }
}