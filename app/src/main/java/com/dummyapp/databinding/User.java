package com.dummyapp.databinding;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Ashutosh Ojha on 4/25/18.
 */

public class User {

    private String name;
    private String surname;
    private String status;
    private boolean isOnline;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(final boolean online) {
        isOnline = online;
    }

    FileOutputStream fileOutputStream;

    {
        try {
            fileOutputStream = new FileOutputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
