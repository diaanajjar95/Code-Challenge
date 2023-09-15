package com.example.codechallenge.domain.auth

import com.example.codechallenge.data.auth.AuthDataSource
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthDataSource,
) {

    suspend operator fun invoke() {
        // just clear the data in the data store
    }

}