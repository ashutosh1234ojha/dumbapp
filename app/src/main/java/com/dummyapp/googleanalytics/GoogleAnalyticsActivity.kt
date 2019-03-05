package com.dummyapp.googleanalytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.dummyapp.MyApplication
import com.dummyapp.R
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker

/**
 * Created by Ashutosh Ojha on 6/8/18.
 */
class GoogleAnalyticsActivity : AppCompatActivity() {

//     var mTracker;
    var mTracker:Tracker?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_analytics)

        val application = application as MyApplication
        mTracker = application.getDefaultTracker()

        findViewById<TextView>(R.id.tvAdd).setOnClickListener(View.OnClickListener {
            mTracker?.setScreenName("Image~"+"GoogleAnalyticsActivity")
            mTracker?.send(HitBuilders.ScreenViewBuilder().build())
        })

    }


    override fun onResume() {
        super.onResume()

        mTracker?.setScreenName("Image~"+"GoogleAnalyticsActivity")
        mTracker?.send(HitBuilders.ScreenViewBuilder().build())
    }
}