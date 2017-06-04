package com.hrupin.twitterandroid.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Igor Khrupin www.hrupin.com on 6/4/17.
 */
interface TwitterAPI {

    @POST("/Registrations/")
    fun registration(@Body body: Map<String, String>): Call<String>
}