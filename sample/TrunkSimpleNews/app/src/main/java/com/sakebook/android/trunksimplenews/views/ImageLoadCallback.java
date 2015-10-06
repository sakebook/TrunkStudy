package com.sakebook.android.trunksimplenews.views;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by sakemotoshinya on 15/08/05.
 */
public interface ImageLoadCallback {
    void success(AsyncCustomImageView view, Bitmap bitmap, String fromUrl);
}
