package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.swipetodismiss.OnSwipeDismissListener;
import com.dummyapp.swipetodismiss.SwipeDismissDialog;
import com.dummyapp.swipetodismiss.SwipeDismissDirection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
        setContentView(R.layout.constraint_layout);
        showCancellationDialog();


        stringOperation();
        abc();


        subString("abccddde");

        int a[] = {1, 3, 12, 5, 9, 10};

        weightedUniformStrings("abccddde", a);
        String str="abc";



        subset();



//        setListener();

    }

    private void subset() {


    }

    private void setListener() {

        EditText et=findViewById(R.id.et);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {

            }
        });
    }

    private void subString(String input) {

//        abccddde
//        6
//        1
//        3
//        12
//        5
//        9
//        10

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {

            int chart = input.charAt(i);

            if (hashMap.containsKey(chart)) {

                int value = hashMap.get(chart);
                hashMap.put(chart, value + chart - 96);
            } else {
                hashMap.put(chart, chart - 96);
            }

        }


        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }

    static String[] weightedUniformStrings(String input, int[] queries) {
//        abccddde
        String output[] = new String[queries.length];

        HashSet<Integer> hashSet = new HashSet<>();

        char prev = ' ';
        int weight = 0;

        for (int i = 0; i < input.length(); i++) {

            char curr = input.charAt(i);
            if (prev != curr) {
                weight = 0;
            }
            weight = weight + 'a' - 1;
            hashSet.add(weight);


        }

        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add(null);
        hashSet1.add(null);


        ArrayMap<Integer,String>  arrayMap=new ArrayMap<>();

        Iterator iterator = hashSet.iterator();

        for (int i = 0; i < queries.length; i++) {

            while (iterator.hasNext()) {

                if (Integer.valueOf(iterator.next().toString()) == queries[i]) {
                    output[i] = "Yes";
                } else {
                    output[i] = "No";
                }
            }
        }

        return output;



    }


    private void stringOperation() {

        String demo = "abc";
        Log.d("String", demo + " first");

        demo = "def";

        Log.d("String", demo + " second");


        StringBuilder stringBuilder = new StringBuilder("abc");
        Log.d("stringBuilder", stringBuilder + " first");

        stringBuilder.replace(0, stringBuilder.length(), "def");

        Log.d("stringBuilder", stringBuilder + " second");

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

        abc();

        abcd(0, 3, "abc");

    }

    private void abc() {

        String s1 = "world";
        String s2 = "hi";
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();


        for (int i = 0; i <= s1.length(); i++) {
            for (int j = i + 1; j <= s1.length(); j++) {

                listOne.add(s1.substring(i, j));
                Log.d("Substring", s1.substring(i, j) + " i=" + i + " j=" + j);

            }
        }

        for (int i = 0; i <= s2.length(); i++) {
            for (int j = i + 1; j <= s2.length(); j++) {
                listTwo.add(s2.substring(i, j));

                Log.d("Substring", s2.substring(i, j) + " i=" + i + " j=" + j);

            }
        }

        for (int i = 0; i < listOne.size(); i++) {
            for (int j = 0; j < listTwo.size(); j++) {

                if (listOne.get(i).equals(listTwo.get(j))) {
                    Log.d("Substring", "Yes");
                    return;
                }
            }
        }
        Log.d("Substring", "No");
    }

    void abcd(final int start, final int end, final String string) {

        if (string.isEmpty()) {
            Log.d("Substring", "Yes");
            return;
        }
    }

    /**
     * Method to get Todays date in a specified format
     *
     * @return
     */
    public String getTodaysDate() {
        String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        return new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ENGLISH).format(new Date());
    }//        return getFormattedDate(new Date(), DEFAULT_DATE_FORMAT);


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
