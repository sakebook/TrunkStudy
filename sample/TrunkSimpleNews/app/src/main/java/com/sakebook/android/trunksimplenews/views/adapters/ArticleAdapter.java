package com.sakebook.android.trunksimplenews.views.adapters;

import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;
import com.sakebook.android.trunksimplenews.utils.L;
import com.sakebook.android.trunksimplenews.utils.MemoryLruCache;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class ArticleAdapter extends ArrayAdapter<Article>{
    private List<Article> mArticles;
    private int mResourceId;
    private AppCompatActivity mAppCompatActivity;
    private LoaderManager mLoaderManager;
    private MemoryLruCache mLruCache = new MemoryLruCache();

    public ArticleAdapter(AppCompatActivity activity, int resource, List<Article> articles, LoaderManager loaderManager) {
        super(activity, resource);
        mArticles = articles;
        mResourceId = resource;
        mAppCompatActivity = activity;
        mLoaderManager = loaderManager;
    }

    @Override
    public int getCount() {
        return mArticles.size();
    }


    @Override
    public Article getItem(int position) {
        return mArticles.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mAppCompatActivity, mResourceId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article article = mArticles.get(position);
        holder.titleText.setText(article.getTitle());
        String url = article.getUser().getImageUrl();
        L.d("holder.id: " + holder.contentImage.getId());
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(getContext()).load(url).into(holder.contentImage);
        }
        return convertView;
    }

    private class ViewHolder {

        private TextView titleText;
//        private TextView descriptionText;
        private ImageView contentImage;

        public ViewHolder(View view) {
            titleText = (TextView)view.findViewById(R.id.list_title_text);
//            descriptionText = (TextView)view.findViewById(0);
            contentImage = (ImageView) view.findViewById(R.id.list_image);
        }
    }
}
