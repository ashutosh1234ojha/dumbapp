package com.dummyapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ashutosh Ojha on 6/21/18.
 */
public class YourBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        Toast.makeText(context, "Broadcast received", Toast.LENGTH_SHORT).show();
    }
}
