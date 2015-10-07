package com.sakebook.android.trunksimplenews;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.sakebook.android.trunksimplenews.utils.L;

/**
 * Created by sakemotoshinya on 15/07/28.
 */
public class TrunkSimpleNewsApplication extends Application {

    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        L.d("TrunkSimpleNewsApplication onCreate");
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
//            analytics.setDryRun(true);
        }
        return mTracker;
    }
}
