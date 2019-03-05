package com.dummyapp;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Ashutosh Ojha on 5/11/18.
 */

public class JunitTest2 {

    FirstDayAtSchool school = new FirstDayAtSchool();
    String[] bag = {"Books", "Notebooks", "Pens", "Pencils"};

    @Test
    public void testAddPencils() {
        System.out.println("Inside testAddPencils()");
        assertArrayEquals(bag, school.addPencils());
    }

}
