package com.dummyapp.mapclusterring;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

/**
 * Created by cl-macmini-86 on 9/21/17.
 */

public class CustomClusterRenderer extends DefaultClusterRenderer<ClusterItemObject> {

    private final Context mContext;

    public CustomClusterRenderer(Context context, GoogleMap map,
                                 ClusterManager<ClusterItemObject> clusterManager) {
        super(context, map, clusterManager);

        mContext = context;
    }

    @Override protected void onBeforeClusterItemRendered(ClusterItemObject item, MarkerOptions markerOptions) {
        final BitmapDescriptor markerDescriptor =
        BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);

//        markerOptions.icon(markerDescriptor).snippet(item.getName());
    }
}
