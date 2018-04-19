package com.dummyapp.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.dummyapp.R
import kotlinx.android.synthetic.main.activity_kotlin_main.*

class MainKotlinActivity : AppCompatActivity(), View.OnClickListener {


    //    private var etEmail: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

        init()
    }


    fun init() {
//        etEmail = findViewById(R.id.etEmail) as EditText



        //Initialization
        btnSignIn.setOnClickListener(this)



    }

    override fun onClick( v: View?) {


        when (v?.id) {
            R.id.btnSignIn ->

                if (isValid()) {

                    val myArray = arrayListOf<String>("Jan", "Feb", "March")

                    val intent = Intent(this, SubKotlinActivity::class.java)
                    intent.putStringArrayListExtra("array", myArray)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "check credentials", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun isValid(): Boolean {
         var v:Int=4



        val email = etEmail?.text.toString()
        val password = etPassword?.text.toString()

        return email == "a1@a1.com" && password == "qwerty"



    }
}

