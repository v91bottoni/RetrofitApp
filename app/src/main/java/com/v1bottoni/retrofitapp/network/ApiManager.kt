package com.v1bottoni.retrofitapp.network


import com.v1bottoni.retrofitapp.service.UserService
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        val retrofit = Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()


        val userService = retrofit.create(UserService::class.java)
    }
}