package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cl-macmini-86 on 6/13/17.
 */

public class PopupWindowActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private PopupWindow mPopupWindow;
    private LinearLayout ll;
    private TextView tvOne;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);
        ll=(LinearLayout)findViewById(R.id.ll);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.popupwindow,null);
        tvOne=(TextView)customView.findViewById(R.id.tvOne)    ;
        tvOne.setOnClickListener(this);
        button=(Button)findViewById(R.id.button);

        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(PopupWindowActivity.this, "one", Toast.LENGTH_SHORT).show();
            }
        });

        mPopupWindow = new PopupWindow(customView, (int) getResources().getDimension(R.dimen._156dp),
                (int) getResources().getDimension(R.dimen._220dp), false);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mPopupWindow.dismiss();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mPopupWindow.showAsDropDown(button);
            }
        });


    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()){
            case R.id.tvOne:
//                 Toast.makeText(PopupWindowActivity.this, "one", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
