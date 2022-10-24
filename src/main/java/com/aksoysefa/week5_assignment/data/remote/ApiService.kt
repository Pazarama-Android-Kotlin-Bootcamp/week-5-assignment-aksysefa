package com.aksoysefa.week5_assignment.data.remote

import com.aksoysefa.week5_assignment.ui.model.Post
import com.aksoysefa.week5_assignment.ui.model.Users
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @DELETE("posts/{id}")
    fun deletePost(@Path("{id}") id:String) : Call<Post>

}