package com.aksysefa.assignment5.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.aksysefa.assignment5.data.local.database.base.BaseDao
import com.aksysefa.assignment5.data.local.database.entity.PostEntity
import com.aksysefa.assignment5.utils.Constants


@Dao
interface PostDao : BaseDao<PostEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME}")
    fun getAllPosts(): List<PostEntity>

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun getPostById(postId: String): PostEntity?

}