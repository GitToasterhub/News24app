package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.test.Pojo.Item;

public class ShowNewsItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news_item);
        Intent intent=getIntent();
        String content;
        content=intent.getStringExtra("content");
        content="<html><body>"+content+"</body></html>";

        WebView webView=(WebView) findViewById(R.id.webV);
        webView.loadData(content,"text/html;charset=utf-8","UTF-8");

    }
}
