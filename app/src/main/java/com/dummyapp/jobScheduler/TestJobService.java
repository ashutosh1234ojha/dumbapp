package com.dummyapp.jobScheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

/**
 * Created by Ashutosh Ojha on 5/24/18.
 */
public class TestJobService extends JobService {
    private static final String TAG = "SyncService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Intent service = new Intent(getApplicationContext(), LocalWordService.class);
        service.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getApplicationContext().startActivity(service);
        Util.scheduleJob(getApplicationContext()); // reschedule the job
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
