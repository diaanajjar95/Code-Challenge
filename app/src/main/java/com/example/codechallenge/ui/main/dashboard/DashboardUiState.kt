package com.example.codechallenge.ui.main.dashboard

import com.example.codechallenge.data.models.NewsEntity

data class DashboardUiState(
    val newsList: List<NewsEntity> = listOf(),
    val isLoading: Boolean = false,
    val message: String? = null,
)