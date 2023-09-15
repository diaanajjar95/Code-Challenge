package com.example.codechallenge.domain.auth

import com.example.codechallenge.data.auth.AuthDataSource
import com.example.codechallenge.data.models.AppUser
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthDataSource,
) {

    suspend operator fun invoke(user: AppUser) {

    }

}