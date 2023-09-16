package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    val newsList: Flow<List<NewsEntity>>

    suspend fun refreshNewsItems(newsList: MutableList<NewsEntity>)

}