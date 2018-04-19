package com.dummyapp.dependencyinjection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dummyapp.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by cl-macmini-86 on 7/7/17.
 */

public class DependencyInjectionActivity extends AppCompatActivity {
    @Inject
    NetworkApi networkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency_injection);
        boolean injected = networkApi == null ? false : true;
        TextView userAvailable = (TextView) findViewById(R.id.target);
        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected));
    }
}
