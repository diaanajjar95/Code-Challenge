package com.example.codechallenge.data.auth

import com.example.codechallenge.data.models.AppUser
import com.example.codechallenge.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface AuthDataSource : AuthLocalDataSource

@Singleton
class AuthDataSourceImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val localDataSource: AuthLocalDataSource,
) : AuthDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: AppUser) {
        withContext(dispatcher) {
            localDataSource.register(user)
        }
    }

    override suspend fun getRegisteredUser(): Flow<AppUser?> {
        return withContext(dispatcher) {
            localDataSource.getRegisteredUser()
        }
    }

    override suspend fun logout() {
        withContext(dispatcher) {
            localDataSource.logout()
        }
    }

}