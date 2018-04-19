package com.dummyapp.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 8/1/17.
 */

public class JavaActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        String a="a";
        Log.e("Tag",a+"  a");
        String b=a;
        Log.e("Tag",b+"  b");
        a="ty";
        Log.e("Tag",a+"  a");
        Log.e("Tag",b+"  b");

    }
}
