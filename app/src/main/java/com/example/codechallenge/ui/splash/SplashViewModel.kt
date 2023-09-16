package com.example.codechallenge.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.data.auth.AuthDataSource
import com.example.codechallenge.domain.auth.IsUserLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase,
    private val authRepository: AuthDataSource,
) : ViewModel() {

    private val _navigate = MutableSharedFlow<Boolean>(replay = 1)
    val navigate: SharedFlow<Boolean> = _navigate

    fun checkNavigate() {
        viewModelScope.launch {
            delay(2000)

            authRepository.getRegisteredUser().collectLatest {
                Log.d("TAGTAG", "checkNavigate: user : $it")
                it?.let {
                    _navigate.tryEmit(true)
                } ?: kotlin.run {
                    _navigate.tryEmit(false)
                }
            }
        }
    }

}