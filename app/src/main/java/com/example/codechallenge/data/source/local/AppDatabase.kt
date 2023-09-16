package com.example.codechallenge.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.data.source.local.daos.NewsDao

@Database(entities = [NewsEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}