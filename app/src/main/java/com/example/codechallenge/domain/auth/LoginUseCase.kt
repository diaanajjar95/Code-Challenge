package com.example.codechallenge.domain.auth

import com.example.codechallenge.data.auth.AuthDataSource
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthDataSource,
) {

    suspend operator fun invoke(email: String, password: String) {

    }

}