package com.dummyapp.sqlite;

/**
 * Created by Ashutosh Ojha on 2/21/18.
 */

public class Contact {
    int id;
    String name;
    String phone;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }
}
