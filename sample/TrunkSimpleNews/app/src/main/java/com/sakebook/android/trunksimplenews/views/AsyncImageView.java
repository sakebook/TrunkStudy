package com.sakebook.android.trunksimplenews.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.sakebook.android.trunksimplenews.network.ImageLoader;

public class AsyncImageView extends ImageView implements LoaderManager.LoaderCallbacks<Bitmap> {

    private String mUrl;

    private ImageLoadCallback mImageLoadCallback;

    public AsyncImageView(Context context) {
        super(context);
    }

    public AsyncImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AsyncImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageFromUrl(String url, LoaderManager loaderManager, ImageLoadCallback callback) {
        this.mUrl = url;
        this.mImageLoadCallback = callback;
        loaderManager.initLoader(url.hashCode(), null, this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        ImageLoader loader = new ImageLoader(getContext(), mUrl);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
        mImageLoadCallback.success(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
