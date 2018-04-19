package com.dummyapp.background.download;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Ashutosh Ojha on 4/17/18.
 */

public class DownloadService extends IntentService {

    private static String file_url = "https://api.androidhive.info/progressdialog/hive.jpg";
    String url1="https://www.google.co.in/imgres?imgurl=https://static.pexels.com/photos/248797/pexels-photo-248797.jpeg&imgrefurl=https://www.pexels.com/search/nature/&h=1000&w=2500&tbnid=mVrwcCQle9g31M:&tbnh=142&tbnw=" +
            "355&usg=__CnFETdy-h4rlfcnE-ycGQXfBbcs%3D&vet=10ahUKEwjv2bKE5MPaAhUGr48KHROjDPIQ_B0IwAEwEA..i&docid=ShwNVOdFBcmkxM&itg=" +
            "1&sa=X&ved=0ahUKEwjv2bKE5MPaAhUGr48KHROjDPIQ_B0IwAEwEA";
    public static final int UPDATE_PROGRESS=0;

    public DownloadService() {
        super("");
    }


    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {


        download(intent);
    }

    private void download(final Intent intent) {

        String urlToDownload = intent.getStringExtra("url");
        ResultReceiver receiver = (ResultReceiver) intent.getParcelableExtra("receiver");
        try {
            URL url = new URL(file_url);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream("/sdcard/BarcodeScanner-debug.jpg");

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt("progress" ,(int) (total * 100 / fileLength));
                receiver.send(UPDATE_PROGRESS, resultData);
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bundle resultData = new Bundle();
        resultData.putInt("progress" ,100);
        receiver.send(UPDATE_PROGRESS, resultData);
    }


}
