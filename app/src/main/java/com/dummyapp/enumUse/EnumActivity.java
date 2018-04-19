package com.dummyapp.enumUse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 8/19/17.
 */

public class EnumActivity extends AppCompatActivity implements Count {

    int position;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum);
        position = 9;


    }


}
