package com.dummyapp.screenlock;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 7/17/17.
 */

public class ScreenLockActivity extends AppCompatActivity {

    private LinearLayout llScreenLock;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_lock);
        llScreenLock=(LinearLayout)findViewById(R.id.llScreenLock);

        doubleTap();
        llScreenLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

            }
        });
    }

    private void doubleTap() {
        final GestureDetector gd = new GestureDetector(ScreenLockActivity.this, new GestureDetector.SimpleOnGestureListener(){


            //here is the method for double tap


            @Override
            public boolean onDoubleTap(MotionEvent e) {

                //your action here for double tap e.g.
                //Log.d("OnDoubleTapListener", "onDoubleTap");
                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 1000);


                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);

            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }


        });

//here yourView is the View on which you want to set the double tap action

        llScreenLock.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return gd.onTouchEvent(event);
            }
        });
    }
}
