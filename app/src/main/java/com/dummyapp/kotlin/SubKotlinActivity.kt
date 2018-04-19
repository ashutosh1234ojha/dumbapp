package com.dummyapp.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.dummyapp.R
import com.dummyapp.kotlin.modal.UserDetails
import kotlinx.android.synthetic.main.activity_sub_kotlin.*

/**
 * Created by cl-macmini-86 on 9/19/17.
 */
class SubKotlinActivity : AppCompatActivity(), ClickCallBack {


    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_kotlin)

        init()

        val myArray = intent.getStringArrayListExtra("array")

        tvValue.text = myArray[0]

        val user= UserDetails("ashutosh",11)
        val string:String=""
        Log.d("UserName",user.name)
        Log.d("UserAge", "${user.age}")
    }

    private fun init() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(applicationContext)
        val recyclerAdapter: RecyclerAdapter = RecyclerAdapter(this)
        val myArray = intent.getStringArrayListExtra("array")

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = recyclerAdapter
        recyclerAdapter.setData(myArray)
    }

    override fun setOnClick(position: Int) {

        Toast.makeText(this, "clicked " + position, Toast.LENGTH_SHORT).show()
    }
}