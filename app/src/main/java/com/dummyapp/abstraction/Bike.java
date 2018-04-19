package com.dummyapp.abstraction;

/**
 * Created by Ashutosh Ojha on 3/6/18.
 */

public class Bike extends PlusarBike {


    Bike() {

        ab();
    }


    @Override
    void ab() {

        PlusarBike.met();
    }


}
