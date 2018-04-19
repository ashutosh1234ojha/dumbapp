package com.dummyapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashutosh Ojha on 2/21/18.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //DB Version
    private static final int DATABASE_VERSION=1;
    //DB Name
    private static final String DATABASE_NAME="contactsManager";
    //DB Table name
    private static final String TABLE_CONTACTS="contacts";
    private static final String KEY_ID="id";

    public DatabaseHandler(final Context context, final String name, final SQLiteDatabase.CursorFactory factory, final int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACTS_TABLE="CREATE TABLE";
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int i, final int i1) {

    }
}
