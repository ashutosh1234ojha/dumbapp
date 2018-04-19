package com.dummyapp.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dummyapp.R

/**
 * Created by cl-macmini-86 on 9/19/17.
 */
class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var dataList: ArrayList<String>? = null
    private var callBack:ClickCallBack?=null

    init {
        mContext = context
        callBack=context as ClickCallBack
    }


    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.tvDateCell?.text = dataList?.get(position)

        holder?.tvDateCell?.setOnClickListener( {

            callBack?.setOnClick(position)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false)

        return MyViewHolder(view)
    }


    class MyViewHolder(viewType: View) : RecyclerView.ViewHolder(viewType) {


        var tvDateCell: TextView = viewType.findViewById<TextView>(R.id.tvDateCell)

    }

    fun setData(list: ArrayList<String>) {
        dataList = list
        notifyDataSetChanged()
    }

}