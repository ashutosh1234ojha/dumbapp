package com.dummyapp.background.alaram;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.dummyapp.background.service.BroadcastReceiver;

/**
 * Created by Ashutosh Ojha on 3/12/18.
 */

public class MyBroadcastManager extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Toast.makeText(context, "Alarm set",Toast.LENGTH_LONG).show();
    }
}
