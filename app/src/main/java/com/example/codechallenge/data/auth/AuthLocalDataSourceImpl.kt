package com.example.codechallenge.data.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.codechallenge.data.models.AppUser
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : AuthLocalDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isLoggedIn(email: String, password: String): AppUser? {
        // get the user from data store and return it
        return null
//        return AppUser("", "", "", "", "")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

}