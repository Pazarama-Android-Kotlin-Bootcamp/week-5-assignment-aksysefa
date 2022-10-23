package com.aksysefa.assignment5.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aksysefa.assignment5.data.local.database.converter.DaoConverter
import com.aksysefa.assignment5.data.local.database.dao.PostDao
import com.aksysefa.assignment5.data.local.database.entity.UserEntity
import com.aksysefa.assignment5.utils.Constants

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(DaoConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): PostDao

    companion object {
        private var instance: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, UserDatabase::class.java, Constants.USER_TABLE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

    }
}