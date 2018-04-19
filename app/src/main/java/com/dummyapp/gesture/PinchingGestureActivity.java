package com.dummyapp.gesture;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 8/4/17.
 */

public class PinchingGestureActivity extends AppCompatActivity {

    private ImageView ivGestureDetection;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();
    private float scale = 1f;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinching_gesture);

        ivGestureDetection = (ImageView) findViewById(R.id.ivGestureDetection);



        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
    }

    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            if(scale>=1){
                matrix.setScale(scale, scale);
                ivGestureDetection.setImageMatrix(matrix);
            }else {
                Toast.makeText(PinchingGestureActivity.this, "smaller than original not allowed", Toast.LENGTH_SHORT).show();
            }

            return true;
        }
    }
}
