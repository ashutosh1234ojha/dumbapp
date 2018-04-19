package com.dummyapp.swipeableview;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dummyapp.R;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by cl-macmini-86 on 7/12/17.
 */


@NonReusable
@Layout(R.layout.gallery_item_big)
public class ImageTypeBig {

    @View(R.id.imageView)
    private ImageView imageView;

    private int mUrl;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ImageTypeBig(Context context, PlaceHolderView placeHolderView, int url) {
        mContext = context;
        mPlaceHolderView = placeHolderView;
        mUrl = url;
    }

    @Resolve
    private void onResolved() {
        Glide.with(mContext).load(mUrl).into(imageView);
    }

    @LongClick(R.id.imageView)
    private void onLongClick(){
        mPlaceHolderView.removeView(this);
    }

}