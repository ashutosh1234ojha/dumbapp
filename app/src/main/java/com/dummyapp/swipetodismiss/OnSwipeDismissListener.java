package com.dummyapp.swipetodismiss;

import android.view.View;

/**
 * Created by Ashutosh Ojha on 12/20/17.
 */

public interface OnSwipeDismissListener {
    void onSwipeDismiss(View view, SwipeDismissDirection direction);
}
