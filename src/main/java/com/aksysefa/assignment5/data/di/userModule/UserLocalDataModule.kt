package com.aksysefa.assignment5.data.di.userModule

import android.content.Context
import com.aksysefa.assignment5.data.local.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserLocalDataModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext appContext: Context): UserDatabase {
        return UserDatabase.getDatabase(appContext)
    }

    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase) = db.userDao()
}