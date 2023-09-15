package com.example.codechallenge.data.auth

import com.example.codechallenge.data.models.AppUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface AuthDataSource : AuthLocalDataSource

@Singleton
class AuthDataSourceImpl @Inject constructor(
    private val localDataSource: AuthLocalDataSource,
) : AuthDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isLoggedIn(email: String, password: String) : AppUser?{
        return withContext(Dispatchers.IO) {
            localDataSource.isLoggedIn(email,password)
        }
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

}