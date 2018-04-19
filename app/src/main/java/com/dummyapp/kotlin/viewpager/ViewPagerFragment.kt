package com.dummyapp.kotlin.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dummyapp.R
import kotlinx.android.synthetic.main.fragment_viewpager.view.*

/**
 * Created by cl-macmini-86 on 9/27/17.
 */
class ViewPagerFragment : Fragment() {

    var position: Int = 0



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parentView: View = inflater?.inflate(R.layout.fragment_viewpager, container, false) as View
        init(parentView)
        return parentView
    }

    private fun init(parentView: View) {

        parentView.tvText.text = "position sdfdsdfsdf $position"
    }

     fun setVluePosition(p: Int) {
        position = p
    }
}