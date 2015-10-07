package com.sakebook.android.trunksimplenews.utils;

import android.util.Log;

import com.sakebook.android.trunksimplenews.BuildConfig;
import com.sakebook.android.trunksimplenews.TrunkSimpleNewsApplication;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class L {

    private final static String TAG =
            TrunkSimpleNewsApplication.class.getSimpleName();

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
