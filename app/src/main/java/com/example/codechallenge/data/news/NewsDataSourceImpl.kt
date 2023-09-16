package com.example.codechallenge.data.news

import com.example.codechallenge.data.mappers.toEntity
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.data.source.remote.DefaultResponse
import com.example.codechallenge.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSourceImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource,
) : NewsDataSource {

    override val newsList: Flow<List<NewsEntity>>
        get() = localDataSource.newsList

    override suspend fun getMostPopularNews() {
        withContext(dispatcher) {
            val result = remoteDataSource.getMostPopularNews()
            if (result is DefaultResponse.Success) {
                val newsItems = result.body.newsList?.map {
                    it.toEntity()
                }?.toMutableList() ?: mutableListOf()
                localDataSource.refreshNewsItems(newsItems)
            }
        }
    }

}