package com.sakebook.android.trunksimplenews.views;

import android.graphics.Bitmap;

/**
 * Created by sakemotoshinya on 15/08/05.
 */
public interface ImageLoadCallback {

    void success(Bitmap bitmap, String fromUrl);
}
