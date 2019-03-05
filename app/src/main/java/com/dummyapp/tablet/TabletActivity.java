package com.dummyapp.tablet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 5/14/18.
 */

public class TabletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);
    }
}
