package com.example.codechallenge.data.source.remote

import com.example.codechallenge.data.models.MostPopularResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndPoints {

    @GET("mostpopular/v2/viewed/30.json")
    suspend fun getMostPopularNews(): Response<MostPopularResponse>

}