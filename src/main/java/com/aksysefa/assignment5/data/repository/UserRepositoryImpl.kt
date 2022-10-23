package com.aksysefa.assignment5.data.repository


import com.aksysefa.assignment5.data.local.database.UserDatabase
import com.aksysefa.assignment5.data.model.Users
import com.aksysefa.assignment5.data.remote.api.ApiService
import retrofit2.Call

class UserRepositoryImpl constructor(
    private val apiService: ApiService,
    private val userDatabase: UserDatabase
): UserRepository {
        override fun getUsers(): Call<List<Users>> {
            return apiService.getUsers()
        }
    }

