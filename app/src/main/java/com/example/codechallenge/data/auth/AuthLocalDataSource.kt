package com.example.codechallenge.data.auth

import com.example.codechallenge.data.models.AppUser

interface AuthLocalDataSource {

    suspend fun login(email: String, password: String)

    suspend fun register(email: String, password: String)

    suspend fun isLoggedIn(email: String, password: String) : AppUser?

    suspend fun logout()

}