package com.aksysefa.assignment5.data.repository

import com.aksysefa.assignment5.data.local.database.entity.PostEntity
import com.aksysefa.assignment5.data.model.Post
import retrofit2.Call


interface PostRepository {
    fun getPosts(): Call<List<Post>>
    fun getPostById(id: Int): PostEntity?
    fun insertFavoritePost(post: PostEntity)
    fun deleteFavoritePost(post: PostEntity)
}