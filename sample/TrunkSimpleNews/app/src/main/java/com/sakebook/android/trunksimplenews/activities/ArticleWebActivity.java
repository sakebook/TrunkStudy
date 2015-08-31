package com.sakebook.android.trunksimplenews.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;

public class ArticleWebActivity extends AppCompatActivity {

    private static String CONST_ARTICLE = "article";
    private WebView mWebView;

    public static Intent createIntent(Context context, Article article) {
        Intent intent = new Intent(context, ArticleWebActivity.class);
        intent.putExtra(CONST_ARTICLE, article);
        return intent;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_web);

        mWebView = (WebView)findViewById(R.id.web);
//        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
//        mWebView.setInitialScale(1);
//        mWebView.getSettings().setUseWideViewPort(true);
//        mWebView.getSettings().setLoadWithOverviewMode(true);

        if (getIntent() != null) {
            Intent i = getIntent();
            Article article = (Article)i.getSerializableExtra(CONST_ARTICLE);
//            mWebView.loadUrl(article.getUrl());
            mWebView.loadUrl("http://yahoo.co.jp");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
