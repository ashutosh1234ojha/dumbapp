package com.dummyapp.viewpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by cl-macmini-86 on 8/19/17.
 */

public class ViewPagerFragment extends Fragment {

    private LinearLayout llViewpagerFragment;
    private int position;
    private Activity activity;
    private TextView tvText;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        init(parentView);
        return parentView;
    }

    private void init(View parentView) {
        llViewpagerFragment = (LinearLayout) parentView.findViewById(R.id.llViewpagerFragment);
        tvText = (TextView) parentView.findViewById(R.id.tvText);

        tvText.setText("Position" + position);


    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }
}
