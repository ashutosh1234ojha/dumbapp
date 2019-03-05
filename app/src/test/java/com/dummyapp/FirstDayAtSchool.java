package com.dummyapp;

import java.util.Arrays;

/**
 * Created by Ashutosh Ojha on 5/11/18.
 */

public class FirstDayAtSchool {




        public String[] prepareMyBag() {
            String[] schoolbag = {"Books", "Notebooks", "Pens"};
            System.out.println("My school bag contains: "+ Arrays.toString(schoolbag));
            return schoolbag;
        }

        public String[] addPencils() {
            String[] schoolbag = {"Books", "Notebooks", "Pens", "Pencils"};
            System.out.println("Now my school bag contains: "+Arrays.toString(schoolbag));
            return schoolbag;
        }
    }


