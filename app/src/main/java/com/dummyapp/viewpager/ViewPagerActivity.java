package com.dummyapp.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cl-macmini-86 on 8/18/17.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<ViewPagerFragment> fragmentsList;
    private TabLayout tabLayout;
    private Button btnAddNewFragment, btnRemoveNewFragment;
    private List<String> titleList;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        init();
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        btnAddNewFragment = (Button) findViewById(R.id.btnAddNewFragment);
        btnRemoveNewFragment = (Button) findViewById(R.id.btnRemoveNewFragment);
        tabLayout.setupWithViewPager(viewPager);
        fragmentsList = new ArrayList<>();
        titleList = new ArrayList<>();

        btnAddNewFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                tabLayout.addTab(tabLayout.newTab());

                fragmentsList.add(new ViewPagerFragment());
                titleList.add("Two  " + fragmentsList.size());
                viewPagerAdapter.setList(fragmentsList, titleList);
                viewPagerAdapter.notifyDataSetChanged();


            }
        });

        btnRemoveNewFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                tabLayout.removeTabAt(titleList.size() - 1);

                fragmentsList.remove(fragmentsList.size() - 1);
                viewPagerAdapter.setList(fragmentsList, titleList);
                viewPagerAdapter.notifyDataSetChanged();
            }
        });


        fragmentsList.add(new ViewPagerFragment());
        titleList.add("One");

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setList(fragmentsList, titleList);
        viewPager.setAdapter(viewPagerAdapter);


//        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
//        tabOne.setText("ONE");
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.filter, 0, 0);
//        tabLayout.getTabAt(0).setCustomView(tabOne);

    }


}
