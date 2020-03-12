package com.example.agroiapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;



public class marketpriceagri extends AppCompatActivity {
    private WebView wv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketpriceagri);
        wv2=(WebView)findViewById(R.id.agrimarketprice);
        WebSettings webSettings=wv2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv2.loadUrl("https://www.myagriguru.com/farmers-market-price");
    }
    }
