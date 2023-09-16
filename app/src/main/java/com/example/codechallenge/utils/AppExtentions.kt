package com.example.codechallenge.utils

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(this).matches()
}

fun String.isStrongPassword(): Boolean {
    val uppercasePattern = Regex("[A-Z]")
    val symbolPattern = Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?]+")

    return length >= 8 && uppercasePattern.containsMatchIn(this) && symbolPattern.containsMatchIn(this)
}