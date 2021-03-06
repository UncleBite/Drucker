package com.example.yueyingwu.drucker_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainPoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_pool);

        WebView poolGuideView = (WebView)findViewById(R.id.PoolGuideView);
        //Log.i("Info","line20");
        poolGuideView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        poolGuideView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        poolGuideView.loadUrl("https://drive.google.com/file/d/15d6uZYblFuQkoXR_3IeEofauZGxEVbeQ/view?usp=sharing");
    }
}
