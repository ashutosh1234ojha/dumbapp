package com.dummyapp.background.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        loop();
    }

    @Override
    public int onStartCommand(@Nullable final Intent intent, final int flags, final int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    private void loop() {
        for (int i = 0; i < 1000; i++) {
            Log.d("Tag", i + "");

            if (i == 999) {
                loop();
            }
        }

//        Intent RTReturn = new Intent(StartServiceActivity.RECEIVE_JSON);
        Intent RTReturn = new Intent("casd");
        RTReturn.putExtra("json", "ram");
        sendBroadcast(RTReturn);
    }


}
