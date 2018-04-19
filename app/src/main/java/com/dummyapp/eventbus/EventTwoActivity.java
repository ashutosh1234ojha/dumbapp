package com.dummyapp.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dummyapp.R;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 11/29/17.
 */

public class EventTwoActivity extends AppCompatActivity {

    private Button btnGeneral;
    private TextView tvResult;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);

        btnGeneral=(Button)findViewById(R.id.btnGeneral);
        tvResult=(TextView) findViewById(R.id.tvResult);

        EventOneActivity.bus.register(this);
        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("RAM");
        arrayList.add("SHYAM");
        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                EventOneActivity.bus.post(arrayList);

            }
        });
    }
}
