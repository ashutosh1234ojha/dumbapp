package com.dummyapp.mvvm.model;

import com.dummyapp.mvvm.utilities.StringUtility;

/**
 * Created by Ashutosh Ojha on 4/25/18.
 */

public class Cell {

    public Player player;


    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null || StringUtility.isNullOrEmpty(player.value);
    }
}
