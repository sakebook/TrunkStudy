package com.sakebook.android.sample.retrofitsample;

import android.app.Application;
import android.content.res.Configuration;

import com.sakebook.android.sample.retrofitsample.utils.LocalStorageUtil;

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
        //Check if a device is a tablet
        LocalStorageUtil.putBoolean("is_tablet", getResources().getBoolean(R.bool.is_tablet));
    }

    /**
     * If a device is a tablet, allow an applicaiton to autoRotate
     *
     * @return true: autoRotate false: Do not allow landscape mode
     */
    public static boolean isAutoLandscape() {
        return LocalStorageUtil.getBoolean("is_tablet", false);
    }

    public boolean isLandscape() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

}
