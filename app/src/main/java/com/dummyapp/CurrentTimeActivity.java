package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by cl-macmini-86 on 9/4/17.
 */

public class CurrentTimeActivity extends AppCompatActivity {
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);
//        getCurrentDateTime();
//        getCurrentDateTime4();

//        Calendar calendar = getFormattedCalender();
//        Log.d("Calendar", calendar.getTime() + " new time");
//        Log.d("Calendar", calendar.get(Calendar.YEAR) + " YEAR");
//        Log.d("Calendar", calendar.get(Calendar.MONTH) + " MONTH");
//        Log.d("Calendar", calendar.get(Calendar.DAY_OF_MONTH) + " DAY_OF_MONTH");
//        Log.d("Calendar", calendar.get(Calendar.HOUR_OF_DAY) + " HOUR_OF_DAY");
//        Log.d("Calendar", calendar.get(Calendar.MINUTE) + " MINUTE");

        Log.d("Offset", getLocalDateTimeFromUtc1("2017-09-22T18:47:21.600Z"));

//        getLocalDateTimeFromUtc1("2017-09-22T18:47:21.600Z");

        getCurrentDateTime4();

    }

    private Calendar getFormattedCalender() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 18);
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 48);
        return calendar;
    }


    /**
     * Get current dateTime
     *
     * @return currentTime
     */
    public static String getCurrentDateTime4() {
        Date myDate = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        calendar.setTime(myDate);
        Log.d("Tag", calendar.get(Calendar.HOUR_OF_DAY) + "  Current hour of day");
//        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) );
        Date time = calendar.getTime();
        SimpleDateFormat outputFmt = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        String dateAsString = outputFmt.format(time);
        Log.d("Tag", dateAsString + "  Time Current ");
        return dateAsString;
    }

    /**
     * Get current dateTime
     *
     * @return currentTime
     */
    public static String getCurrentDateTime() {
        Date myDate = new Date();

        Calendar calendar = Calendar.getInstance();

//        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        String d = "2018-02-14'T'13:23:44.000'Z'";

        calendar.setTime(myDate);
        Date time = calendar.getTime();
        SimpleDateFormat outputFmt = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        String dateAsString = outputFmt.format(time);
        Log.d("Tag", dateAsString + "  Time¬ current");
        return dateAsString;
    }


    /**
     * Get offset
     *
     * @return offset in minutes
     */
    public static int getOffset() {
        TimeZone timezone = TimeZone.getDefault();
        int seconds = (timezone.getOffset(Calendar.ZONE_OFFSET) + timezone.getDSTSavings()) / 1000;
        int minutes = seconds / 60;
        double hours = minutes / 60;
        return minutes;

    }

    /**
     * @param utcTime input
     * @return local dateTime
     */
    public static String getLocalDateTimeFromUtc1(final String utcTime) {

        try {
            DateFormat utcFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date date = utcFormat.parse(utcTime);

            String outPutFormat = "yyyy-MM-dd'T'HH:mm:ss";

            DateFormat pstFormat;

            pstFormat = new SimpleDateFormat(outPutFormat);

            pstFormat.setTimeZone(TimeZone.getDefault());



            return pstFormat.format(date);
        } catch (ParseException e) {
            return "";
        }


    }

}
