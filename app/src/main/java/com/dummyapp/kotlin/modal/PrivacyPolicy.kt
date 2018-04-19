package com.dummyapp.kotlin.modal

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by cl-macmini-86 on 9/29/17.
 */

class PrivacyPolicy {
    @SerializedName("message")
    @Expose
    val message: String? = null
    @SerializedName("status")
    @Expose
    val status: Int? = null
}
