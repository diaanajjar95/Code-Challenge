package com.example.codechallenge.data.auth

import com.example.codechallenge.data.models.AppUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthLocalDataSourceImpl @Inject constructor(
    private val userDataStore: UserDataStore,
) : AuthLocalDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: AppUser) {
        userDataStore.saveUser(user)
    }

    override suspend fun getRegisteredUser(): Flow<AppUser?> {
        return userDataStore.getUser()
    }

    override suspend fun logout() {
        userDataStore.deleteUser()
    }

}