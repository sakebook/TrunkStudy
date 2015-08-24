package com.sakebook.android.trunksimplenews.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.sakebook.android.trunksimplenews.network.ImageLoader;

import java.util.Random;

public class AsyncImageView extends ImageView implements LoaderManager.LoaderCallbacks<Bitmap> {

    private String mUrl;
    private long startTimeMillis;
    private boolean canAnimate = true;

    private ImageLoadCallback mImageLoadCallback;

    public AsyncImageView(Context context) {
        super(context);
    }

    public AsyncImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        startTimeMillis = SystemClock.uptimeMillis();
        Log.d("AsyncImageView", "AsyncImageView init 2");
    }

    public AsyncImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("AsyncImageView", "AsyncImageView init 3");
    }

    public void setImageFromUrl(String url, int id, LoaderManager loaderManager, ImageLoadCallback callback) {
        this.mUrl = url;
        this.mImageLoadCallback = callback;
        loaderManager.initLoader(mUrl.hashCode(), null, this);
    }

    @Override
    public void setImageAlpha(int alpha) {
        super.setImageAlpha(alpha);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (!canAnimate) {
//            super.onDraw(canvas);
//        } else {
//            float normalized = (SystemClock.uptimeMillis() - startTimeMillis) / 200f;
//            Log.d("", "normalized: " + normalized);
//            if (normalized >= 1f) {
//                canAnimate = false;
//                super.draw(canvas);
//            } else {
//                int partialAlpha = (int) (0xff * normalized);
//                super.setImageAlpha(partialAlpha);
//                super.draw(canvas);
//            }
//        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
//        AlphaAnimation fadeImage = new AlphaAnimation(0, 1);
//        fadeImage.setDuration(1000);
//        fadeImage.setInterpolator(new DecelerateInterpolator());
//        this.startAnimation(fadeImage);
        ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f).setDuration(100).start();
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        ImageLoader loader = new ImageLoader(getContext(), mUrl);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
        mImageLoadCallback.success(data, mUrl);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
