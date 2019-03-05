package com.dummyapp.jobScheduler;

import android.content.Context;
import android.content.Intent;

import com.dummyapp.background.service.BroadcastReceiver;

/**
 * Created by Ashutosh Ojha on 5/24/18.
 */
public class MyStartServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Util.scheduleJob(context);
    }
}
