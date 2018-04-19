package com.dummyapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 4/10/18.
 */

public class ContanerFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_container, container, false);
        TextView textView=view.findViewById(R.id.tvName);
        textView.setText(getArguments().getString("name"));
        return view;
    }
}
