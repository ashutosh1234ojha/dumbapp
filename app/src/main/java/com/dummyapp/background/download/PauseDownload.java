package com.dummyapp.background.download;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by Ashutosh Ojha on 4/19/18.
 */

public class PauseDownload extends ResultReceiver {
    public PauseDownload(final Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(final int resultCode, final Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);

    }
}
