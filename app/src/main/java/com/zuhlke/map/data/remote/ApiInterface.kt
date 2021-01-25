package com.zuhlke.map.data.remote

import com.zuhlke.map.data.model.TrafficImageResponse
import com.zuhlke.map.utils.TRAFFIC_IMAGES
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(TRAFFIC_IMAGES)
    suspend fun getTrafficImages() : TrafficImageResponse


}