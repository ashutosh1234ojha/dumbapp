package com.dummyapp.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by cl-macmini-86 on 8/18/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<ViewPagerFragment> fragmentList;
    private List<String> titleList;


    public ViewPagerAdapter(final FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(final int position) {
        ViewPagerFragment fragment = fragmentList.get(position);
        fragment.setPosition(position);
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void setList(List<ViewPagerFragment> fragmentList, final List<String> titleList) {
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return titleList.get(position);
    }
}
