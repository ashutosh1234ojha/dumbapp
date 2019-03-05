package com.dummyapp.oreo.pip;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Rational;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/30/18.
 */

public class PictureInPictureActivity extends AppCompatActivity {

    private LinearLayout ll;
    Button btn;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_in_picture);

        ll=findViewById(R.id.ll);


         btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(Build.VERSION.SDK_INT>26){

                    try {
                        Rational rational=new Rational(ll.getWidth(),ll.getHeight());
                        PictureInPictureParams mParams=new  PictureInPictureParams.Builder()
                                .setAspectRatio(rational)
                                .build();

                        enterPictureInPictureMode(mParams);
                    }catch (Exception e){

                    }
                }else {
                    Toast.makeText(PictureInPictureActivity.this, "only supported in >26", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onPictureInPictureModeChanged(final boolean isInPictureInPictureMode, final Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        if(isInPictureInPictureMode){
            btn.setVisibility(View.GONE);
        }else {
            btn.setVisibility(View.VISIBLE);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
