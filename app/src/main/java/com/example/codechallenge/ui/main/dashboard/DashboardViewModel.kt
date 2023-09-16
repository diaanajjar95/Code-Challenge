package com.example.codechallenge.ui.main.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.data.news.NewsDataSource
import com.example.codechallenge.domain.common.IsNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DashboardViewModel"

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val isNetworkAvailable: IsNetworkAvailable,
    private val newsRepository: NewsDataSource,
) : ViewModel() {

    init {
        fetchNews()
    }

    private val _newsState = MutableStateFlow<List<NewsEntity>>(mutableListOf())
    val newsState: StateFlow<List<NewsEntity>> = _newsState

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                if (isNetworkAvailable()) {
                    Log.d(TAG, "fetchNews: network available")
                    newsRepository.getMostPopularNews()
                }else{
                    Log.d(TAG, "fetchNews: network is not available")
                }
                _newsState.value = newsRepository.newsList.first()
            } catch (e: Exception) {
                _newsState.value = mutableListOf()
            }
        }
    }

}