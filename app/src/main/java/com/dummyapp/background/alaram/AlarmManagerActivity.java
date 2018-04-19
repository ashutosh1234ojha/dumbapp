package com.dummyapp.background.alaram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 3/12/18.
 */

public class AlarmManagerActivity extends AppCompatActivity {

    private TextView output;
    private Button btnClick;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        btnClick = findViewById(R.id.btnClick);
        output = findViewById(R.id.output);
        output.setText(3 + "");

        btnClick.setOnClickListener(view ->
                createAlarmManager()

        );
    }

    private void createAlarmManager() {

        int i= Integer.parseInt(output.getText().toString());
        Intent intent=new Intent(this,MyBroadcastManager.class);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,100,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);

        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();

//        String channelId = "id";
//        CharSequence channelName = "name";
//        int importance = NotificationManager.IMPORTANCE_MAX;
//        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
//
//        notificationChannel.setLightColor(Color.RED);
//        notificationChannel.enableVibration(true);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
//        builder.setSmallIcon(R.drawable.bitmap);
//
//        builder.setOngoing(true);
//
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.journaldev.com/"));
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, 0);
//        builder.setContentIntent(pendingIntent);
//        builder.setContentTitle("content title");
//        builder.setContentText("content textsfjklsjdaflkjsdlkfjlskdjflksdjflakjdflksdjf ksjadfklsdlfjsdjflklkasdfj sakldjflsadjkfl");
//        builder.setSubText("sub text aslkdfjsdlkfj klsadjflksdjf aklsdjflasjdf;lafadfka;j dfasdjflksadjfsl dflska dfjlaksdjflafj");
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.createNotificationChannel(notificationChannel);
//        notificationManager.createNotificationChannelGroup();
//        notificationManager.notify(1, builder.build());


    }
}
