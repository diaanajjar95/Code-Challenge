package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.MostPopularResponse
import com.example.codechallenge.data.source.remote.DefaultResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSourceImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource,
) : NewsDataSource {

    override suspend fun getMostPopularNews(): DefaultResponse<MostPopularResponse> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getMostPopularNews()
        }
    }

}