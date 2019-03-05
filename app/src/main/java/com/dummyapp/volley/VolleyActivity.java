package com.dummyapp.volley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dummyapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Ashutosh Ojha on 6/14/18.
 */
public class VolleyActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
    private Gson gson;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

//        init();

        findViewById(R.id.btn).setOnClickListener(view -> {
            init();
        });



        findViewById(R.id.btn).setOnClickListener(v->{

        });
    }

    private void init() {


        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        requestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {


                Toast.makeText(VolleyActivity.this, "" + response, Toast.LENGTH_SHORT).show();

                Users users = gson.fromJson(response, Users.class);
//                List<Users.User> users = Arrays.asList(gson.fromJson(response, Users.User[].class));

//                Log.i("PostActivity", users.size() + " posts loaded.");
                for (Users.User user : users.getUsers()) {
                    Log.i("PostActivity", user.getEmail() + ": " + user.getName());
                }
            }


        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(final VolleyError error) {
                Toast.makeText(VolleyActivity.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        });


        requestQueue.add(stringRequest);


    }

}
