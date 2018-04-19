package com.dummyapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDateTimePicker implements OnClickListener {
    private final int SET = 102, CANCEL = 103;
    boolean mIgnoreEvent = false;
    private DatePicker datePicker;
    private TimePicker timePicker;
    String AM_PM;;
    private ViewSwitcher viewSwitcher;
    private Button btn_set, btn_cancel;
    private Calendar calendar_date = null;
    private Activity activity;
    private ICustomDateTimeListener iCustomDateTimeListener = null;
    private Dialog dialog;
    private boolean is24HourView = true, isAutoDismiss = true;
    private int selectedHour, selectedMinute;
    private int minHour = -1;
    private int minMinute = -1;
    private int maxHour = 25;
    private int maxMinute = 25;
    private int timePickerIntervalInMinutes = 5;

    public CustomDateTimePicker(Activity a,
                                ICustomDateTimeListener customDateTimeListener) {
        activity = a;
        iCustomDateTimeListener = customDateTimeListener;

        dialog = new Dialog(activity, android.R.style.Theme_Holo_Light_Dialog_NoActionBar);
        dialog.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                resetData();
            }
        });

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View dialogView = getDateTimePickerLayout();
        dialog.setContentView(dialogView);
    }

    /**
     * @param date       date in String
     * @param fromFormat format of your <b>date</b> eg: if your date is 2011-07-07
     *                   09:09:09 then your format will be <b>yyyy-MM-dd hh:mm:ss</b>
     * @param toFormat   format to which you want to convert your <b>date</b> eg: if
     *                   required format is 31 July 2011 then the toFormat should be
     *                   <b>d MMMM yyyy</b>
     * @return formatted date
     */
    public static String convertDate(String date, String fromFormat,
                                     String toFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fromFormat);
            Date d = simpleDateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);

            simpleDateFormat = new SimpleDateFormat(toFormat);
            simpleDateFormat.setCalendar(calendar);
            date = simpleDateFormat.format(calendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String pad(int integerToPad) {
        if (integerToPad >= 10 || integerToPad < 0)
            return String.valueOf(integerToPad);
        else
            return "0" + String.valueOf(integerToPad);
    }

    public View getDateTimePickerLayout() {
        ScrollView scrollView = new ScrollView(activity);
        LinearLayout.LayoutParams linear_match_match = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams linear_match_wrap = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linear_match_wrap.setMargins(0, 5, 0, 0);
        LinearLayout.LayoutParams linear_wrap_wrap = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams frame_match_wrap = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams button_params = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);

        LinearLayout linear_main = new LinearLayout(activity);
        linear_main.setLayoutParams(linear_match_match);
        linear_main.setOrientation(LinearLayout.VERTICAL);
        linear_main.setGravity(Gravity.CENTER);

        LinearLayout linear_child = new LinearLayout(activity);
        linear_child.setLayoutParams(linear_wrap_wrap);
        linear_child.setOrientation(LinearLayout.VERTICAL);

        LinearLayout linear_datePicker = new LinearLayout(activity);
        linear_datePicker.setLayoutParams(linear_wrap_wrap);
        linear_datePicker.setOrientation(LinearLayout.VERTICAL);


        LinearLayout linear_top = new LinearLayout(activity);
        linear_top.setLayoutParams(linear_match_match);

        viewSwitcher = new ViewSwitcher(activity);
        viewSwitcher.setLayoutParams(frame_match_wrap);

        datePicker = new DatePicker(activity);
        datePicker.setMinDate(Calendar.getInstance().getTimeInMillis() - 10000);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
//        datePicker.setMaxDate(calendar.getTimeInMillis());
        datePicker.setCalendarViewShown(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            linear_datePicker.setNestedScrollingEnabled(true);
        }


        timePicker = new TimePicker(activity);





        try {
            ViewGroup amPmView;
            ViewGroup v1 = (ViewGroup)timePicker.getChildAt(0);
            ViewGroup v2 = (ViewGroup)v1.getChildAt(0);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                ViewGroup v3 = (ViewGroup)v2.getChildAt(0);
                amPmView = (ViewGroup)v3.getChildAt(3);
            } else {
                amPmView = (ViewGroup)v2.getChildAt(3);
            }
            OnClickListener listener = new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("click","click");
                    timePicker.setCurrentHour((timePicker.getCurrentHour() + 12) % 24);
                }
            };
            View am = amPmView.getChildAt(0);
            View pm = amPmView.getChildAt(1);
            am.setOnClickListener(listener);
            pm.setOnClickListener(listener);
        } catch (Exception e) {
            // DO nothing... just ignore the workaround if this fails.
        }








        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectedHour = hourOfDay;
                selectedMinute = minute;
                Log.i("Selected Hour", "==" + hourOfDay);
                Log.i("Selected Minute", "==" + minute);

                if (mIgnoreEvent)
                    return;
                if (minute % timePickerIntervalInMinutes != 0) {
                    int minuteFloor = minute - (minute % timePickerIntervalInMinutes);
                    minute = minuteFloor + (minute == minuteFloor + 1 ? timePickerIntervalInMinutes : 0);
                    if (minute == 60) {
                        hourOfDay = hourOfDay + 1;
                        if (hourOfDay == 24) {
                            hourOfDay = 0;
                        }
                        minute = 0;
                    }
                    mIgnoreEvent = true;
                    view.setCurrentMinute(minute);
                    mIgnoreEvent = false;
                }

                boolean validTime = true;
                if (hourOfDay < minHour || (hourOfDay == minHour && minute < minMinute)) {
                    validTime = false;
                }

                if (hourOfDay > maxHour || (hourOfDay == maxHour && minute > maxMinute)) {
                    validTime = false;
                }

                if (validTime) {
                    selectedHour = hourOfDay;
                    selectedMinute = minute;
                }
                setTimeIn24HourFormat(selectedHour, selectedMinute);
            }
        });


        LinearLayout linear_bottom = new LinearLayout(activity);
        linear_match_match.topMargin = 8;
        linear_bottom.setLayoutParams(linear_match_match);
        linear_bottom.setPadding(5, 5, 5, 5);

        btn_set = new Button(activity);
        button_params.setMargins(5, 0, 0, 0);
        btn_set.setLayoutParams(button_params);
        btn_set.setText("Set");
        btn_set.setId(SET);
        btn_set.setOnClickListener(this);
