package com.dummyapp.kotlin.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by cl-macmini-86 on 9/26/17.
 */
class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var fragmentList: List<ViewPagerFragment>? = null


    override fun getItem(position: Int): Fragment {

        val fragment = fragmentList?.get(position)
        fragment?.setVluePosition(position)
        return fragmentList?.get(position)!!
    }

    override fun getCount(): Int {

        return fragmentList?.size ?: 0
    }

    fun setList(fragmentsList: MutableList<ViewPagerFragment>) {
        this.fragmentList = fragmentsList
    }
}