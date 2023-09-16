package com.example.codechallenge.data.models

data class AppUser(
    val fullName: String,
    val email: String,
    val nationalId: String,
    val phone: String,
    val dateOfBirth: String,
    val password: String,
)