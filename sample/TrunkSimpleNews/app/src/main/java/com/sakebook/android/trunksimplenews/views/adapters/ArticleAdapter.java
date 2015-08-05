package com.sakebook.android.trunksimplenews.views.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.LoaderManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;
import com.sakebook.android.trunksimplenews.views.AsyncImageView;
import com.sakebook.android.trunksimplenews.views.ImageLoadCallback;

import java.util.List;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class ArticleAdapter extends ArrayAdapter<Article>{
    private List<Article> mArticles;
    private int mResourceId;
    private Context mContext;
    private LoaderManager mLoaderManager;

    public ArticleAdapter(Context context, int resource, List<Article> articles, LoaderManager loaderManager) {
        super(context, resource);
        mArticles = articles;
        mResourceId = resource;
        mContext = context;
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), mResourceId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article article = mArticles.get(position);
        holder.titleText.setText(article.getTitle());
        String url = article.getUser().getImageUrl();
        if (!TextUtils.isEmpty(url)) {
            parent.setTag(holder.contentImage);
            holder.contentImage.setImageFromUrl(url, mLoaderManager, new ImageLoadCallback() {
                @Override
                public void success(Bitmap bitmap) {
                    holder.contentImage.setImageBitmap(bitmap);
                }
            });
        }

        return convertView;
    }

    private static class ViewHolder {

        private TextView titleText;
//        private TextView descriptionText;
        private AsyncImageView contentImage;

        public ViewHolder(View view) {
            titleText = (TextView)view.findViewById(R.id.list_title_text);
//            descriptionText = (TextView)view.findViewById(0);
            contentImage = (AsyncImageView) view.findViewById(R.id.list_image);
        }
    }
}
