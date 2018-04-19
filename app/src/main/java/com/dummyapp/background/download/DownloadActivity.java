package com.dummyapp.background.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dummyapp.MainActivity;
import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/17/18.
 */

public class DownloadActivity extends AppCompatActivity {

    private Button btn;
    private ProgressBar progress_bar;
    private Notification.Builder notificationBuilder;
    private Integer notificationID = 100;
    private NotificationManager notificationManager;
    private Notification notification;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);

        btn = findViewById(R.id.btn);
        progress_bar = findViewById(R.id.progress_bar);
        btn.setOnClickListener(view -> {

//            startService(new Intent(this,DownloadService.class));

            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra("url", "your url to be downloaded");
            intent.putExtra("receiver", new DownloadReceiver(new Handler()));
            startService(intent);


        });

        setNotificationBuilder();






    }

    private void setNotificationBuilder() {

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        Intent intent=new Intent();
        intent.setAction("com.dummyapp.background.download");
        sendBroadcast(intent);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(DownloadActivity.this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder = new Notification.Builder(getApplicationContext());
        notificationBuilder.setOngoing(true)
//                .setContentTitle("Abc image ")
                .setContentText("Downloading")
                .setSmallIcon(R.drawable.bitmap)
                .addAction(R.drawable.ic_pause_black_24dp,"pause",pendingIntent)
                .addAction(R.drawable.ic_cancel_black_24dp,"pause",pendingIntent)
                .setProgress(100, 0, false);

        notification=notificationBuilder.build();


//        notification.contentView= new RemoteViews(getPackageName(),
//                R.layout.custom_notification);



        notificationManager.notify(notificationID, notification);





    }

    private class DownloadReceiver extends ResultReceiver {
        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                int progress = resultData.getInt("progress");
                progress_bar.setProgress(progress);

                notificationBuilder.setProgress(100, progress, false)
                        .setContentText("Downloaded");
                notificationManager.notify(notificationID, notificationBuilder.build());

                if (progress == 100) {

                    notificationBuilder.setProgress(0, 0, false)
                            .setContentText("Downloaded")
                            .setOngoing(false);


                    Intent intent=new Intent(DownloadActivity.this, MainActivity.class);
                    PendingIntent pendingIntent=PendingIntent.getActivity(DownloadActivity.this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    notificationBuilder.setContentIntent(pendingIntent);
                    notificationManager.notify(notificationID, notificationBuilder.build());

                    Toast.makeText(DownloadActivity.this, "Successfully downloaded", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public class PauseDownload extends ResultReceiver{

        public PauseDownload(final Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(final int resultCode, final Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);


            Toast.makeText(DownloadActivity.this, "asdf", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DownloadActivity.this, DownloadService.class);
            intent.putExtra("url", "your url to be downloaded");
            intent.putExtra("receiver", new DownloadReceiver(new Handler()));
            stopService(intent);
        }
    }
}
