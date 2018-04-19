package com.dummyapp.background.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

/**
 * this service will be stopped by itself or by client
 */

public class MyService extends Service {
    Handler mHandler;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        loop();

        return super.onStartCommand(intent, flags, startId);

    }



    private void loop() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        Log.d("Tag", i + "");

                        Intent RTReturn = new Intent("casd");
                        RTReturn.putExtra("json", "ram");
                        sendBroadcast(RTReturn);
                        if (i == 999) {
                            loop();
                        }

                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            Log.d("Tag", i + "main thread");
                        } else {
                            Log.d("Tag", i + "separate thread");
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();


//        for (int i = 0; i < 1000; i++) {
//            Log.d("Tag", i + "");
//            if (i == 999) {
//                loop();
//            }
//
//        }
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

    @Override
    public boolean onUnbind(final Intent intent) {
        return super.onUnbind(intent);
    }


}
