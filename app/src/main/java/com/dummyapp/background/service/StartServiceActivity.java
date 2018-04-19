package com.dummyapp.background.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 7/21/17.
 */

public class StartServiceActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String RECEIVE_JSON = StartServiceActivity.class.getSimpleName();
    private Button btnStopService;
    private BroadcastReceiver bReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getStringExtra("json").equals("ram")) {
                Toast.makeText(context, intent.getStringExtra("json"), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "else", Toast.LENGTH_SHORT).show();

            }

        }
    };

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        btnStopService=(Button)findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(this);

        BroadcastReceiver broadcastReceiver=new com.dummyapp.background.service.BroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("casd");
        registerReceiver(broadcastReceiver, intentFilter);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(StartServiceActivity.this, "jksdlf", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(final View view) {

        switch (view.getId()) {
            case R.id.btnStartService:
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("Service", "my world");
//                startService(intent);


                Intent intentService = new Intent(this, MyIntentService.class);
                intent.putExtra("Service", "my world");
                startService(intentService);
                break;

            case R.id.btnStopService:
                Intent intentStop = new Intent(this, MyIntentService.class);
                intentStop.putExtra("Service", "my world");
                this.stopService(intentStop);
                break;
        }
    }
}
