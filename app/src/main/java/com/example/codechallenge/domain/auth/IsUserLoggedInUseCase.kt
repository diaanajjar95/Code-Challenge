package com.example.codechallenge.domain.auth

import com.example.codechallenge.data.auth.AuthDataSource
import javax.inject.Inject

class IsUserLoggedInUseCase @Inject constructor(
    private val authRepository: AuthDataSource,
) {

    suspend operator fun invoke(): Boolean {
        val user = authRepository.isLoggedIn("", "")
        return user?.let {
            true
        } ?: kotlin.run {
            false
        }
    }

}