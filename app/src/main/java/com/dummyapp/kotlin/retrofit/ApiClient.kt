package com.dummyapp.kotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by cl-macmini-86 on 9/29/17.
 */

object ApiClient {

    //    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private val API_BASE_URL = "http://34.207.220.100:3000/"
    private var retrofit: Retrofit? = null


    val client: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit as Retrofit
        }



//    package info.androidhive.retrofit.rest;
//
//    import retrofit2.Retrofit;
//    import retrofit2.converter.gson.GsonConverterFactory;
//
//
//    public class ApiClient {
//
//        public static final String BASE_URL = "http://api.themoviedb.org/3/";
//        private static Retrofit retrofit = null;
//
//
//        public static Retrofit getClient() {
//            if (retrofit==null) {
//                retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//            }
//            return retrofit;
//        }
//    }
}
