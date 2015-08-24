package com.sakebook.android.trunksimplenews.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by sakemotoshinya on 15/08/25.
 */
public class MemoryLruCache {

    final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    final int cacheSize = maxMemory / 8;

    private LruCache<String, Bitmap> mLruCache = new LruCache<String, Bitmap>(cacheSize){
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount() / 1024;
        }
    };

    public MemoryLruCache() {
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mLruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return mLruCache.get(key);
    }
}
