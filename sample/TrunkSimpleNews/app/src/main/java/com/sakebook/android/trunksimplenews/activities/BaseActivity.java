package com.sakebook.android.trunksimplenews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.sakebook.android.trunksimplenews.TrunkSimpleNewsApplication;
import com.sakebook.android.trunksimplenews.utils.L;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendScreen();
    }

    private void sendScreen() {
        L.d("class name: " + this.getClass().getSimpleName());


        TrunkSimpleNewsApplication application =
                (TrunkSimpleNewsApplication) getApplication();
        Tracker t = application.getDefaultTracker();
        t.setScreenName(this.getClass().getSimpleName());
        t.send(new HitBuilders.ScreenViewBuilder().build());

    }
}

