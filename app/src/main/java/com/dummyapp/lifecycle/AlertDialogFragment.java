package com.dummyapp.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dummyapp.R;

/**
 * Created by Ashutosh Ojha on 2/6/18.
 */

public class AlertDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_stack_view, container, false);
        return view;
    }
}
