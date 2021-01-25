package com.zuhlke.map.di


import com.zuhlke.map.ui.cameraimage.CameraImageFragment
import com.zuhlke.map.ui.trafficcamera.TrafficCameraFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTrafficCameraFragment(): TrafficCameraFragment

    @ContributesAndroidInjector
    abstract fun contributeCameraImageFragment(): CameraImageFragment

}