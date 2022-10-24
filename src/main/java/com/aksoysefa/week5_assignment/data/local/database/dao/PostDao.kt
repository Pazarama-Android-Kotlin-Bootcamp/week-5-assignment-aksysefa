package com.aksoysefa.week5_assignment.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.aksoysefa.week5_assignment.data.local.database.base.BaseDao
import com.aksoysefa.week5_assignment.data.local.database.entity.PostEntity
import com.aksoysefa.week5_assignment.utils.Constants

@Dao
interface PostDao  : BaseDao<PostEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME}")
    fun getAllPosts(): List<PostEntity>

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun getPostById(postId: String): PostEntity?

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun deleteFavoriteById(postId: String)
}