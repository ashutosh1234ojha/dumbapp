package com.dummyapp.lifecycle;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 2/5/18.
 */

public class ActivityLifeCycle extends AppCompatActivity {
    private static final String TAG = "Activity";
    private EditText etOne, etTwo;
    private Button btn;
    private FragmentLifeCycle fragmentLifeCycle;
    private FragmentLifeCycleOne fragmentLifeCycleOne;
    private FragmentLifeCycleTwo fragmentLifeCycleTwo;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");


        fragmentLifeCycle = new FragmentLifeCycle();
        fragmentLifeCycleOne = new FragmentLifeCycleOne();
        fragmentLifeCycleTwo = new FragmentLifeCycleTwo();
        etOne = findViewById(R.id.etOne);
        etTwo = findViewById(R.id.etTwo);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLifeCycle.this);

                View view1 = getLayoutInflater().inflate(R.layout.three_button_custom_alert, null);
                builder.setView(view1);

                TextView tvLeftSide = view1.findViewById(R.id.tvLeftSide);

                tvLeftSide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        Toast.makeText(ActivityLifeCycle.this, "tv", Toast.LENGTH_SHORT).show();
                    }
                });
//                builder.setView(getLayoutInflater().inflate(R.layout.three_button_custom_alert, null));

                builder.setMessage("msg");
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, final int i) {

                    }
                });

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, final int i) {

                    }
                });


//                builder.show();

//                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
//                alertDialogFragment.show(getSupportFragmentManager(), "tag");


                Dialog dialog = new Dialog(ActivityLifeCycle.this);
                dialog.setTitle("sadf");
                dialog.show();


            }
        });

        count++;
        getSupportFragmentManager().beginTransaction().add(R.id.fl, fragmentLifeCycle).addToBackStack("zero").commit();
        count++;
//        getSupportFragmentManager().beginTransaction().add(R.id.fl, fragmentLifeCycleOne).addToBackStack("one").commit();
        count++;
//        getSupportFragmentManager().beginTransaction().add(R.id.fl, fragmentLifeCycleTwo).addToBackStack("two").commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        FragmentManager fragmentManager = getSupportFragmentManager();

//        if(count==3)
//        {
//            fragmentManager.beginTransaction().remove(fragmentLifeCycleTwo).commit();
//            count--;
//        }else if(count==2){
//            fragmentManager.beginTransaction().remove(fragmentLifeCycleOne).commit();
//            count--;
//        }else if(count==1){
//            fragmentManager.beginTransaction().remove(fragmentLifeCycle).commit();
//            count--;
//        }else {
//
//        }

        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().getBackStackEntryAt(2);
//            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        if (isFinishing()) {
            Log.e(TAG, "is finishing");

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaved");
        outState.putString("one", etOne.getText().toString());
        outState.putString("two", etTwo.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestore");
        etOne.setText(savedInstanceState.getString("one"));
        etTwo.setText(savedInstanceState.getString("two"));
    }

}
