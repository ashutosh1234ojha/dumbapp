package com.dummyapp.customCalender;

import java.util.Date;

/**
 * Created by cl-macmini-86 on 8/22/17.
 */

public class Task {
    private Date date;
    private boolean isChecked;

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(final boolean checked) {
        isChecked = checked;
    }
}
