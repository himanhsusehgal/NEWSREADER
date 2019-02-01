package com.example.newsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        WebView webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        Intent intent = getIntent();
        String url = intent.getStringExtra("content");
        Log.i("ARTICLE ACTIVITY", url);

        try {
            JSONObject jsonObject = new JSONObject(url);
            String newsurl = jsonObject.getString("url");

            webView.loadUrl(newsurl);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
