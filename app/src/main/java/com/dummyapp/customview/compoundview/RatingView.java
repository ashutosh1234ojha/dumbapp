package com.dummyapp.customview.compoundview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 12/21/17.
 */

public class RatingView extends RelativeLayout {

    private TextView facebookTv, yelpTv, foursquareTv;

    public RatingView(final Context context) {
        super(context, null);
        init();
    }

    public RatingView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public RatingView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RatingView(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        inflate(getContext(), R.layout.compound_view_rating, this);

        facebookTv = findViewById(R.id.facebookTv);
        yelpTv = findViewById(R.id.yelpTv);
        foursquareTv = findViewById(R.id.foursquareTv);


        facebookTv.setVisibility(GONE);
        yelpTv.setVisibility(GONE);
        foursquareTv.setVisibility(GONE);

//        facebookTv.setAlpha(0);
//        yelpTv.setAlpha(0);
//        foursquareTv.setAlpha(0);
    }


    public void setPOI(int fb, int yelp, int square) {
        if (fb > 0) {
            facebookTv.setVisibility(VISIBLE);
            facebookTv.setText(String.valueOf(fb));
        }

        if (yelp > 0) {
            yelpTv.setVisibility(VISIBLE);
            yelpTv.setText(String.valueOf(yelp));
        }
        if (square > 0) {
            foursquareTv.setVisibility(VISIBLE);
            foursquareTv.setText(String.valueOf(square));
        }

    }

}
