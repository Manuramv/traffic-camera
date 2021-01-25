package com.zuhlke.map.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zuhlke.map.factory.BaseViewModelFactory
import com.zuhlke.map.ui.cameraimage.CameraImageViewModel
import com.zuhlke.map.ui.trafficcamera.TrafficCameraViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TrafficCameraViewModel::class)
    abstract fun bindTrafficCameraViewModel(movieDetailsViewModel: TrafficCameraViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CameraImageViewModel::class)
    abstract fun bindCameraImageViewModel(movieDetailsViewModel: CameraImageViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory
}