package com.dummyapp;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Ashutosh Ojha on 5/11/18.
 */

public class JunitTest1 {


        FirstDayAtSchool school = new FirstDayAtSchool();
        String[] bag = {"Books", "Notebooks", "Pens"};

        @Test
        public void testPrepareMyBag() {
            System.out.println("Inside testPrepareMyBag()");
            assertArrayEquals(bag, school.prepareMyBag());

    }
}
