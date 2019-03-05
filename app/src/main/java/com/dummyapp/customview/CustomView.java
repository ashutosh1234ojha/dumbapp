package com.dummyapp.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 12/8/17.
 */

public class CustomView extends View {
    float dim;
    int shape;
    private Paint paint;
    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;

    public CustomView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        paint.setColor(ContextCompat.getColor(context, R.color.colorBlue));
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        try {
            dim = a.getDimension(R.styleable.CustomView_dim, 20f);
            shape = a.getInteger(R.styleable.CustomView_shape, 0);
        } finally {
            a.recycle();
        }
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        switch (shape) {
            case CIRCLE:
                canvas.drawCircle(dim, dim, dim, paint);
                break;
            case SQUARE:
                canvas.drawRect(0, 0, dim, dim, paint);
                break;
        }
    }
}
