package com.aksysefa.assignment5.data.local.database.dao

import androidx.room.Query
import com.aksysefa.assignment5.data.local.database.entity.UserEntity
import com.aksysefa.assignment5.utils.Constants

interface UserDao {

    @Query("SELECT * FROM ${Constants.TABLE_USER_NAME}")
    fun getAllUser(): List<UserEntity>

    @Query("DELETE FROM ${Constants.TABLE_USER_NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_USER_NAME} WHERE id =:Id")
    fun getUserById(Id: Int): UserEntity?
}