package com.marlonmafra.rxnotification.fcm.sample;

import android.app.Application;
import android.content.Context;

public class SampleApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }
}
