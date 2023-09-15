package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.MostPopularResponse
import com.example.codechallenge.data.source.remote.ApiEndPoints
import com.example.codechallenge.data.source.remote.DefaultResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRemoteDataSourceImpl @Inject constructor(
    private val apiEndPoints: ApiEndPoints,
) : NewsRemoteDataSource {

    override suspend fun getMostPopularNews(): DefaultResponse<MostPopularResponse> {
        return try {
            DefaultResponse.create(
                apiEndPoints.getMostPopularNews()
            )
        } catch (e: Exception) {
            DefaultResponse.create(e)
        }
    }


}