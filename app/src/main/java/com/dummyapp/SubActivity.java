package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.swipetodismiss.OnSwipeDismissListener;
import com.dummyapp.swipetodismiss.SwipeDismissDialog;
import com.dummyapp.swipetodismiss.SwipeDismissDirection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/**
 * Created by cl-macmini-86 on 3/30/17.
 */

public class SubActivity extends AppCompatActivity {

    private TextView textView;
    // current displayed month
    private Calendar currentDate = Calendar.getInstance();
    // default date format
    private static final String DATE_FORMAT = "MMM yyyy";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);
        showCancellationDialog();


    }


    private void showCancellationDialog() {

//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_revoke_driver);
//
//        DisplayMetrics metrics = getResources().getDisplayMetrics();
//        int width = metrics.widthPixels;
//        dialog.getWindow().setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.show();
//
//
//        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(final DialogInterface dialogInterface) {
//
//            }
//        });

        View dialog = LayoutInflater.from(this).inflate(R.layout.dialog_revoke_driver, null);
        new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                    @Override
                    public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                        Toast.makeText(SubActivity.this, "Swipe dismissed to: " + direction, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();



    }

    /**
     * Method to get Todays date in a specified format
     *
     * @return
     */
    public String getTodaysDate() {
        String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        return new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ENGLISH).format(new Date());
//        return getFormattedDate(new Date(), DEFAULT_DATE_FORMAT);
    }


    public String getFormattedDate(Date date, String format) {
        return new SimpleDateFormat(format, Locale.ENGLISH).format(date);
    }


    /**
     * Display dates correctly in grid
     */
    public void updateCalendar(HashSet<Date> events) {
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Log.d("Tag", calendar.toString() + "  day of month");

        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        Log.d("Tag", monthBeginningCell + "  month beginning_cell");

        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        Log.d("Tag", calendar.toString() + " calender month beginning_cell");

        // fill cells
        while (cells.size() < 42) {
            cells.add(calendar.getTime());
            Log.d("Tag", cells.size() + " size");
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            Log.d("Tag", calendar + " while");
        }

        // update grid
//        grid.setAdapter(new CalendarAdapter(getContext(), cells, events));

        // update title
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        textView.setText(sdf.format(currentDate.getTime()));

        // set header color according to current season

    }

}
