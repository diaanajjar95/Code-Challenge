package com.example.codechallenge.utils

import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.abs

fun String.isValidEmail(): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(this).matches()
}

fun String.isStrongPassword(): Boolean {
    val uppercasePattern = Regex("[A-Z]")
    val symbolPattern = Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?]+")

    return length >= 8 && uppercasePattern.containsMatchIn(this) && symbolPattern.containsMatchIn(
        this
    )
}

fun String.calculateTimeAgo(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val currentDate = Calendar.getInstance().time
    val date = dateFormat.parse(this)

    if (date != null) {
        val diffMillis = abs(currentDate.time - date.time)
        val diffDays = diffMillis / (1000 * 60 * 60 * 24)

        return when {
            diffDays == 1L -> "1 day ago"
            diffDays > 1L -> "$diffDays days ago"
            else -> "today"
        }
    }

    return "unknown"
}