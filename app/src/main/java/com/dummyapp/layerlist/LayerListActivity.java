package com.dummyapp.layerlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;
import com.dummyapp.SubActivity;

/**
 * Created by cl-macmini-86 on 7/24/17.
 */

public class LayerListActivity extends AppCompatActivity {

    private Button btnLauncher;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layerlist);

        btnLauncher=(Button)findViewById(R.id.btnLauncher);
        btnLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(LayerListActivity.this, SubActivity.class));
            }
        });


    }
}
