package com.example.codechallenge.data.news

import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.data.source.local.daos.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao,
) : NewsLocalDataSource {

    private val _newList: Flow<List<NewsEntity>> = newsDao.getAllNews()

    override val newsList: Flow<List<NewsEntity>>
        get() = _newList

    override suspend fun refreshNewsItems(newsList: MutableList<NewsEntity>) {
//        newsDao.deleteAllNews()
        newsDao.insertAllNews(*newsList.toTypedArray())
    }

}