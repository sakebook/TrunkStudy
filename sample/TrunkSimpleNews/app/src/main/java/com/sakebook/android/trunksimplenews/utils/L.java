package com.sakebook.android.trunksimplenews.utils;

import android.util.Log;

import com.sakebook.android.trunksimplenews.BuildConfig;
import com.sakebook.android.trunksimplenews.TrunksimpleNewsApplication;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class L {

    private final static String TAG = TrunksimpleNewsApplication.class.getSimpleName();

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
