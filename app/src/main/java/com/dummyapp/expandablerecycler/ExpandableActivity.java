package com.dummyapp.expandablerecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dummyapp.R;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 3/22/18.
 */

public class ExpandableActivity extends AppCompatActivity {

    private RecyclerView rvHeader;
    private LinearLayoutManager linearLayoutManager;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        init();

    }

    private void init() {
        rvHeader=findViewById(R.id.rvHeader);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rvHeader.setLayoutManager(linearLayoutManager);
        categoryAdapter=new CategoryAdapter();
        rvHeader.setAdapter(categoryAdapter);

        ArrayList<Category> categoryArrayList=new ArrayList<>();



        ////First
        ArrayList<SubCategory> subCategoryArrayList1=new ArrayList<>();
        SubCategory subCategory1=new SubCategory();
        subCategory1.setSubCategory("apple");

        SubCategory subCategory2=new SubCategory();
        subCategory2.setSubCategory("orange");

        subCategoryArrayList1.add(subCategory1);
        subCategoryArrayList1.add(subCategory2);

        Category category1=new Category();
        category1.setHeader("Fruit");
        category1.setSubList(subCategoryArrayList1);

        categoryArrayList.add(category1);


        ///Second
        ArrayList<SubCategory> subCategoryArrayList2=new ArrayList<>();
        SubCategory subCategory11=new SubCategory();
        subCategory11.setSubCategory("pen");

        SubCategory subCategory22=new SubCategory();
        subCategory22.setSubCategory("book");

        subCategoryArrayList2.add(subCategory11);
        subCategoryArrayList2.add(subCategory22);

        Category category11=new Category();
        category11.setHeader("Stationary");
        category11.setSubList(subCategoryArrayList2);

        categoryArrayList.add(category11);


        categoryAdapter.setData(categoryArrayList);
    }
}
