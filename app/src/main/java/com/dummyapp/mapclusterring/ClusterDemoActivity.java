package com.dummyapp.mapclusterring;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dummyapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.maps.android.clustering.ClusterManager;

/**
 * Created by cl-macmini-86 on 9/21/17.
 *
 * https://medium.com/@tonyshkurenko/work-with-clustermanager-bdf3d70fb0fd
 */

public class ClusterDemoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private ClusterManager<ClusterItemObject> mClusterManager;
    private CustomClusterRenderer renderer;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster_demo);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        this.googleMap = googleMap;

        mClusterManager = new ClusterManager<>(this, googleMap);
        renderer = new CustomClusterRenderer(this, googleMap, mClusterManager);



        googleMap.setOnCameraIdleListener(mClusterManager);
        googleMap.setOnMarkerClickListener(mClusterManager);
        googleMap.setOnInfoWindowClickListener(mClusterManager);
        addPersonItems();
        mClusterManager.cluster();
        mClusterManager.setRenderer(renderer);
    }

    private void addPersonItems() {
        for (int i = 0; i < 3; i++) {
            mClusterManager.addItem(new ClusterItemObject(-26.187616, 28.079329, "PJ", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new ClusterItemObject(-26.207616, 28.079329, "PJ2", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new ClusterItemObject(-26.217616, 28.079329, "PJ3", "https://twitter.com/pjapplez"));
        }
    }
}
