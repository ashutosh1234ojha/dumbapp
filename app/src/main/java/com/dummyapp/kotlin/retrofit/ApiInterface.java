package com.dummyapp.kotlin.retrofit;

import com.dummyapp.kotlin.modal.PrivacyPolicy;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cl-macmini-86 on 9/29/17.
 *
 * AIzaSyDWuURyI7cT9FCRvn2izM7u4PvIjtafoMA
 */

public interface ApiInterface {

    @GET("get_req_cause_pref?api_key=special-key")
    Call<PrivacyPolicy> getPrivacyPolicy();

}
