package com.example.codechallenge.di

import com.example.codechallenge.ui.base.binding.BindingAdapters
import com.example.codechallenge.ui.base.binding.BindingAdaptersImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideBindingAdapters(): BindingAdapters {
        return BindingAdaptersImpl()
    }

}