package com.example.codechallenge.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.data.source.remote.DefaultResponse
import com.example.codechallenge.domain.news.GetMostPopularNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMostPopularNewsUseCase: GetMostPopularNewsUseCase,
) : ViewModel() {


    fun getMostPopularNews() {
        viewModelScope.launch {
            when (val result = getMostPopularNewsUseCase()) {
                is DefaultResponse.Fail -> {
                    Log.d(TAG, "getMostPopularNews: ${result.error}")
                }

                is DefaultResponse.Success -> {
                    Log.d(TAG, "getMostPopularNews: ${result.body}")
                }
            }
        }
    }

}