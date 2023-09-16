package com.example.codechallenge.ui.main

import androidx.lifecycle.ViewModel
import com.example.codechallenge.data.news.NewsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepository: NewsDataSource,
) : ViewModel() {


}