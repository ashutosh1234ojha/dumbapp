package com.dummyapp.oreo.pip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/30/18.
 */

public class PipLauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent=new Intent(PipLauncherActivity.this,PictureInPictureActivity.class);
                startActivity(intent);
            }
        });
    }
}