//        btn_set.setTypeface(ContactsContract.Contacts.Data.getFont(activity));
        btn_set.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        btn_set.setTextColor(activity.getResources().getColorStateList(R.color.colorPrimary));
//        btn_set.setBackgroundResource(R.drawable.main_interaction_btn_selector);


        btn_cancel = new Button(activity);
        btn_cancel.setLayoutParams(button_params);
        btn_cancel.setText("Cancel");
        btn_cancel.setId(CANCEL);
        btn_cancel.setOnClickListener(this);
//        btn_cancel.setTypeface(ContactsContract.Contacts.Data.getFont(activity));
        btn_cancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        btn_cancel.setTextColor(activity.getResources().getColorStateList(R.color.colorAccent));
//        btn_cancel.setBackgroundResource(R.drawable.light_grey_btn_selector);

        linear_bottom.addView(btn_cancel);
        linear_bottom.addView(btn_set);

//        linear_child.addView(linear_top);
        linear_datePicker.addView(datePicker);
        linear_child.addView(linear_datePicker);
        linear_child.addView(timePicker);
        linear_child.addView(linear_bottom);
        scrollView.addView(linear_child);
        linear_main.addView(scrollView);


        return linear_main;
    }

    public void setTimePickerIntervalInMinutes(int intervalMinutes) {
        timePickerIntervalInMinutes = intervalMinutes;
    }

    public void setMin(int hour, int minute) {
        minHour = hour;
        minMinute = minute;
    }

    public void setMax(int hour, int minute) {
        maxHour = hour;
        maxMinute = minute;
    }

    public void showDialog() {
        if (!dialog.isShowing()) {
            if (calendar_date == null)
                calendar_date = Calendar.getInstance();


            selectedMinute = calendar_date.get(Calendar.MINUTE);
            selectedHour = calendar_date.get(Calendar.HOUR_OF_DAY);
            Log.i("Selected Mionutes", "==" + selectedMinute);
            Log.i("Selected Hours1", "==" + selectedHour);

            timePicker.setIs24HourView(is24HourView);
            mIgnoreEvent = true;
            timePicker.setCurrentMinute(calendar_date.get(Calendar.MINUTE));
            mIgnoreEvent = false;
            Log.i("Selected Hours2", "==" + selectedHour);
            timePicker.setCurrentHour(calendar_date.get(Calendar.HOUR_OF_DAY));


            setMin(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE));
            setMax(24, 60);

            datePicker.updateDate(calendar_date.get(Calendar.YEAR),
                    calendar_date.get(Calendar.MONTH),
                    calendar_date.get(Calendar.DATE));

            dialog.show();
        }
    }

    public void setAutoDismiss(boolean isAutoDismiss) {
        this.isAutoDismiss = isAutoDismiss;
    }

    public void dismissDialog() {
        if (!dialog.isShowing())
            dialog.dismiss();
    }

    public void setDate(Calendar calendar) {
        if (calendar != null)
            calendar_date = calendar;
    }

    public void setDate(Date date) {
        if (date != null) {
            calendar_date = Calendar.getInstance();
            calendar_date.setTime(date);
        }
    }

    public void setDate(int year, int month, int day) {
        if (month < 12 && month >= 0 && day < 32 && day >= 0 && year > 100
                && year < 3000) {
            calendar_date = Calendar.getInstance();
            calendar_date.set(year, month, day);
        }

    }

    public void setTimeIn24HourFormat(int hourIn24Format, int minute) {
        if (hourIn24Format < 24 && hourIn24Format >= 0 && minute >= 0
                && minute < 60) {
            if (calendar_date == null)
                calendar_date = Calendar.getInstance();

            calendar_date.set(calendar_date.get(Calendar.YEAR),
                    calendar_date.get(Calendar.MONTH),
                    calendar_date.get(Calendar.DAY_OF_MONTH), hourIn24Format,
                    minute);

            is24HourView = true;
        }
    }

    public void setTimeIn12HourFormat(int hourIn12Format, int minute,
                                      boolean isAM) {
        if (hourIn12Format < 13 && hourIn12Format > 0 && minute >= 0
                && minute < 60) {
            if (hourIn12Format == 12)
                hourIn12Format = 0;

            int hourIn24Format = hourIn12Format;

            if (!isAM)
                hourIn24Format += 12;

            if (calendar_date == null)
                calendar_date = Calendar.getInstance();

            calendar_date.set(calendar_date.get(Calendar.YEAR),
                    calendar_date.get(Calendar.MONTH),
                    calendar_date.get(Calendar.DAY_OF_MONTH), hourIn24Format,
                    minute);

            is24HourView = false;
        }
    }

    public void set24HourFormat(boolean is24HourFormat) {
        is24HourView = is24HourFormat;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case SET:
            if (iCustomDateTimeListener != null) {
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                int day = datePicker.getDayOfMonth();
                if (Build.VERSION.SDK_INT == 21) {
                    Log.i("SDK version", "===" + Build.VERSION.SDK_INT);
                    selectedHour = timePicker.getCurrentHour();
                    selectedMinute = timePicker.getCurrentMinute();
                }


                Log.e("===","==="+selectedHour);

                calendar_date.set(year, month, day, selectedHour,
                        selectedMinute);
                //calendar_date.set(Calendar.AM_PM,timePicker.getA);
                if(calendar_date.get(Calendar.HOUR_OF_DAY) < 12) {
                    AM_PM = "AM";
                } else {
                    AM_PM = "PM";
                }
                Log.e("AM_PM",""+AM_PM);
                Log.e("===","==="+calendar_date.get(Calendar.HOUR_OF_DAY));
                calendar_date.get(Calendar.AM_PM);

                Date currDate = Calendar.getInstance().getTime();
                Date selectedDate = calendar_date.getTime();
                long diff = selectedDate.getTime() - currDate.getTime();

                //  if (diff > 0) {
                iCustomDateTimeListener.onSet(dialog, calendar_date,
                        calendar_date.getTime(), calendar_date
                                .get(Calendar.YEAR),
                        getMonthFullName(calendar_date.get(Calendar.MONTH)),
                        getMonthShortName(calendar_date.get(Calendar.MONTH)),
                        calendar_date.get(Calendar.MONTH), calendar_date
                                .get(Calendar.DAY_OF_MONTH),
                        getWeekDayFullName(calendar_date
                                .get(Calendar.DAY_OF_WEEK)),
                        getWeekDayShortName(calendar_date
                                .get(Calendar.DAY_OF_WEEK)), calendar_date
                                .get(Calendar.HOUR_OF_DAY),
                        getHourIn12Format(calendar_date
                                .get(Calendar.HOUR_OF_DAY)), calendar_date
                                .get(Calendar.MINUTE), calendar_date
                                .get(Calendar.SECOND), AM_PM);
                if (dialog.isShowing() && isAutoDismiss) {
                    dialog.dismiss();
                }
                // } else {

                //    new DialogPopup().alertPopup(activity, "", "Cannot select time before current time.");
//					Toast.makeText(activity, "Cannot select time before current time", Toast.LENGTH_SHORT).show();
                //   }
            }

            break;

            case CANCEL:
                if (iCustomDateTimeListener != null)
                    iCustomDateTimeListener.onCancel();
                if (dialog.isShowing())
                    dialog.dismiss();
                break;
        }
    }

    private String getMonthFullName(int monthNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, monthNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
        simpleDateFormat.setCalendar(calendar);
        String monthName = simpleDateFormat.format(calendar.getTime());

        return monthName;
    }

    private String getMonthShortName(int monthNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, monthNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
        simpleDateFormat.setCalendar(calendar);
        String monthName = simpleDateFormat.format(calendar.getTime());

        return monthName;
    }

    private String getWeekDayFullName(int weekDayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, weekDayNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        simpleDateFormat.setCalendar(calendar);
        String weekName = simpleDateFormat.format(calendar.getTime());

        return weekName;
    }

    private String getWeekDayShortName(int weekDayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, weekDayNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE");
        simpleDateFormat.setCalendar(calendar);
        String weekName = simpleDateFormat.format(calendar.getTime());

        return weekName;
    }

    private int getHourIn12Format(int hour24) {
        int hourIn12Format = 0;

        if (hour24 == 0)
            hourIn12Format = 12;
        else if (hour24 <= 12)
            hourIn12Format = hour24;
        else
            hourIn12Format = hour24 - 12;

        return hourIn12Format;
    }

    private String getAMPM(Calendar calendar) {
//        String ampm = (calendar.get(Calendar.AM_PM) == (Calendar.AM)) ? "AM"
//                : "PM";
//        return ampm;
        return "";
    }

    private void resetData() {
        calendar_date = null;
        is24HourView = true;
    }

    public interface ICustomDateTimeListener {
        public void onSet(Dialog dialog, Calendar calendarSelected,
                          Date dateSelected, int year, String monthFullName,
                          String monthShortName, int monthNumber, int date,
                          String weekDayFullName, String weekDayShortName, int hour24,
                          int hour12, int min, int sec, String AM_PM);

        public void onCancel();
    }
}