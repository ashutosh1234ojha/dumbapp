package com.dummyapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect()  {
        assertEquals("asdf",8-6, 2);
        assertEquals("sdf",16, 10+ 5,
                0.1);
    }
}