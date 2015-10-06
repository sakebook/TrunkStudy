package com.sakebook.android.trunksimplenews.services;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by sakemotoshinya on 15/08/31.
 */
public class CustomAsyncTaskLoader extends AsyncTaskLoader {
    public CustomAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public Object loadInBackground() {
        return null;
    }

    @Override
    protected Object onLoadInBackground() {
        return super.onLoadInBackground();
    }
}
