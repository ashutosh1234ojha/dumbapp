package com.dummyapp.constraintlayout;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.dummyapp.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ashutosh Ojha on 5/31/18.
 */
public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        ImageView earthImage = findViewById(R.id.earth_image);
        ImageView marsImage = findViewById(R.id.mars_image);
        ImageView saturnImage = findViewById(R.id.saturn_image);

        ValueAnimator earthAnimator = animatePlanet(earthImage, TimeUnit.SECONDS.toMillis(2));
        ValueAnimator marsAnimator = animatePlanet(marsImage, TimeUnit.SECONDS.toMillis(6));
        ValueAnimator saturnAnimator = animatePlanet(saturnImage, TimeUnit.SECONDS.toMillis(12));

        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                earthAnimator.start();
                marsAnimator.start();
                saturnAnimator.start();
            }
        });


    }

    private ValueAnimator animatePlanet(ImageView planet, long orbitDuration) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);
        anim.addUpdateListener(valueAnimator -> {
            int val = (Integer) valueAnimator.getAnimatedValue();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) planet.getLayoutParams();
            layoutParams.circleAngle = val;
            planet.setLayoutParams(layoutParams);
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);

        return anim;
    }
}
