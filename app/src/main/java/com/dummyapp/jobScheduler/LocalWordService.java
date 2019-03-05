package com.dummyapp.jobScheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 5/24/18.
 */
public class LocalWordService extends AppCompatActivity {

    private TextView tvCheck;
    int count =0;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCheck=findViewById(R.id.tvCheck);
        tvCheck.setText(++count+" count");
    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        tvCheck.setText(++count+" count");
    }
}
