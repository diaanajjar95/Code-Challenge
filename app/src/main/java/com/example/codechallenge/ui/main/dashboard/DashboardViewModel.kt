package com.example.codechallenge.ui.main.dashboard

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.R
import com.example.codechallenge.data.news.NewsDataSource
import com.example.codechallenge.domain.common.IsNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val application: Application,
    private val isNetworkAvailable: IsNetworkAvailable,
    private val newsRepository: NewsDataSource,
) : ViewModel() {

    init {
        fetchNews()
    }

    private val _uiState: MutableStateFlow<DashboardUiState> = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    private fun fetchNews() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            try {
                if (isNetworkAvailable()) {
                    newsRepository.getMostPopularNews()
                } else {
                    _uiState.update {
                        it.copy(
                            message = application.getString(R.string.offline_mode_message)
                        )
                    }
                }

                val newsList = newsRepository.newsList.first()
                _uiState.update {
                    it.copy(
                        newsList = newsList,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        newsList = mutableListOf()
                    )
                }
            }
        }
    }

    fun messageShown() {
        _uiState.update {
            it.copy(message = null)
        }
    }

}