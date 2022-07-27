package com.tcoding.catsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.tcoding.catsapp.R
import com.tcoding.catsapp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var obj = intent.getStringExtra("obj")

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(obj!!)
        }


    }
}