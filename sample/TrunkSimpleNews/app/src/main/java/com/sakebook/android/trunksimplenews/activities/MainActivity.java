package com.sakebook.android.trunksimplenews.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.TrunkSimpleNewsApplication;
import com.sakebook.android.trunksimplenews.models.Article;
import com.sakebook.android.trunksimplenews.network.ApiClient;
import com.sakebook.android.trunksimplenews.utils.L;
import com.sakebook.android.trunksimplenews.views.adapters.ArticleAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity {

    private ListView mListView;
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.d("MainActivity onCreate");
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView)findViewById(R.id.list_article);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = (Article) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, article.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = ArticleWebActivity.createIntent(MainActivity.this, article);
                startActivity(intent);
            }
        });
        mListView.setDivider(null);

        getArticles();
//        getArticlesFromAssets();
    }


    private void getArticles() {
        ApiClient.getArticles(new Callback<List<Article>>() {
            @Override
            public void success(List<Article> articles, Response response) {
                L.d("success: " + articles.size());

                mAdapter = new ArticleAdapter(MainActivity.this, R.layout.list_article_item, articles, getSupportLoaderManager());
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                L.d("failure: " + error.getLocalizedMessage());
            }
        });
    }

    private void getArticlesFromAssets() {
        try {
            AssetManager assetManager = this.getAssets();
            InputStream inputStream = assetManager.open("sample.json");
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            Type type = new TypeToken<List<Article>>(){}.getType();
            List<Article> articles = gson.fromJson(reader,type);
            mAdapter = new ArticleAdapter(MainActivity.this, R.layout.list_article_item, articles, getSupportLoaderManager());
            mListView.setAdapter(mAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_license) {
            showLicense();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showLicense() {
        TrunkSimpleNewsApplication application =
                (TrunkSimpleNewsApplication)getApplication();
        Tracker t = application.getDefaultTracker();
        t.send(new HitBuilders.EventBuilder()
                .setCategory("UX")
                .setAction("click")
                .setLabel("license")
                .build());
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
