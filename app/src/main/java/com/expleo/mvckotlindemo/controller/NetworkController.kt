package com.expleo.mvckotlindemo.controller

import android.widget.Toast
import com.expleo.androidkotlintutorial.network.ApiService
import com.expleo.androidkotlintutorial.network.NetworkUtil
import com.expleo.mvckotlindemo.model.User
import com.expleo.mvckotlindemo.util.CustomCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkController() {

    fun getResponse(customCallback : CustomCallback) {

        var apiclass = NetworkUtil().getRetrofit().create(ApiService::class.java)

        var users = apiclass.getDOTOData()

        users.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                var myResponse = response.body()
                var title : String = myResponse.title

                customCallback.onSuccessResponse(title)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                customCallback.onFailureResponse()
            }
        })
    }
}