package com.dummyapp.stackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.StackView;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh Ojha on 12/6/17.
 */

public class StackViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        StackView sv =(StackView) findViewById(R.id.stackView);

        sv.setInAnimation(this, android.R.animator.fade_in);
        sv.setOutAnimation(this, android.R.animator.fade_out);

        StackViewAdapter albumsAdapter =
                new StackViewAdapter(getStores(),R.layout.item_stack_view,
                        StackViewActivity.this);

        sv.setAdapter(albumsAdapter);

    }

    private List<String> getStores(){
        List<String> stores = new ArrayList<String>();
        stores.add("apple");
        stores.add("htc");
        stores.add("samsung");
        stores.add("lg");
        stores.add("sony");
        stores.add("nokia");
        stores.add("panasonic");
        return stores;
    }
}
