package com.example.codechallenge.data.news

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsModule {

    @Binds
    @Singleton
    abstract fun bindNewsLocalDataSource(
        newsLocalDataSourceImpl: NewsLocalDataSourceImpl,
    ): NewsLocalDataSource

    @Binds
    @Singleton
    abstract fun bindNewsRemoteDataSource(
        newsRemoteDataSourceImpl: NewsRemoteDataSourceImpl,
    ): NewsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        newsDataSourceImpl: NewsDataSourceImpl,
    ): NewsDataSource

}