package com.dummyapp.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 5/24/18.
 */
public class CActivity extends AppCompatActivity {

    private TextView tvCheck;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCheck=findViewById(R.id.tvCheck);

        tvCheck.setText("C");

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent=new Intent(CActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        tvCheck.setText("C new intent");
    }
}
