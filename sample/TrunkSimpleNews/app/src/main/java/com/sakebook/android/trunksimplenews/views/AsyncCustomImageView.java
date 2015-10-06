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
import com.sakebook.android.trunksimplenews.utils.L;

import java.util.Random;

public class AsyncCustomImageView extends ImageView implements LoaderManager.LoaderCallbacks<Bitmap> {

    private final static String TAG = AsyncCustomImageView.class.getSimpleName();
    private String mUrl;
    private long startTimeMillis;
    private boolean canAnimate = true;

    private ImageLoadCallback mImageLoadCallback;

    public AsyncCustomImageView(Context context) {
        super(context);
    }

    public AsyncCustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        startTimeMillis = SystemClock.uptimeMillis();
        L.d("AsyncCustomImageView init 2");
    }

    public AsyncCustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        L.d("AsyncCustomImageView init 3");
    }

    public void setImageFromUrl(String url, int id, LoaderManager loaderManager, ImageLoadCallback callback) {
        this.mUrl = url;
        this.setTag(mUrl);
        this.mImageLoadCallback = callback;
        loaderManager.initLoader(url.hashCode(), null, this);
//        loaderManager.restartLoader(url.hashCode(), null, new LoaderManager.LoaderCallbacks<Bitmap>() {
//            @Override
//            public Loader onCreateLoader(int id, Bundle args) {
//                L.d("(2) new--------");
//                L.d("onCreateLoader");
//                return new ImageLoader(getContext(), mUrl);
//            }
//
//            @Override
//            public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
//                L.d("(6) new--------");
//                L.d("onLoadFinished");
//                AsyncCustomImageView.this.mImageLoadCallback.success(AsyncCustomImageView.this, data, AsyncCustomImageView.this.mUrl);
////                if (mUrl.equals(this.getTag())) {
////                    L.d("url match!");
////                    this.mImageLoadCallback.success(this, data, mUrl);
////                } else {
////                    L.d("url not match!");
////                }
////        this.mImageLoadCallback.success(this, data, mUrl);
//
//            }
//
//            @Override
//            public void onLoaderReset(Loader loader) {
//                L.d("onLoaderReset new");
//
//            }
//        });
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
        L.d("onCreateLoader");
        return new ImageLoader(getContext(), mUrl);
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
        L.d("onLoadFinished");
        if (mUrl.equals(this.getTag())) {
            L.d("url match!");
            this.mImageLoadCallback.success(this, data, mUrl);
        } else {
            L.d("url not match!");
        }
//        this.mImageLoadCallback.success(this, data, mUrl);

    }

    @Override
    public void onLoaderReset(Loader loader) {
        L.d("onLoaderReset");

    }
}
