package com.example.profileapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserService {
    private val BASE_URL = "https://randomuser.me/"
//    private val BASE_URL = "https://reqres.in/api/"

//    fun getUserService(): UserApi {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(UserApi::class.java)
//    }
    fun getUserService(): UserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

}