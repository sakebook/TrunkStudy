package com.sakebook.android.trunksimplenews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;
import com.sakebook.android.trunksimplenews.network.ApiClient;
import com.sakebook.android.trunksimplenews.utils.L;
import com.sakebook.android.trunksimplenews.views.adapters.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }


    private void init() {
        mListView = (ListView)findViewById(R.id.list_article);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = (Article) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, article.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
