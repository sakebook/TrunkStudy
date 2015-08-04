package com.sakebook.android.trunksimplenews.views.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.trunksimplenews.R;
import com.sakebook.android.trunksimplenews.models.Article;

import java.util.List;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class ArticleAdapter extends ArrayAdapter<Article>{
    private List<Article> mArticles;
    private int mResourceId;
    private Context mContext;
    public ArticleAdapter(Context context, int resource, List<Article> objects) {
        super(context, resource, objects);
        this.mArticles = objects;
        this.mResourceId = resource;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mArticles.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
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
            holder.contentImage.setImageResource(R.mipmap.ic_launcher);
//            holder.contentImage.setImageBitmap(bitmap);
        }

        return convertView;
    }

    private static class ViewHolder {

        private TextView titleText;
//        private TextView descriptionText;
        private ImageView contentImage;

        public ViewHolder(View view) {
            titleText = (TextView)view.findViewById(R.id.list_title_text);
//            descriptionText = (TextView)view.findViewById(0);
            contentImage = (ImageView)view.findViewById(R.id.list_image);
        }
    }
}
