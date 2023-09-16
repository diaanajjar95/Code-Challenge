package com.example.codechallenge.ui.main.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.data.auth.AuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val authRepository: AuthDataSource,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MoreUiState> = MutableStateFlow(MoreUiState())
    val uiState: StateFlow<MoreUiState> = _uiState.asStateFlow()

    fun fetchUser() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            delay(2000)

            authRepository.getRegisteredUser().collect { appUser ->

                _uiState.update {
                    it.copy(
                        user = appUser,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            delay(2000)
            authRepository.logout()
            _uiState.update {
                it.copy(
                    isLoggedOut = true,
                    isLoading = false
                )
            }
        }
    }
}