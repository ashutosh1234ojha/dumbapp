package com.dummyapp.vectorAnimation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 7/17/17.
 */

public class VectorActivity extends AppCompatActivity {

    private int scaleNormal = 1, scaleBig = 2;
    private int previousSelected;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);


        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup radioGroup, @IdRes final int rb) {

                if (previousSelected != 0) {
                    findViewById(previousSelected).setScaleX(scaleNormal);
                    findViewById(previousSelected).setScaleY(scaleNormal);
                }
                findViewById(rb).setScaleX(scaleBig);
                findViewById(rb).setScaleY(scaleBig);
                previousSelected = rb;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_cut:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
