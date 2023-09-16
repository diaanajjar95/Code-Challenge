package com.example.codechallenge.data.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.codechallenge.data.models.AppUser
import com.example.codechallenge.di.DatabaseMoshi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


interface UserDataStore {

    fun getUser(): Flow<AppUser?>

    suspend fun saveUser(user: AppUser)

    suspend fun deleteUser()

}

class UserDataStoreImpl @Inject constructor(
    @DatabaseMoshi moshi: Moshi,
    private val dataStore: DataStore<Preferences>,
) : UserDataStore {

    private val userAdapter: JsonAdapter<AppUser> = moshi.adapter(AppUser::class.java)

    override fun getUser(): Flow<AppUser?> {
        return dataStore.data
            .map { preferences ->
                val jsonString = preferences[USER_KEY]
                try {
                    jsonString?.let { userAdapter.fromJson(it) }
                } catch (e: IOException) {
                    null
                }
            }
    }

    override suspend fun saveUser(user: AppUser) {
        dataStore.edit { preferences ->
            val jsonString = userAdapter.toJson(user)
            preferences[USER_KEY] = jsonString
        }
    }

    override suspend fun deleteUser() {
        dataStore.edit { preferences ->
            preferences.remove(USER_KEY)
        }
    }

    companion object {
        private val USER_KEY = stringPreferencesKey("user_key")
    }
}