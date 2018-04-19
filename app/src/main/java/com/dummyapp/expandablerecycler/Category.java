package com.dummyapp.expandablerecycler;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 3/30/18.
 */

public class Category {
   private String header;
   private boolean isShown;
   private ArrayList<SubCategory> subList;

    public String getHeader() {
        return header;
    }

    public void setHeader(final String header) {
        this.header = header;
    }

    public ArrayList<SubCategory> getSubList() {
        return subList;
    }

    public void setSubList(final ArrayList<SubCategory> subList) {
        this.subList = subList;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(final boolean shown) {
        isShown = shown;
    }
}
