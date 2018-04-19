package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cl-macmini-86 on 10/3/17.
 */

public class DynamicWeight extends AppCompatActivity implements View.OnClickListener {
    private TextView tvRemaining, tvFunded, tvFundedTxt, tvRemainingTxt;
    private EditText etPercentage;
    private Button btnCalculate;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_java);

        init();
    }

    private void init() {
        tvFunded = (TextView) findViewById(R.id.tvFunded);
        tvFundedTxt = (TextView) findViewById(R.id.tvFundedTxt);
        tvRemaining = (TextView) findViewById(R.id.tvRemaining);
        tvRemainingTxt = (TextView) findViewById(R.id.tvRemainingTxt);
        etPercentage = (EditText) findViewById(R.id.etPercentage);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnCalculate:

                float percentageFunded = Float.parseFloat(etPercentage.getText().toString());
                float percentageRemaining = 100 - percentageFunded;


                tvFunded.setLayoutParams(new LinearLayout.LayoutParams(0,
                        50, percentageFunded));

                tvFunded.setText(percentageFunded + "");

                tvFundedTxt.setLayoutParams(new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.WRAP_CONTENT, percentageFunded));


                tvRemaining.setLayoutParams(new LinearLayout.LayoutParams(0,
                        50, percentageRemaining));

                tvRemaining.setText(percentageRemaining + "");

                tvRemainingTxt.setLayoutParams(new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.WRAP_CONTENT, percentageRemaining));
                break;
        }
    }
}
