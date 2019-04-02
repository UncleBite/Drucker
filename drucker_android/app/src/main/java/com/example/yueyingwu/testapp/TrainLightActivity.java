package com.example.yueyingwu.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainLightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_light);

        WebView lightGuideView = (WebView)findViewById(R.id.LightGuideView);
        //Log.i("Info","line20");
        lightGuideView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        lightGuideView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        lightGuideView.loadUrl("https://docs.google.com/document/d/16DBSo4yXjmNl9v8OKcULPE0qiuV8y10shNWJ4iUi-ZY/edit#");
    }
}
