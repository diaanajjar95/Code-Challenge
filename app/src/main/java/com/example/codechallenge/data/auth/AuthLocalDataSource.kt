package com.example.codechallenge.data.auth

import com.example.codechallenge.data.models.AppUser
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun login(email: String, password: String)

    suspend fun register(user: AppUser)

    suspend fun getRegisteredUser(): Flow<AppUser?>

    suspend fun logout()

}