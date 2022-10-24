package com.aksoysefa.week5_assignment.data.repository

import com.aksoysefa.week5_assignment.ui.model.Users
import retrofit2.Call

interface UserRepository {
    fun getUsers(): Call<List<Users>>
}