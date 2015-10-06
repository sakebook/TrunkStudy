package com.sakebook.android.trunksimplenews.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

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

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWebView = (WebView)findViewById(R.id.web);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setInitialScale(1);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        if (getIntent() != null) {
            Intent i = getIntent();
            Article article = (Article)i.getSerializableExtra(CONST_ARTICLE);
            mWebView.loadUrl(article.getUrl());
//            mWebView.loadUrl("http://yahoo.co.jp");
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

        switch (id) {
            case R.id.action_share:
                shareArticle();
                return true;
            case R.id.action_open_browser:
                openArticle();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openArticle() {
        Log.d("TAG", "openArticle");
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(mWebView.getUrl()));

        final int REQUEST_CODE = 1000;
        try{
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException exception) {
            Toast.makeText(this, "対応するアプリがありません",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void shareArticle() {
        Log.d("TAG", "shareArticle");
        String shareText = mWebView.getTitle() + " / " +  mWebView.getUrl();
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, shareText);

        final int REQUEST_CODE = 1000;
        try{
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException exception) {
            Toast.makeText(this, "対応するアプリがありません",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final int REQUEST_CODE = 1000;
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "成功",
                        Toast.LENGTH_SHORT).show();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "キャンセル",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.d("TAG", "知らない結果");
        }
    }


}
