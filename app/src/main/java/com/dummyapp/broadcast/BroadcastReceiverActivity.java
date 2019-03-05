package com.dummyapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 6/21/18.
 */
public class BroadcastReceiverActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);

        registerReceiver(receiver, intentFilter);

    }


    IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AirplaneMode", "Service state changed");

            Toast.makeText(context, "Broadcast received", Toast.LENGTH_SHORT).show();
        }
    };


//   public static class MyBroadcastReceiver extends BroadcastReceiver{
//        @Override
//        public void onReceive(final Context context, final Intent intent) {
//            super.onReceive(context, intent);
//            Toast.makeText(context, "Broadcast received", Toast.LENGTH_SHORT).show();
//        }
//    }
 }
