package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by cl-macmini-86 on 10/12/17.
 */

public class DateTimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

//        setDateTimePicker();

        String value = "2018-01-24'T'11:11:00.000'Z'";

        localToUtc(value);
    }

    private void setDateTimePicker() {
        new SingleDateAndTimePickerDialog.Builder(this)
                //.bottomSheet()
                //.curved()
                //.minutesStep(15)

                //.displayHours(false)
                //.displayMinutes(false)

                .displayListener(new SingleDateAndTimePickerDialog.DisplayListener() {
                    @Override
                    public void onDisplayed(SingleDateAndTimePicker picker) {
                        //retrieve the SingleDateAndTimePicker
                    }
                })

                .title("Simple")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {

                    }
                }).display();
    }

    /**
     * @param utcDateAndTime date in utc
     * @return local time
     */
    public static String localToUtc(final String utcDateAndTime) {


        String format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//        java.text.DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        java.text.DateFormat pstFormat = new SimpleDateFormat(format);
        pstFormat.setTimeZone(TimeZone.getDefault());


        Date date = null;
        try {
            date = pstFormat.parse(utcDateAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        java.text.DateFormat pstFormat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm a");
        java.text.DateFormat utcFormat = new SimpleDateFormat(format);
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        String date1 = utcFormat.format(date);
        Log.d("Tag", date1 + "  utc");
        return date1;


    }
}
