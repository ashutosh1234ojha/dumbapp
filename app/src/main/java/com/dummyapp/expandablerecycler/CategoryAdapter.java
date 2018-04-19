package com.dummyapp.expandablerecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CustomViewHolder> {

    private ArrayList<Category> categoriesList;
    private Context context;

    @Override
    public CustomViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_category, parent, false);
        context=parent.getContext();

        return  new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {

        holder.tvCategory.setText(categoriesList.get(position).getHeader());


        holder.tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(categoriesList.get(position).isShown()){
                    holder.rvSubCategory.setVisibility(View.GONE);
                    categoriesList.get(position).setShown(false);
                }else {
                    holder.rvSubCategory.setVisibility(View.VISIBLE);
                    categoriesList.get(position).setShown(true);

                }
            }
        });

        SubCategoryAdapter subCategoryAdapter=new SubCategoryAdapter();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        holder.rvSubCategory.setLayoutManager(linearLayoutManager);
        holder.rvSubCategory.setAdapter(subCategoryAdapter);
        subCategoryAdapter.setData(categoriesList.get(position).getSubList());
    }

    public void setData(final ArrayList<Category> categories) {
        this.categoriesList = categories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return categoriesList != null ? categoriesList.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory;
        private RecyclerView rvSubCategory;

        public CustomViewHolder(final View itemView) {
            super(itemView);

            tvCategory = itemView.findViewById(R.id.tvCategory);
            rvSubCategory = itemView.findViewById(R.id.rvSubCategory);
        }
    }
}
