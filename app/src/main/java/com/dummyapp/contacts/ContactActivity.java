package com.dummyapp.contacts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cl-macmini-86 on 10/3/17.
 */

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnReadContact;
    private RecyclerView rvContacts;
    private ContactAdapter contactAdapter;
    private LinearLayoutManager layoutManager;
    private Cursor cursor;
    private List<String> contactList;
    private MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);


        init();
    }

    private void init() {
        btnReadContact = (Button) findViewById(R.id.btnReadContact);
        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        contactAdapter = new ContactAdapter(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        contactList = new ArrayList<>();
        btnReadContact.setOnClickListener(this);

        rvContacts.setAdapter(contactAdapter);
        rvContacts.setLayoutManager(layoutManager);


        IntentFilter filter = new IntentFilter("com.dummyapp.contacts");
        MyBroadCastReceiver myReceiver = new MyBroadCastReceiver();
        registerReceiver(myReceiver, filter);

    }

    public void GetContactsIntoArrayList() {

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


            contactList.add(name + " " + ":" + " " + phoneNumber);
        }

        contactAdapter.setData(contactList);

        cursor.close();

    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnReadContact:
//                GetContactsIntoArrayList();

//                ReadContactService readContactService=new ReadContactService(this)



                Intent intent = new Intent(this, ReadContactService.class);
                startService(intent);
                break;
        }
    }


    public class MyBroadCastReceiver extends BroadcastReceiver {


        public MyBroadCastReceiver() {

        }

        @Override
        public void onReceive(final Context context, final Intent intent) {

            if (intent != null) {
                Log.d("Contact", intent.getStringArrayListExtra("contact").toString());
                Log.d("Contact", intent.getIntExtra("size", 0) + "");

                contactAdapter.setData(intent.getStringArrayListExtra("contact"));
            } else {
                Log.d("Contact", "" + intent);
            }
        }
    }
}
