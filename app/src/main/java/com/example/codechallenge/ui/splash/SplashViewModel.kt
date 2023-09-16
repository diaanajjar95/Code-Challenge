package com.example.codechallenge.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.data.auth.AuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthDataSource,
) : ViewModel() {

    private val _navigate = MutableSharedFlow<Boolean>(replay = 1)
    val navigate: SharedFlow<Boolean> = _navigate

    fun checkNavigate() {
        viewModelScope.launch {
            delay(2000)

            authRepository.getRegisteredUser().collectLatest {
                it?.let {
                    _navigate.tryEmit(true)
                } ?: kotlin.run {
                    _navigate.tryEmit(false)
                }
            }
        }
    }
}