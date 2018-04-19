package com.dummyapp.background.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;


/**
 * Created by cl-macmini-86 on 9/28/17.
 */

public class LooperActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
    }


    class LooperThread extends Thread{

         public Handler mHandler;


        public void run() {
            Looper.prepare();

            mHandler = new Handler() {
                public void handleMessage(Message msg) {

                }
            };

            Looper.loop();
        }
    }
}
