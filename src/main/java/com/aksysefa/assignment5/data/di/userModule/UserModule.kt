package com.aksysefa.assignment5.data.di.userModule

import com.aksysefa.assignment5.data.local.database.UserDatabase
import com.aksysefa.assignment5.data.remote.api.ApiService
import com.aksysefa.assignment5.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class UserModule {


    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providePostRepository(apiService: ApiService, userDatabase: UserDatabase) : UserRepositoryImpl {
        return UserRepositoryImpl(apiService, userDatabase)
    }
}