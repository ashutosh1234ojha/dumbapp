package com.dummyapp.permisssion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 8/3/17.
 */

public class AskPermissionActivity extends AppCompatActivity {

    private Button btnCheckPermission;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_permission);
        btnCheckPermission = (Button) findViewById(R.id.btnCheckPermission);

        btnCheckPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


                if (ContextCompat.checkSelfPermission(AskPermissionActivity.this, Manifest.permission.WRITE_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(AskPermissionActivity.this, Manifest.permission.WRITE_CALENDAR)) {
                        Toast.makeText(AskPermissionActivity.this, "Good explanation", Toast.LENGTH_SHORT).show();
                    } else {
                        ActivityCompat.requestPermissions(AskPermissionActivity.this, new String[]{Manifest.permission.WRITE_CALENDAR}, 100);
                    }

                }
            }
        });
    }
}
