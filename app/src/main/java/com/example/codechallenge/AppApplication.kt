package com.example.codechallenge

import android.app.Application
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.example.codechallenge.ui.base.binding.BindingAdaptersImpl
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AppApplication : Application(), DataBindingComponent {

    @Inject
    lateinit var appBindingAdapters: BindingAdaptersImpl

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(this)
    }

    override fun getBindingAdapters(): BindingAdaptersImpl {
        return appBindingAdapters
    }

}