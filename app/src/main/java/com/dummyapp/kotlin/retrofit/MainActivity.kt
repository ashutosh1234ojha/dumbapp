package com.dummyapp.kotlin.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

import com.dummyapp.R
import com.dummyapp.kotlin.modal.PrivacyPolicy

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by cl-macmini-86 on 9/29/17.
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private fun apiHitMethod() {


        val apiService = ApiClient.client.create(ApiInterface::class.java)

        val call = apiService.privacyPolicy
        call.enqueue(object : Callback<PrivacyPolicy> {
            override fun onResponse(call: Call<PrivacyPolicy>, response: Response<PrivacyPolicy>) {

                val privacyPolicy = response.body()
                Log.d(TAG, "Number of movies received: " + privacyPolicy.message!!)
                Log.d(TAG, "Number of movies received: " + privacyPolicy.status!!)
            }

            override fun onFailure(call: Call<PrivacyPolicy>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tvCheck -> apiHitMethod()
        }
    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName

        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY = ""
    }
}
