package com.dummyapp.ViewTypeRecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 10/17/17.
 */

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<String> list = new ArrayList<>();
    private Button btnReset;
    private boolean listShowing = true;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        btnReset = (Button) findViewById(R.id.btnReset);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerViewAdapter(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        btnReset.setOnClickListener(this);


        setList();
        recyclerAdapter.setData(list);
    }

    void setList() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        list.add("twelve");
        list.add("thirteen");
        list.add("fourteen");
        list.add("fifteen");
        list.add("sixteen");
        list.add("seventeen");
        list.add("eighteen");
        list.add("19");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        list.add("33");
        list.add("34");
        list.add("35");
        list.add("36");
        list.add("37");
        list.add("38");
        list.add("39");
        list.add("40");
        list.add("41");
        list.add("42");
    }

    void clearList() {
        list.clear();
    }

    @Override
    public void onClick(final View view) {

        switch (view.getId()) {

            case R.id.btnReset:

                if (listShowing) {
                    clearList();

                } else {
                    setList();
                }
                recyclerAdapter.setData(list);
                listShowing = !listShowing;

                break;
        }
    }
}
