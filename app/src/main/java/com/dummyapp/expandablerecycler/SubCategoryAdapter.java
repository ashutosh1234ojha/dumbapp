package com.dummyapp.expandablerecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dummyapp.R;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 3/22/18.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.CustomViewHolder> {

    private ArrayList<SubCategory> subCategoryArrayList;

    @Override
    public CustomViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_sub_category, parent, false);

        return  new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {

        holder.tvSubCategory.setText(subCategoryArrayList.get(position).getSubCategory());
    }

    public void setData(final ArrayList<SubCategory> subCategories) {
        this.subCategoryArrayList = subCategories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return subCategoryArrayList != null ? subCategoryArrayList.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSubCategory;

        public CustomViewHolder(final View itemView) {
            super(itemView);

            tvSubCategory = itemView.findViewById(R.id.tvSubCategory);
        }
    }
}
