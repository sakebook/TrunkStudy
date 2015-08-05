package com.sakebook.android.trunksimplenews.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.AsyncTaskLoader;

import com.sakebook.android.trunksimplenews.utils.L;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by sakemotoshinya on 15/08/05.
 */
public class ImageLoader extends AsyncTaskLoader<Bitmap> {

    private String mUrl;

    public ImageLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public void deliverResult(Bitmap data) {
        L.d("deliverResult");
        super.deliverResult(data);
    }

    @Override
    public Bitmap loadInBackground() {
        L.d("loadInBackground");
        InputStream input = null;
        try {
            input = new URL(mUrl).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            input.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        L.d("onStartLoading");
        this.forceLoad();
    }
}
