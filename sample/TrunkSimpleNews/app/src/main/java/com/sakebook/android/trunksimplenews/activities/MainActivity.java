package com.sakebook.android.trunksimplenews.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;
import com.sakebook.android.trunksimplenews.views.adapters.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }


    private void init() {
        ListView list = (ListView)findViewById(R.id.list_article);
        //TODO: 記事取得
        List<Article> articles = new ArrayList<>();
        Article a1 = new Article();
        a1.setTitle("一つ目の記事");
        Article a2 = new Article();
        a2.setTitle("2つ目の記事");
        Article a3 = new Article();
        a3.setTitle("3つ目の記事");
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        ArticleAdapter adapter = new ArticleAdapter(this, R.layout.list_article_item, articles);
        list.setAdapter(adapter);
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
