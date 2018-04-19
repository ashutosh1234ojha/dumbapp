package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by cl-macmini-86 on 9/15/17.
 */

public class TurnOnGpsWithoutRedirection extends AppCompatActivity {

    private EditText editText;
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);
        editText = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
//                String number = "1000500000.574";

                String number = editText.getText().toString();
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###.00");

                System.out.println(formatter.format(amount));
                tv.setText(formatter.format(amount));

            }
        });

        editText.addTextChangedListener(new NumberTextWatcherForThousand(editText));

//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(final Editable editable) {
//
//                editText.removeTextChangedListener(this);
//
//                try {
//                    String originalString = editable.toString();
//
//
//                    Long longval;
//                    if (originalString.contains(",")) {
//                        originalString = originalString.replaceAll(",", "");
//                    }
//                    longval = Long.parseLong(originalString);
//
//                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
//                    formatter.applyPattern("#,###,###,###");
//                    String formattedString = formatter.format(longval);
//
//                    //setting text after format to EditText
//                    editText.setText(formattedString);
//                    editText.setSelection(editText.getText().length());
//                } catch (NumberFormatException nfe) {
//                    nfe.printStackTrace();
//                }
//
//                editText.addTextChangedListener(this);
//
//
//            }
//        });


    }


}
