package com.dummyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by Ashutosh Ojha on 1/18/18.
 */

public class ShimmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);

        ShimmerLayout shimmerLayout = findViewById(R.id.shimmer_layout);
        shimmerLayout.startShimmerAnimation();

        set();
    }

    void subSet(char[] set) {
        int c = set.length;

        for (int i = 0; i < (1 << c); i++) {
            System.out.print("{");
            for (int j = 0; j < c; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public  void set() {
        char c[] = {'a', 'b', 'c'};
        subSet(c);
    }
}
