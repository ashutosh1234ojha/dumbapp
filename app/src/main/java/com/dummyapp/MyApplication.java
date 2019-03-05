package com.dummyapp;

import android.app.Activity;
import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by cl-macmini-86 on 7/7/17.
 */

public class MyApplication extends Application implements HasActivityInjector {

    GoogleAnalytics googleAnalytics;
    Tracker tracker;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
//        DaggerMyApplicationComponent.create().inject(this);

        googleAnalytics=GoogleAnalytics.getInstance(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    synchronized  public Tracker getDefaultTracker(){
        if(tracker==null){
//           tracker=googleAnalytics.newTracker(R.xml.g)
            tracker = googleAnalytics.newTracker(R.xml.global_tracker);
        }

        return tracker;
    }
}
