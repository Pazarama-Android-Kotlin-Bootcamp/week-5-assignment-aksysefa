package com.aksysefa.assignment5.data.remote.api

import com.aksysefa.assignment5.data.model.Post
import com.aksysefa.assignment5.data.model.Users
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("users")
    fun getUsers(): Call<List<Users>>

    @DELETE("posts/{id}")
    fun deletePost(@Path("{id}") id: String): Call<Post>
}
