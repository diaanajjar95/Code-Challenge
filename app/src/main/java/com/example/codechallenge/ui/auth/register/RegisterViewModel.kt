package com.example.codechallenge.ui.auth.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge.R
import com.example.codechallenge.data.auth.AuthDataSource
import com.example.codechallenge.data.models.AppUser
import com.example.codechallenge.utils.isStrongPassword
import com.example.codechallenge.utils.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val application: Application,
    private val authRepository: AuthDataSource,
) : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun register(
        fullName: String,
        email: String,
        nationalId: String,
        phoneNumber: String,
        dob: String,
        password: String,
    ) {

        // validation here
        if (fullName.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.FULL_NAME_FIELD,
                        application.getString(R.string.full_name_empty_error)
                    )
                )
            }
            return
        }

        if (email.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.EMAIL_FIELD,
                        application.getString(R.string.email_empty_error)
                    )
                )
            }
            return
        }

        if (!email.isValidEmail()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.EMAIL_FIELD,
                        application.getString(R.string.email_validation_error)
                    )
                )
            }
            return
        }

        if (nationalId.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.NATIONAL_ID_FIELD,
                        application.getString(R.string.national_id_empty_error)
                    )
                )
            }
            return
        }

        if (phoneNumber.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.PHONE_NUMBER_FIELD,
                        application.getString(R.string.phone_no_empty_error)
                    )
                )
            }
            return
        }

        if (dob.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.DATE_OF_BIRTH_FIELD,
                        application.getString(R.string.dob_empty_error)
                    )
                )
            }
            return
        }

        if (password.isEmpty()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.PASSWORD_FIELD,
                        application.getString(R.string.password_empty_error)
                    )
                )
            }
            return
        }

        if (!password.isStrongPassword()) {
            _uiState.update {
                it.copy(
                    fieldValidation = Pair(
                        EnumField.PASSWORD_FIELD,
                        application.getString(R.string.password_validation_error)
                    )
                )
            }
            return
        }

        _uiState.update {
            it.copy(
                isLoading = true
            )
        }

        val userToBeRegistered = AppUser(
            fullName = fullName,
            email = email,
            nationalId = nationalId,
            phone = phoneNumber,
            dateOfBirth = dob,
            password = password
        )

        // now we can register
        viewModelScope.launch {
            authRepository.register(userToBeRegistered)
            // check if the registration process has been successful then navigate to the main screen and save the user into data store

            delay(2000)

            _uiState.update {
                it.copy(
                    navigate = true,
                    isLoading = false,
                )
            }
        }
    }
}

enum class EnumField {
    FULL_NAME_FIELD,
    EMAIL_FIELD,
    NATIONAL_ID_FIELD,
    PHONE_NUMBER_FIELD,
    DATE_OF_BIRTH_FIELD,
    PASSWORD_FIELD,
}