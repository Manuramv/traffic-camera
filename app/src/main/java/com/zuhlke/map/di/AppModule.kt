package com.zuhlke.map.di

import android.app.Application
import android.content.Context
import com.zuhlke.map.data.remote.ApiInterface
import com.zuhlke.map.data.remote.RetrofitService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

   @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiInterface {
        return RetrofitService.getRetrofitService()
    }

}