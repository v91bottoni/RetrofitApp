package com.v1bottoni.retrofitapp.service

import com.v1bottoni.retrofitapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users/1")
    fun getUser(): Call<User>
}