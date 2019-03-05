package com.dummyapp.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/25/18.
 */

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding activityDataBindingBinding= DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        User user=new User();
        user.setOnline(true);
        activityDataBindingBinding.setUser(user);

    }
}
