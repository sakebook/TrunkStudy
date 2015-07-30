package com.sakebook.android.trunksimplenews.views.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class ArticleAdapter<T> extends ArrayAdapter<T>{
    public ArticleAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }
}
