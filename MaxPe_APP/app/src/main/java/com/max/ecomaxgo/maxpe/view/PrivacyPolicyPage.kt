package com.max.ecomaxgo.maxpe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.max.ecomaxgo.maxpe.R

class PrivacyPolicyPage : AppCompatActivity() {

    private lateinit var imgBackPrivacyPolicy: ImageView
    private lateinit var webViewPrivacy: WebView
    private lateinit var pbLoadingPrivacy: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy_page)

        imgBackPrivacyPolicy = findViewById(R.id.imgBackPrivacyPolicy)
        webViewPrivacy = findViewById(R.id.webViewPrivacy)
        pbLoadingPrivacy = findViewById(R.id.pbLoadingPrivacy)

        imgBackPrivacyPolicy.setOnClickListener { finish() }
        startWebView("https://maxpe.in/privacy.html")
    }

    private fun startWebView(url: String) {

        val settings = webViewPrivacy.settings
        webViewPrivacy.settings.defaultTextEncodingName = "utf-8"
        settings.javaScriptEnabled = true

        webViewPrivacy.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                pbLoadingPrivacy.visibility = View.GONE
            }

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                Toast.makeText(this@PrivacyPolicyPage, "Error:$description", Toast.LENGTH_SHORT).show()

            }
        }
        webViewPrivacy.loadUrl(url)
    }
}