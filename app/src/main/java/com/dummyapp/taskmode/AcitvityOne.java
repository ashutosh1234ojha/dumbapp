package com.dummyapp.taskmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 2/28/18.
 */

public class AcitvityOne extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_mode);

        Button btnStandard = findViewById(R.id.btnStandard);
        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                Intent intent = new Intent(AcitvityOne.this, AcitvityOne.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        Log.d("Tag", "new intent");
    }
}
