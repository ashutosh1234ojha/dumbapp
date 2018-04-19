package com.dummyapp.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dummyapp.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 11/29/17.
 */

public class EventOneActivity extends AppCompatActivity {
    public static Bus bus = new Bus(ThreadEnforcer.MAIN);
    private Button btnGeneral;
    private TextView tvResult;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);
        btnGeneral=(Button)findViewById(R.id.btnGeneral);
        tvResult=(TextView) findViewById(R.id.tvResult);

        bus.register(this);
        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                startActivity(new Intent(EventOneActivity.this,EventTwoActivity.class));
            }
        });

        tvResult.setText("ASHUTOSH");
    }

    @Subscribe
    public void getMessage(ArrayList<String> list) {
//        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

        tvResult.setText("Size "+list.size()+" First text "+list.get(0));
    }
}
