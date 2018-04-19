package com.dummyapp.background.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Chronometer;

/**
 * Created by Ashutosh Ojha on 3/19/18. 
 */

public class BoundService extends Service {
    private static String LOG_TAG = "BoundService";
    private IBinder iBinder=new MyBinder();
    private Chronometer chronometer;

    @Override
    public void onCreate() {
        super.onCreate();
        chronometer=new Chronometer(this);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    @Nullable
    @Override
    public IBinder onBind(final Intent intent) {
        Log.e(LOG_TAG,"onBind");
        return iBinder;
    }

    @Override
    public void onRebind(final Intent intent) {
        Log.e(LOG_TAG,"onRebind");

        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(final Intent intent) {
        Log.e(LOG_TAG,"onUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(LOG_TAG,"onDestroy");
        chronometer.stop();

    }


    public String getTimestamp() {
        long elapsedMillis = SystemClock.elapsedRealtime()
                - chronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis - hours * 3600000) / 60000;
        int seconds = (int) (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
        int millis = (int) (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000);
        return hours + ":" + minutes + ":" + seconds + ":" + millis;
    }

    public class MyBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }
}
