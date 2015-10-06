package com.sakebook.android.trunksimplenews.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;

public class ArticleSimpleActivity extends AppCompatActivity {

    private static String CONST_ARTICLE = "article";

    public static Intent createIntent(Context context, Article article) {
        Intent intent = new Intent(context, ArticleSimpleActivity.class);
        intent.putExtra(CONST_ARTICLE, article);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_simple);

        if (getIntent() != null) {
            Intent i = getIntent();
            Article article = (Article)i.getSerializableExtra(CONST_ARTICLE);
            TextView tv = (TextView)findViewById(R.id.text_body_simple);
            Log.d("TAG", article.getDescription());
            tv.setText(article.getDescription().replaceAll("<.+?>", ""));
        }
    }
}
