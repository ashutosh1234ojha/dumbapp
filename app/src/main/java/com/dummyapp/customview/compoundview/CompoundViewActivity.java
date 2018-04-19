package com.dummyapp.customview.compoundview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 12/21/17.
 */

public class CompoundViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_view);

        RatingView ratingView = findViewById(R.id.ratingsView);
        ratingView.setPOI(4,5,2);
    }
}
