package com.v1bottoni.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.v1bottoni.retrofitapp.model.User
import com.v1bottoni.retrofitapp.network.ApiManager
import com.v1bottoni.retrofitapp.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Error

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    lateinit var userService : UserService
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchUser()
    }

    private fun fetchUser() {
        userService = ApiManager.userService

        userService.getUser().enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    user = response.body()
                    Log.d(TAG, "SUCCESS: $user")
                }else{
                    Log.d(TAG, "Error: ${response.code()} body: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
               Log.d(TAG, t.localizedMessage ?: "Stacce!!!!")
            }

        })
    }
}