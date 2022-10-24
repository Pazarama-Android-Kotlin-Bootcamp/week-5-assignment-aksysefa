package com.aksoysefa.week5_assignment.data.remote

import com.aksoysefa.week5_assignment.ui.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceUser {
    @GET("users")
    fun getUsers(): Call<List<Users>>
}