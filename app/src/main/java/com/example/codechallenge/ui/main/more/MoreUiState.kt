package com.example.codechallenge.ui.main.more

import com.example.codechallenge.data.models.AppUser

data class MoreUiState(
    val user: AppUser? = null,
    val isLoading: Boolean = false,
    val isLoggedOut: Boolean = false,
)