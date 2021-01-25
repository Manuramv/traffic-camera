package com.zuhlke.map

import android.app.Application
import com.zuhlke.map.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class MyApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

    }

    override fun androidInjector() = dispatchingAndroidInjector

}