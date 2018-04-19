package com.dummyapp.background.service;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by cl-macmini-86 on 7/24/17.
 */

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (intent.getStringExtra("json").equals("ram")) {
            Toast.makeText(context, intent.getStringExtra("json")+"33", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "else"+"3d3", Toast.LENGTH_SHORT).show();

        }

    }
}
