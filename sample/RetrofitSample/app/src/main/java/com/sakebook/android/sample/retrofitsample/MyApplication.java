package com.sakebook.android.sample.retrofitsample;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication sApp;
    public final static String TAG = "RetrofitSample";

    public MyApplication() {

    }

    public static MyApplication getInstance() {
        if (sApp == null) {
            sApp = new MyApplication();
        }
        return sApp;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

}
