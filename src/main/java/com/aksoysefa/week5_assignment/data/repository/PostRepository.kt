package com.aksoysefa.week5_assignment.data.repository

import com.aksoysefa.week5_assignment.data.local.database.entity.PostEntity
import com.aksoysefa.week5_assignment.ui.model.Post
import retrofit2.Call

interface PostRepository {
    fun getPosts(): Call<List<Post>>
    fun getPostById(id: Int): PostEntity?
    fun insertFavoritePost(post: PostEntity)
    fun deleteFavoritePost(id: String)
    fun getFavorites(): List<PostEntity>
}