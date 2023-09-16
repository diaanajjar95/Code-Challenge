package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsDataSource {

    val newsList: Flow<List<NewsEntity>>

    suspend fun getMostPopularNews()

}