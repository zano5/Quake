package com.example.android.quakereport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    private WebView webEquake;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle  bundle = getIntent().getExtras();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webEquake = (WebView) findViewById(R.id.webEquake);

        webEquake.loadUrl(bundle.getString(Constants.URL));

        WebSettings webSettings = webEquake.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
