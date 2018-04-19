package com.dummyapp.customCalender;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cl-macmini-86 on 8/21/17.
 */

public class CalenderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPreviousMonth, btnNextMonth;
    private CalenderAdapter calenderAdapter;
    private Calendar currentDate;
    private GridView calendar_grid;
    private static final int DAYS_COUNT = 42;
    private TextView tvCurrentMonth, tvPreviousMonth, tvNextMonth;
    private List<Date> eventDates;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        init();
    }

    private void init() {
        btnNextMonth = (Button) findViewById(R.id.btnNextMonth);
        btnPreviousMonth = (Button) findViewById(R.id.btnPreviousMonth);
        calendar_grid = (GridView) findViewById(R.id.calendar_grid);
        tvCurrentMonth = (TextView) findViewById(R.id.tvCurrentMonth);
        tvNextMonth = (TextView) findViewById(R.id.tvNextMonth);
        tvPreviousMonth = (TextView) findViewById(R.id.tvPreviousMonth);


        eventDates = new ArrayList<>();
        btnNextMonth.setOnClickListener(this);
        btnPreviousMonth.setOnClickListener(this);
        currentDate = Calendar.getInstance();
        calenderAdapter = new CalenderAdapter(this);
        calendar_grid.setAdapter(calenderAdapter);

        eventDates.add(new Date());
        updateCalendar();
        setMonths(0);


    }

    private void setMonths(int type) {
        int current=0,previous=0,next=0;
        switch (type){
            case 0:
                current=-1;
                previous=2;
                next=-2;
                break;

            case 1:
                current=-1;
                previous=2;
                next=-2;
                break;
            case -1:
                current=-1;
                previous=2;
                next=-2;
                break;
        }

        tvCurrentMonth.setText(theMonth(currentDate.get(Calendar.MONTH)));
//        currentDate.add(Calendar.MONTH, current);
//        tvPreviousMonth.setText(theMonth(currentDate.get(Calendar.MONTH)));
//        currentDate.add(Calendar.MONTH, previous);
//        tvNextMonth.setText(theMonth(currentDate.get(Calendar.MONTH)));
//        currentDate.add(Calendar.MONTH, -next);
    }


    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnNextMonth:
                currentDate.add(Calendar.MONTH, 1);
                setMonths(1);
//                currentDate.add(Calendar.MONTH, -2);
                updateCalendar();

                break;
            case R.id.btnPreviousMonth:
                currentDate.add(Calendar.MONTH, -1);
                setMonths(-1);
//                currentDate.add(Calendar.MONTH, -2);
                updateCalendar();
                break;

        }
    }

    private void updateCalendar() {
        ArrayList<Task> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        Log.d("Tag", monthBeginningCell + "");
        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        // fill cells
        while (cells.size() < DAYS_COUNT) {

            Task task = new Task();
            task.setDate(calendar.getTime());
            cells.add(task);

            //It moves the calender one day forward(by adding one day in calender) after each iteration.
            // So that we can get new value which is to be added in cells
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calenderAdapter.setData(cells,eventDates);
    }


//    private void updateCalendar() {
//        ArrayList<Date> cells = new ArrayList<>();
//        Calendar calendar = (Calendar) currentDate.clone();
//
//        // determine the cell for current month's beginning
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//
//        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//
//        Log.d("Tag", monthBeginningCell + "");
//        // move calendar backwards to the beginning of the week
//        calendar.add(Calendar.DAY_OF_MONTH,- monthBeginningCell);
//
//        // fill cells
//        while (cells.size() < DAYS_COUNT) {
//            cells.add(calendar.getTime());
//
//                //It moves the calender one day forward(by adding one day in calender) after each iteration.
//                // So that we can get new value which is to be added in cells
//            calendar.add(Calendar.DAY_OF_MONTH, 1);
//        }
//
//        calenderAdapter.setData(cells);
//    }

    public static String theMonth(int month) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[month];
    }
}
