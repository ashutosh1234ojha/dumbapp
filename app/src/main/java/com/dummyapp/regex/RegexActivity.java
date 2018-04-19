package com.dummyapp.regex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cl-macmini-86 on 8/24/17.
 */

public class RegexActivity extends AppCompatActivity {

    private int count = 0, time;
    private Button btnStart;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);

        init();


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String target = "Ashutosh . Is a regex student , android developer . ";

                Pattern pattern = Pattern.compile("(\\w){2}");
                Matcher matcher = pattern.matcher(target);


//                while (matcher.find()) {
//                    Log.d("Match", "count   " + ++count + "----  group   " + matcher.group());
//                    Log.d("Match", "start index   " + matcher.start() + "----  end index  " + (matcher.end() - 1));
//                }
//                String pattern = "(\\w)(\\s+)([\\.,])";
                String removeSpaceFollowedByChar="(\\w)(\\s+)([\\.,])";
                Log.d("Output",target.replaceAll(removeSpaceFollowedByChar,"9"));



            }
        });


    }

    private void init() {
        btnStart = (Button) findViewById(R.id.btnStart);
    }
}
