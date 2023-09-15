package com.example.codechallenge.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.domain.auth.IsUserLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase,
) : ViewModel() {

    private val _navigate = MutableSharedFlow<Boolean>(replay = 1)
    val navigate: SharedFlow<Boolean> = _navigate

    fun checkNavigate() {
        viewModelScope.launch {
            delay(2000)
            val isLoggedIn = isUserLoggedInUseCase()
            _navigate.tryEmit(isLoggedIn)
        }
    }

}