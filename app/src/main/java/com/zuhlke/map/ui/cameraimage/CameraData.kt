package com.zuhlke.map.ui.cameraimage

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//data class to parse the data from map fragment to camera fragment through bundle
@Parcelize
data class CameraData(
    val imageUrl: String,
    val imageTakenDate: String
) : Parcelable