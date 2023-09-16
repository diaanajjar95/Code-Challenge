package com.example.codechallenge.domain.news

import com.example.codechallenge.data.models.MostPopularResponse
import com.example.codechallenge.data.news.NewsDataSource
import com.example.codechallenge.data.source.remote.DefaultResponse
import javax.inject.Inject

class GetMostPopularNewsUseCase @Inject constructor(
    private val newsRepository: NewsDataSource,
) {

    suspend operator fun invoke()/*: DefaultResponse<MostPopularResponse>*/ {
//        return newsRepository.getMostPopularNews()
    }

}