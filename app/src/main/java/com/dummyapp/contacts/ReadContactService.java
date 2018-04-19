package com.dummyapp.contacts;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh Ojha on 10/24/17.
 */

public class ReadContactService extends IntentService {

    private Cursor cursor;
    private List<String> contactList = new ArrayList<>();

    public ReadContactService() {
        super("");
    }

    public ReadContactService(final String name) {
        super(name);
    }


    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {


        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


            contactList.add(name + " " + ":" + " " + phoneNumber);
        }


        Intent intent1 = new Intent();
        intent1.setAction("com.dummyapp.contacts");
        intent1.putExtra("size", contactList.size());
        intent1.putStringArrayListExtra("contact", (ArrayList<String>) contactList);
        sendBroadcast(intent1);


        cursor.close();

    }


}
