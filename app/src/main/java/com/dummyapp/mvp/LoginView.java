package com.dummyapp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 9/21/17.
 */

public class LoginView extends AppCompatActivity implements ViewCallBack {

    private EditText etEmail, etPassword;
    private Button btnSignIn;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        init();
    }
    private void init() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
    }

    @Override
    public void emailCheck() {

    }

    @Override
    public void passwordCheck() {

    }

    @Override
    public void buttonCheck() {

    }
}
