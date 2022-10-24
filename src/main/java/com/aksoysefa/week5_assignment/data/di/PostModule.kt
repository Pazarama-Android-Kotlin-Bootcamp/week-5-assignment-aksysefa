package com.aksoysefa.week5_assignment.data.di

import com.aksoysefa.week5_assignment.data.local.database.PostsDatabase
import com.aksoysefa.week5_assignment.data.remote.ApiService
import com.aksoysefa.week5_assignment.data.repository.PostRepository
import com.aksoysefa.week5_assignment.data.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class PostsModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providePostRepository(apiService: ApiService, postsDatabase: PostsDatabase): PostRepository {
        return PostRepositoryImpl(apiService,postsDatabase)
    }

}