package com.dummyapp.swipeableview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;
import com.mindorks.placeholderview.PlaceHolderView;

/**
 * Created by cl-macmini-86 on 7/12/17.
 */

public class SwipeAbleViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipeable_view);

        PlaceHolderView mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);

// (Optional): If customisation is Required then use Builder with the PlaceHolderView
// placeHolderView.getBuilder()
//      .setHasFixedSize(false)
//      .setItemViewCacheSize(10)
//      .setLayoutManager(new GridLayoutManager(this, 3));

        mGalleryView
                .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, R.drawable.bitmap));
//        .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, R.drawable.bitmap))
//        .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, R.drawable.bitmap))
//        .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, R.drawable.bitmap));
    }
}
