package com.example.codechallenge.data.models

data class AppUser(
    val email: String,
    val password: String,
    val phone: String,
    val nationalId: String,
    val dateOfBirth: String,
)