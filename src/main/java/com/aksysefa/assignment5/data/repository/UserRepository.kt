package com.aksysefa.assignment5.data.repository

import com.aksysefa.assignment5.data.model.Users
import retrofit2.Call

interface UserRepository {
    fun getUsers(): Call<List<Users>>
}