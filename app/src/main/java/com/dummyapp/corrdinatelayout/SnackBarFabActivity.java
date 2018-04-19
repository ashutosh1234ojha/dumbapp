package com.dummyapp.corrdinatelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;


/**
 * Created by cl-macmini-86 on 7/5/17.
 */

public class SnackBarFabActivity extends AppCompatActivity {

    private Button showSnackbarButton;
    private CoordinatorLayout CoordinatorLayout;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_fab);
        init();
    }

    private void init() {
        showSnackbarButton=(Button)findViewById(R.id.showSnackbarButton);
        CoordinatorLayout=(CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        showSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Snackbar.make(CoordinatorLayout,
                        "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Custom action
                            }
                        }).show();
            }
        });

    }
}
