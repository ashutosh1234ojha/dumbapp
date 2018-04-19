package com.dummyapp.background;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 7/10/17.
 */

public class ThreadActivity extends AppCompatActivity {

    private TextView tvThread;
    private Handler h;
    private Button btnDone;
    private RelativeLayout regularLayout;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        regularLayout = (RelativeLayout) findViewById(R.id.regularLayout);
        tvThread = (TextView) findViewById(R.id.tvThread);
        btnDone = (Button) findViewById(R.id.btnDone);
        tvThread.setText("started");

        new Runnable() {
            @Override
            public void run() {

                regularLayout.setBackgroundColor(ContextCompat.getColor(ThreadActivity.this, R.color.colorBrightGreen));
            }
        };

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


                ThreadClass threadClass = new ThreadClass();
                threadClass.run();
            }
        });

    }

    public class ThreadClass extends Thread {

        @Override
        public void run() {
//            super.run();

            getValue();
        }
    }

    private void getValue() {

        int a = 10;
        for (int i = 0; i < 10; i++) {

            a--;
            Log.d("tag", a + "");
            if (a == 9) {
                getValue();

            }
        }
    }
}
