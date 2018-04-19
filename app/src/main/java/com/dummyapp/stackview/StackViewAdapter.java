package com.dummyapp.stackview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dummyapp.R;

import java.util.List;

/**
 * Created by Ashutosh Ojha on 12/6/17.
 */

public class StackViewAdapter extends ArrayAdapter {

    private List<String> storesList;
    private Context context;
    private int itemLayout;

    public StackViewAdapter(List<String> stores, int resource, Context ctx) {
        super(ctx, resource, stores);
        storesList = stores;
        context = ctx;
        itemLayout = resource;
    }

    @Override
    public int getCount() {
        return storesList.size();
    }
    @Override
    public String getItem(int position) {
        return storesList.get(position);
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(itemLayout, parent, false);
        }

        String store = storesList.get(position);

        TextView storeName = (TextView) view.findViewById(R.id.store_name);
//        ImageView storeImg = (ImageView) view.findViewById(R.id.store_image);


        storeName.setText(store);
        int resId = context.getResources().getIdentifier(store,
                "drawable", context.getPackageName());
//        storeImg.setImageResource(resId);

        return view;
    }

}
