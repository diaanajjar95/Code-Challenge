package com.example.codechallenge.data.news

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsLocalDataSourceImpl @Inject constructor(
    // inject the Room instance
): NewsLocalDataSource {
}