package com.dummyapp.downloadfile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dummyapp.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cl-macmini-86 on 9/28/17.
 */

public class DownloadMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProgressBar, btnShareImage;
    private ImageView my_image;
    // Progress Dialog
    private ProgressDialog pDialog;
    public static final int progress_bar_type = 0;

    // File url to download
    private static String file_url = "https://api.androidhive.info/progressdialog/hive.jpg";
    private String imageFilePath;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_download);

        init();
    }

    private void init() {
        btnProgressBar = (Button) findViewById(R.id.btnProgressBar);
        btnShareImage = (Button) findViewById(R.id.btnShareImage);
        my_image = (ImageView) findViewById(R.id.my_image);

        btnProgressBar.setOnClickListener(this);
        btnShareImage.setOnClickListener(this);
    }

    /**
     * Showing Dialog
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }


    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnProgressBar:
                new DownloadFileFromURL().execute(file_url);
                break;

            case R.id.btnShareImage:
                shareWithEmail();
                break;
        }
    }

    /**
     * This method share referral code on mail
     */
    private void shareWithEmail() {


        //For image
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpg");

        share.putExtra(Intent.EXTRA_STREAM, Uri.parse(file_url));

        startActivity(Intent.createChooser(share, "Share Image"));


//For text
//        Intent share = new Intent(Intent.ACTION_SEND);
//        share.setType("text/plain");
//        share.putExtra(Intent.EXTRA_TEXT, "I'm being sent!!");
//        startActivity(Intent.createChooser(share, "Share Text"));

    }

    /**
     * Background Async Task to download file
     */
    private class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                // this will be useful so that you can show a tipical 0-100% progress bar
                int lengthOfFile = connection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream to write the data to destination
                OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);

            // Displaying downloaded image into image view
            // Reading image path from sdcard
            String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
            // setting downloaded into image view

            imageFilePath = imagePath;
            my_image.setImageDrawable(Drawable.createFromPath(imagePath));
        }

    }
}
