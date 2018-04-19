package com.dummyapp.progressbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar=(ProgressBar) findViewById(R.id.progress_bar);
    }
}
