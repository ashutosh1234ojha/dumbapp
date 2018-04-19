package com.dummyapp.kotlin.viewpager

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.dummyapp.R

/**
 * Created by cl-macmini-86 on 9/26/17.
 */
class ViewPagerActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private var fragmentsList: MutableList<ViewPagerFragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)


        init()
    }

    private fun init() {
        fragmentsList = mutableListOf<ViewPagerFragment>()
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        val adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)


        fragmentsList?.add(ViewPagerFragment())
        fragmentsList?.add(ViewPagerFragment())
        fragmentsList?.add(ViewPagerFragment())


        adapter.setList(fragmentsList!!)
        viewPager?.adapter = adapter
    }
}