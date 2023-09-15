package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.MostPopularResponse
import com.example.codechallenge.data.source.remote.DefaultResponse

interface NewsRemoteDataSource {

    suspend fun getMostPopularNews(): DefaultResponse<MostPopularResponse>

}