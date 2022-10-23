package com.aksysefa.assignment5.data.repository

import com.aksysefa.assignment5.data.local.database.PostsDatabase
import com.aksysefa.assignment5.data.local.database.entity.PostEntity
import com.aksysefa.assignment5.data.remote.api.ApiService
import com.aksysefa.assignment5.data.model.Post
import retrofit2.Call



class PostRepositoryImpl constructor(
    private val apiService: ApiService,
    private val postsDatabase: PostsDatabase
) : PostRepository {
    override fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }

    override fun getPostById(id: Int): PostEntity? {
        return postsDatabase.postDao().getPostById(id.toString())
    }

    override fun insertFavoritePost(post: PostEntity) {
        return postsDatabase.postDao().insert(post)
    }

    override fun deleteFavoritePost(post: PostEntity) {
        return postsDatabase.postDao().delete(post)
    }
}