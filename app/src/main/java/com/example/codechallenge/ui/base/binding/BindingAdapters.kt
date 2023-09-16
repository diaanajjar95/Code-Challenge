package com.example.codechallenge.ui.base.binding

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

interface BindingAdapters {

    @BindingAdapter(
        "appImageUrl",
        "appError",
        "appPlaceholder",
        requireAll = false
    )
    fun <T> AppCompatImageView.loadImage(
        model: T,
        error: Drawable?,
        placeholder: Drawable?,
    )

}