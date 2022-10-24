package com.aksoysefa.week5_assignment.data.repository

import com.aksoysefa.week5_assignment.data.remote.ApiService
import com.aksoysefa.week5_assignment.data.remote.ApiServiceUser
import com.aksoysefa.week5_assignment.ui.model.Users
import retrofit2.Call

class UserRepositoryImpl constructor(
    private val apiServiceUser: ApiServiceUser
) : UserRepository {
    override fun getUsers(): Call<List<Users>> {
        return apiServiceUser.getUsers()
    }
}