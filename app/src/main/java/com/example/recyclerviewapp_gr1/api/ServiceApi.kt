package com.example.recyclerviewapp_gr1.api

import com.example.recyclerviewapp_gr1.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {

    @GET("users")
    fun getUsers() : Call<List<User>>
}