package com.example.profileapplication.api

//import com.example.profileapplication.data.User
//import com.example.profileapplication.data.UserList
import com.example.profileapplication.data.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api")
    suspend fun getUser(
        @Query("results") results: Int
    ): Response<User>

//    @GET("users")
//    suspend fun getUser(): Response<UserList>


//    companion object{
//        const val BASE_URL = "https://api.unsplash.com/"
//    }

}