package com.dummyapp.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 12/8/17.
 */

public class CustomViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }
}
