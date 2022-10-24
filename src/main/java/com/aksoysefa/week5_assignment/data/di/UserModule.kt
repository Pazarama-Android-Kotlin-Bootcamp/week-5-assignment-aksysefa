package com.aksoysefa.week5_assignment.data.di

import com.aksoysefa.week5_assignment.data.remote.ApiService
import com.aksoysefa.week5_assignment.data.remote.ApiServiceUser
import com.aksoysefa.week5_assignment.data.repository.UserRepository
import com.aksoysefa.week5_assignment.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class UsersModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiServiceUser {
        return retrofit.create(ApiServiceUser::class.java)
    }

    @Provides
    fun provideUserRepository(apiServiceUser: ApiServiceUser) : UserRepository {
        return UserRepositoryImpl(apiServiceUser)
    }
}