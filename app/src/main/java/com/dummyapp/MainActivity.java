package com.dummyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvCheck;
    private EditText etCard;
    CustomDateTimePicker customDateTimePicker;
    String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static Calendar selectedScheduleCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCheck=(TextView)findViewById(R.id.tvCheck);


//        init();

//        cardDate();

        tvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ThreeButtonAlert.showAlert(MainActivity.this,"Choose image","Gallery", "Camera", new ThreeButtonAlert.OnAlertOkCancelClickListener() {
                    @Override
                    public void onOkButtonClicked() {
                        Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelButtonClicked() {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onViewClicked() {
                        Toast.makeText(MainActivity.this, "view", Toast.LENGTH_SHORT).show();
                    }
                });


//                ABC abc=new ABC();
//                abc.setfNmae("ASHUTOSH");
//                Bundle bundle=new Bundle();
//                bundle.putParcelable("NAME",abc);
//                Intent intent=new Intent(MainActivity.this,SubActivity.class);
//                intent.putExtras(bundle);
//                startActivity(intent);
//                Calendar now = Calendar.getInstance();
//                int year = now.get(Calendar.YEAR);
//                int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
//                int day = now.get(Calendar.DAY_OF_MONTH);
//                int hour = now.get(Calendar.HOUR_OF_DAY);
//                int minute = now.get(Calendar.MINUTE);
//                int second = now.get(Calendar.SECOND);
//                int millis = now.get(Calendar.MILLISECOND);

            }
        });



    }

    private void cardDate() {

        etCard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {

                String string=editable.toString();

                if(string.length()==1)
                {
                    int no= Integer.parseInt(string);
                }

               

            }
        });


    }

    private void init() {


        etCard=findViewById(R.id.etCard);
//        ABC abc=new ABC();
//        abc.setfNmae("ASHUTOSH");
        Bundle bundle=new Bundle();
//        bundle.putParcelable("NAME",abc);
        Intent intent=new Intent(MainActivity.this,SubActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

        compareDates();

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);

        System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);
    }

    private void compareDates() {

        Date date1=new Date();
        Date date2=new Date();


        //if  msgPushedTimestamp<logFileTimestamp=less than 0
        //if  msgPushedTimestamp=logFileTimestamp=0
        //if  msgPushedTimestamp>logFileTimestamp=greater than 0

//        String msgPushedTimestamp = "2016-06-11";
//        String logFileTimestamp = "2016-06-11";
        String msgPushedTimestamp = "2017-04-03T10:05:00.000Z";
        String logFileTimestamp = "2017-04-04T16:23:00.000Z";

        int compare=msgPushedTimestamp.compareTo(logFileTimestamp);
        Log.d("Compare",compare+"");

//        if(date1.after(date2)){
//            System.out.println("Date1 is after Date2");
//        }
//
//        if(date1.before(date2)){
//            System.out.println("Date1 is before Date2");
//        }
//
//        if(date1.equals(date2)){
//            System.out.println("Date1 is equal Date2");
//        }
    }

//

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tvCheck:
                Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
