package com.dummyapp.background;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dummyapp.R;


/**
 * Created by cl-macmini-86 on 4/26/17.
 */

public class AsyncActivity extends AppCompatActivity {

    private Button btnClick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        btnClick=(Button)findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LongOperation longOperation=new LongOperation();
                longOperation.execute("");
//                longOperation.onProgressUpdate(1,2,3,4);

            }
        });
    }
    private class LongOperation extends AsyncTask<String, String, String> {
        TextView txt;

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i+"");
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText("Executed"); // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
             txt = (TextView) findViewById(R.id.output);
            txt.setText("Wait...");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

                txt.setText(values[0]);

        }
    }
}
