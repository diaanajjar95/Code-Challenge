package com.example.codechallenge.ui.auth.register

data class RegisterUiState(
    val fieldValidation: Pair<EnumField, String>? = null,
    val isLoading: Boolean = false,
    val navigate: Boolean = false,
)