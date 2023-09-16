package com.example.codechallenge.ui.base.binding

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.codechallenge.R
import javax.inject.Inject

class BindingAdaptersImpl @Inject constructor() : BindingAdapters {

    override fun <T> AppCompatImageView.loadImage(
        model: T,
        error: Drawable?,
        placeholder: Drawable?,
    ) {
        model?.let {
            glideLoadImage(
                this@loadImage,
                it,
                error,
                placeholder
            )
        } ?: kotlin.run {
            Glide.with(context).clear(this)
            setImageResource(R.drawable.ic_placeholder)
        }
    }

    private fun <T> glideLoadImage(
        img: AppCompatImageView,
        model: T,
        error: Drawable?,
        placeholder: Drawable?,
    ) {
        Glide.with(img.context)
            .load(model)
            .error(error)
            .placeholder(placeholder)
            .into(img)
    }

}