package com.dummyapp.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/10/18.
 */

public class ContainerActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout flContainer;
    private Button btnOne, btnTwo, btnThree;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        flContainer = findViewById(R.id.flContainer);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);


        if(savedInstanceState!=null){

            switch (savedInstanceState.getString("visibleFragment","TagTwo")){
                case "TagThree":
                    threeTransaction();
                    break;

                case "TagTwo":
                    twoTransaction();
                    break;

                case "TagOne":
                    oneTransaction();
                    break;
            }
        }else {
            oneTransaction();

        }

    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnOne:
                oneTransaction();

                break;
            case R.id.btnTwo:
                twoTransaction();



                break;
            case R.id.btnThree:
                threeTransaction();


                break;
        }
    }

    private void threeTransaction() {

        Bundle bundle3=new Bundle();
        bundle3.putString("name","three");

        ContanerFragment contanerFragment3=new ContanerFragment();
        contanerFragment3.setArguments(bundle3);
        getFragmentManager().beginTransaction().replace(R.id.flContainer,contanerFragment3,"TagThree").commit();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void twoTransaction() {

        Bundle bundle2=new Bundle();
        bundle2.putString("name","two");

        ContanerFragment contanerFragment2=new ContanerFragment();
        contanerFragment2.setArguments(bundle2);
        getFragmentManager().beginTransaction().replace(R.id.flContainer,contanerFragment2,"TagTwo").commit();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }

    private void oneTransaction() {

        Bundle bundle1=new Bundle();
        bundle1.putString("name","one");

        ContanerFragment contanerFragment1=new ContanerFragment();
        contanerFragment1.setArguments(bundle1);

        getFragmentManager().beginTransaction().replace(R.id.flContainer,contanerFragment1,"TagOne").commit();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    @Override
    public void onSaveInstanceState(final Bundle outState, final PersistableBundle outPersistentState) {

        android.support.v4.app.Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.flContainer);
        outState.putString("visibleFragment","TagTwo");
        super.onSaveInstanceState(outState, outPersistentState);
    }

//    @Override
//    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        String tag=savedInstanceState.getString("visibleFragment");
//
//        Log.d("tag",tag);
//    }
}
